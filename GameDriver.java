import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * ---------------------------------------------------------------------------
 * File name: GameDriver.java<br/>
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
 * To drive a dungeon game using other classes and methods.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft & Larry Bryant
 */
public class GameDriver
{

	/**
	 * To display game intro splash, and run methods
	 * from other classes to simulate dungeon exploration. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */

	public static void main (String [ ] args)
	{
		int question,	//to hold value for direction prompt
			position,	//to hold and pass player position
			length;		//to hold length of dungeon
		
				
		try
		{
			//output intro splash
			System.out.println("\n\n");
			System.out.println("*********     *******     ********     ***   ***");
			System.out.println("*********    *********    *********    ***  ***");
			System.out.println("      ***    ***   ***    ***   ***    *** ***");
			System.out.println("     ***     ***   ***    ***   ***    ******");
			System.out.println("    ***      ***   ***    *********    *****");
			System.out.println("   ***       ***   ***    ********     *****");
			System.out.println("  ***        ***   ***    *** ***      ******");
			System.out.println(" ***         ***   ***    ***  ***     *** ***");
			System.out.println("*********     *******     ***   ***    ***  ***");
			System.out.println("*********     *******     ***    ***   ***   ***");
			
			System.out.println("\n              THE DUNGEON GAME");
			System.out.println("\n\n");
			JOptionPane.showMessageDialog(null, "WELCOME TO ZORK: THE DUNGEON GAME\n\n" +
				"In this game, you are exploring a dungeon of unknown " +
				"size.\nIt is your challenge to safely navigate the dungeon" +
				" and find the exit.\nThe dungeon is full of creatures who" +
				" will try and stop you\nfrom making it out alive.  For every" +
				" room you enter,\nthere is a chance to encounter a monster or" +
				" to find a weapon.\nYou must defeat all monsters in a room" +
				" in order to advance.\n\nThe game is over when you have" +
				" either exited the dungeon alive\nor have been defeated.");
		
			//clear splash
			clearScreen ( );
		
			//create new dungeon
			Dungeon dungeon = new Dungeon();
			//place player in first dungeon room
			Dungeon.dungeon[0].playerFound(true);
			position = dungeon.player1.getPosition ( );
			length = dungeon.getLength ( );
			
			//run loop while player is not in last room
			while(position != (length-1))
			{
				clearScreen();
				
				//show cell description
				JOptionPane.showMessageDialog(null, Dungeon.dungeon[position].getCellDes ( ));
				
				//display dungeon map
				System.out.println(dungeon.dungeonMap());
				
				//display dialog if monster or weapon found
				if(Dungeon.dungeon[position].monsterFound || Dungeon.dungeon[position].weaponFound)
				{
					JOptionPane.showMessageDialog(null, dungeon.toString(position));
				}
				
				//display game over if player dead
				if(dungeon.player1.getHealth() <= 0)
				{
					JOptionPane.showMessageDialog (null, "Alas, the dungeon has bested you and your life has expired...");
					dungeon.gameOver ( );
					}
					
					//display specific direction message for first room or other rooms
					if(position == 0)
					{
						UIManager.put ("OptionPane.yesButtonText", "Yes");
						UIManager.put ("OptionPane.noButtonText", "No");
						question = JOptionPane.showConfirmDialog (null, "Continue to next room?", "", JOptionPane.YES_NO_OPTION);
						if(question == JOptionPane.YES_OPTION)
						{	
							dungeon.player1.movePlayer (1);
						}
						else
						{
							JOptionPane.showMessageDialog (null, "Guess your not up to the task... Game Over.");
							dungeon.gameOver ( );
						}	
					}
					else
					{
						UIManager.put ("OptionPane.yesButtonText", "Left");
						UIManager.put ("OptionPane.noButtonText", "Right");
						UIManager.put ("OptionPane.cancelButtonText", "Quit");
						question = JOptionPane.showConfirmDialog (null, "Which direction would you like to move?");
						
						if(question == JOptionPane.YES_OPTION)
						{
							dungeon.player1.movePlayer(-1);
						}	
						else if(question == JOptionPane.NO_OPTION)
						{
							dungeon.player1.movePlayer(1);
						}
						else if(question == JOptionPane.CANCEL_OPTION)
						{
							JOptionPane.showMessageDialog (null, "Guess your not up to the task... Game Over.");
							dungeon.gameOver ( );
						}
						else if(question == JOptionPane.CLOSED_OPTION)
						{
							JOptionPane.showMessageDialog (null, "Guess your not up to the task... Game Over.");
							dungeon.gameOver ( );
						}
					
					}
				
					position = dungeon.player1.getPosition ();
				
				}
			
			
			clearScreen();
		
			//display the end when player reaches last cell
			JOptionPane.showMessageDialog(null, Dungeon.dungeon[dungeon.getLength()-1].getCellDes ( ));
			System.out.println(dungeon.dungeonMap());
			System.out.println("######## ##     ## ########    ######## ##    ## ########");
			System.out.println("   ##    ##     ## ##          ##       ###   ## ##     ##");
			System.out.println("   ##    ##     ## ##          ##       ####  ## ##     ##");
			System.out.println("   ##    ######### ######      ######   ## ## ## ##     ##");
			System.out.println("   ##    ##     ## ##          ##       ##  #### ##     ##");
			System.out.println("   ##    ##     ## ##          ##       ##   ### ##     ##");
			System.out.println("   ##    ##     ## ########    ######## ##    ## ########");	
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog (null, "OOPS! Well now this is embarrassing! \nIt seems that Zork" +
					" has encountered an error of some sort. \nUnfortunately game play must stop at this point" +
					" but feel free to have another go at the dungeon, on the house!\n\n " +
					"Error: " + e);
		}

	}//end of main
	
	public static void clearScreen()
	{
	
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}//end of clearScreen

}//end of GameDriver.java
