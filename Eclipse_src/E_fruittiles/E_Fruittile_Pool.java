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
import java.util.*;

/**
 * This class is responsible to create all Fruit Tiles that are present in a finca gamebox.
 * It can also randomly give away those tiles, so the communities can be filled.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public final class E_Fruittile_Pool implements Serializable
{
	private ArrayList<E_Fruittile> _tile_array = new ArrayList<E_Fruittile>();
	Random generator = new Random();
	/**
	 * the constructor creates all 42 (mostly) different Finca tiles and stores them in an ArrayList
	 * @pre: -
	 * @post: the ArrayList _tile_array is filled with all Fincatiles the game has
	 */
	public E_Fruittile_Pool()
	{
		E_Fruittile a = new E_Fruittile(1, 1, 0, 0, 0, 0, 0, 0,"1-100-000-0.png");
		_tile_array.add(a);
		
		E_Fruittile b = new E_Fruittile(1, 0, 1, 0, 0, 0, 0, 0,"1-010-000-0.png");
		_tile_array.add(b);
		
		E_Fruittile c = new E_Fruittile(1, 0, 0, 1, 0, 0, 0, 0,"1-001-000-0.png");
		_tile_array.add(c);
		
		E_Fruittile d = new E_Fruittile(1, 0, 0, 0, 1, 0, 0, 0,"1-000-100-0.png");
		_tile_array.add(d);
		
		E_Fruittile e = new E_Fruittile(1, 0, 0, 0, 0, 1, 0, 0,"1-000-010-0.png");
		_tile_array.add(e);
		
		E_Fruittile f = new E_Fruittile(1, 0, 0, 0, 0, 0, 1, 0,"1-000-001-0.png");
		_tile_array.add(f);
		
		E_Fruittile g = new E_Fruittile(2, 2, 0, 0, 0, 0, 0, 0,"2-200-000-0.png");
		_tile_array.add(g);
		
		E_Fruittile h = new E_Fruittile(2, 0, 2, 0, 0, 0, 0, 0,"2-020-000-0.png");
		_tile_array.add(h);
		
		E_Fruittile i = new E_Fruittile(2, 0, 0, 2, 0, 0, 0, 0,"2-002-000-0.png");
		_tile_array.add(i);
		
		E_Fruittile j = new E_Fruittile(2, 0, 0, 0, 2, 0, 0, 0,"2-000-200-0.png");
		_tile_array.add(j);
		
		E_Fruittile k = new E_Fruittile(2, 0, 0, 0, 0, 2, 0, 0,"2-000-020-0.png");
		_tile_array.add(k);
		
		E_Fruittile l = new E_Fruittile(2, 0, 0, 0, 0, 0, 2, 0,"2-000-002-0.png");
		_tile_array.add(l);
		
		E_Fruittile m = new E_Fruittile(3, 3, 0, 0, 0, 0, 0, 0,"3-300-000-0.png");
		_tile_array.add(m);
		
		E_Fruittile n = new E_Fruittile(3, 0, 3, 0, 0, 0, 0, 0,"3-030-000-0.png");
		_tile_array.add(n);
		
		E_Fruittile o = new E_Fruittile(3, 0, 0, 3, 0, 0, 0, 0,"3-003-000-0.png");
		_tile_array.add(o);
		
		E_Fruittile p = new E_Fruittile(3, 0, 0, 0, 3, 0, 0, 0,"3-000-300-0.png");
		_tile_array.add(p);
		
		E_Fruittile q = new E_Fruittile(3, 0, 0, 0, 0, 3, 0, 0,"3-000-030-0.png");
		_tile_array.add(q);
		
		E_Fruittile r = new E_Fruittile(3, 0, 0, 0, 0, 0, 3, 0,"3-000-003-0.png");
		_tile_array.add(r);
		
		E_Fruittile s = new E_Fruittile(4, 0, 0, 0, 0, 0, 0, 4,"4-000-000-4.png");
		_tile_array.add(s);
		
		E_Fruittile t = new E_Fruittile(4, 0, 0, 0, 0, 0, 0, 4,"4-000-000-4.png");
		_tile_array.add(t);
		
		E_Fruittile u = new E_Fruittile(4, 0, 0, 0, 0, 0, 0, 4,"4-000-000-4.png");
		_tile_array.add(u);
		
		E_Fruittile v = new E_Fruittile(4, 2, 2, 0, 0, 0, 0, 0,"4-220-000-0.png");
		_tile_array.add(v);
		
		E_Fruittile w = new E_Fruittile(4, 2, 0, 0, 0, 0, 2, 0,"4-200-002-0.png");
		_tile_array.add(w);
		
		E_Fruittile x = new E_Fruittile(4, 0, 0, 0, 2, 2, 0, 0,"4-000-220-0.png");
		_tile_array.add(x);
		
		E_Fruittile y = new E_Fruittile(4, 0, 2, 0, 2, 0, 0, 0,"4-020-200-0.png");
		_tile_array.add(y);
		
		E_Fruittile z = new E_Fruittile(4, 0, 0, 2, 0, 2, 0, 0,"4-002-020-0.png");
		_tile_array.add(z);
		
		E_Fruittile aa = new E_Fruittile(4, 0, 0, 2, 0, 0, 2, 0,"4-002-002-0.png");
		_tile_array.add(aa);
		
		E_Fruittile ab = new E_Fruittile(5, 0, 0, 0, 0, 0, 0, 5,"5-000-000-5.png");
		_tile_array.add(ab);
		
		E_Fruittile ac = new E_Fruittile(5, 0, 0, 0, 0, 0, 0, 5,"5-000-000-5.png");
		_tile_array.add(ac);
		
		E_Fruittile ad = new E_Fruittile(5, 0, 0, 0, 0, 0, 0, 5,"5-000-000-5.png");
		_tile_array.add(ad);
		
		E_Fruittile ae = new E_Fruittile(5, 3, 0, 2, 0, 0, 0, 0,"5-302-000-0.png");
		_tile_array.add(ae);
		
		E_Fruittile af = new E_Fruittile(5, 0, 3, 0, 0, 2, 0, 0,"5-030-020-0.png");
		_tile_array.add(af);
		
		E_Fruittile ag = new E_Fruittile(5, 0, 0, 0, 3, 0, 2, 0,"5-000-302-0.png");
		_tile_array.add(ag);
		
		E_Fruittile ah = new E_Fruittile(5, 0, 2, 0, 0, 0, 3, 0,"5-020-003-0.png");
		_tile_array.add(ah);
		
		E_Fruittile ai = new E_Fruittile(5, 2, 0, 0, 0, 3, 0, 0,"5-200-030-0.png");
		_tile_array.add(ai);
		
		E_Fruittile aj = new E_Fruittile(6, 0, 0, 0, 0, 0, 0, 6,"6-000-000-6.png");
		_tile_array.add(aj);
		
		E_Fruittile ak = new E_Fruittile(6, 0, 0, 0, 0, 0, 0, 6,"6-000-000-6.png");
		_tile_array.add(ak);
		
		E_Fruittile al = new E_Fruittile(6, 0, 0, 0, 0, 0, 0, 6,"6-000-000-6.png");
		_tile_array.add(al);
		
		E_Fruittile am = new E_Fruittile(6, 1, 1, 1, 1, 1, 1, 0,"6-111-111-0.png");
		_tile_array.add(am);
		
		E_Fruittile an = new E_Fruittile(6, 1, 1, 1, 1, 1, 1, 0,"6-111-111-0.png");
		_tile_array.add(an);
		
		E_Fruittile ao = new E_Fruittile(6, 1, 1, 1, 1, 1, 1, 0,"6-111-111-0.png");
		_tile_array.add(ao);
		
		E_Fruittile ap = new E_Fruittile(5, 0, 0, 3, 2, 0, 0, 0,"5-003-200-0.png");
		_tile_array.add(ap);
		
	}
	/**
	 * class removes a random Fruit tile from the arrayList and returns it
	 * @pre: class has to be constructed and arrayList can't be empty
	 * @post: one less element is in the arrayList
	 * @return: a Object of the type Fincatile from a random position of the arrayList
	 */
	public E_Fruittile get_random_tile()
	{
		int vecsize=_tile_array.size();
	    int randomnumber = generator.nextInt(vecsize);
	    E_Fruittile chosenOne=_tile_array.get(randomnumber);
	    _tile_array.remove(randomnumber);		
	    return chosenOne;
	}
}
