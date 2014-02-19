import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Cell.java<br/>
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
 * To generate a room or cell object
 * to fill the dungeon.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft
 */
public class Cell
{
	public String cellDescription; //Holds a information about the story as well as details about the room the player is in
	
	public boolean playerFound = false,	//used to determine if the player is in a certain cell
				   monsterFound = false,//used to determine if a monster is in a cell
				   weaponFound = false,	//used to determine if a weapon is in a cell
				   cellVisited = false;
				   
	
	public Monster[] monsters = new Monster[5]; //Created an array of Monsters containing 5 blank indexes
	public Weapon[] weapon = new Weapon[1];	//used to hold weapon type object for cell
	Random rnd = new Random();
	int randomMonster = rnd.nextInt(2) + 1,	//random number for 50% chance of room containing monster
		randomMonType = rnd.nextInt(3) + 1,	//random number for monster type
		randomMonNum = rnd.nextInt(3) + 1,	//random number for number of monster type in cell
		randomWeapon = rnd.nextInt (4) + 1,	//random number for 25% chance of weapon
		randomWepType = rnd.nextInt(2) + 1, //random number for weapon type
		randomDes=rnd.nextInt(20);	//random number for cell description
	
	//an array of cell descriptions to be picked at random.
	String[] cellDes = {"THE STORY:\n\nYou had sought refuge in a cave to avoid the severe acid storm\n"+
					"that was brooding on the horizon of the desert wasteland.\n"+ 
					"Just as you had fallen asleep, you heard a loud noise and the\n" +
					"ground began to shake. The rumbling grew louder and louder near the\n" +
					"entrance. You lept to your feet in time to watch mud flood over the \n" +
					"entance and begin pouring in. Panicing, you rushed down through\n" +
					"the cave. The path was surprisingly clear, and as you fully awake\n" +
					"and snap out of the terror of the situation, you realize\n" +
					"you left EVERYTHING behind...You are alone, without any\n" +
					"supplies, no way out, and completely blind in the now pitch\n" +
					"black cave. You hear the mud stop behind you. You gaze \n" +
					"desperately into the dark, frantically searching for anything\n"+
					"and notice a very faint radiating glow on\n" +
					"the path ahead. You have nothing to lose at this point, and \n" +
					"decide to investigate the glow. Besides, If you are going to die you'd\n" +
					"like to atleast be in the comfort of light. Upon reaching the light\n" +
					"you realize you've discovered a post-war bunker. These things\n" +
					"sprang up everywhere before, and during the war. You rejoice\n" +
					"because you know these things always have multiple exits!\n" +
					"The front reinforced vault door is open. Blast marks, and bullet casings\n" +
					"litter the area just inside. Shrieks, the sound of gun fire, and explosions\n" +
					"are fading away off in the distance. You don't know what's happening\n" +
					"and you don't care so long as you get out of here in one piece.\n" +
					"You begin your arduous journey forward into the unknown.",
					"The walls are grey and riddled with cracks; a group of pipes\n"+
					"are jutting from the ceiling. Old rusted broken pre-war \n"+
					"machinery sit around the edges of the room bolted to\n"+
					"the floor. The lights, although dim, were working still...\n"+
					"a sign that you are not alone.",
					"The lights are flickering on and off. Through the strobe you\n"+
					"can make out humanoid shapes near the door, but you're unsure\n"+
					"of what it really is. Roots stretch out of the left wall and\n"+
					"across the floor; making it difficult to walk and keep your \n"+
					"eyes on the shadows on the opposite side of the room.",
					"You encounter a barracade of rusted metal bed frames. There is\n"+
					"no way round the barracade, but you need to move on; you make\n" +
					"the decision to press on, and loudly break through the baracade.\n" +
					"The room is a hallway through the bunker's dormitory. Corspes fill\n" +
					"the bedrooms. The inhabitants never stood a chance.",
					"You find yourself in a wide gathering area. Various bandits lay \n" +
					"dead and partially eaten on the floor. Their chests eviscerated \n" +
					"and filled with eggs. Screams echo from the corrodore across the room.",
					"The room wreaks of death. Air ducts had rusted loose from the \n" +
					"ceiling, fallen, and busted open on the ground. They spewed\n" +
					"putrid air into the vacant hallway.",
					"A battlefield lay before you. On one side: a rubble filled\n"+
					"police station covered in gore. The other side: a make shift\n"+
					"cover, blast marks, and bullet casing. There were not any\n"+
					"intact corpses...you shuddered at the thought of what\n"+
					"happened to them.",
					"Egg clutches clutter the floor. A pale slime coats the walls.\n"+
					"Some of the eggs are pulsating you fear what may dig its way\n"+
					"out, and hope you won't find out.",
					"Giant insect carcasses are piled up in the center of the room\n" +
					"smoldering. The smell of burnt flesh and hair doesn't\n" +
					"even compare to the horrid smells raidiating out from these\n"+
					"dead burnt insects.The concrete ceiling, and walls are \n" +
					"all black with soot.",
					"Harsh light floods from the a huge whole in the high ceiling.\n"+
					"Looking up you realize you have stumbled into a 70 floor \n" +
					"tall storage facility. This would be an excelent place to\n" +
					"scavenge; except the caving 9 foot thick ceiling had busted\n" +
					"the stairs loose and allowed who knows what in.\n" +
					"You carefully begin scaling the concrete mountain looking for\n" +
					"an exit.",
					"Decomposed corpses lay overlapping each other up against the\n" +
					"far door. No injuries immediately noticible. However, there\n" +
					"is scratch marks over and around the door. You remain\n" +
					"steadfast, and continue on determined to escape this nightmare.",
					"The floor slopes down infront of you. The floor had caved into\n" +
					"the room below. That floor was covered with murky stagnant water.\n" +
					"Severed limbs, and random body parts floated just on the surface.",
					"The corridor is completely pitch black. You carefully felt for\n" +
					"the wall, and began slowly moving forward praying\n" +
					"that something wasn't waiting for you in the dark.",
					"A draft blows up from the stair well infront of you. Looking down\n"+
					"the stairs there is a rusted sign bairly hanging above the door at\n"+
					"the bottom. It says: Restricted Area, Authorized Personnel Only. \n" +
					"You must of found the life support chamber. You can hear generators\n" +
					"quietly humming as they consume the last amount of fuel that someone\n" +
					"loaded up.",
					"Noxious fumes cloud the room. You rip a piece of your clothe loose, and\n" +
					"tie it around your mouth. You wade through the possibly deadly fumes\n" +
					"hoping they aren't present in the rest of bunker.",
					"The walls are symetrically lined with hatches leading to some sort of\n"+
					"incenerator. The smell of gas is faintly present along with the sound of gun\n"+
					"fire below you. You begin to panic when suddenly the room shacks. You\n"+
					"go to the ground covering your head as flames blast the hatches loose,\n"+
					"and scorches the ceiling. The temperature begins to rapidly climb.\n" +
					"You crawl quickly under the bellowing flames which sear your back, but\n" +
					"you manage to reach the other side of the room.",
					"Skittering sounds scratch along the exterior walls of the hallway. However, \n"+
					"the walls are thick, except for the gapping whole at the end of the right wall...",
					"You are clearly in the mess hall. Stools, serving trays, tables, and\n"+
					"food distrubutor machines sit eerily vacant. You can't help, but wish\n" +
					"you had a Cadbury Creme Egg. That's one thing you just realize you miss\n" +
					"about this post war nightmare...Easter with your folks.",
					"You found what seems to be an insane asylum for stir crazy bunker dwellers.\n" +
					"All the cells are busted up and riddled with gore. Except 1, which has\n" +
					",despite the attempts of the bunkers new inhabitants, been preserved.\n" +
					"A skeletal figure lay in the fetal position inside. It's surrounded by\n" +
					"some insane scribbles about walls needing to be built in cells. It goes\n" +
					"on to include something about failing an important test because his spouse was\n" +
					"having a child. Confused, you try not to read too much into it.",
					"You're standing in some surgical ward. Maniacal laughter flares up a distance infront of you.\n"+
					"There is blood splatters every where. Surgical saws coated in gore; bone \n"+
					"fragments glued to the floor in puddles of coagulated blood. The unwelcome\n" +
					"stench of copper was present. You knew it was from the blood, but you\n" +
					"regretted the fact that you knew it was from the blood.",
					"Sheets of music littered the floor. Chairs were knocked over and jumbled up\n"+
					"with various musical instruments. at the front of the room was a stage. The \n"+
					"rafters holding the lights abovethe stage had fallen from the ceiling and \n" +
					"drove themselves through the floor behind a charred piano. A skeleton draped\n"+
					"across the hood of the piano, burnt to it. You laugh to yourself, at least he\n"+
					"died doing what he loved...You caught yourself and felt sick to your stomach\n"+
					"what had this new world done to you...",
					"The floor is covered with filth and the stench is almost overwhelming.\n"+
					"Someone, or something had shot up and busted open the bunkers ceptic tanks\n"+
					"in this waste processing area. The build of years of excrement safely\n" +
					", and snuggly stored in tank was now all over the room...However, there\n" +
					"was a bitter sweetness to the situation. You were going to have to wade\n" +
					"through this mess, but at least insects had eaten a path through it...\n" +
					"but where were the insects?",
					"The events are now coming to a head. You can hear all kinds of chaos\n" +
					"unfolding just infront of you. It goes quiet except for some moaning.\n"+
					"You wait and hear a hydrolic lift start up. This must be where an exit is.\n"+
					"As you enter the room; you see a man laying on his right side. His\n" +
					"right arm is tucked under him grasping his gut, and his left arm\n" +
					"laying limp on the floor at his side. A puddle of blood flowing out from him.\n" +
					"He lets out a final gasp and dies. You stand in silence,\n" +
					"surrounded by dead men, women, and children all that was left of this bunker's\n"+
					"inhabitance must of fled here in the wake of destruction. Their attempts to escape\n"+
					"failed. You feel sorry as you look up at the ascending lift watching\n"+
					"it carry what ever is left of the bandit raiding party that tore through\n" +
					"this place. Part of you knows you are free, and you\n" +
					"want to be happy, but part of you knows you just walked through a \n" +
					"grave yard filled with fresh souls. You just witnessed the horror\n" +
					"that humanity has become...After about an hour you lower the lift\n" +
					"and head to the surface. Unsure of what\n" +
					"might lay ahead, unsure of who you are, and unsure of why the world\n" +
			        "is now the way it is, but in all this uncertantity one fact arises:\n"+
					"The tradgedy, the true catastrophe, is that humanity may be no more..."};
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 */
	public Cell()
	{
		monFound();
		wepFound();
		monsters[0] = monFound();
	}
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param monsterFound
	 * @param weaponFound
	 */
	public Cell(boolean monsterFound, boolean weaponFound)
	{
		this.monsterFound = monsterFound;
		this.weaponFound = weaponFound;
	}
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param monsterFound
	 * @param weaponFound
	 * @param cellVisited
	 */
	public Cell(boolean monsterFound, boolean weaponFound, boolean cellVisited)
	{
		this.monsterFound = monsterFound;
		this.weaponFound = weaponFound;
		this.cellVisited = cellVisited;
	}
	
