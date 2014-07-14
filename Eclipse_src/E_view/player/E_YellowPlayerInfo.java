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

public class E_YellowPlayerInfo extends E_PlayerInfos {

	public E_YellowPlayerInfo(E_FincaClient my_client) {
		super(my_client);
		this.playerNumber = 2;
		defaultBackgroundColor = new Color(245,245,24,65);
		activeBackgroundColor = new Color(255,241,27,200);
		
		figurePath = getClass().getResource("/media/finca pics/figure-yellow.png");
		joker1Path = getClass().getResource("/media/finca pics/yellow-joker-1.png");
		joker2Path = getClass().getResource("/media/finca pics/yellow-joker2m.png");
		joker3Path = getClass().getResource("/media/finca pics/yellow-joker10.png");
		joker4Path = getClass().getResource("/media/finca pics/yellow-jokertelep.png");
		init();
	}

}