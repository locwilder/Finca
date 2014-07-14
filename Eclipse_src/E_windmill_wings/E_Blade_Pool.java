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
import java.util.*;

import E_fruittiles.E_Fruittile;

/**
 * This class is responsible to create all Windmill Blades that are present in a finca gamebox.
 * It can also randomly give away those blades, so the Windmill can be filled.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public final class E_Blade_Pool implements Serializable
{
	private ArrayList<E_Blade> pool = new ArrayList<E_Blade>();
	private Random rand = new Random();
	
	/**
	 * the constructor creates all 12 windmill blades and stores them in an ArrayList
	 * @pre: -
	 * @post: the arrayList pool is filled with all windmill blades the game has
	 */
	public E_Blade_Pool()
	{
		pool.add(new E_Blade("almond"));
		pool.add(new E_Blade("almond"));
		pool.add(new E_Blade("fig"));
		pool.add(new E_Blade("fig"));
		pool.add(new E_Blade("grape"));
		pool.add(new E_Blade("grape"));
		pool.add(new E_Blade("lemon"));
		pool.add(new E_Blade("lemon"));
		pool.add(new E_Blade("olive"));
		pool.add(new E_Blade("olive"));
		pool.add(new E_Blade("orange"));
		pool.add(new E_Blade("orange"));
	}
	/**
	 * class removes a random windmill blade from the arrayList and returns it
	 * @pre: class has to be constructed and arrayList can't be empty
	 * @post: one less element is in the arrayList
	 * @return: a Object of the type Blade from a random position of the arrayList
	 */
	public E_Blade get_random()
	{
		
		int arr_size = pool.size();
		int random_num = rand.nextInt(arr_size);
		E_Blade chosenOne = pool.remove(random_num);
		return chosenOne;
	}

}
