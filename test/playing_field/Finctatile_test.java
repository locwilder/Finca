package playing_field;

import static org.junit.Assert.*;

import org.junit.Test;

public class Finctatile_test {
	
	Fincatile fincatest = new Fincatile(true, false, false, false, false, false,false,"blub");
//	@Test
//	public void testFincatile() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGet_points() {
		assertEquals("test ob punkte auf 5 gestellt sind",5, fincatest.get_points());
	}

	@Test
	public void testIs_almond() {
		assertTrue(fincatest.is_almond());
	}

	@Test
	public void testIs_fig() {
		assertTrue(!fincatest.is_fig());
	}

	@Test
	public void testIs_grape() {
		assertTrue(!fincatest.is_grape());
	}

	@Test
	public void testIs_lemon() {
		assertTrue(!fincatest.is_lemon());
	}

	@Test
	public void testIs_olive() {
		assertTrue(!fincatest.is_olive());
	}

	@Test
	public void testIs_orange() {
		assertTrue(!fincatest.is_orange());
	}

	@Test
	public void testIs_riddle() {
		assertTrue(!fincatest.is_riddle());
	}

}
