import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java<br/>
 * Project name: GameOfZork<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: David Kraft, kraftd@goldmail.etsu.edu /
 * Larry Bryant, bryantl@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * To create an array of cell objects,
 * generate a string for battle and map,
 * create and keep player object.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft & Larry Bryant
 */
public class Dungeon
{
	static Random rnd = new Random();
	static int randomCell = rnd.nextInt(20);
	public static Cell[] dungeon = new Cell[randomCell + 3];
	Player player1 = new Player();
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 */
	public Dungeon()
	{
		dungeon[0] = new StarterCell();
		dungeon[dungeon.length - 1] = new EndCell();
		for(int i = 1; i < dungeon.length-1; i++)
		{
			dungeon[i] = new Cell();
		}
	}// end of no-arg constructor
	
	/**
	 * Generate a string of battle information <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @param position
	 * @return
	 */
	public String battle(int position)
	{
		String battleInfo = "";
		int monsterHealth,
			   playerHealth,
			   monsterAttack;
		int monsterCount,
			ranPlayerHit,
			ranMonsterHit,
			playerAttack;
		boolean playerDead = false,
				monsterDead = false;
		
		//Generate battle string if cell contains monster(s)
		if(dungeon[position].monsterFound)
		{
			battleInfo += "\nAnd the battle begins...";
			monsterCount = dungeon[position].getMonsterNum();
			
			//Loop through battle for number of monsters in cell
			for(int i = 0; i < monsterCount; i++)
			{
				//Break loop if player dies
				if(playerDead)
				{
					break;
				}
				
				//Populate necessary information about player and monsters
				monsterHealth = dungeon[position].monsters[0].getHealth();
				playerHealth = player1.getHealth();
				playerAttack = player1.getAttack();
				monsterAttack = dungeon[position].monsters[0].getAttack();
				
				//Continue so long as neither player nor monster is dead.
				while(!playerDead || !monsterDead)
				{
					ranPlayerHit = rnd.nextInt(10);	//Generate random for probability of player hit
					ranMonsterHit = rnd.nextInt(5);	//Generate random for probability of monster hit
					battleInfo += "\nPlayer strikes...";
					
					//if random number is 8, player attack misses
					if(ranPlayerHit == 8)
					{
						battleInfo += " MISS!!!";
						
					}
					else
					{
						monsterHealth -= playerAttack;
						battleInfo += " HIT! Monster lost " + playerAttack + " health. Monster Health = " + monsterHealth;
						
						//Check if monster dead
						if(monsterHealth <= 0)
						{
							monsterDead = true;
							break;
						}
					}
					
					battleInfo += " Monster attacks...";
					
					//if random number is 3, monster attack misses
					if(ranMonsterHit == 3)
					{
						battleInfo += " MISS!!!";
					}
					else
					{
						playerHealth -= monsterAttack;
						battleInfo += " HIT! Player lost "  + monsterAttack + " health. Player Health = " + playerHealth;
						
						//Check if player dead
						if(playerHealth <= 0)
						{
							playerDead = true;
							break;
						}
					}
				}
				
				monsterDead = false; //reset boolean to allow for multiple monsters
				player1.setHealth (playerHealth); //set player health to memory
				
			}
			
			 
		}
		dungeon[position].monsterFound = false; //to show monster dead
		return battleInfo;
	}//end of battle method 
	
