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
import java.util.*;

import E_fruittiles.E_Fruittile_Pool;

import E_player.E_Bonus_Plate;

/**
 * This class represents the map.
 * It contains 10 districts and a windmill.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Map implements Serializable
{
	private ArrayList<E_Community> _communities = new ArrayList<E_Community>();
	private E_Windmill _windmill = new E_Windmill();
	private ArrayList<E_Bonus_Plate> _bonustiles = new ArrayList<E_Bonus_Plate>();
	
	private E_Fruittile_Pool _fruitpool;
	private E_Fincatiles_Pool _fincapool;
	
	private int _number_of_players;
	
	private int _grape_pool;
	private int _orange_pool;
	private int _lemon_pool;
	private int _olive_pool;
	private int _fig_pool;
	private int _almond_pool;
	
	private int _donkey_pool_size;
	private int _donkey_pool_max;	
	
	/**
	 * the constructor creates the map with the parameter given
	 * @pre: -
	 * @post: all instance variables are initialized with default or the given value
	 * @param: int, number of players in this game
	 */
	public E_Map(int number_of_players)
	{
		_fruitpool = new E_Fruittile_Pool();
		_fincapool = new E_Fincatiles_Pool();
		
		for(int i=0; i<10; i++)
		{
			_communities.add(new E_Community());
		}
		for(int i=0; i<10; i++)
		{
			_communities.get(i).addFincatile(_fincapool.get_random());
			
			_communities.get(i).addFruittile(_fruitpool.get_random_tile());
			_communities.get(i).addFruittile(_fruitpool.get_random_tile());
			_communities.get(i).addFruittile(_fruitpool.get_random_tile());
			_communities.get(i).addFruittile(_fruitpool.get_random_tile());
		}
		
		
		_number_of_players = number_of_players;
		
		_donkey_pool_max = 2*_number_of_players;
		_donkey_pool_size = _donkey_pool_max;
		
		_grape_pool = 18;
		_orange_pool = 18;
		_lemon_pool = 18;
		_olive_pool = 18;
		_fig_pool = 18;
		_almond_pool = 18;
		
		_windmill.init();
		
		for(int i=7; i>3; i--)
		{
			_bonustiles.add(new E_Bonus_Plate(i));
		}
	}
	/**
	 * adds a fruit type to the gameboard
	 * @pre: class has to be constructed first
	 * @post: more fruits in the pool
	 * @param: 1. String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange')
	 * 		   2. int, how many are added
	 */
	public void add_fruit(String fruit_, int amount_)
	{
		if(fruit_.equalsIgnoreCase("almond"))
		{
			_almond_pool = _almond_pool + amount_;
		}
		else if(fruit_.equalsIgnoreCase("olive"))
		{
			_olive_pool = _olive_pool + amount_;
		}
		else if(fruit_.equalsIgnoreCase("fig"))
		{
			_fig_pool = _fig_pool + amount_;
		}
		else if(fruit_.equalsIgnoreCase("lemon"))
		{
			_lemon_pool = _lemon_pool + amount_;
		}
		else if(fruit_.equalsIgnoreCase("grape"))
		{
			_grape_pool = _grape_pool + amount_;
		}
		else if(fruit_.equalsIgnoreCase("orange"))
		{
			_orange_pool = _orange_pool + amount_;
		}
		else
		{
			// unkonwn string
			System.out.println("spelling mistake: " + fruit_);
		}
	}
	/**
	 * removes a fruit type to the gameboard
	 * @pre: class has to be constructed first
	 * @post: less fruits in the pool
	 * @param: 1. String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange')
	 * 		   2. int, how many are removed
	 */
	public void remove_fruit(String fruit_, int amount_)
	{
		if(fruit_.equalsIgnoreCase("almond"))
		{
			_almond_pool = _almond_pool - amount_;
		}
		else if(fruit_.equalsIgnoreCase("olive"))
		{
			_olive_pool = _olive_pool - amount_;
		}
		else if(fruit_.equalsIgnoreCase("fig"))
		{
			_fig_pool = _fig_pool - amount_;
		}
		else if(fruit_.equalsIgnoreCase("lemon"))
		{
			_lemon_pool = _lemon_pool - amount_;
		}
		else if(fruit_.equalsIgnoreCase("grape"))
		{
			_grape_pool = _grape_pool - amount_;
		}
		else if(fruit_.equalsIgnoreCase("orange"))
		{
			_orange_pool = _orange_pool - amount_;
		}
		else
		{
			// unkonwn string
			System.out.println("spelling mistake: " + fruit_);
		}
	}
	/**
	 * adds a donkey to the gameboard
	 * @pre: class has to be constructed first
	 * @post: one more donkey in the pool
	 */
	public void add_donkey()
	{
		_donkey_pool_size++;
	}
	/**
	 * removes a donkey to the gameboard
	 * @pre: class has to be constructed first
	 * @post: one less donkey in the pool
	 */
	public void remove_donkey()
	{
		_donkey_pool_size--;
	}
	/**
	 * getter for the amount of fruit of one type left on the map.
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: String, what fruit ('almond', 'fig', 'grape', 'lemon', 'olive', 'orange') 
	 * @return: int, amount of asked fruits left
	 */
	public int get_amount(String fruit_)
	{
		if(fruit_.equalsIgnoreCase("almond"))
		{
			return _almond_pool;
		}
		else if(fruit_.equalsIgnoreCase("olive"))
		{
			return _olive_pool;
		}
		else if(fruit_.equalsIgnoreCase("fig"))
		{
			return _fig_pool;
		}
		else if(fruit_.equalsIgnoreCase("lemon"))
		{
			return _lemon_pool;
		}
		else if(fruit_.equalsIgnoreCase("grape"))
		{
			return _grape_pool;
		}
		else if(fruit_.equalsIgnoreCase("orange"))
		{
			return _orange_pool;
		}
		else
		{
			// unkonwn string
			System.out.println("spelling mistake: " + fruit_);
			return 0;
		}
	}
	/**
	 * getter for the amount of donkey left on the map.
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int, amount of donkeys left
	 */
	public int get_donkycount()
	{
		return _donkey_pool_size;
	}
	/**
	 * donkey pool is refilled to its maximum
	 * @pre: class has to be constructed first
	 * @post: donkey pool is full
	 */
	public void refill_donkeys()
	{
		_donkey_pool_size = _donkey_pool_max;
	}
	/**
	 * getter for arraylist with all bonustiles.
	 * most valuable one is at the front (index 0)
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: arrayList, all bonustiles left
	 */
	public ArrayList<E_Bonus_Plate> get_all_bonustiles()
	{
		return _bonustiles;
	}
	/**
	 * removes the most valuable bonus tile an returns it
	 * @pre: class has to be constructed first
	 * @post: one less bonus tile in arrayList
	 * @return: Bonus_Plate, the one with the highest value thats left or null if all gone
	 */
	public E_Bonus_Plate remove_bonustile()
	{
		if(_bonustiles.size()>0)
			return _bonustiles.remove(0);
		else
			return null;
	}
	/**
	 * getter for arraylist with all communities.
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: arrayList, all communities
	 */
	public ArrayList<E_Community> get_communities()
	{
		return _communities;
	}
	/**
	 * getter for the windmill
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: Windmill, the windmill
	 */
	public E_Windmill get_windmill()
	{
		return _windmill;
	}
}
