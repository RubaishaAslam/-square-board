/*
 * Written By: Rubaisha Aslam 
 * Assignment 2
 * This class saves records that will be stored in the hash table
*/
public class Record {
private String key;
private int score;
private int level;


// set the constructor for the class 
public Record(String key, int score, int level) {
	this.key = key;
	this.score = score;
	this.level = level; 
	
}

// returns the string  key 
public String getKey(){
	return key;
}

// return the first integer score 
public int getScore() {
	return score;
}
// returns the second integer level 
public int getLevel() {
	return level;
	
}
}
