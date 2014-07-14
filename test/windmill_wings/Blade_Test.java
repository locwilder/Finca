package windmill_wings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Blade_Test {

//	@Test
//	public void testBlade() {
//		fail("Not yet implemented");
//	}
	Blade bladetest = new Blade("almond");
	
	@Test
	public void testGet_num_of_farmers() {
		
		assertEquals("test ob num of farmers 0 ist",0, bladetest.get_num_of_farmers());
	}

	@Test
	public void testGet_resource_typ() {
		assertTrue("almond" == bladetest.get_resource_typ());
	}

	@Test
	public void testHas_farmer_here() {
		assertTrue(!bladetest.has_farmer_here(0));
	}

}
