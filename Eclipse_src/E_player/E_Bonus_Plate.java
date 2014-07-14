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
/**
 * This class represents a bonus tile. Those are the plates each player gets, as 
 * soon as he owns Fruit tiles with all the values from 1 to 6
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Bonus_Plate implements Serializable
{
	int points;
	/**
	 * the constructor creates one bonus tile with the parameter given
	 * @pre: -
	 * @post: the instance variable is initialized with the given value
	 * @param: int representing the tiles value
	 */
	public E_Bonus_Plate(int value)
	{
		points = value;
	}
	/**
	 * getter for value of tile
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the plates points
	 */
	public int get_value()
	{
		return points;
	}
	
}
