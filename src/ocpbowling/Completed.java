package ocpbowling;

public class Completed implements Frame {

	private final int points;
	private final Frame previous;
	private final Transition transition;

	public Completed(int points, Frame previous, Transition transition) {
		this.points = points;
		this.previous = previous;
		this.transition = transition;
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
