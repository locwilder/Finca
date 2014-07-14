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


package E_windmill_wings;

import java.io.Serializable;
/**
 * This class represents a windmill blade. Those are the plates that are placed on the
 * windmill in random order before the game starts.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Blade implements Serializable
{
	protected int _player_0_farmers;
	protected int _player_1_farmers;
	protected int _player_2_farmers;
	protected int _player_3_farmers;
	
	protected String _resource_typ;
	
	/**
	 * the constructor creates one blade tile with the parameter given and sets
	 * the farmer counters of the different players to 0;
	 * @pre: -
	 * @post: all instance variables are initialized with the given value
	 * @param: String, the resource that is printed on the blade
	 */
	public E_Blade(String resource_typ)
	{
		_resource_typ = resource_typ;
		
		_player_0_farmers = 0;
		_player_1_farmers = 0;
		_player_2_farmers = 0;
		_player_3_farmers = 0;
	}
	/**
	 * adds a farmer of a player to this blade
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: int equal to the players index in the game boards player array (0-3)
	 */
	public void add_farmer(int player_)
	{
		if(player_ == 0)
			_player_0_farmers++;
		if(player_ == 1)
			_player_1_farmers++;
		if(player_ == 2)
			_player_2_farmers++;
		if(player_ == 3)
			_player_3_farmers++;
	}
	/**
	 * removes a farmer of a player from this blade
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: int equal to the players index in the game boards player array (0-3)
	 */
	public void remove_farmer(int player_)
	{
		if(player_ == 0)
			_player_0_farmers--;
		if(player_ == 1)
			_player_1_farmers--;
		if(player_ == 2)
			_player_2_farmers--;
		if(player_ == 3)
			_player_3_farmers--;
	}
	/**
	 * getter for total number of farmers on this blade
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: int equals to the number of farmers here
	 */
	public int get_num_of_farmers()
	{
		return _player_0_farmers + _player_1_farmers + _player_2_farmers + _player_3_farmers;
	}
	/**
	 * getter for the resource type of this blade
	 * @pre: class has to be constructed first
	 * @post: -
	 * @return: String equals to the resource type
	 */
	public String get_resource_typ()
	{
		return _resource_typ;
	}
	/**
	 * checks if a certain player has at least one farmer here
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: int equal to the players index in the game boards player array (0-3)
	 * @return: boolean, true if player has at least 1 farmer here
	 */
	public boolean has_farmer_here(int player_)
	{
		if(player_ == 0)
			return (_player_0_farmers > 0);
		else if(player_ == 1)
			return (_player_1_farmers > 0);
		else if(player_ == 2)
			return (_player_2_farmers > 0);
		else if(player_ == 3)
			return (_player_3_farmers > 0);
		else
		{
			System.out.println("no player at index " + player_);
			return false;
		}
	}
	/**
	 * checks how many farmer a player has on this blade
	 * @pre: class has to be constructed first
	 * @post: -
	 * @param: int equal to the players index in the game boards player array (0-3)
	 * @return: int equal to the number of farmers player has here
	 */
	public int num_of_farmers(int player_)
	{
		if(player_ == 0)
			return _player_0_farmers;
		else if(player_ == 1)
			return _player_1_farmers;
		else if(player_ == 2)
			return _player_2_farmers;
		else if(player_ == 3)
			return _player_3_farmers;
		else
		{
			System.out.println("no player at index " + player_);
			return 0;
		}
	}
}
