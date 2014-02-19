/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java<br/>
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
 * To create a monster object<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft & Larry Bryant
 */
public class Monster
{
	public int health = 20; //Health Counter
	public int attack; //Attack Points
	public String name; //Monster Type
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 22, 2012 <br>
	 * Date last modified: Mar 22, 2012 <br>
	 *
	 * <hr>
	 */
	public Monster()
	{
		
	}//end of no arg constructor
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 22, 2012 <br>
	 * Date last modified: Mar 22, 2012 <br>
	 *
	 * <hr>
	 * @param health
	 * @param attack
	 * @param name
	 */
	public Monster(int health, int attack, String name)
	{
		this.health = health;
		this.attack = attack;
		this.name = name;
	}//end of constructor
	
	/**
	 * Returns attack strength <br>        
	 *
	 * <hr>
	 * Date created: Mar 22, 2012 <br>
	 * Date last modified: Mar 22, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getAttack()
	{
		return attack;
	}//end of getAttack
	
	/**
	 * Returns monsters health level <br>        
	 *
	 * <hr>
	 * Date created: Mar 22, 2012 <br>
	 * Date last modified: Mar 22, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getHealth()
	{
		return health;
	}//end of getHealth
	
	/**
	 * Sets damage to monsters health <br>        
	 *
	 * <hr>
	 * Date created: Mar 22, 2012 <br>
	 * Date last modified: Mar 22, 2012 <br>
	 *
	 * <hr>
	 * @param health
	 */
	public void setHealth(int health)
	{
		this.health += health;
	}//end of setHealth
	
	/**
	 * toString method <br>        
	 *
	 * <hr>
	 * Date created: Mar 22, 2012 <br>
	 * Date last modified: Mar 22, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String strInfo = "name";
		
		
		return strInfo;
	}//end of toString
	
}//end of Monster.java
