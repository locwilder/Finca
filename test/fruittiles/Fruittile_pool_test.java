package fruittiles;

import static org.junit.Assert.*;

import org.junit.Test;

public class Fruittile_pool_test {

//	@Test
//	public void testFruittile_Pool() {
//		fail("Not yet implemented");
//	}

	Fruittile_Pool pooltest = new Fruittile_Pool();
	@Test
	public void testGet_random_tile() {
		assertEquals("testet ob die Fruittile klasse abgerufen werden kann",5,pooltest.get_random_tile().get_points());
	}

}
