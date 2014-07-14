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

/**
 * This class is responsible to create all finca tiles that are present in a finca gamebox.
 * It can also randomly give away those tiles, so the communities can be filled.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public final class E_Fincatiles_Pool implements Serializable
{
	private ArrayList<E_Fincatile> _fincatiles = new ArrayList<E_Fincatile>();
	Random generator = new Random();
	/**
	 * the constructor creates all 10 finca tiles and stores them in an ArrayList
	 * @pre: -
	 * @post: the arrayList _fincatiles is filled with all finca tiles the game has
	 */
	public E_Fincatiles_Pool()
	{
		//almond
		E_Fincatile a = new E_Fincatile(true, false, false, false, false, false, false, "fincat_5_almond.png");
		_fincatiles.add( a);
		//fig
		E_Fincatile b = new E_Fincatile(false, true, false, false, false, false, false, "fincat_5_fig.png");
		_fincatiles.add(b);
		//grape
		E_Fincatile c =new E_Fincatile(false, false, true, false, false, false, false, "fincat_5_grape.png");
		_fincatiles.add(c);
		//lemon
		E_Fincatile d = new E_Fincatile(false, false, false, true, false, false, false, "fincat_5_lemon.png"); 
		_fincatiles.add(d);
		//olive
		E_Fincatile e = new E_Fincatile(false, false, false, false, true, false, false, "fincat_5_olive.png");
		_fincatiles.add(e);
		//orange
		E_Fincatile f = new E_Fincatile(false, false, false, false, false, true, false, "fincat_5_orange.png");
		_fincatiles.add(f);
		//riddle
		E_Fincatile g = new E_Fincatile(false, false, false, false, false, false, true, "fincat_5_riddle.png");
		_fincatiles.add(g);
		//almond + fig
		E_Fincatile h = new E_Fincatile(true, true, false, false, false, false, false, "fincat_5_almond_fig.png");
		_fincatiles.add(h);
		//grape + orange
		E_Fincatile i = new E_Fincatile(false, false, true, false, false, true, false, "fincat_5_grape_orange.png");
		_fincatiles.add(i);
		//lemon + olive
		E_Fincatile j = new E_Fincatile(false, false, false, true, true, false, false, "fincat_5_olive_lemon.png");
		_fincatiles.add(j);
	}
	/**
	 * class removes a random finca tile from the arrayList and returns it
	 * @pre: class has to be constructed and arrayList can't be empty
	 * @post: one less element is in the arrayList
	 * @return: a Object of the type Fincatile from a random position of the arrayList
	 */
	public E_Fincatile get_random()
	{
		int arraysize=_fincatiles.size();
	    int randomnumber = generator.nextInt(arraysize);
	    E_Fincatile chosenOne = _fincatiles.remove(randomnumber);
		return chosenOne;
	}
}
