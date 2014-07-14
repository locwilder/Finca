/**
 * Finca Gruppe 2
 * --------------
 * Michael Kündig 09-737-552
 * Michael Keller 07-708-506
 * Loc Nguyen 06-918-932
 * Thavorith Hean 07-741-127
 * Mehmet Ali Bekooglu 06-920-771 
 * 
 * Assistent: Konstantin Zherebtsov
 */


package E_playing_field;

import java.io.Serializable;
import java.util.ArrayList;

import E_player.E_Player;

/**
 * This class represents everything in the game that can and will be changed.
 * It contains the map and all players.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_GameBoard implements Serializable, Cloneable
{
	private int numberOfPlayers;
	private E_Map gameMap;
	private ArrayList<E_Player> players;
	private int numberOfEmptCom = 0;
	private int nr_of_fincahouses;


	public E_GameBoard() {
	}

	/**
	 * the constructor creates the gameboard with the parameter given 
	 * @pre: -
	 * @post: all instance variables are initialized with default or the given value
	 * @param: arrayList, filled with nicknames of all players
	 */
	public E_GameBoard(ArrayList<String> nicknames)
	{
		numberOfPlayers = nicknames.size();
		gameMap = new E_Map(numberOfPlayers);
		players = new ArrayList<E_Player>();

		players.add(new E_Player(nicknames.get(0), 0)); 

		players.add(new E_Player(nicknames.get(1), 1));

		if(numberOfPlayers >= 3) {
			players.add(new E_Player(nicknames.get(2), 2));

		}
		if(numberOfPlayers >= 4) {
			players.add(new E_Player(nicknames.get(3), 3));

		}
	}
	
	public Object clone() {
		E_GameBoard obj = new E_GameBoard();
		obj.gameMap = this.gameMap;
		obj.nr_of_fincahouses = this.nr_of_fincahouses;
		obj.numberOfEmptCom = this.numberOfEmptCom;
		obj.numberOfPlayers = this.numberOfPlayers;
		obj.players = this.players;
		
		return obj;
	}

	/**
	 * adds a fruit type to the gameboard
	 * @pre: class has to be constructed first
	 * @post: more fruits in the pool
	 * @param: 1. String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange')
	 * 		   2. int, how many are added
	 */
	public void add_fruit_pool(String fruit_, int amount_)
	{
		gameMap.add_fruit(fruit_, amount_);
	}
	/**
	 * removes a fruit type to the gameboard. if pool does not have as many fruits, it takes
	 * all fruits of this type back from all players
	 * @pre: class has to be constructed first
	 * @post: less or more fruits in the pool
	 * @param: 1. String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange')
	 * 		   2. int, how many are removed
	 */
	public void remove_fruit_pool(String fruit_, int amount_)
	{
		if(gameMap.get_amount(fruit_) < amount_)
		{
			for(int i=0; i<numberOfPlayers; i++)
				players.get(i).remove_fruit(fruit_, players.get(i).get_fruitcount(fruit_));
			gameMap.add_fruit(fruit_, 18);
		}
		gameMap.remove_fruit(fruit_, amount_);
	}
	/**
	 * adds a donkey to the gameboard. 
	 * @pre: class has to be constructed first
	 * @post: one more donkey in the pool
	 */
	public void add_donkey_pool()
	{
		gameMap.add_donkey();
	}
	/**
	 * removes a donkey to the gameboard. if pool does not have a donkey, it takes
	 * all donkeys back from all players
	 * @pre: class has to be constructed first
	 * @post: one less or more donkey in the pool
	 */
	public void remove_donkey_pool()
	{
		if(gameMap.get_donkycount() == 0)
		{
			for(int i=0; i<numberOfPlayers; i++)
				players.get(i).remove_all_donkey();
			gameMap.refill_donkeys();
		}
		gameMap.remove_donkey();
	}
	/**
	 * adds a fruit type to a player
	 * @pre: class has to be constructed first
	 * @post: more fruits in possession of the player
	 * @param: 1. String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange')
	 * 		   2. int, how many are added
	 * 		   3. int, players index (0-3)
	 */
	public void add_fruit_player(String fruit_, int amount, int player)
	{
		players.get(player).add_fruit(fruit_, amount);
	}
	/**
	 * removes a fruit type from a player
	 * @pre: class has to be constructed first
	 * @post: less fruits in possession of the player
	 * @param: 1. String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange')
	 * 		   2. int, how many are added
	 * 		   3. int, players index (0-3)
	 */
	public void remove_fruit_player(String fruit_, int amount, int player)
	{
		players.get(player).remove_fruit(fruit_, amount);
	}
	/**
	 * adds a donkey to a player
	 * @pre: class has to be constructed first
	 * @post: one more donkey in possession of the player
	 * @param: int, players index (0-3)
	 */
	public void add_donkey_player(int player)
	{
		players.get(player).add_donkey();
	}
	/**
	 * adds a donkey to a player
	 * @pre: class has to be constructed first
	 * @post: one more donkey in possession of the player
	 * @param: int, players index (0-3)
	 */
	public void remove_donkey_player(int player)
	{
		players.get(player).remove_donkey();
	}
	/**
	 * adds a fruit tile to a player
	 * @pre: class has to be constructed first
	 * @post: one more fruit tile in possession of the player, one less on the community
	 * @param: 1. int, players index (0-3)
	 * 		   2. int, community index where fruit tile is taken from (0-9)
	 */
	public void add_fruittile_player(int player, int community)
	{
		if(gameMap.get_communities().get(community).get_number_of_fruittiles() > 0)
			players.get(player).add_fruittile(gameMap.get_communities().get(community).remove_fruittile());
	}
	/**
	 * adds a finca tile to a player
	 * @pre: class has to be constructed first
	 * @post: one more finca tile in possession of the player, one less on the community
	 * @param: 1. int, players index (0-3)
	 * 		   2. int, community index where finca tile is taken from (0-9)
	 */
	public void add_fincatile_player(int player, int community)
	{
		if(gameMap.get_communities().get(community).get_fincatile() != null)
			players.get(player).add_fincatile(gameMap.get_communities().get(community).remove_fincatile());
	}
	/**
	 * adds a bonus tile to a player
	 * @pre: class has to be constructed first
	 * @post: one more bonus tile in possession of the player, one less on the map
	 * @param: 1. int, players index (0-3)
	 */
	public void add_bonustile_player(int player)
	{
		if(gameMap.get_all_bonustiles().size() > 0)
			players.get(player).add_points(gameMap.remove_bonustile().get_value());
			//players.get(player).add_bonustile(gameMap.remove_bonustile());
	}

	public int getNumOfEmptCom(){
		numberOfEmptCom = 0;
		for(int i=0; i<10; i++) {
			if(this.getMap().get_communities().get(i).get_all_fruittiles().size() == 0)
				numberOfEmptCom++;
		}
		return numberOfEmptCom;
	}
	private int numberOfFhouses(){
		int nr_of_fincas = 0;
		if(getNumberOfPlayers()==2){
			nr_of_fincas = 4;
			return nr_of_fincas;
		}else if(getNumberOfPlayers()==3){
			nr_of_fincas = 5;
			return nr_of_fincas;
		}else if(getNumberOfPlayers()==4){
			nr_of_fincas = 6;
			return nr_of_fincas;
		}else{
			return nr_of_fincas;
		}
	}
	public int getNrOfFincas(){
		int result;
		nr_of_fincahouses = numberOfFhouses();
		
		result = nr_of_fincahouses - getNumOfEmptCom();
		return result;
	}
	
	public int getNrOfFincahouses() {
		return nr_of_fincahouses;
	}
	
	public boolean hasGameEnded() {
		int nr_of_empty_com= getNumOfEmptCom();
		if(numberOfPlayers == 4)
		{
			if(nr_of_empty_com >= 6)
				return true;
		}
		if(numberOfPlayers == 3)
		{
			if(nr_of_empty_com >= 5)
				return true;
		}
		if(numberOfPlayers == 2)
		{
			if(nr_of_empty_com >= 4)
				return true;
		}
		return false;
	}

	/**
	 * getter for the player arrayList
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: arrayList, containing all players
	 */
	public ArrayList<E_Player> getPlayers()
	{
		return players;
	}

	public E_Player getPlayer(int index) {
		return players.get(index);
	}
	/**
	 * getter for the map
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: Map, the map
	 */
	public E_Map getMap()
	{
		return gameMap;
	}

	//follgende methoden für den test erstellt, aber ev auch fürs gui benötigt
	/**
	 * getter for the number of players
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int, total number of players
	 */
	public int getNumberOfPlayers()
	{
		return numberOfPlayers;
	}

	//	/**
	//	 * getter for the 1st players turn
	//	 * @pre: class has to be constructed first
	//	 * @post: -
	//	 * @return: int, 0 if its histurn, 1 if not, 2 if this player does not exist
	//	 */
	//	public int getTurnPlayer1() 
	//	{
	//		return turnPlayer1;
	//	}
	//
	//	/**
	//	 * getter for the 2nd players turn
	//	 * @pre: class has to be constructed first
	//	 * @post: -
	//	 * @return: int, 0 if its histurn, 1 if not, 2 if this player does not exist
	//	 */
	//	public int getTurnPlayer2() 
	//	{
	//		return turnPlayer2;
	//	}
	//
	//	/**
	//	 * getter for the 3rd players turn
	//	 * @pre: class has to be constructed first
	//	 * @post: -
	//	 * @return: int, 0 if its histurn, 1 if not, 2 if this player does not exist
	//	 */
	//	public int getTurnPlayer3() 
	//	{
	//		return turnPlayer3;
	//	}
	//
	//	/**
	//	 * getter for the 4th players turn
	//	 * @pre: class has to be constructed first
	//	 * @post: -
	//	 * @return: int, 0 if its histurn, 1 if not, 2 if this player does not exist
	//	 */
	//	public int getTurnPlayer4() 
	//	{
	//		return turnPlayer4;
	//	}
}
