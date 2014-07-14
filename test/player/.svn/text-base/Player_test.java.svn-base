package player;

import static org.junit.Assert.*;

import org.junit.Test;

public class Player_test {

Player p1 = new Player("blue", 1);

//
//	@Test
//	public void testPlayer() {
//		
//	}

	@Test
	public void testAdd_points() {
		assertEquals(8, p1.get_points());
		p1.add_points(-5);
		assertEquals(3, p1.get_points());		
	}

	@Test
	public void testGet_points() {
		assertEquals(8,p1.get_points());
		assertTrue(p1.get_points()==8);
		p1.add_points(5);
		assertTrue(p1.get_points()==13);
	
	}

	@Test
	public void testGet_colour() {
		assertEquals("test ob blau richtig ist", 1, p1.getPlayerNumber());
	}

	@Test
	public void testGet_fruitcount() {
		p1.add_fruit("olive", 2);
		assertTrue(2 == p1.get_fruitcount("olive"));

	}

	@Test
	public void testGet_donkeys() {
		assertTrue(0==p1.get_donkeys());
		
	}

	@Test
	public void testAdd_fruit() {
		assertEquals("test the fruit counter for 0", 0, p1.get_fruitcount("olive"));
		p1.add_fruit("olive", 4);
		assertEquals("test the fruit counter for 0", 4, p1.get_fruitcount("olive"));


	}

	@Test
	public void testRemove_fruit() {
		assertEquals("test the fruit counter for 0", 0, p1.get_fruitcount("olive"));
		p1.add_fruit("olive", 4);
		assertEquals("test the fruit counter for 4", 4, p1.get_fruitcount("olive"));
		p1.remove_fruit("olive", 2);
		assertEquals("test the fruit counter for 2", 2, p1.get_fruitcount("olive"));
		
	}

	@Test
	public void testAdd_donkey() {
		assertEquals("test the donkey counter for 0", 0, p1.get_donkeys());
		p1.add_donkey();
		assertEquals("test the donkey counter for 1", 1, p1.get_donkeys());
	}

	@Test
	public void testRemove_donkey() {
		assertEquals("test the donkey counter for 0", 0, p1.get_donkeys());
		p1.add_donkey();
		assertEquals("test the donkey counter for 1", 1, p1.get_donkeys());
		p1.remove_donkey();
		assertEquals("test the donkey counter for 0", 0, p1.get_donkeys());

	}

	@Test
	public void testRemove_all_donkey() {
		assertEquals("the the donkey counter for 0", 0, p1.get_donkeys());
		p1.add_donkey();
		p1.add_donkey();
		p1.add_donkey();
		assertEquals("the the donkey counter for 3", 3, p1.get_donkeys());
		p1.remove_all_donkey();
		assertEquals("the the donkey counter for 0", 0, p1.get_donkeys());



	}

}
