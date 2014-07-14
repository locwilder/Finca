package playing_field;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/*
 * This Testclass is aimed to test if a gameboard object is 
 * inizialised properly.
 * It tests the state of the containing Players, communities and
 * windmill, by checking the correctness of their values.
 */
public class GameBoard_test {

	
	ArrayList<String> nicknames = new ArrayList<String>();
	

	@Test
	public void test_player_init()
	{
		nicknames.add("Tick");
		nicknames.add("Trick");
		nicknames.add("Track");
		GameBoard test = new GameBoard(nicknames);
		// startwerte der Player
		
		assertEquals(3, test.getPlayers().size());
		
		assertEquals("Tick", test.getPlayers().get(0).get_username());
		assertEquals("Trick", test.getPlayers().get(1).get_username());
		assertEquals("Track", test.getPlayers().get(2).get_username());
		
		assertEquals("red", test.getPlayers().get(0).get_colour());
		assertEquals("green", test.getPlayers().get(1).get_colour());
		assertEquals("blue", test.getPlayers().get(2).get_colour());
		
		for(int i=0; i<3; i++)
		{
			assertEquals(true, test.getPlayers().get(i).has_double_move());
			assertEquals(true, test.getPlayers().get(i).has_gust_of_wind());
			assertEquals(true, test.getPlayers().get(i).has_large_donkey_cart());
			assertEquals(true, test.getPlayers().get(i).has_one_fruit_less());
		
			assertEquals(0, test.getPlayers().get(i).get_fruitcount("orange"));
			assertEquals(0, test.getPlayers().get(i).get_fruitcount("lemon"));
			assertEquals(0, test.getPlayers().get(i).get_fruitcount("olive"));
			assertEquals(0, test.getPlayers().get(i).get_fruitcount("fig"));
			assertEquals(0, test.getPlayers().get(i).get_fruitcount("grape"));
			assertEquals(0, test.getPlayers().get(i).get_fruitcount("spellingmisstake"));
		
			assertEquals(8, test.getPlayers().get(i).get_points());
			assertEquals(0, test.getPlayers().get(i).get_donkeys());
		}
	}
	@Test
	public void test_communities_init()
	{
		nicknames.add("Tick");
		nicknames.add("Trick");
		nicknames.add("Track");
		GameBoard test = new GameBoard(nicknames);
		// startwerte der communities
		assertEquals(10, test.getMap().get_communities().size());
		System.out.println("All Finca Plates:");
		System.out.println("Points:\t" + "Almond:\t" + "Fig:\t" + "Grape:\t" + "Lemon:\t" + "Olive:\t" + "Orange:\t" + "Riddle:");
		for(int i= 0; i<10; i++)
		{
			assertEquals(4, test.getMap().get_communities().get(i).get_number_of_fruittiles());
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().get_points() + "\t");
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().is_almond() + "\t");
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().is_fig() + "\t");
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().is_grape() + "\t");
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().is_lemon() + "\t");
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().is_olive() + "\t");
			System.out.print(test.getMap().get_communities().get(i).get_fincatile().is_orange() + "\t");
			System.out.println(test.getMap().get_communities().get(i).get_fincatile().is_riddle());
		}
		System.out.println("All Fruit Plates:");
		System.out.println("Points:\t" + "Almond:\t" + "Fig:\t" + "Grape:\t" + "Lemon:\t" + "Olive:\t" + "Orange:\t" + "Riddle:");
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_points() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_almond_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_fig_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_grape_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_lemon_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_olive_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_orange_cost() + "\t");
				System.out.println(test.getMap().get_communities().get(i).get_all_fruittiles().get(j).get_riddle_cost() + "\t");
			}
		}
		System.out.println("The 10 Top Fruit Plates:");
		System.out.println("Points:\t" + "Almond:\t" + "Fig:\t" + "Grape:\t" + "Lemon:\t" + "Olive:\t" + "Orange:\t" + "Riddle:");
		for(int i=0; i<10; i++)
		{
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_points() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_almond_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_fig_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_grape_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_lemon_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_olive_cost() + "\t");
				System.out.print(test.getMap().get_communities().get(i).get_top_fruittile().get_orange_cost() + "\t");
				System.out.println(test.getMap().get_communities().get(i).get_top_fruittile().get_riddle_cost() + "\t");
		}
	}
	@Test
	public void test_windmill_init()
	{
		nicknames.add("Tick");
		nicknames.add("Trick");
		nicknames.add("Track");
		GameBoard test = new GameBoard(nicknames);
		// startwerte der windmill
		assertEquals(12, test.getMap().get_windmill().get_blade_array().length);
		for(int i=0; i<12; i++)
		{
			assertEquals(false, test.getMap().get_windmill().get_blade_array()[i].has_farmer_here(0));
			assertEquals(false, test.getMap().get_windmill().get_blade_array()[i].has_farmer_here(1));
			assertEquals(false, test.getMap().get_windmill().get_blade_array()[i].has_farmer_here(2));
			assertEquals(false, test.getMap().get_windmill().get_blade_array()[i].has_farmer_here(3));
			assertEquals(0, test.getMap().get_windmill().get_blade_array()[i].get_num_of_farmers());
		}
		for(int i=0; i<12; i++)
		{
			System.out.println((i+1) + ": " + test.getMap().get_windmill().get_blade_array()[i].get_resource_typ());
		}
	}
	
	@Test
	public void test_map_init()
	{
		nicknames.add("Tick");
		nicknames.add("Trick");
		nicknames.add("Track");
		GameBoard test = new GameBoard(nicknames);
		// startwerte der map
		int testcounter = 7;
		for(int i=0; i<4; i++)
		{
			assertEquals(testcounter, test.getMap().get_all_bonustiles().get(i).get_value());
			testcounter--;
		}
		assertEquals(18, test.getMap().get_amount("almond"));
		assertEquals(18, test.getMap().get_amount("fig"));
		assertEquals(18, test.getMap().get_amount("grape"));
		assertEquals(18, test.getMap().get_amount("lemon"));
		assertEquals(18, test.getMap().get_amount("olive"));
		assertEquals(18, test.getMap().get_amount("orange"));
		assertEquals(0, test.getMap().get_amount("speelingmisstace"));
		assertEquals(6, test.getMap().get_donkycount());
	}
	
	@Test
	public void test_gameboard_init()
	{
		nicknames.add("Tick");
		nicknames.add("Trick");
		nicknames.add("Track");
		GameBoard test = new GameBoard(nicknames);
		// startwerte des gameboards
		assertEquals(3, test.getNumberOfPlayers());
		assertEquals(1, test.getTurnPlayer1());
		assertEquals(0, test.getTurnPlayer2());
		assertEquals(0, test.getTurnPlayer3());
		assertEquals(2, test.getTurnPlayer4());
	}
}