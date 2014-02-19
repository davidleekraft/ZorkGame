/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java<br/>
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
 * Generate a weapon<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft & Larry Bryant
 */
public class Weapon
{
	public String name = "";	//to hold weapon name
	public int weaponType = 0;	//to hold weapon type
	public int attack = 1;		//to hold weapon attack value
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 */
	public Weapon()
	{
		
	}//end of no-arg constructor
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 * @param weaponType
	 * @param attack
	 */
	public Weapon(String name, int weaponType, int attack)
	{
		this.name = name;
		this.weaponType = weaponType;
		this.attack = attack;
	}//end of contructor
	
	/**
	 * Returns attack value <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getAttack()
	{
		return attack;
	}//end of getAttack
	
	
}//end of Weapon.java
