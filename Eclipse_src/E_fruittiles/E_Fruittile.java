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


package E_fruittiles;

import java.io.Serializable;

/**
 * This class represents a fruit tile. Those are the plates each community initially 
 * has four of, that can be bought by the players. 
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Fruittile implements Serializable
{
	private int _points;
	private int _almond_cost;
	private int _fig_cost;
	private int _grape_cost;
	private int _lemon_cost;
	private int _olive_cost;
	private int _orange_cost;
	private int _riddle_cost;
	private String _tile_name;
	/**
	 * the constructor creates one fruit tile with the parameters given
	 * @pre: -
	 * @post: all instance variables are initialized with the given value
	 * @param: 1.:  int, representing points the tile gives a player when bought
	 * 		   2-8: int, each representing how much of one resource the tile costs to buy
	 * 		   9.:  String, saves the name the corresponding picture has
	 */
	public E_Fruittile(int points, int almonds, int figs, int grapes, int lemons, int olives, int oranges, int riddle_cost, String fname)
	{
		_points = points;
		_almond_cost = almonds;
		_fig_cost = figs;
		_grape_cost = grapes;
		_lemon_cost = lemons;
		_olive_cost = olives;
		_orange_cost = oranges;
		_riddle_cost = riddle_cost;
		_tile_name = fname;
	}
	/**
	 * getter for points
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates points
	 */
	public int get_points()
	{
		return _points;
	}
	/**
	 * getter for almond cost
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates almond cost
	 */
	public int get_almond_cost()
	{
		return _almond_cost;
	}
	/**
	 * getter for fig cost
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates fig cost
	 */
	public int get_fig_cost()
	{
		return _fig_cost;
	}
	/**
	 * getter for grape cost
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates grape cost
	 */
	public int get_grape_cost()
	{
		return _grape_cost;
	}
	/**
	 * getter for lemon cost
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates lemon cost
	 */
	public int get_lemon_cost()
	{
		return _lemon_cost;
	}
	/**
	 * getter for olive cost
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates olive cost
	 */
	public int get_olive_cost()
	{
		return _olive_cost;
	}
	/**
	 * getter for orange cost
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates orange cost
	 */
	public int get_orange_cost()
	{
		return _orange_cost;
	}
	/**
	 * getter for riddle cost(those with the question mark on it)
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates riddle cost
	 */
	public int get_riddle_cost()
	{
		return _riddle_cost;
	}
	/**
	 * getter for the name
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: String equals to the name of the plates' picture 
	 */
	public String get_tile_name()
	{
		return _tile_name;
	}
}
