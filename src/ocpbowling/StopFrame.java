package ocpbowling;

public class StopFrame implements Frame {

	final Transition transition;
	
	public StopFrame(Transition transition) {
		this.transition = transition;
	}

	@Override
	public int score() {
		return 0;
	}
	
	@Override
	public Frame roll(int roll) {
		return transition.next(this, roll);
	}

	@Override
	public Frame previous() {
		return this;
	}

	@Override
	public Frame bonus(int roll) {
		return this;
	}

}
