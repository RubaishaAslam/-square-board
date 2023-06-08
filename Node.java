/*
 * Written By: Rubaisha Aslam 
 * Student Number: 251179721
 * Assignment 2
 * This class saves adds nodes that will be used in the linked list 
*/

public class Node {
	// set instance variable 
	private Record data;
	private Node next;

	//create a node with record data 
	public Node(Record data) {
		this.data = data;
		this.next = null;
	}
	
	// return the next node 
	public Node getNextNode() {
		return next;
	}
	
	//set the next node
	public void setNextNode(Node add) {
		this.next = add;
		
	}

	// return the data 
	public Record getRecord() {
		return data;
	}
	

	// set the record 
	public void setRecord(Record newRec) {
		this.data = newRec;
	}
}
