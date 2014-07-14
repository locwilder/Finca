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

public class E_BluePlayerInfo extends E_PlayerInfos {

	public E_BluePlayerInfo(E_FincaClient my_client) {
		super(my_client);
		this.playerNumber = 0;
		defaultBackgroundColor = new Color(85,100,217,65);
		activeBackgroundColor = new Color(25,166,247,200);
		
		figurePath = getClass().getResource("/media/finca pics/figure-blue.png");
		joker1Path = getClass().getResource("/media/finca pics/blue-joker-1.png");
		joker2Path = getClass().getResource("/media/finca pics/blue-joker2m.png");
		joker3Path = getClass().getResource("/media/finca pics/blue-joker10.png");
		joker4Path = getClass().getResource("/media/finca pics/blue-jokertelep.png");
		init();
				
	}

}
