package playing_field;

import static org.junit.Assert.*;

import org.junit.Test;

public class Map_test {

Map maptest = new Map(4);


	@Test
	public void testAdd_fruit() {
		assertEquals("überprüft ob die Anzahl der früchte stimmt",18, maptest.get_amount("almond"));
		maptest.add_fruit("almond", 2);
		assertEquals("überprüft ob die Anzahl der früchte stimmt",20, maptest.get_amount("almond"));

	}

	@Test
	public void testRemove_fruit() {
		assertTrue(true);
	}

	@Test
	public void testAdd_donkey() {
		assertEquals("überprüft ob die Anzahl der esel stimmt",8, maptest.get_donkycount());
		maptest.add_donkey();
		assertEquals("überprüft ob die Anzahl der esel stimmt",9, maptest.get_donkycount());

	}

	@Test
	public void testRemove_donkey() {
		assertEquals("überprüft ob die Anzahl der esel stimmt",8, maptest.get_donkycount());
		maptest.remove_donkey();
		assertEquals("überprüft ob die Anzahl der esel stimmt",7, maptest.get_donkycount());
	}

	@Test
	public void testGet_amount() {
		assertTrue(maptest.get_amount("almond")==18);
		
	}

	@Test
	public void testGet_donkycount() {
		assertEquals(8,maptest.get_donkycount());
	}

	@Test
	public void testRefill_donkeys() {
		assertEquals("überprüft ob die Anzahl der esel stimmt",8, maptest.get_donkycount());
		maptest.remove_donkey();
		maptest.remove_donkey();
		maptest.remove_donkey();
		assertEquals("überprüft ob die Anzahl der esel stimmt",5, maptest.get_donkycount());
		maptest.refill_donkeys();
		assertEquals("überprüft ob die Anzahl der esel stimmt",8, maptest.get_donkycount());
	}

}
