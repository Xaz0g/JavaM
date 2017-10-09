package se.su.dsv.inte;

import org.junit.*;
import org.junit.Assert;

public class MapTest {
	
	private Map m;
	private static final int VALID_HEIGHT = 20, VALID_WIDTH = 20;
	
	@Test
	public void validDimensions() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
	}

}
