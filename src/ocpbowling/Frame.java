package ocpbowling;

public interface Frame {

	int score();

	Frame roll(int roll);
	
	Frame bonus(int roll);

	Frame previous();

}