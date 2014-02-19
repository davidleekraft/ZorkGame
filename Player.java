/**
 * ---------------------------------------------------------------------------
 * File name: Player.java<br/>
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
 * Generate player for game<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft & Larry Bryant
 */
public class Player extends Monster
{
	public int health = 100; //Health Counter
	public int position = 0;	//position of player
	public Weapon weapon;	//to hold player weapon
	public int weaponType = 0;	//holds type of player weapon
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 */
	public Player ( )
	{
		weapon = new Weapon();
	}
	
	/**
	 * return attack points <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see Monster#getAttack()
	 */
	public int getAttack()
	{
		return weapon.getAttack();
	}//end getAttack
	
	/**
	 * Set player weapon <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param weapon
	 */
	public void setWeapon(int weapon)
	{
		if(weapon == 1)
		{
			this.weapon = new Stick();
		}
		else if(weapon == 2)
		{
			this.weapon = new Sword();
		}
	}//end of setWeapon
	
	/**
	 * Return player weapon <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}//end of getWeapon
	
	/**
	 * Return player health <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see Monster#getHealth()
	 */
	public int getHealth()
	{
		return health;
	}//end of getHealth
	
	/**
	 * Set player health <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param health
	 * @see Monster#setHealth(int)
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}//end of setHealth
	
	/**
	 * Move player position from one cell to another <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param move
	 */
	public void movePlayer (int move)
	{
		Dungeon.dungeon[position].playerFound(false);
		position += move;
		Dungeon.dungeon[position].playerFound(true);
		Dungeon.dungeon[position].setVisited(true);
	}//end of movePlayer
	
	/**
	 * Return player position <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getPosition()
	{
		return position;
	}//end of getPosition
	
	
	
}
