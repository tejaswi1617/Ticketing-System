package employeePerformance;

public enum WorkWeights 
{	    
	HIGH  (9),  
    MEDIUM(8), 
    LOW   (7); 

    public int workWeights = 0;

    WorkWeights(int workWeights) 
    {
		// TODO Auto-generated constructor stub
    	this.workWeights = workWeights;
	}

    public int getWorkWeights() 
    {
        return this.workWeights;
    }     
}
