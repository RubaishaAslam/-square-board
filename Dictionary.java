/*
 * Written By: Rubaisha Aslam 
 * Assignment 2
 * This class implements a hash table in which collisions are resolved using separate chaining 
*/

public class Dictionary {
    private int lenghtOfTable;
	private int count;
	private Node[] table;
	 
	 
	 
	 // set a size to the dictionary  
	 public Dictionary(int size) {
	        this.lenghtOfTable = size;
	        table = new Node[size];
	    }
	 
	// create a hash table to use later
	private int hashTable(String inputs) {
		// initialize the hash 
        int hash = 0;
        // loop through the numbers of input and create a hash table 
        for (int i = 0; i < inputs.length(); i++) {
            hash = (hash * 34 ) % lenghtOfTable;
            hash= (hash +  (int)inputs.charAt(i)) % lenghtOfTable;
        }
        return hash;
    }
	
	// add record value in hash table using separate chaining or throw DuplicatedKeyExceptionn if object already exist 
	public int put(Record rec) throws DuplicatedKeyException{
        int keyStore = hashTable(rec.getKey());
        Node currKey = table[keyStore];
        // check if the key is empty if so add a node with record value and return 0
        if (currKey == null) {

            table[keyStore] = new Node(rec); 
            
            return 0;

        }
        // check if the key is not empty 
        if(currKey != null) 
        	// checks if key exists if so throw an exception 
            if(get(rec.getKey()) != null) {
                throw new DuplicatedKeyException("KEY IS IN THERE BRO");
            }
        	// if the key is not empty and the next node is not empty add more not 
            while(currKey.getNextNode() != null){
            	currKey = currKey.getNextNode();
            }
            // set the value to a new node and return 1
            currKey.setNextNode(new Node(rec));
            
            return 1;
        

    }

	public Record get(String key) {
		
		
		 int keyStore = hashTable(key);
		 Node currentStored = table[keyStore];
		 
		 
		 while (currentStored !=null){
			while (currentStored.getRecord().getKey().equals(key)) {
			 return currentStored.getRecord();}
			 currentStored = currentStored.getNextNode();
		 }

		 return null; 
	}
	
	// method removes a key from the table or throw InexistentKeyException if it does not exist 
	public void remove(String key) throws InexistentKeyException{
		int keyStore = hashTable(key);
		 Node currentStored = table[keyStore];
		// if there is no value returns an exception 
		 if (currentStored == null) {
			throw new InexistentKeyException("KEY IS NOT THERE BRO");
		}
		 // if  there is key 
		if (currentStored != null) {
            Node previousVal = null;
            Node currentVal = currentStored;
            // sees if the next is not empty if yes 
            while (currentVal.getNextNode() != null) {
            	//checks if the next node is the record value if yes takes the current and set it as previous
            	while (currentVal.getRecord().equals(currentVal)) {
            		previousVal = currentVal;
            }
            	// if not set the current entry is the next node
            	currentVal = currentVal.getNextNode();

            }
            // if the current value is recorded check if the previous is null and remove the cur by setting it to the next node 
            if (currentVal.getRecord().equals(key)) {

                  if (previousVal == null) {

                	  currentStored = currentVal.getNextNode();

                  } else {

                	  previousVal.setNextNode(currentVal.getNextNode());

            }
      }}}
	
	
// return number of record objects in hash table
public int numElements()
{
	return count;
}
}
