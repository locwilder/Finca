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
import java.rmi.RemoteException;

import javax.swing.border.EtchedBorder;
import java.util.*;
import E_client.E_FincaClient;
import E_playing_field.E_GameBoard;
/**
 * This class represents the rules of the game. Each time the player makes an input (turn) via GUI, one of
 * this classes methodes is called. The class checks if the turn is valid and if so changes the game board
 * in the way the players turn is changing things.
 * For this, the class has several states.
 * @author Michael Keller
 * @version 
 * @responsibilities
 */
public class E_Turn implements Serializable
{
	
	//generall needed information
	private int playerNumber;
	private int numberOfPlayers;
	//setupCounter is used for the setup-phase to place the farmers on the blades
	private int setupCounter; 
	//counts how many fruits the player has already delivered this turn
	private int alreadyDeliveredFruits = 0;
	private ArrayList<Integer> deliveredCommunities;
	//different states 
	private boolean hasMadeMinTurn = false;
	private boolean hasMadeFullTurn = false;
	private boolean moveTwiceMode = false;
	private boolean secondMoveMode = false;
	private boolean gustOfWindMode1 = false;
	private boolean gustOfWindMode2 = false;
	private int 	gustOfWindStartBlade = -1;
	private boolean largeDonkeyMode = false;
	private boolean payLessMode = false;
	private String oneLessFruit = "";
	private boolean isPayingLessNow = false;

	/**
	 * the constructor creates one turn class
	 * @pre: -
	 * @post: the instance variables is initialized with either the given values or default values
	 * @param: 1. int containing the players number (= index in player array -> 0-3)
	 * 		   2. int containing the total number of players
	 */
	public E_Turn(int playerNumber, int numberOfPlayers){
		deliveredCommunities = new ArrayList<Integer>();
		this.playerNumber = playerNumber;
		this.numberOfPlayers = numberOfPlayers;

		if(this.numberOfPlayers == 4)
			setupCounter = 3;
		if(this.numberOfPlayers == 3)
			setupCounter = 4;
		if(this.numberOfPlayers == 2)
			setupCounter = 5;
	}
	
	

	/**
	 * called by the GUI when a windmill-blade has been clicked
	 * @pre: class has to be constructed first
	 * @post: depends...
	 * @param: 1. int specifying the pressed blade (0-11)
	 * 		   2. GameBoard the game board
	 * @return: boolean, true if he made a whole successful turn -> turn could be ended
	 */
	public boolean useWindmillBlade(int bladeNumber_, E_GameBoard gameboard_)
	{
		if(moveTwiceMode)
			return doubleMove(bladeNumber_, gameboard_);
		if(gustOfWindMode1)
			return gustOfWindStart(bladeNumber_, gameboard_);
		if(gustOfWindMode2)
			return gustOfWindMove(bladeNumber_, gameboard_);
		//this.isMyTurn && this.alreadyDeliveredFruits == 0 && !largeDonkeyMode && !payLessMode
		if(this.alreadyDeliveredFruits == 0 && !largeDonkeyMode && !payLessMode && !hasMadeFullTurn)
		{
			//if it's still setup-phase
			if(this.setupCounter > 0)
			{
				//adds a farmer to a windmillblade
				gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].add_farmer(playerNumber);
				//give one fruit of the blades fruit type
				String fruit = gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].get_resource_typ();
				gameboard_.remove_fruit_pool(fruit, 1);
				gameboard_.add_fruit_player(fruit, 1, playerNumber);
				//one less farmer to set
				setupCounter--;
				hasMadeMinTurn = true;
				hasMadeFullTurn = true;
				return true;
			}

