/**
 * ---------------------------------------------------------------------------
 * File name: EndCell.java<br/>
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
 * Generate the last cell<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author David Kraft
 */
public class EndCell extends Cell
{
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 23, 2012 <br>
	 * Date last modified: Mar 23, 2012 <br>
	 *
	 * <hr>
	 */
	public EndCell()
	{
		super(false, false);
		cellDescription = "\n"+cellDes[cellDes.length-1]+"\n";
	}//end of constructor
	
	/**
	 * Return cell description <br>        
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
}//end of EndCell.java
