package ocpbowling;

public class StrikeOneBonus implements Frame {

	private final int points;
	private final Frame previous;
	private final Transition transition;

	public StrikeOneBonus(int points, Frame previous, Transition transition) {
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
		throw new IllegalStateException("Unexpected call");
	}

	@Override
	public Frame bonus(int roll) {
		return transition.bonus(this, points, roll);
	}

	@Override
	public Frame previous() {
		return previous;
	}

}