	/**
	 * To set whether cell has been visited so that
	 * room contents will either show or be hidden. <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param cellVisited
	 */
	public void setVisited(boolean cellVisited)
	{
		this.cellVisited = cellVisited;
	}
	
	/**
	 * Generate monster object if monster found in cell. <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public Monster monFound()
	{
		Monster tempMon = new Monster();
		
		//if randomMonster == 2 then generate monster
		if(randomMonster == 2)
		{
			monsterFound = true;
			
			//generate monster type based on random number
			if(randomMonType == 1)
			{
				randomMonNum = 1;
				Monster[] monsters = new Monster[1];
				tempMon = new GiantInsect();
			}
			else if(randomMonType == 2)
			{
				Monster[] monsters = new Monster[randomMonNum];
				for(int i=0; i<=randomMonNum-1; i++)
				{
					tempMon = new Bandits();
				}
			}
			else
			{
				Monster[] monsters = new Monster[randomMonNum];
				for(int i=0; i<=randomMonNum-1; i++)
				{
					tempMon = new Zombie();
				}
			}
		}
		return tempMon;
	}//end of monFound
	
	/**
	 * Generate weapon if weapon found in cell <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 */
	public void wepFound()
	{
		//generate weapon if randomWeapon == 3
		if(randomWeapon == 3)
		{
			weaponFound = true;
			Weapon[] weapon = new Weapon[1];
			
			if(randomWepType == 1)
			{
				weapon[0] = new Stick();
			}
			else if(randomWepType == 2)
			{
				weapon[0] = new Sword();
			}
		}
	}//end of wepFound
	
