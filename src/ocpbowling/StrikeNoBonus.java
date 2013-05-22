package ocpbowling;

public class StrikeNoBonus implements Frame {

	private final Transition transition;
	private final Frame previous;

	public StrikeNoBonus(Frame previous, Transition transition) {
		this.previous = previous;
		this.transition = transition;
	}

	@Override
	public int score() {
		return 10 + previous.score();
	}

	@Override
	public Frame roll(int roll) {
		return transition.next(this, roll);
	}
	
	@Override
	public Frame bonus(int roll) {
		return transition.bonus(this, 10, roll);
	}

	@Override
	public Frame previous() {
		return previous;
	}

}