	/**
	 * Generate string for dungeon map <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public String dungeonMap()
	{
		String dungeonMap = "";
		
		dungeonMap += "DUNGEON MAP\n\n";
		
		//Get toString printout for each cell
		for(int i = 0; i < dungeon.length; i++)
		{
			dungeonMap += dungeon[i];
		}
		
		return dungeonMap;
	}//end of dungeonMap
	
	
	/**
	 * toString Method <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @param position
	 * @return
	 */
	public String toString(int position)
	{
		int x = rnd.nextInt (weaponDes.length);
		String dungeonPrint = "",
		       weapon = weaponDes[x],
			   briefWep=briefWeaponDes[x];
		
		//Generate string if weapon found in cell
		if(dungeon[position].weaponFound)
		{
			dungeonPrint += "\n\n";
			if(dungeon[position].randomWepType == 1)
			{
				dungeonPrint += "There is a metal table leg laying on the ground.\n";
				
				if(player1.weaponType == 2)
				{
					dungeonPrint += "You already have a better weapon, you leave the leg.";
				}
				else if(player1.weaponType == 1)
				{
					dungeonPrint += "You already have a metal table leg, you leave this one here.";
				}
				else if(player1.weaponType == 0)
				{
					dungeonPrint += "You do not have a weapon, you pick up the table leg.";
					player1.setWeapon(1);
					player1.weaponType = 1;
					dungeon[position].weaponFound = false;
				}
				
			}
			else if(dungeon[position].randomWepType == 2)
			{
				dungeonPrint += weapon+"\n";
				
				if(player1.weaponType == 1)
				{
					dungeonPrint += "This "+briefWep+" will do more damage than your metal table leg.\n"+
									"You decide to keep "+briefWep+" and discard the table leg.";
					player1.setWeapon(2);
					player1.weaponType = 2;
					dungeon[position].weapon[0] = new Stick();
					dungeon[position].randomWepType = 1;
				}
				else if(player1.weaponType == 2)
				{
					dungeonPrint += "You already have a "+briefWep+", you leave this one here.";
				}
				else if(player1.weaponType == 0)
				{
					dungeonPrint += "You do not have a weapon, you pick up the "+briefWep+".";
					player1.setWeapon(2);
					player1.weaponType = 2;
					dungeon[position].weaponFound = false;
				}
				
			}
			
		}
		
		//Generate string if monster found in cell
		if(dungeon[position].monsterFound)
		{
			dungeonPrint += "\n\nWATCH OUT! This room contains " +
					dungeon[position].randomMonNum + " ";
					if(dungeon[position].randomMonType == 1)
						{
							dungeonPrint += "Giant Insect";
						}
					else if(dungeon[position].randomMonType == 2)
					{
						dungeonPrint += "Bandit(s)";
					}
					else if(dungeon[position].randomMonType == 3)
					{
						dungeonPrint += "Zombie(s)";
					}
					
					dungeonPrint += "!";
		}
		
		//Add battle output to string
		dungeonPrint += battle(position);
		
		
		return dungeonPrint;
	}//end of toString
	
	/**
	 * Return dungeon size <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getLength()
	{
		return dungeon.length;
	}//end of getLength	
	
	/**
	 * Print out GAME OVER when applicable <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 */
	public void gameOver()
	{
		GameDriver.clearScreen();
		System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########");
		System.out.println("##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ##");
		System.out.println("##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ##");
		System.out.println("##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########");
		System.out.println("##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##");
		System.out.println("##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##");
		System.out.println(" ######   ##     ## ##     ## ########     #######     ###    ######## ##     ##");
		System.exit(0);
	}//end of gameOver
	
	private String[] weaponDes ={"There is a some sort of a haphazard bandit weapon sticking out of some poor souls back.\n"+
								"Lifting it up you see its a table leg with various nails, and saws stuck to it.\n",
								"You notice an open tool box. You look through it briefly, but there is nothing useful.\n"+
								"As you turn to move on you notice a fire hydrant wrench in the cornor. Hit something\n"+
								"with that and it will definitely go down.\n",
								"A bloody crowbar lay on a bullet riddled desk.\n",
								"A bright red fire emergency box lay on it's side. The glass smashed out, but inside a\n"+
								"fire axe lay menacing.\n",
								"A piece of rebar juts out of the side of crack in the concrete wall.\n"+
								"With a small tug it comes loose. This will do some damage.\n"};
	
	private String[] briefWeaponDes ={"gnarled bandit weapon","fire hydrant wrench","blood spattered crowbar","fire axe","rebar"};
	
}//end of Dungeon.java