	/**
	 * Set whether player is found in cell <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @param playerFound
	 */
	public void playerFound(boolean playerFound)
	{
		this.playerFound = playerFound;
	}//end of playerFound
	
	/**
	 * Return number of monsters in cell <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getMonsterNum()
	{
		return randomMonNum;
	}//end of getMonsterNum
	
	/**
	 * Return a random cell description <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public String getCellDes()
	{
		if(randomDes==0)
		{
			cellDescription = "\n"+cellDes[randomDes+1];
		}
		else if(randomDes == cellDes.length)
		{
			cellDescription = "\n"+cellDes[randomDes-1];
		}
		else if(randomDes>0 && randomDes < cellDes.length)
		{
			cellDescription = "\n"+cellDes[randomDes]+"\n";
		}
		return cellDescription;
	}//end of getCellDes
	
	/**
	 * toString <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String cellPrint = "";
		
		if(!cellVisited)
		{
			cellPrint += "|?????|";
		}
		else if(playerFound && monsterFound && weaponFound)
		{
			cellPrint += "|_PWM_|";
		}
		else if(playerFound && monsterFound)
		{
			cellPrint += "|_P_M_|";
		}
		else if(playerFound && weaponFound)
		{
			cellPrint += "|_P_W_|";
		}
		else if(monsterFound && weaponFound)
		{
			cellPrint += "|_M_W_|";
		}
		else if(monsterFound)
		{
			cellPrint += "|__M__|";
		}
		else if(weaponFound)
		{
			cellPrint += "|__W__|";
		}
		else if(playerFound)
		{
			cellPrint += "|__P__|";
		}
		else if(playerFound)
		{
			cellPrint += "|*_P_*|";
		}
		else
		{
			cellPrint += "|_____|";
		}
		
		return cellPrint;
	}//end of toString
	
}//end of Cell.java
