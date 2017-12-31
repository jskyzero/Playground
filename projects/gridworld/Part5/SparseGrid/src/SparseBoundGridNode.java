	public class SparseBoundGridNode
  	{
    	// values 
        private Object occupant;
       	private int col;
        private SparseBoundGridNode next;
    	
    	// construct	
    	public SparseBoundGridNode(Object occupant, int col, SparseBoundGridNode next)
    	{
    		this.occupant = occupant;
    		this.col = col;
    		this.next = next;
    	}

    	// get next node 
    	public SparseBoundGridNode getNext()
    	{
    		return this.next;
    	}

    	public void setNext(SparseBoundGridNode next)
    	{
    		this.next = next;
    	}

    	// get occupant
    	public Object getOccupant()
    	{
    		return this.occupant;
    	}

    	// get column
    	public int getCol()
    	{
    		return this.col;
    	}

	}