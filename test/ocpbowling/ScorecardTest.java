package ocpbowling;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class ScorecardTest {
	
	@Test
	public void noScore() {
		Scorecard scorecard = rolls(new int[] { 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0 });
		Assert.assertEquals(0, scorecard.score());
	}

	@Test
	public void addsScore() {
		Scorecard scorecard = rolls(new int[] { 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1 });
		Assert.assertEquals(20, scorecard.score());
	}
	
	@Test
	public void noSpare() {
		Scorecard scorecard = rolls(new int[] { 0,1, 9,0, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1 });
		Assert.assertEquals(18, scorecard.score());
	}
	
	@Test
	public void spare() {
		Scorecard scorecard = rolls(new int[] { 0,1, 9,1, 1,0, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,1 });
		Assert.assertEquals(20, scorecard.score());
	}
	
	@Test
	public void strike() {
		Scorecard scorecard = rolls(new int[] { 0,1, 0,1, 1,0, 10, 1,1, 0,1, 0,1, 0,1, 0,1, 0,1 });
		Assert.assertEquals(22, scorecard.score());		
	}
	
	@Test
	public void allStrikes() {
		Scorecard scorecard = rolls(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10 });
		Assert.assertEquals(300, scorecard.score());		
	}

	private Scorecard rolls(int[] rolls) {
		return rolls(rolls, new Scorecard(new StopFrame(new Transition())));
	}
	
	private Scorecard rolls(int[] rolls, Scorecard scorecard) {
		if (rolls.length == 1) 
			return scorecard.roll(rolls[0]);
		
		int[] slice = Arrays.copyOfRange(rolls, 1, rolls.length);
		return rolls(slice, scorecard.roll(rolls[0]));
	}
}

