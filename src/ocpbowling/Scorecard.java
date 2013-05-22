package ocpbowling;

public class Scorecard {
	private final Frame frame;

	public Scorecard(Frame frame) {
		this.frame = frame;
	}
	
	public int score() {
		return frame.score();
	}

	public Scorecard roll(int points) {
		return new Scorecard(frame.roll(points));
	}

}
