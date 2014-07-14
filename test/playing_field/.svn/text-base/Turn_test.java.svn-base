package playing_field;

import java.util.ArrayList;
import java.util.Scanner;

import player.Turn;

public class Turn_test 
{
	
	public static void main(String[] args) 
	{
		Turn _testTurn = new Turn(0,3);
		ArrayList<String> names = new ArrayList<String>();
		names.add("what");
		names.add("the");
		names.add("fuck");
		GameBoard _testGB = new GameBoard(names);
		_testTurn.itIsYourTurn();
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("Windmill state:");
		System.out.println("---------------");
		System.out.println("Blade 0: " + _testGB.getMap().get_windmill().get_blade_array()[0].get_resource_typ());
		System.out.println("Blade 1: " + _testGB.getMap().get_windmill().get_blade_array()[1].get_resource_typ());
		System.out.println("Blade 2: " + _testGB.getMap().get_windmill().get_blade_array()[2].get_resource_typ());
		System.out.println("Blade 3: " + _testGB.getMap().get_windmill().get_blade_array()[3].get_resource_typ());
		System.out.println("Blade 4: " + _testGB.getMap().get_windmill().get_blade_array()[4].get_resource_typ());
		System.out.println("Blade 5: " + _testGB.getMap().get_windmill().get_blade_array()[5].get_resource_typ());
		System.out.println("Blade 6: " + _testGB.getMap().get_windmill().get_blade_array()[6].get_resource_typ());
		System.out.println("Blade 7: " + _testGB.getMap().get_windmill().get_blade_array()[7].get_resource_typ());
		System.out.println("Blade 8: " + _testGB.getMap().get_windmill().get_blade_array()[8].get_resource_typ());
		System.out.println("Blade 9: " + _testGB.getMap().get_windmill().get_blade_array()[9].get_resource_typ());
		System.out.println("Blade 10: " + _testGB.getMap().get_windmill().get_blade_array()[10].get_resource_typ());
		System.out.println("Blade 11: " + _testGB.getMap().get_windmill().get_blade_array()[11].get_resource_typ());
		System.out.println();
		
		System.out.println("Community state:");
		System.out.println("----------------");
		System.out.println("Community 0: " + _testGB.getMap().get_communities().get(0).get_top_fruittile().get_tile_name());
		System.out.println("Community 1: " + _testGB.getMap().get_communities().get(1).get_top_fruittile().get_tile_name());
		System.out.println("Community 2: " + _testGB.getMap().get_communities().get(2).get_top_fruittile().get_tile_name());
		System.out.println("Community 3: " + _testGB.getMap().get_communities().get(3).get_top_fruittile().get_tile_name());
		System.out.println("Community 4: " + _testGB.getMap().get_communities().get(4).get_top_fruittile().get_tile_name());
		System.out.println("Community 5: " + _testGB.getMap().get_communities().get(5).get_top_fruittile().get_tile_name());
		System.out.println("Community 6: " + _testGB.getMap().get_communities().get(6).get_top_fruittile().get_tile_name());
		System.out.println("Community 7: " + _testGB.getMap().get_communities().get(7).get_top_fruittile().get_tile_name());
		System.out.println("Community 8: " + _testGB.getMap().get_communities().get(8).get_top_fruittile().get_tile_name());
		System.out.println("Community 9: " + _testGB.getMap().get_communities().get(9).get_top_fruittile().get_tile_name());
		System.out.println();
		
		System.out.println("place 1st farmer on: ");
		int input = myScan.nextInt();
		_testTurn.useWindmillBlade(input, _testGB); //setup 1/4
		
		System.out.println("place 2nd farmer on: ");
		input = myScan.nextInt();
		_testTurn.useWindmillBlade(input, _testGB); //setup 2/4
		
		System.out.println("place 3rd farmer on: ");
		input = myScan.nextInt();
		_testTurn.useWindmillBlade(input, _testGB); //setup 3/4
		
		System.out.println("place 4th farmer on: ");
		input = myScan.nextInt();
		_testTurn.useWindmillBlade(input, _testGB); //setup 4/4
		
		System.out.println("Players Posession after setup:");
		System.out.println("------------------------------");
		System.out.println("Players almond fruitcount: " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
		System.out.println("Players fig fruitcount:    " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
		System.out.println("Players grape fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
		System.out.println("Players lemon fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
		System.out.println("Players olive fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
		System.out.println("Players orange fruitcount: " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
		System.out.println("Players riddle fruitcount: " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
		System.out.println("Players donkeycount:       " + _testGB.getPlayers().get(0).get_donkeys());
		System.out.println();
		
		while(true)
		{
			_testTurn.itIsYourTurn();
			System.out.println("to move enter 'move',");
			System.out.println("to buy enter 'buy',");
			System.out.println("to use joker enter 'joker',");
			System.out.println("to quit enter 'quit'");
			String inp = myScan.next();
			System.out.println("input: " + inp);
			if(inp.equals("move"))
			{
				System.out.println("farmer on which blade?");
				input = myScan.nextInt();
				if(_testTurn.useWindmillBlade(input, _testGB))
				{
					System.out.println("Players Posession after move:");
					System.out.println("-----------------------------");
					System.out.println("Players almond fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
					System.out.println("Players fig fruitcount:     " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
					System.out.println("Players grape fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
					System.out.println("Players lemon fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
					System.out.println("Players olive fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
					System.out.println("Players orange fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
					System.out.println("Players riddle fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
					System.out.println("Players donkeycount:        " + _testGB.getPlayers().get(0).get_donkeys());
					System.out.println("Players points:             " + _testGB.getPlayers().get(0).get_points());
					System.out.println();
					
					_testTurn.endTurn();
				}
				else
				{
					System.out.println("no farmer there");
					System.out.println();
				}
			}
			else if(inp.equals("buy"))
			{
				boolean buymore = true;
				while(buymore)
				{
					System.out.println("from where?");
					input = myScan.nextInt();
					if(_testTurn.useCommunity(input, _testGB))
					{
						System.out.println("buy more? yes/no");
						inp = myScan.next();
						if(inp.equals("no"))
							buymore = false;
					}
					else
					{
						System.out.println("you lack donkey/fruits to buy this");
						System.out.println("buy something else? yes/no");
						inp = myScan.next();
						if(inp.equals("no"))
							buymore = false;
					}
					System.out.println("Players Posession after buy:");
					System.out.println("----------------------------");
					System.out.println("Players almond fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
					System.out.println("Players fig fruitcount:     " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
					System.out.println("Players grape fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
					System.out.println("Players lemon fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
					System.out.println("Players olive fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
					System.out.println("Players orange fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
					System.out.println("Players riddle fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
					System.out.println("Players donkeycount:        " + _testGB.getPlayers().get(0).get_donkeys());
					System.out.println("Players points:             " + _testGB.getPlayers().get(0).get_points());
					System.out.println();
					
					System.out.println("Community state after buy:");
					System.out.println("--------------------------");
					System.out.println("Community 0: " + _testGB.getMap().get_communities().get(0).get_top_fruittile().get_tile_name());
					System.out.println("Community 1: " + _testGB.getMap().get_communities().get(1).get_top_fruittile().get_tile_name());
					System.out.println("Community 2: " + _testGB.getMap().get_communities().get(2).get_top_fruittile().get_tile_name());
					System.out.println("Community 3: " + _testGB.getMap().get_communities().get(3).get_top_fruittile().get_tile_name());
					System.out.println("Community 4: " + _testGB.getMap().get_communities().get(4).get_top_fruittile().get_tile_name());
					System.out.println("Community 5: " + _testGB.getMap().get_communities().get(5).get_top_fruittile().get_tile_name());
					System.out.println("Community 6: " + _testGB.getMap().get_communities().get(6).get_top_fruittile().get_tile_name());
					System.out.println("Community 7: " + _testGB.getMap().get_communities().get(7).get_top_fruittile().get_tile_name());
					System.out.println("Community 8: " + _testGB.getMap().get_communities().get(8).get_top_fruittile().get_tile_name());
					System.out.println("Community 9: " + _testGB.getMap().get_communities().get(9).get_top_fruittile().get_tile_name());
					System.out.println();
					
					_testTurn.endTurn();
				}
			}
			else if(inp.equals("joker"))
			{
				System.out.println("choose joker: names: 'move twice', 'gust of wind', 'large donkey cart' 'one fruit less'");
				inp = myScan.next();
				if(inp.equals("move twice"))
				{
					_testTurn.useJoker(inp, _testGB);
					System.out.println("move from where?");
					input = myScan.nextInt();
					if(_testTurn.useWindmillBlade(input, _testGB))
					{
						System.out.println("looks like you didn't have this jocker any more...");
						System.out.println("normel move performed instead");
						_testTurn.endTurn();
					}
					else
					{
						System.out.println("move from where?");
						input = myScan.nextInt();
						while(!_testTurn.useWindmillBlade(input, _testGB))
						{
							System.out.println("move from where?");
							input = myScan.nextInt();
						}
						System.out.println("Players Posession after move:");
						System.out.println("-----------------------------");
						System.out.println("Players almond fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
						System.out.println("Players fig fruitcount:     " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
						System.out.println("Players grape fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
						System.out.println("Players lemon fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
						System.out.println("Players olive fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
						System.out.println("Players orange fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
						System.out.println("Players riddle fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
						System.out.println("Players donkeycount:        " + _testGB.getPlayers().get(0).get_donkeys());
						System.out.println("Players points:             " + _testGB.getPlayers().get(0).get_points());
						System.out.println();
						
						_testTurn.endTurn();
					}
				}
				else if(inp.equals("gust of wind"))
				{
					_testTurn.useJoker(inp, _testGB);
					System.out.println("move from where?");
					input = myScan.nextInt();
					if(_testTurn.useWindmillBlade(input, _testGB))
					{
						System.out.println("looks like you didn't have this jocker any more...");
						System.out.println("normel move performed instead");
						_testTurn.endTurn();
					}
					else
					{
						System.out.println("move to where?");
						input = myScan.nextInt();
						if(_testTurn.useWindmillBlade(input, _testGB))
						{
							System.out.println("Players Posession after move:");
							System.out.println("-----------------------------");
							System.out.println("Players almond fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
							System.out.println("Players fig fruitcount:     " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
							System.out.println("Players grape fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
							System.out.println("Players lemon fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
							System.out.println("Players olive fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
							System.out.println("Players orange fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
							System.out.println("Players riddle fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
							System.out.println("Players donkeycount:        " + _testGB.getPlayers().get(0).get_donkeys());
							System.out.println("Players points:             " + _testGB.getPlayers().get(0).get_points());
							System.out.println();
							
							_testTurn.endTurn();
						}
						else
						{
							System.out.println("very strange error on line 231");
							_testTurn.endTurn();
						}
					}
				}
				else if(inp.equals("large donkey cart"))
				{
					_testTurn.useJoker(inp, _testGB);
					boolean buymore = true;
					while(buymore)
					{
						System.out.println("buy where?");
						input = myScan.nextInt();
						if(_testTurn.useCommunity(input, _testGB))
						{
							System.out.println("buy more? yes/no");
							inp = myScan.next();
							if(inp.equals("no"))
								buymore = false;
						}
						else
						{
							System.out.println("cant buy this... buy more? yes/no");
							inp = myScan.next();
							if(inp.equals("no"))
								buymore = false;
						}
					}
					System.out.println("Players Posession after buy:");
					System.out.println("----------------------------");
					System.out.println("Players almond fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
					System.out.println("Players fig fruitcount:     " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
					System.out.println("Players grape fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
					System.out.println("Players lemon fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
					System.out.println("Players olive fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
					System.out.println("Players orange fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
					System.out.println("Players riddle fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
					System.out.println("Players donkeycount:        " + _testGB.getPlayers().get(0).get_donkeys());
					System.out.println("Players points:             " + _testGB.getPlayers().get(0).get_points());
					System.out.println();
					
					System.out.println("Community state after buy:");
					System.out.println("--------------------------");
					System.out.println("Community 0: " + _testGB.getMap().get_communities().get(0).get_top_fruittile().get_tile_name());
					System.out.println("Community 1: " + _testGB.getMap().get_communities().get(1).get_top_fruittile().get_tile_name());
					System.out.println("Community 2: " + _testGB.getMap().get_communities().get(2).get_top_fruittile().get_tile_name());
					System.out.println("Community 3: " + _testGB.getMap().get_communities().get(3).get_top_fruittile().get_tile_name());
					System.out.println("Community 4: " + _testGB.getMap().get_communities().get(4).get_top_fruittile().get_tile_name());
					System.out.println("Community 5: " + _testGB.getMap().get_communities().get(5).get_top_fruittile().get_tile_name());
					System.out.println("Community 6: " + _testGB.getMap().get_communities().get(6).get_top_fruittile().get_tile_name());
					System.out.println("Community 7: " + _testGB.getMap().get_communities().get(7).get_top_fruittile().get_tile_name());
					System.out.println("Community 8: " + _testGB.getMap().get_communities().get(8).get_top_fruittile().get_tile_name());
					System.out.println("Community 9: " + _testGB.getMap().get_communities().get(9).get_top_fruittile().get_tile_name());
					System.out.println();
					
					_testTurn.endTurn();
				}
				else if(inp.equals("one fruit less"))
				{
					_testTurn.useJoker(inp, _testGB);
					boolean buymore = true;
					while(buymore)
					{
						System.out.println("buy where?");
						input = myScan.nextInt();
						if(_testTurn.useCommunity(input, _testGB))
						{
							System.out.println("buy more? yes/no");
							inp = myScan.next();
							if(inp.equals("no"))
								buymore = false;
						}
						else
						{
							System.out.println("cant buy this... buy more? yes/no");
							inp = myScan.next();
							if(inp.equals("no"))
								buymore = false;
						}
					}
					System.out.println("Players Posession after buy:");
					System.out.println("----------------------------");
					System.out.println("Players almond fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("almond"));
					System.out.println("Players fig fruitcount:     " + _testGB.getPlayers().get(0).get_fruitcount("fig"));
					System.out.println("Players grape fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("grape"));
					System.out.println("Players lemon fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("lemon"));
					System.out.println("Players olive fruitcount:   " + _testGB.getPlayers().get(0).get_fruitcount("olive"));
					System.out.println("Players orange fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("orange"));
					System.out.println("Players riddle fruitcount:  " + _testGB.getPlayers().get(0).get_fruitcount("riddle"));
					System.out.println("Players donkeycount:        " + _testGB.getPlayers().get(0).get_donkeys());
					System.out.println("Players points:             " + _testGB.getPlayers().get(0).get_points());
					System.out.println();
					
					System.out.println("Community state after buy:");
					System.out.println("--------------------------");
					System.out.println("Community 0: " + _testGB.getMap().get_communities().get(0).get_top_fruittile().get_tile_name());
					System.out.println("Community 1: " + _testGB.getMap().get_communities().get(1).get_top_fruittile().get_tile_name());
					System.out.println("Community 2: " + _testGB.getMap().get_communities().get(2).get_top_fruittile().get_tile_name());
					System.out.println("Community 3: " + _testGB.getMap().get_communities().get(3).get_top_fruittile().get_tile_name());
					System.out.println("Community 4: " + _testGB.getMap().get_communities().get(4).get_top_fruittile().get_tile_name());
					System.out.println("Community 5: " + _testGB.getMap().get_communities().get(5).get_top_fruittile().get_tile_name());
					System.out.println("Community 6: " + _testGB.getMap().get_communities().get(6).get_top_fruittile().get_tile_name());
					System.out.println("Community 7: " + _testGB.getMap().get_communities().get(7).get_top_fruittile().get_tile_name());
					System.out.println("Community 8: " + _testGB.getMap().get_communities().get(8).get_top_fruittile().get_tile_name());
					System.out.println("Community 9: " + _testGB.getMap().get_communities().get(9).get_top_fruittile().get_tile_name());
					System.out.println();
					
					_testTurn.endTurn();
				}
				else
				{
					System.out.println("no such joker");
					System.out.println();
				}
			}
			else if(inp.equals("quit"))
			{
				return;
			}
			else
			{
				System.out.println("typo");
			}
		}
	}
}
