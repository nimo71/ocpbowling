package ocpbowling;

public class Strike implements Frame {

	private final int points;
	private final Frame previous;

	public Strike(int points, Frame previous) {
		this.points = points;
		this.previous = previous;
	}

	@Override
	public int score() {
		return previous.score() + points;
	}

	@Override
	public Frame roll(int roll) {
		throw new IllegalStateException("Should never be called");
	}

	@Override
	public Frame bonus(int roll) {
		return this; 
	}

	@Override
	public Frame previous() {
		return previous;
	}

}
