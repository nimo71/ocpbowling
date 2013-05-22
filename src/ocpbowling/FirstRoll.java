package ocpbowling;

public class FirstRoll implements Frame {

	final Transition transition;
	private final Frame previous;
	private final int points;

	public FirstRoll(int points, Frame previous, Transition transition) {
		this.points = points;
		this.previous = previous;
		this.transition = transition;
	}
	
	public int points() {
		return points;
	}

	@Override
	public int score() {
		return previous.score() + points; 
	}

	@Override
	public Frame roll(int roll) {
		return transition.next(this, roll);
	}

	@Override
	public Frame previous() {
		return previous;
	}

	@Override
	public Frame bonus(int roll) {
		return this;
	}

}
