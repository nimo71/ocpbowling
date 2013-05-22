package ocpbowling;

public class Transition {

	private static final int ALL_PINS = 10;

	public Frame next(StopFrame previous, int roll) {
		return firstRollOfFrame(previous, roll);
	}

	public Frame next(Completed previous, int roll) {
		return firstRollOfFrame(previous, roll);
	}

	public Frame next(SpareNoBonus previous, int roll) {
		return firstRollOfFrame(previous, roll);
	}
	
	public Frame next(StrikeNoBonus previous, int roll) {
		return firstRollOfFrame(previous, roll);
	}
	
	public Frame next(FirstRoll previous, int roll) {		
		return secondRollOfFrame(previous, roll);
	}

	public Frame bonus(SpareNoBonus previous, int previousPoints, int roll) {
		return new Spare(previousPoints + roll, previous.previous().bonus(roll));
	}

	public Frame bonus(StrikeNoBonus previous, int previousPoints, int roll) {
		return new StrikeOneBonus(previousPoints + roll, previous.previous().bonus(roll), this);
	}
	
	public Frame bonus(StrikeOneBonus previous, int previousPoints, int roll) {
		return new Strike(previousPoints + roll, previous.previous().bonus(roll));
	}
	
	private Frame firstRollOfFrame(Frame previous, int roll) {
		Frame newPreviousFrame = previous.bonus(roll);
		
		if (isStrike(roll)) 
			return new StrikeNoBonus(newPreviousFrame, this);
		
		return new FirstRoll(roll, newPreviousFrame, this);
	}
	
	private Frame secondRollOfFrame(FirstRoll previous, int roll) {
		int points = previous.points() + roll;
		Frame newPreviousFrame = previous.previous().bonus(roll);
		
		if (isSpare(previous, roll)) 
			return new SpareNoBonus(points, newPreviousFrame, this);
		
		return new Completed(points, newPreviousFrame, this);
	}

	private boolean isSpare(FirstRoll firstRoll, int roll) {
		return firstRoll.points() + roll == ALL_PINS;
	}
	
	private boolean isStrike(int roll) {
		return roll == ALL_PINS;
	}

}
