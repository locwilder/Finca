package player;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import playing_field.GameBoard;

public class Turn_test {

	ArrayList<String> nicknames = new ArrayList<String>();



	@Test
	public void testTurn() {
		nicknames.add("trick");
		nicknames.add("Trick");
		nicknames.add("Track");
		nicknames.add("dagobert");
		GameBoard gb = new GameBoard(nicknames);
		Turn tturn = new Turn(0,4);
		assertEquals(4, gb.getNumberOfPlayers());
		assertEquals(18, gb.getMap().get_amount("almond"));
		assertEquals(4, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		assertEquals(0, gb.getMap().get_windmill().get_blade_array()[0].get_num_of_farmers());
	}

//	@Test
//	public void testItIsYourTurn() {
//		nicknames.add("trick");
//		nicknames.add("Trick");
//		nicknames.add("Track");
//		nicknames.add("dagobert");
//		GameBoard gb = new GameBoard(nicknames);
//		Turn tturn = new Turn(0,4);
//		tturn.itIsYourTurn();
//	}

	@Test
	public void testUseWindmillBlade() {
		nicknames.add("trick");
		nicknames.add("Trick");
		nicknames.add("Track");
		nicknames.add("dagobert");
		GameBoard gb = new GameBoard(nicknames);
		Turn tturn = new Turn(1,4);
		assertEquals(4, gb.getNumberOfPlayers());
		assertEquals(18, gb.getMap().get_amount("almond"));
		assertEquals(4, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		assertEquals(0, gb.getMap().get_windmill().get_blade_array()[0].get_num_of_farmers());
		tturn.itIsYourTurn();
		tturn.useWindmillBlade(0, gb);
		tturn.useWindmillBlade(1, gb);
		tturn.useWindmillBlade(2, gb);
		assertEquals(1, gb.getMap().get_windmill().get_blade_array()[0].get_num_of_farmers());
		assertEquals(1, gb.getMap().get_windmill().get_blade_array()[1].get_num_of_farmers());
		assertEquals(1, gb.getMap().get_windmill().get_blade_array()[2].get_num_of_farmers());
		tturn.useWindmillBlade(0, gb);
		assertEquals(2, gb.getMap().get_windmill().get_blade_array()[1].get_num_of_farmers());
		tturn.useWindmillBlade(2, gb);
		assertEquals(1, gb.getMap().get_windmill().get_blade_array()[3].get_num_of_farmers());
		tturn.useWindmillBlade(1, gb);
		assertEquals(2, gb.getMap().get_windmill().get_blade_array()[3].get_num_of_farmers());
		tturn.useWindmillBlade(3, gb);
		tturn.useWindmillBlade(4, gb); //sollte nichts passieren
		assertEquals(4, gb.getPlayers().size());
		assertEquals(8, gb.getPlayers().get(1).get_points());
		assertEquals(0, gb.getPlayers().get(1).get_donkeys());
		tturn.useWindmillBlade(5, gb);
		assertEquals(1, gb.getPlayers().get(1).get_donkeys());

		
	}

	@Test
	public void testUseCommunity() {
		nicknames.add("trick");
		nicknames.add("Trick");
		nicknames.add("Track");
		nicknames.add("dagobert");
		GameBoard gb = new GameBoard(nicknames);
		Turn tturn = new Turn(1,4);
		Turn godturn = new Turn(0,4);
		assertEquals(4, gb.getNumberOfPlayers());
		assertEquals(18, gb.getMap().get_amount("almond"));
		assertEquals(4, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		assertEquals(0, gb.getMap().get_windmill().get_blade_array()[0].get_num_of_farmers());
		tturn.itIsYourTurn();
		godturn.itIsYourTurn();
		godturn.useWindmillBlade(0, gb);
		godturn.useWindmillBlade(0, gb);
		godturn.useWindmillBlade(0, gb);
		godturn.useCommunity(0, gb);
		assertEquals(3, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		//testet ob turn weitergegeben wird.
		godturn.useCommunity(0, gb);
		assertEquals(2, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		godturn.itIsYourTurn();
		
	}

	@Test
	public void testUseJoker() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndTurn() {
		nicknames.add("trick");
		nicknames.add("Trick");
		nicknames.add("Track");
		nicknames.add("dagobert");
		GameBoard gb = new GameBoard(nicknames);
		Turn tturn = new Turn(1,4);
		Turn godturn = new Turn(0,4);
		assertEquals(4, gb.getNumberOfPlayers());
		assertEquals(18, gb.getMap().get_amount("almond"));
		assertEquals(4, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		assertEquals(0, gb.getMap().get_windmill().get_blade_array()[0].get_num_of_farmers());
		godturn.useCommunity(0, gb);
		godturn.endTurn();
		godturn.useCommunity(0, gb);
		assertEquals(2, gb.getMap().get_communities().get(0).get_number_of_fruittiles());

		//System.out.println();
		
		
	}

	@Test
	public void testCancelTurn() {
		nicknames.add("trick");
		nicknames.add("Trick");
		nicknames.add("Track");
		nicknames.add("dagobert");
		GameBoard gb = new GameBoard(nicknames);
		Turn tturn = new Turn(1,4);
		Turn godturn = new Turn(0,4);
		assertEquals(4, gb.getNumberOfPlayers());
		assertEquals(18, gb.getMap().get_amount("almond"));
		assertEquals(4, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		assertEquals(0, gb.getMap().get_windmill().get_blade_array()[0].get_num_of_farmers());
		godturn.useCommunity(0, gb);
		assertEquals(3, gb.getMap().get_communities().get(0).get_number_of_fruittiles());
		// kei ahnig wia der cancel turn teste mit em clien
		//godturn.cancelTurn();
		//assertEquals(4, gb.getMap().get_communities().get(0).get_number_of_fruittiles());

		
	}

}
