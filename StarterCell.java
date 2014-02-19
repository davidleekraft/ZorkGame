/**
 * ---------------------------------------------------------------------------
 * File name: StarterCell.java<br/>
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
 * To Create first Cell<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft
 */
public class StarterCell extends Cell
{
	public boolean playerFound = true; //sets player in first room for start
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 */
	public StarterCell ( )
	{
		super(false, false, true);
		cellDescription = "\n"+cellDes[0]+"\n";
	}//end of constructor
	
	/**
	 * Returns cell description <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see Cell#getCellDes()
	 */
	public String getCellDes()
	{
		return cellDescription;
	}//end of getCellDes
}//end of StarterCell.java
