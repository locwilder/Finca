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


package E_view.player;

import java.awt.Color;

import E_client.E_FincaClient;

public class E_RedPlayerInfo extends E_PlayerInfos {

	public E_RedPlayerInfo(E_FincaClient my_client) {
		super(my_client);
		this.playerNumber = 1;
		defaultBackgroundColor = new Color(220,100,100,65);
		activeBackgroundColor = new Color(246,39,18,200);

		figurePath = getClass().getResource("/media/finca pics/figure-red.png");
		joker1Path = getClass().getResource("/media/finca pics/red-joker-1.png");
		joker2Path = getClass().getResource("/media/finca pics/red-joker2m.png");
		joker3Path = getClass().getResource("/media/finca pics/red-joker10.png");
		joker4Path = getClass().getResource("/media/finca pics/red-jokertelep.png");
		init();
	}

}
