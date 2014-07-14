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

import E_fruittiles.E_Fruittile;


/**
 * This class represents a community of the game board.
 * it contains 0 to 4 fruit tiles an 0 to 1 finca tile.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Community implements Serializable
{
	private E_Fincatile _fincatile;
	private ArrayList<E_Fruittile> _fruittiles = new ArrayList<E_Fruittile>();
	
	public E_Community()
	{
		
	}
	/**
	 * getter for the finca tile
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: Fincatile, the finca tile
	 */
	public E_Fincatile get_fincatile() 
	{
		return _fincatile;
	}
	/**
	 * removes the finca tile
	 * @pre: class has to be constructed first
	 * @post: the finca tile is set to null
	 * @return: Fincatile, the finca tile
	 */
	public E_Fincatile remove_fincatile()
	{
		E_Fincatile tmp = _fincatile;
		_fincatile = null;
		return tmp;
	}
	/**
	 * getter for the number of fruit tiles
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int, the fruit tile arrayList size
	 */
	public int get_number_of_fruittiles() 
	{
		return _fruittiles.size();
	}
	/**
	 * getter for the top fruit tile
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: Fruittile, the one on top. null if there all gone
	 */
	public E_Fruittile get_top_fruittile()
	{
		if(!_fruittiles.isEmpty())
			return _fruittiles.get(get_number_of_fruittiles()-1);
		
		else
			return null;
	}
	/**
	 * removes the top fruit tile
	 * @pre: class has to be constructed first
	 * @post: one less fruit tile in the arrayList
	 * @return: Fruittile, the one on top. null if there all gone
	 */
	public E_Fruittile remove_fruittile()
	{
		if(!_fruittiles.isEmpty())
			return _fruittiles.remove(get_number_of_fruittiles()-1);
		
		else
			return null;
	}
	/**
	 * getter for the arrayList with all fruit tile.
	 * used for tests, but also to get the size.
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: arrayList, containing all fruittiles
	 */
	public ArrayList<E_Fruittile> get_all_fruittiles()
	{
		return _fruittiles;
	}
	/**
	 * adds a fruit tile. used by map in the initialization process.
	 * @pre: class has to be constructed first
	 * @post: one more fruit tile in the arrayList
	 * @param: the fruittile to add
	 */
	public void addFruittile(E_Fruittile element)
	{
		_fruittiles.add(element);
	}
	/**
	 * adds a finca tile. used by map in the initialization process.
	 * @pre: class has to be constructed first
	 * @post: fruittile is saved in class
	 * @param: the fincatile to add
	 */
	public void addFincatile(E_Fincatile element)
	{
		_fincatile = element;
	}
}