			//used after the setup phase
			else
			{
				//only react if there is a farmer of this player here
				if(gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].has_farmer_here(playerNumber))
				{
					//move the farmer forward by blades equal to the number of farmers on his blade
					int steps = gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].get_num_of_farmers();
					gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].remove_farmer(playerNumber);
					gameboard_.getMap().get_windmill().get_blade_array()[(bladeNumber_+steps)%12].add_farmer(playerNumber);
					//take fruit from the map and give it to the player
					int fruitamount = gameboard_.getMap().get_windmill().get_blade_array()[(bladeNumber_+steps)%12].get_num_of_farmers();
					String fruit = gameboard_.getMap().get_windmill().get_blade_array()[(bladeNumber_+steps)%12].get_resource_typ();
					gameboard_.remove_fruit_pool(fruit, fruitamount);
					gameboard_.add_fruit_player(fruit, fruitamount, playerNumber);
					//if farmer passed line: gameboard gives donkey-cart
					if(steps <= 6)
					{
						if(bladeNumber_ >= 0 && bladeNumber_ <= 5)
						{
							if( (bladeNumber_+steps) > 5)
							{
								gameboard_.remove_donkey_pool();
								gameboard_.add_donkey_player(playerNumber);
							}
						}
						if(bladeNumber_ >= 6 && bladeNumber_ <= 11)
						{
							if( (bladeNumber_+steps) > 11)
							{
								gameboard_.remove_donkey_pool();
								gameboard_.add_donkey_player(playerNumber);
							}
						}
					}
					if(steps > 6)
					{
						gameboard_.remove_donkey_pool();
						gameboard_.add_donkey_player(playerNumber);

						if(bladeNumber_ >= 0 && bladeNumber_ <= 5)
						{
							if( (bladeNumber_+steps) > 11)
							{
								gameboard_.remove_donkey_pool();
								gameboard_.add_donkey_player(playerNumber);
							}
						}
						if(bladeNumber_ >= 6 && bladeNumber_ <= 11)
						{
							if( (bladeNumber_+steps) > 17)
							{
								gameboard_.remove_donkey_pool();
								gameboard_.add_donkey_player(playerNumber);
							}
						}
					}
					secondMoveMode = false;
					hasMadeFullTurn = true;
					hasMadeMinTurn = true;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * called by the GUI when a community has been clicked
	 * @pre: class has to be constructed first
	 * @post: depends...
	 * @param: 1. int specifying the pressed community (0-9)
	 * 		   2. GameBoard the game board
	 * @return: boolean, true if he made a whole successful buy -> turn could be ended but also continued if player wants to buy more
	 */
	public boolean useCommunity(int community, E_GameBoard gameboard_, String riddlebuy_)
	{
		if(largeDonkeyMode)
			return largeDonkeyBuy(community, gameboard_, riddlebuy_);
		if(payLessMode && isPayingLessNow)
			return lessCostBuy(community, gameboard_, riddlebuy_);
		//only react to clicks if its my turn and setup phase is over
		//this.isMyTurn && this.setupCounter == 0 && !this.secondMoveMode && !moveTwiceMode && !gustOfWindMode1 && !gustOfWindMode2 && gameboard_.getMap().get_communities().get(community).get_all_fruittiles().size() > 0
		if(this.setupCounter == 0 && !this.secondMoveMode && !hasMadeFullTurn && !moveTwiceMode && !gustOfWindMode1 && !gustOfWindMode2 && gameboard_.getMap().get_communities().get(community).get_all_fruittiles().size() > 0 )
		{
			for(int i=0; i<deliveredCommunities.size(); i++)
			{
				if(deliveredCommunities.get(i) == community)
				{
					return false;
				}
			}
			if(riddlebuy_.equals(""))
			{

				//checks if the fruittile can be bought by the player
				boolean almondbuy=false, figbuy=false, grapebuy=false, lemonbuy=false, 
				olivebuy=false, orangebuy= false, spaceInCart=false, hasDonkey=false;
				if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
				{almondbuy=true;}
				if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
				{figbuy=true;}
				if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
				{grapebuy=true;}
				if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
				{lemonbuy=true;}
				if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
				{olivebuy=true;}
				if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
				{orangebuy=true;}
				if( (6-alreadyDeliveredFruits) >= 
					gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
				{spaceInCart=true;}
				if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
				{hasDonkey=true;}
				//if he already delivered, the donkey is already paid and there is no need for a second one
				if(alreadyDeliveredFruits > 0)
					hasDonkey = true;

				//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
				//if a bonus or finca tile has to be distributed
				if (almondbuy && figbuy && grapebuy && lemonbuy &&
						olivebuy && orangebuy && spaceInCart && hasDonkey)
				{	
					//take the delivered fruits from player and add to the pool
					gameboard_.remove_fruit_player("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost(), playerNumber);
					gameboard_.add_fruit_pool("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost());
					gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
					gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
					gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
					gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
					gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
					gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
					gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
					gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
					gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
					gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());

					//only discount a donkey at the first delivery of this turn
					if(alreadyDeliveredFruits == 0)
					{
						gameboard_.remove_donkey_player(playerNumber);
						gameboard_.add_donkey_pool();
					}

					//give tile to player and remember how many resources he already delivered
					int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
					gameboard_.add_fruittile_player(playerNumber, community);
					alreadyDeliveredFruits += points;
					gameboard_.getPlayers().get(playerNumber).add_points(points);
					gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

					//check for bonus plate
					if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
							&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
							&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
							&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
							&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
							&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
					{
						gameboard_.add_bonustile_player(playerNumber);
						gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
					}

					//check for finca plate
					if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
					{
						giveTheFincaTile(gameboard_, community);
					}

					//end Turn/buy some more
					deliveredCommunities.add(community);
					hasMadeMinTurn = true;
					return true;
				}			
			}
			else
			{
				if(riddlebuy_.equalsIgnoreCase("almond"))
				{
					//checks if the fruittile can be bought by the player
					boolean almondbuy=false, spaceInCart=false, hasDonkey=false;
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
					{almondbuy=true;}

					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;

					//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
					//if a bonus or finca tile has to be distributed
					if (almondbuy && spaceInCart && hasDonkey)
					{	
						//take the delivered fruits from player and add to the pool
						gameboard_.remove_fruit_player("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
						gameboard_.add_fruit_pool("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

						//only discount a donkey at the first delivery of this turn
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.add_donkey_pool();
						}

						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += points;
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;
					}			
				}
				else if(riddlebuy_.equalsIgnoreCase("fig"))
				{
					//checks if the fruittile can be bought by the player
					boolean figbuy=false, spaceInCart=false, hasDonkey=false;
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
					{figbuy=true;}

					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;

					//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
					//if a bonus or finca tile has to be distributed
					if (figbuy && spaceInCart && hasDonkey)
					{	
						//take the delivered fruits from player and add to the pool
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

						//only discount a donkey at the first delivery of this turn
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.add_donkey_pool();
						}

						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += points;
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;
					}
				}
				else if(riddlebuy_.equalsIgnoreCase("grape"))
				{
					//checks if the fruittile can be bought by the player
					boolean grapebuy=false, spaceInCart=false, hasDonkey=false;
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
					{grapebuy=true;}

					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;

					//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
					//if a bonus or finca tile has to be distributed
					if (grapebuy && spaceInCart && hasDonkey)
					{	
						//take the delivered fruits from player and add to the pool
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

						//only discount a donkey at the first delivery of this turn
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.add_donkey_pool();
						}

						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += points;
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;
					}
				}
				else if(riddlebuy_.equalsIgnoreCase("lemon"))
				{
					//checks if the fruittile can be bought by the player
					boolean lemonbuy=false, spaceInCart=false, hasDonkey=false;
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
					{lemonbuy=true;}

					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;

					//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
					//if a bonus or finca tile has to be distributed
					if (lemonbuy && spaceInCart && hasDonkey)
					{	
						//take the delivered fruits from player and add to the pool
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

						//only discount a donkey at the first delivery of this turn
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.add_donkey_pool();
						}

						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += points;
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;
					}
				}
				else if(riddlebuy_.equalsIgnoreCase("olive"))
				{
					//checks if the fruittile can be bought by the player
					boolean olivebuy=false, spaceInCart=false, hasDonkey=false;
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
					{olivebuy=true;}

					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;

					//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
					//if a bonus or finca tile has to be distributed
					if (olivebuy && spaceInCart && hasDonkey)
					{	
						//take the delivered fruits from player and add to the pool
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

						//only discount a donkey at the first delivery of this turn
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.add_donkey_pool();
						}

						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += points;
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;
					}
				}
				else if(riddlebuy_.equalsIgnoreCase("orange"))
				{
					//checks if the fruittile can be bought by the player
					boolean orangebuy=false, spaceInCart=false, hasDonkey=false;
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
					{orangebuy=true;}

					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;

					//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
					//if a bonus or finca tile has to be distributed
					if (orangebuy && spaceInCart && hasDonkey)
					{	
						//take the delivered fruits from player and add to the pool
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

						//only discount a donkey at the first delivery of this turn
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.add_donkey_pool();
						}

						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += points;
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;
					}
				}
				else 
				{
					System.out.println("wrong spelling in Turn, use community, riddlebuy != \"\" ");
				}
			}
		}
		return false;
	}


	/**
	 * called by the GUI when a jocker has been clicked
	 * @pre: class has to be constructed first
	 * @post: depends...
	 * @param: 1. String specifying the pressed jocker ('move twice', 'gust of wind', 'large donkey cart' 'one fruit less')
	 * 		   2. GameBoard the game board
	 */
	public void useJoker(String joker, E_GameBoard gameboard_, String lessbuy_)
	{
		//only react to clicks if its my turn && didn't already deliver fruits && setup phase is over
		if(this.alreadyDeliveredFruits == 0 && this.setupCounter == 0 && !moveTwiceMode && !secondMoveMode && !gustOfWindMode1 && !gustOfWindMode2 && !largeDonkeyMode && !payLessMode && !hasMadeFullTurn)
		{
			if(joker.equalsIgnoreCase("move twice") && gameboard_.getPlayers().get(playerNumber).has_double_move())
			{
				moveTwiceMode = true;
				gameboard_.getPlayers().get(playerNumber).used_double_move();
				gameboard_.getPlayers().get(playerNumber).add_points(-2);
			}
			if(joker.equalsIgnoreCase("gust of wind") && gameboard_.getPlayers().get(playerNumber).has_gust_of_wind())
			{
				gustOfWindMode1 = true;
				gameboard_.getPlayers().get(playerNumber).used_gust_of_wind();
				gameboard_.getPlayers().get(playerNumber).add_points(-2);
			}
			if(joker.equalsIgnoreCase("large donkey cart") && gameboard_.getPlayers().get(playerNumber).has_large_donkey_cart())
			{
				largeDonkeyMode = true;
				gameboard_.getPlayers().get(playerNumber).used_large_donkey_cart();
				gameboard_.getPlayers().get(playerNumber).add_points(-2);
			}
			if(joker.equalsIgnoreCase("one fruit less") && gameboard_.getPlayers().get(playerNumber).has_one_fruit_less())
			{
				payLessMode = true;
				isPayingLessNow = true;
				oneLessFruit = lessbuy_;
				gameboard_.getPlayers().get(playerNumber).used_one_fruit_less();
				gameboard_.getPlayers().get(playerNumber).add_points(-2);
			}
		}
	}

	/**
	 * called by the GUI after a use method was called if player confirms and ends his turn
	 * @pre: class has to be constructed first
	 * @post: all states are put back to default and its not the players turn any longer
	 */
	public void endTurn()
	{	
		this.alreadyDeliveredFruits = 0;
		hasMadeFullTurn = false;
		hasMadeMinTurn = false;
		moveTwiceMode = false;
		secondMoveMode = false;
		gustOfWindMode1 = false;
		gustOfWindMode2 = false;
		gustOfWindStartBlade = -1;
		largeDonkeyMode = false;
		payLessMode = false;
		oneLessFruit = "";
		isPayingLessNow = false;
		deliveredCommunities.clear();
	}

	/**
	 * called by the GUI after a use method was called if player cancels the turn
	 * @pre: class has to be constructed first
	 * @post: game board and turn is set to the way they were at the beginning of the turn
	 */
	public void cancelTurn() throws RemoteException
	{
		
		this.alreadyDeliveredFruits = 0;
		hasMadeFullTurn = false;
		hasMadeMinTurn = false;
		moveTwiceMode = false;
		secondMoveMode = false;
		gustOfWindMode1 = false;
		gustOfWindMode2 = false;
		gustOfWindStartBlade = -1;
		largeDonkeyMode = false;
		payLessMode = false;
		oneLessFruit = "";
		isPayingLessNow = false;
		deliveredCommunities.clear();
	}
	
	public boolean hasPlayerMadeTurn()
	{
		return hasMadeMinTurn;
	}

	// called by this.useWindmillBlade if moveTwiceMode
	private boolean doubleMove(int bladeNumber_, E_GameBoard gameboard_)
	{
		//only react if there is a farmer of this player here
		if(gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].has_farmer_here(playerNumber))
		{
			//move the farmer forward by blades equal to the number of farmers on his blade
			int steps = gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].get_num_of_farmers();
			gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].remove_farmer(playerNumber);
			gameboard_.getMap().get_windmill().get_blade_array()[(bladeNumber_+steps)%12].add_farmer(playerNumber);
			//take fruit from the map and give it to the player
			int fruitamount = gameboard_.getMap().get_windmill().get_blade_array()[(bladeNumber_+steps)%12].get_num_of_farmers();
			String fruit = gameboard_.getMap().get_windmill().get_blade_array()[(bladeNumber_+steps)%12].get_resource_typ();
			gameboard_.remove_fruit_pool(fruit, fruitamount);
			gameboard_.add_fruit_player(fruit, fruitamount, playerNumber);
			//if farmer passed line: gameboard gives donkey-cart
			if(steps <= 6)
			{
				if(bladeNumber_ >= 0 && bladeNumber_ <= 5)
				{
					if( (bladeNumber_+steps) > 5)
					{
						gameboard_.remove_donkey_pool();
						gameboard_.add_donkey_player(playerNumber);
					}
				}
				if(bladeNumber_ >= 6 && bladeNumber_ <= 11)
				{
					if( (bladeNumber_+steps) > 11)
					{
						gameboard_.remove_donkey_pool();
						gameboard_.add_donkey_player(playerNumber);
					}
				}
			}
			if(steps > 6)
			{
				gameboard_.remove_donkey_pool();
				gameboard_.add_donkey_player(playerNumber);

				if(bladeNumber_ >= 0 && bladeNumber_ <= 5)
				{
					if( (bladeNumber_+steps) > 11)
					{
						gameboard_.remove_donkey_pool();
						gameboard_.add_donkey_player(playerNumber);
					}
				}
				if(bladeNumber_ >= 6 && bladeNumber_ <= 11)
				{
					if( (bladeNumber_+steps) > 17)
					{
						gameboard_.remove_donkey_pool();
						gameboard_.add_donkey_player(playerNumber);
					}
				}
			}
			moveTwiceMode = false;
			secondMoveMode = true;
		}

		return false; //damit gui nicht fragt ob zug beenden oder cancel, stattdessen wird auf weiteren klick gewartet
	}

	// called by this.useWindmillBlade if gustOfWindMode1
	private boolean gustOfWindStart(int startingBlade, E_GameBoard gameboard_)
	{
		if(gameboard_.getMap().get_windmill().get_blade_array()[startingBlade].has_farmer_here(playerNumber))
		{
			gustOfWindStartBlade = startingBlade;
			gustOfWindMode1 = false;
			gustOfWindMode2 = true;
		}
		return false;
	}

	// called by this.useWindmillBlade if gustOfWindMode2
	private boolean gustOfWindMove(int bladeNumber_, E_GameBoard gameboard_)
	{
		gameboard_.getMap().get_windmill().get_blade_array()[gustOfWindStartBlade].remove_farmer(playerNumber);
		gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].add_farmer(playerNumber);
		int fruitamount = gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].get_num_of_farmers();
		String fruit = gameboard_.getMap().get_windmill().get_blade_array()[bladeNumber_].get_resource_typ();
		gameboard_.remove_fruit_pool(fruit, fruitamount);
		gameboard_.add_fruit_player(fruit, fruitamount, playerNumber);
		hasMadeFullTurn = true;
		hasMadeMinTurn = true;
		return true;
	}

	// called by this.useCommunity if largeDonkeyMode
	private boolean largeDonkeyBuy(int community, E_GameBoard gameboard_, String riddlebuy_)
	{
		for(int i=0; i<deliveredCommunities.size(); i++)
		{
			if(deliveredCommunities.get(i) == community)
				return false;
		}
		if(riddlebuy_.equals(""))
		{

			//checks if the fruittile can be bought by the player
			boolean almondbuy=false, figbuy=false, grapebuy=false, lemonbuy=false, 
			olivebuy=false, orangebuy= false, spaceInCart=false;
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
			{almondbuy=true;}
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
			{figbuy=true;}
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
			{grapebuy=true;}
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
			{lemonbuy=true;}
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
			{olivebuy=true;}
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
			{orangebuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (almondbuy && figbuy && grapebuy && lemonbuy &&
					olivebuy && orangebuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost(), playerNumber);
				gameboard_.add_fruit_pool("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost());
				gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
				gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
				gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
				gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
				gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
				gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
				gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
				gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
				gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
				gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());


				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}	
		else if(riddlebuy_.equalsIgnoreCase("almond"))
		{
			//checks if the fruittile can be bought by the player
			boolean almondbuy=false, spaceInCart=false;
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
			{almondbuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (almondbuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
				gameboard_.add_fruit_pool("almond", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}
		else if(riddlebuy_.equalsIgnoreCase("fig"))
		{
			//checks if the fruittile can be bought by the player
			boolean figbuy=false, spaceInCart=false;
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
			{figbuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (figbuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
				gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}
		else if(riddlebuy_.equalsIgnoreCase("grape"))
		{
			//checks if the fruittile can be bought by the player
			boolean grapebuy=false, spaceInCart=false;
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
			{grapebuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (grapebuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
				gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());

				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}
		else if(riddlebuy_.equalsIgnoreCase("lemon"))
		{
			//checks if the fruittile can be bought by the player
			boolean lemonbuy=false, spaceInCart=false;

			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
			{lemonbuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (lemonbuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
				gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());


				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}
		else if(riddlebuy_.equalsIgnoreCase("olive"))
		{
			//checks if the fruittile can be bought by the player
			boolean olivebuy=false, spaceInCart=false;
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
			{olivebuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (olivebuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
				gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());


				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}
		else if(riddlebuy_.equalsIgnoreCase("orange"))
		{
			//checks if the fruittile can be bought by the player
			boolean orangebuy= false, spaceInCart=false;
			if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost())
			{orangebuy=true;}
			if( (10-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
			{spaceInCart=true;}

			//adds the fruittile to the player and removes from gameboard. also reallocates resources and checks 
			//if a bonus or finca tile has to be distributed
			if (orangebuy && spaceInCart)
			{	
				//take the delivered fruits from player and add to the pool
				gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost(), playerNumber);
				gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost());


				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += points;
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}
				//end Turn/buy some more
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
		}
		else
			System.out.println("spellingmisstake in turn, large donkey buy methode");

		return false;
	}

	// called by this.useCommunity if payLessMode
	private boolean lessCostBuy(int community, E_GameBoard gameboard_, String riddlebuy_)
	{
		for(int i=0; i<deliveredCommunities.size(); i++)
		{
			if(deliveredCommunities.get(i) == community)
				return false;
		}
		
		boolean almondbuy=false, figbuy=false, grapebuy=false, lemonbuy=false, 
		olivebuy=false, orangebuy= false, spaceInCart=false, hasDonkey=false;
		
		if(riddlebuy_.equals(""))
		{
			if(oneLessFruit.equalsIgnoreCase("almond"))
			{
				if(gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost() > 0)
				{
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()-1)
					{almondbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
					{figbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
					{grapebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
					{lemonbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
					{olivebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
					{orangebuy=true;}
					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;
					
					if(hasDonkey && spaceInCart && orangebuy && olivebuy && lemonbuy && grapebuy && figbuy && almondbuy)
					{
						gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()-1), playerNumber);
						gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()-1));
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());
						
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.getMap().add_donkey();
						}
						
						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += (points-1);
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;

					}
					
					//he still cant afford the tile
					else
					{
						return false;
					}
				}
				
				//in case the user entered a fruit to deliver that is not on this plate -> normal buy
				else
				{
					isPayingLessNow = false;
					boolean state =  useCommunity(community, gameboard_, riddlebuy_);
					isPayingLessNow = true;
					return state;
				}
			}
			else if(oneLessFruit.equalsIgnoreCase("fig"))
			{
				if(gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost() > 0)
				{
					
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
					{almondbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost()-1)
					{figbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
					{grapebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
					{lemonbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
					{olivebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
					{orangebuy=true;}
					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;
					
					if(hasDonkey && spaceInCart && orangebuy && olivebuy && lemonbuy && grapebuy && figbuy && almondbuy)
					{
						gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()), playerNumber);
						gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()));
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost()-1, playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost()-1);
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());
						
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.getMap().add_donkey();
						}
						
						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += (points-1);
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;

					}
					
					//he still cant afford the tile
					else
					{
						return false;
					}
				}
				
				//in case the user entered a fruit to deliver that is not on this plate -> normal buy
				else
				{
					isPayingLessNow = false;
					boolean state =  useCommunity(community, gameboard_, riddlebuy_);
					isPayingLessNow = true;
					return state;
				}
			}
			else if(oneLessFruit.equalsIgnoreCase("grape"))
			{
				if(gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost() > 0)
				{
					
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
					{almondbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
					{figbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost()-1)
					{grapebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
					{lemonbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
					{olivebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
					{orangebuy=true;}
					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;
					
					if(hasDonkey && spaceInCart && orangebuy && olivebuy && lemonbuy && grapebuy && figbuy && almondbuy)
					{
						gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()), playerNumber);
						gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()));
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost()-1, playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost()-1);
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());
						
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.getMap().add_donkey();
						}
						
						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += (points-1);
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;

					}
					
					//he still cant afford the tile
					else
					{
						return false;
					}
				}
				
				//in case the user entered a fruit to deliver that is not on this plate -> normal buy
				else
				{
					isPayingLessNow = false;
					boolean state =  useCommunity(community, gameboard_, riddlebuy_);
					isPayingLessNow = true;
					return state;
				}
			}
			else if(oneLessFruit.equalsIgnoreCase("lemon"))
			{
				if(gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost() > 0)
				{					
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
					{almondbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
					{figbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
					{grapebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost()-1)
					{lemonbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
					{olivebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
					{orangebuy=true;}
					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;
					
					if(hasDonkey && spaceInCart && orangebuy && olivebuy && lemonbuy && grapebuy && figbuy && almondbuy)
					{
						gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()), playerNumber);
						gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()));
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost()-1, playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost()-1);
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());
						
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.getMap().add_donkey();
						}
						
						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += (points-1);
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;

					}
					
					//he still cant afford the tile
					else
					{
						return false;
					}
				}
				
				//in case the user entered a fruit to deliver that is not on this plate -> normal buy
				else
				{
					isPayingLessNow = false;
					boolean state =  useCommunity(community, gameboard_, riddlebuy_);
					isPayingLessNow = true;
					return state;
				}
			}
			else if(oneLessFruit.equalsIgnoreCase("olive"))
			{
				if(gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost() > 0)
				{
					
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
					{almondbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
					{figbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
					{grapebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
					{lemonbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost()-1)
					{olivebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost())
					{orangebuy=true;}
					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;
					
					if(hasDonkey && spaceInCart && orangebuy && olivebuy && lemonbuy && grapebuy && figbuy && almondbuy)
					{
						gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()), playerNumber);
						gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()));
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost()-1, playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost()-1);
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost(), playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost());
					
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.getMap().add_donkey();
						}
						
						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += (points-1);
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;

					}
					
					//he still cant afford the tile
					else
					{
						return false;
					}
				}
				
				//in case the user entered a fruit to deliver that is not on this plate -> normal buy
				else
				{
					isPayingLessNow = false;
					boolean state =  useCommunity(community, gameboard_, riddlebuy_);
					isPayingLessNow = true;
					return state;
				}
			}
			else if(oneLessFruit.equalsIgnoreCase("orange"))
			{
				if(gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost() > 0)
				{
					
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost())
					{almondbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost())
					{figbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost())
					{grapebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost())
					{lemonbuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost())
					{olivebuy=true;}
					if (gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost()-1)
					{orangebuy=true;}
					if( (6-alreadyDeliveredFruits) >= 
						gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points())
					{spaceInCart=true;}
					if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
					{hasDonkey=true;}
					//if he already delivered, the donkey is already paid and there is no need for a second one
					if(alreadyDeliveredFruits > 0)
						hasDonkey = true;
					
					if(hasDonkey && spaceInCart && orangebuy && olivebuy && lemonbuy && grapebuy && figbuy && almondbuy)
					{
						gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()), playerNumber);
						gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_almond_cost()));
						gameboard_.remove_fruit_player("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost(), playerNumber);
						gameboard_.add_fruit_pool("fig", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_fig_cost());
						gameboard_.remove_fruit_player("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost(), playerNumber);
						gameboard_.add_fruit_pool("grape", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_grape_cost());
						gameboard_.remove_fruit_player("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost(), playerNumber);
						gameboard_.add_fruit_pool("lemon", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_lemon_cost());
						gameboard_.remove_fruit_player("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost(), playerNumber);
						gameboard_.add_fruit_pool("olive", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_olive_cost());
						gameboard_.remove_fruit_player("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost()-1, playerNumber);
						gameboard_.add_fruit_pool("orange", gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_orange_cost()-1);
					
						if(alreadyDeliveredFruits == 0)
						{
							gameboard_.remove_donkey_player(playerNumber);
							gameboard_.getMap().add_donkey();
						}
						
						//give tile to player and remember how many resources he already delivered
						int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
						gameboard_.add_fruittile_player(playerNumber, community);
						alreadyDeliveredFruits += (points-1);
						gameboard_.getPlayers().get(playerNumber).add_points(points);
						gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

						//check for bonus plate
						if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
								&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
						{
							gameboard_.add_bonustile_player(playerNumber);
							gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
						}

						//check for finca plate
						if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
						{
							giveTheFincaTile(gameboard_, community);
						}

						//end Turn/buy some more
						isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
						deliveredCommunities.add(community);
						hasMadeMinTurn = true;
						return true;

					}
					
					//he still cant afford the tile
					else
					{
						return false;
					}
				}
				
				//in case the user entered a fruit to deliver that is not on this plate -> normal buy
				else
				{
					isPayingLessNow = false;
					boolean state =  useCommunity(community, gameboard_, riddlebuy_);
					isPayingLessNow = true;
					return state;
				}
			}
			//if oneLessFruit is ot one of the 6 fruit keywords
			else 
			{
				System.out.println("spelling mistake in Turn, lesscostbuy");
				return false;
			}
		}
		
		else if(riddlebuy_.equalsIgnoreCase("almond") && oneLessFruit.equalsIgnoreCase("almond"))
		{
			if(gameboard_.getPlayers().get(playerNumber).get_fruitcount("almond")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1)
			{almondbuy=true;}
			if( (6-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
			{spaceInCart=true;}
			if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
			{hasDonkey=true;}
			//if he already delivered, the donkey is already paid and there is no need for a second one
			if(alreadyDeliveredFruits > 0)
				hasDonkey = true;
			
			if(almondbuy && spaceInCart && hasDonkey)
			{
				gameboard_.remove_fruit_player("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1), playerNumber);
				gameboard_.add_fruit_pool("almond", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1));
				
				if(alreadyDeliveredFruits == 0)
				{
					gameboard_.remove_donkey_player(playerNumber);
					gameboard_.getMap().add_donkey();
				}
				
				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += (points-1);
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}

				//end Turn/buy some more
				isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
			
			//if he still cant buy the tile
			else
			{
				return false;
			}
		}
		
		else if(riddlebuy_.equalsIgnoreCase("fig") && oneLessFruit.equalsIgnoreCase("fig"))
		{
			if(gameboard_.getPlayers().get(playerNumber).get_fruitcount("fig")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1)
			{figbuy=true;}
			if( (6-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
			{spaceInCart=true;}
			if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
			{hasDonkey=true;}
			//if he already delivered, the donkey is already paid and there is no need for a second one
			if(alreadyDeliveredFruits > 0)
				hasDonkey = true;
			
			if(figbuy && spaceInCart && hasDonkey)
			{
				gameboard_.remove_fruit_player("fig", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1), playerNumber);
				gameboard_.add_fruit_pool("fig", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1));
				
				if(alreadyDeliveredFruits == 0)
				{
					gameboard_.remove_donkey_player(playerNumber);
					gameboard_.getMap().add_donkey();
				}
				
				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += (points-1);
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}

				//end Turn/buy some more
				isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
			
			//if he still cant buy the tile
			else
			{
				return false;
			}
		}
		
		else if(riddlebuy_.equalsIgnoreCase("grape") && oneLessFruit.equalsIgnoreCase("grape"))
		{
			if(gameboard_.getPlayers().get(playerNumber).get_fruitcount("grape")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1)
			{grapebuy=true;}
			if( (6-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
			{spaceInCart=true;}
			if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
			{hasDonkey=true;}
			//if he already delivered, the donkey is already paid and there is no need for a second one
			if(alreadyDeliveredFruits > 0)
				hasDonkey = true;
			
			if(grapebuy && spaceInCart && hasDonkey)
			{
				gameboard_.remove_fruit_player("grape", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1), playerNumber);
				gameboard_.add_fruit_pool("grape", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1));
				
				if(alreadyDeliveredFruits == 0)
				{
					gameboard_.remove_donkey_player(playerNumber);
					gameboard_.getMap().add_donkey();
				}
				
				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += (points-1);
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}

				//end Turn/buy some more
				isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
			
			//if he still cant buy the tile
			else
			{
				return false;
			}
		}
		
		else if(riddlebuy_.equalsIgnoreCase("lemon") && oneLessFruit.equalsIgnoreCase("lemon"))
		{
			if(gameboard_.getPlayers().get(playerNumber).get_fruitcount("lemon")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1)
			{lemonbuy=true;}
			if( (6-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
			{spaceInCart=true;}
			if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
			{hasDonkey=true;}
			//if he already delivered, the donkey is already paid and there is no need for a second one
			if(alreadyDeliveredFruits > 0)
				hasDonkey = true;
			
			if(lemonbuy && spaceInCart && hasDonkey)
			{
				gameboard_.remove_fruit_player("lemon", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1), playerNumber);
				gameboard_.add_fruit_pool("lemon", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1));
				
				if(alreadyDeliveredFruits == 0)
				{
					gameboard_.remove_donkey_player(playerNumber);
					gameboard_.getMap().add_donkey();
				}
				
				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += (points-1);
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}

				//end Turn/buy some more
				isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
			
			//if he still cant buy the tile
			else
			{
				return false;
			}
		}
		
		else if(riddlebuy_.equalsIgnoreCase("olive") && oneLessFruit.equalsIgnoreCase("olive"))
		{
			if(gameboard_.getPlayers().get(playerNumber).get_fruitcount("olive")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1)
			{olivebuy=true;}
			if( (6-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
			{spaceInCart=true;}
			if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
			{hasDonkey=true;}
			//if he already delivered, the donkey is already paid and there is no need for a second one
			if(alreadyDeliveredFruits > 0)
				hasDonkey = true;
			
			if(olivebuy && spaceInCart && hasDonkey)
			{
				gameboard_.remove_fruit_player("olive", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1), playerNumber);
				gameboard_.add_fruit_pool("olive", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1));
				
				if(alreadyDeliveredFruits == 0)
				{
					gameboard_.remove_donkey_player(playerNumber);
					gameboard_.getMap().add_donkey();
				}
				
				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += (points-1);
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}

				//end Turn/buy some more
				isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
			
			//if he still cant buy the tile
			else
			{
				return false;
			}
		}
		
		else if(riddlebuy_.equalsIgnoreCase("orange") && oneLessFruit.equalsIgnoreCase("orange"))
		{
			if(gameboard_.getPlayers().get(playerNumber).get_fruitcount("orange")>=
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1)
			{orangebuy=true;}
			if( (6-alreadyDeliveredFruits) >= 
				gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points()-1)
			{spaceInCart=true;}
			if(gameboard_.getPlayers().get(playerNumber).get_donkeys() > 0)
			{hasDonkey=true;}
			//if he already delivered, the donkey is already paid and there is no need for a second one
			if(alreadyDeliveredFruits > 0)
				hasDonkey = true;
			
			if(orangebuy && spaceInCart && hasDonkey)
			{
				gameboard_.remove_fruit_player("orange", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1), playerNumber);
				gameboard_.add_fruit_pool("orange", (gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_riddle_cost()-1));
				
				if(alreadyDeliveredFruits == 0)
				{
					gameboard_.remove_donkey_player(playerNumber);
					gameboard_.getMap().add_donkey();
				}
				
				//give tile to player and remember how many resources he already delivered
				int points = gameboard_.getMap().get_communities().get(community).get_top_fruittile().get_points();
				gameboard_.add_fruittile_player(playerNumber, community);
				alreadyDeliveredFruits += (points-1);
				gameboard_.getPlayers().get(playerNumber).add_points(points);
				gameboard_.getPlayers().get(playerNumber).bonusCounterUp(points);

				//check for bonus plate
				if(		gameboard_.getPlayers().get(playerNumber).get_bonusCounter1() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter2() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter3() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter4() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter5() > 0 
						&& gameboard_.getPlayers().get(playerNumber).get_bonusCounter6() > 0)
				{
					gameboard_.add_bonustile_player(playerNumber);
					gameboard_.getPlayers().get(playerNumber).bonusCounter_down();
				}

				//check for finca plate
				if(gameboard_.getMap().get_communities().get(community).get_number_of_fruittiles() == 0)
				{
					giveTheFincaTile(gameboard_, community);
				}

				//end Turn/buy some more
				isPayingLessNow = false; //so that the player doesn't get a discount on other buys this turn
				deliveredCommunities.add(community);
				hasMadeMinTurn = true;
				return true;
			}
			
			//if he still cant buy the tile
			else
			{
				return false;
			}
		}
		//player wants to buy a riddle tile with another resource than the joker decreses -> normal buy
		else	
		{
			isPayingLessNow = false;
			boolean state =  useCommunity(community, gameboard_, riddlebuy_);
			isPayingLessNow = true;
			return state;
		}
	}
	
	private void giveTheFincaTile(E_GameBoard gameboard_, int community)
	{
		//numberOfFincas++;
		int player1Resources = 0;
		int player2Resources = 0;
		int player3Resources = 0;
		int player4Resources = 0;

		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_almond())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_almond_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_almond_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_almond_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_almond_cost();
			}
		}
		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_fig())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_fig_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_fig_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_fig_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_fig_cost();
			}
		}
		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_grape())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_grape_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_grape_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_grape_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_grape_cost();
			}
		}
		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_lemon())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_lemon_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_lemon_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_lemon_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_lemon_cost();
			}
		}
		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_olive())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_olive_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_olive_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_olive_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_olive_cost();
			}
		}
		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_orange())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_orange_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_orange_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_orange_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_orange_cost();
			}
		}
		if(gameboard_.getMap().get_communities().get(community).get_fincatile().is_riddle())
		{
			for(int i=0; i<gameboard_.getPlayers().get(0).get_fruittiles().size(); i++)
				player1Resources += gameboard_.getPlayers().get(0).get_fruittiles().get(i).get_riddle_cost();
			for(int i=0; i<gameboard_.getPlayers().get(1).get_fruittiles().size(); i++)
				player2Resources += gameboard_.getPlayers().get(1).get_fruittiles().get(i).get_riddle_cost();
			if(numberOfPlayers > 2)
			{
				for(int i=0; i<gameboard_.getPlayers().get(2).get_fruittiles().size(); i++)
					player3Resources += gameboard_.getPlayers().get(2).get_fruittiles().get(i).get_riddle_cost();
			}
			if(numberOfPlayers > 3)
			{
				for(int i=0; i<gameboard_.getPlayers().get(3).get_fruittiles().size(); i++)
					player4Resources += gameboard_.getPlayers().get(3).get_fruittiles().get(i).get_riddle_cost();
			}
		}
		if(player1Resources > player2Resources && player1Resources > player3Resources && player1Resources > player4Resources)
			gameboard_.add_fincatile_player(0, community);
		else if(player2Resources > player1Resources && player2Resources > player3Resources && player2Resources > player4Resources)
			gameboard_.add_fincatile_player(1, community);
		else if(player3Resources > player2Resources && player3Resources > player1Resources && player3Resources > player4Resources)
			gameboard_.add_fincatile_player(2, community);
		else if(player4Resources > player2Resources && player4Resources > player3Resources && player4Resources > player1Resources)
			gameboard_.add_fincatile_player(3, community);
		else //at least 2 player have the same amount -> remove, no one gets it
			gameboard_.getMap().get_communities().get(community).remove_fincatile();
	
	}
	
	public int get_setupCounter(){
		return setupCounter;
	}
	
	public void set_setupCounter(int hebl)
	{
		setupCounter = hebl;
	}
}