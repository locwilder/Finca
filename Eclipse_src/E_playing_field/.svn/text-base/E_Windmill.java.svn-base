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

import E_windmill_wings.E_Blade;
import E_windmill_wings.E_Blade_Pool;

/**
 * This class represents the windmill on the playing field where farmers move.
 * It consists of 12 blades, saved in an array
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Windmill implements Serializable
{
	private E_Blade_Pool _blade_pool;
	private E_Blade[] _blades;
	
	/**
	 * used to initialize the windmill -> blades are put on it
	 * @pre: class has to be constructed first
	 * @post: blades are now on the windmill in random order
	 */
	public void init()
	{
		_blade_pool = new E_Blade_Pool();
		_blades = new E_Blade[12];
		
		for(int i=0; i<12; i++)
		{
			_blades[i] = _blade_pool.get_random();
		}
	}
	
	/**
	 * getter for the blades
	 * @pre: class has to be constructed and initialized first
	 * @post: -
	 * @return: Blade[] containing all blades
	 */
	public E_Blade[] get_blade_array()
	{
		return _blades;
	}
}
