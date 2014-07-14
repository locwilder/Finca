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
/**
 * This class represents a finca tile. Those are the plates each community initially 
 * has one of, that are given to a player when the last fruit tile is gone. 
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Fincatile implements Serializable
{
	private int _points = 5;
	private String _name;
	private boolean _almond = false;
	private boolean _fig = false;
	private boolean _grape = false;
	private boolean _lemon = false;
	private boolean _olive = false;
	private boolean _orange = false;
	private boolean _riddle = false;
	/**
	 * the constructor creates one fruit tile with the parameters given
	 * @pre: -
	 * @post: all instance variables are initialized with the given value
	 * @param: 1-7: boolean, each saying if the resource is present on the plate
	 * 		   8.:  String, saves the name the corresponding picture has
	 */
	public E_Fincatile(boolean alm, boolean fig, boolean gra, boolean lem, boolean oli, boolean ora, boolean rid, String fincaname)
	{
		_points = 5;
		_almond = alm;
		_fig = fig;
		_grape = gra;
		_lemon = lem;
		_olive = oli;
		_orange = ora;
		_riddle = rid;
		_name = fincaname;
		
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
	 * getter for almond presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_almond() 
	{
		return _almond;
	}
	/**
	 * getter for fig presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_fig() 
	{
		return _fig;
	}
	/**
	 * getter for grape presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_grape() 
	{
		return _grape;
	}
	/**
	 * getter for lemon presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_lemon() 
	{
		return _lemon;
	}
	/**
	 * getter for olive presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_olive() 
	{
		return _olive;
	}
	/**
	 * getter for orange presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_orange() 
	{
		return _orange;
	}
	/**
	 * getter for riddle presence
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: boolean, true if this resource is on the tile
	 */
	public boolean is_riddle() 
	{
		return _riddle;
	}
	/**
	 * getter for the name
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: String equals to the name of the plates' picture 
	 */
	public String get_name()
	{
		return _name;
	}
	
} 
