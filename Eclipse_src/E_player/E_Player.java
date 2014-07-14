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


package E_player;

import java.io.Serializable;
import java.util.*;

import E_fruittiles.E_Fruittile;

import E_playing_field.E_Fincatile;
/**
 * This class represents a player. It contains all possessions (fruit, Finca and bonus tiles, points,
 * resources, donkeys and jokers) as well as color and username
 * 
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Player implements Serializable
{
	private Vector<E_Fruittile> fruittiles;
	private Vector<E_Fincatile> fincatiles;
	private Vector<E_Bonus_Plate> bonustiles;
	private Hashtable<String, Integer> straight = new Hashtable<String, Integer>();
	
	
	private int playerNumber;
	private String username;
	private int points;
	private int almonds;
	private int figs;
	private int grapes;
	private int lemons;
	private int olives;
	private int oranges;
	private int donkeys;
	private int bonusCounter1=0;
	private int bonusCounter2=0;
	private int bonusCounter3=0;
	private int bonusCounter4=0;
	private int bonusCounter5=0;
	private int bonusCounter6=0;
	
	
	
	private boolean oneFruitLess;
	private boolean largeDonkeyCart;
	private boolean gustOfWind;
	private boolean doubleMove;
	
	// god-mode zum testen der knöpfe
//	public E_Player(String godmode)
//	{
//		almonds = 99;
//		figs = 99;
//		grapes = 99;
//		lemons = 99;
//		olives = 99;
//		oranges = 99;
//		donkeys = 9;
//		points = 8;
//		username = godmode;
//		
//		largeDonkeyCart = true;
//		doubleMove = true;
//		gustOfWind = true;
//		oneFruitLess = true;
//		
//		fruittiles = new Vector<E_Fruittile>();
//		fincatiles = new Vector<E_Fincatile>();
//		bonustiles = new Vector<E_Bonus_Plate>();
//	}
	/**
	 * the constructor creates one player with the parameters given
	 * @pre: -
	 * @post: the instance variables is initialized with either the given values or default values
	 * @param: 1. String containing the players color
	 * 		   2. String containing the players username
	 */
	public E_Player(String name, int number)
	{
		straight.put("almonds", new Integer(0));
		straight.put("figs", new Integer(0));
		straight.put("grapes", new Integer(0));
		straight.put("lemons", new Integer(0));
		straight.put("olives", new Integer(0));
		straight.put("oranges", new Integer(0));
		straight.put("riddle", new Integer(0));

		
		almonds = 0;
		figs = 0;
		grapes = 0;
		lemons = 0;
		olives = 0;
		oranges = 0;
		donkeys = 0;
		points = 8;
		playerNumber = number;
		username = name;
		
		largeDonkeyCart = true;
		doubleMove = true;
		gustOfWind = true;
		oneFruitLess = true;
		
		fruittiles = new Vector<E_Fruittile>();
		fincatiles = new Vector<E_Fincatile>();
		bonustiles = new Vector<E_Bonus_Plate>();
	}
	/**
	 * adds a certain amount of points 
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: 1. String equals to the type of resource that should be added
	 * 			available: 'almond', 'fig', 'grape', 'lemon', 'olive', 'orange'
	 * 		   2. int, specifying how many resources should be added
	 */
	public void add_points(int points_)
	{
		points += points_;
	}
	/**
	 * getter for points
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equal to the players points
	 */
	public int get_points()
	{	
		return points; 
	}
	/**
	 * getter for playerNumber
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: String equal to the players color
	 */
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	/**
	 * getter for username
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: String equal to the players username
	 */
	public String get_username()
	{
		return username;
	}
	/**
	 * getter for the amount of a resource the player has
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: String saying which resource amount should be returned. available:
	 * 			'almond', 'fig', 'grape', 'lemon', 'olive', 'orange', 'riddle' 
	 * @return: int equals to the players number of resources of a type
	 */
	public int get_fruitcount(String fruit_) 
	{
		if(fruit_.equalsIgnoreCase("almond"))
			return almonds;
		else if(fruit_.equalsIgnoreCase("fig"))
			return figs;
		else if(fruit_.equalsIgnoreCase("grape"))
			return grapes;
		else if(fruit_.equalsIgnoreCase("lemon"))
			return lemons;
		else if(fruit_.equalsIgnoreCase("olive"))
			return olives;
		else if(fruit_.equalsIgnoreCase("orange"))
			return oranges;
		else if(fruit_ == "riddle")
		{
			int max = 0;
			if(almonds > max)
				max = almonds;
			if(figs > max)
				max = figs;
			if(grapes > max)
				max = grapes;
			if(lemons > max)
				max = lemons;
			if(olives > max)
				max = olives;
			if(oranges > max)
				max = oranges;
			return max;
		}
		
		else
		{
			System.out.println("Spelling mistake: " + fruit_);
			return 0;
		}
	}
	/**
	 * getter for number of donkeys owned by player
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the players donkey amount
	 */
	public int get_donkeys() 
	{
		return donkeys;
	}
	/**
	 * getter for fruit tiles
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: Vector containing all fruit tiles owned by this player
	 */
	public Vector<E_Fruittile> get_fruittiles()
	{
		return fruittiles;
	}
	/**
	 * adds fruit of a certain type in a certain quantity to player
	 * @pre: class has to be constructed first
	 * @post: player owns more fruit
	 * @param: 1. String equals to the type of resource that should be added
	 * 			available: 'almond', 'fig', 'grape', 'lemon', 'olive', 'orange'
	 * 		   2. int, specifying how many resources should be added
	 */
	public void add_fruit(String typ, int amount)
	{
		if(typ.equalsIgnoreCase("almond"))
		{
			almonds += amount;
		}
		else if(typ.equalsIgnoreCase("fig"))
		{
			figs += amount;
		}
		else if(typ.equalsIgnoreCase("grape"))
		{
			grapes += amount;
		}
		else if(typ.equalsIgnoreCase("lemon"))
		{
			lemons += amount;
		}
		else if(typ.equalsIgnoreCase("olive"))
		{
			olives += amount;
		}
		else if(typ.equalsIgnoreCase("orange"))
		{
			oranges += amount;
		}
		else
		{
			System.out.println("Spelling mistake: " + typ);
		}
	}
	/**
	 * removes fruit of a certain type in a certain quantity from player
	 * @pre: class has to be constructed first, player has to own at least as many fruits
	 * @post: player owns less fruit
	 * @param: 1. String equals to the type of resource that should be removed
	 * 			available: 'almond', 'fig', 'grape', 'lemon', 'olive', 'orange'
	 * 		   2. int, specifying how many resources should be removed
	 */
	public void remove_fruit(String typ, int amount)
	{
		if(typ.equalsIgnoreCase("almond"))
		{
			almonds -= amount;
		}
		else if(typ.equalsIgnoreCase("fig"))
		{
			figs -= amount;
		}
		else if(typ.equalsIgnoreCase("grape"))
		{
			grapes -= amount;
		}
		else if(typ.equalsIgnoreCase("lemon"))
		{
			lemons -= amount;
		}
		else if(typ.equalsIgnoreCase("olive"))
		{
			olives -= amount;
		}
		else if(typ.equalsIgnoreCase("orange"))
		{
			oranges -= amount;
		}
		else
		{
			System.out.println("Spelling mistake: " + typ);
		}
	}
	/**
	 * adds a donkey to player
	 * @pre: class has to be constructed first
	 * @post: player owns one more donkey
	 */
	public void add_donkey() // like get donkey 
	{
		donkeys++;
	}
	/**
	 * removes a donkey from player
	 * @pre: class has to be constructed first and player has to own a donkey
	 * @post: player owns one less donkey
	 */
	public void remove_donkey() // like use a donkey
	{
		donkeys--;
	}
	/**
	 * removes all donkeys from player
	 * @pre: class has to be constructed first
	 * @post: player owns no donkeys
	 */
	public void remove_all_donkey() 
	{
		donkeys = 0;
	}
	/**
	 * checks if player has joker 'large donkey cart'
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if the player still has this joker
	 */
	public boolean has_large_donkey_cart()
	{
		return largeDonkeyCart;
	}
	/**
	 * checks if player has joker 'gust of wind'
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if the player still has this joker
	 */
	public boolean has_gust_of_wind()
	{
		return gustOfWind;
	}
	/**
	 * checks if player has joker 'double move'
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if the player still has this joker
	 */
	public boolean has_double_move()
	{
		return doubleMove;
	}
	/**
	 * checks if player has joker 'pay one less'
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if the player still has this joker
	 */
	public boolean has_one_fruit_less()
	{
		return oneFruitLess;
	}
	/**
	 * player has used his joker, so the boolean is set to false
	 * @pre: class has to be constructed first
	 * @post: _large_donkey_cart is now false
	 */
	public void used_large_donkey_cart()
	{
		largeDonkeyCart = false;
	}
	/**
	 * player has used his joker, so the boolean is set to false
	 * @pre: class has to be constructed first
	 * @post: _gust_of_wind is now false
	 */
	public void used_gust_of_wind()
	{
		gustOfWind = false;
	}
	/**
	 * player has used his joker, so the boolean is set to false
	 * @pre: class has to be constructed first
	 * @post: _double_move is now false
	 */
	public void used_double_move()
	{
		doubleMove = false;
	}
	/**
	 * player has used his joker, so the boolean is set to false
	 * @pre: class has to be constructed first
	 * @post: _one_fruit_less is now false
	 */
	public void used_one_fruit_less()
	{
		oneFruitLess = false;
	}
	/**
	 * adds one fruit tile to players possession
	 * @pre: class has to be constructed first
	 * @post: player owns one more fruit tile
	 * @param: Fruittile, the element that should be added
	 */
	public void add_fruittile(E_Fruittile tile)
	{
		fruittiles.add(tile);
	}
	/**
	 * adds one finca tile to players possession
	 * @pre: class has to be constructed first
	 * @post: player owns one more finca tile
	 * @param: Fincatile, the element that should be added
	 */
	public void add_fincatile(E_Fincatile tile)
	{
		fincatiles.add(tile);
		points += 5;
	}
	/**
	 * adds one bonus tile to players possession
	 * @pre: class has to be constructed first
	 * @post: player owns one more bonus tile
	 * @param: Bonus_Plate, the element that should be added
	 */
	public void add_bonustile(E_Bonus_Plate tile)
	{
		bonustiles.add(tile);
	}	
	public void bonusCounterUp(int points)
	{
		if(points == 1)
			bonusCounter1++;
		if(points == 2)
			bonusCounter2++;
		if(points == 3)
			bonusCounter3++;
		if(points == 4)
			bonusCounter4++;
		if(points == 5)
			bonusCounter5++;
		if(points == 6)
			bonusCounter6++;
	}
	public void bonusCounter_down(){
		bonusCounter1--;
		bonusCounter2--;
		bonusCounter3--;
		bonusCounter4--;
		bonusCounter5--;
		bonusCounter6--;
	}
	public int get_bonusCounter1(){
		return bonusCounter1;
	}
	public int get_bonusCounter2(){
		return bonusCounter2;
	}
	public int get_bonusCounter3(){
		return bonusCounter3;
	}
	public int get_bonusCounter4(){
		return bonusCounter4;
	}
	public int get_bonusCounter5(){
		return bonusCounter5;
	}
	public int get_bonusCounter6(){
		return bonusCounter6;
	}
	
	public int getAmountOfFruitOnTiles(String fruit)
	{
		if(fruit.equalsIgnoreCase("almond"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_almond_cost();
			return fruitCounter;
		}
		
		else if(fruit.equalsIgnoreCase("fig"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_fig_cost();
			return fruitCounter;
		}
		else if(fruit.equalsIgnoreCase("grape"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_grape_cost();
			return fruitCounter;
		}
		else if(fruit.equalsIgnoreCase("lemon"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_lemon_cost();
			return fruitCounter;
		}
		else if(fruit.equalsIgnoreCase("olive"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_olive_cost();
			return fruitCounter;
		}
		else if(fruit.equalsIgnoreCase("orange"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_orange_cost();
			return fruitCounter;
		}
		else if(fruit.equalsIgnoreCase("riddle"))
		{
			int fruitCounter = 0;
			for(int i=0; i<fruittiles.size(); i++)
				fruitCounter += fruittiles.get(i).get_riddle_cost();
			return fruitCounter;
		}
		else
		{
			System.out.println("spelling mistake in player, getAmountOfFuitOnTiles");
			return 0;
		}
	}
}