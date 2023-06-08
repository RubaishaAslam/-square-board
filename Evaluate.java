/*
 * Written By: Rubaisha Aslam 
 * Assignment 2
 * This class implements all the auxiliary methods needed by the algorithm that plays the game
*/

public class Evaluate {
	private char [][] gameBoard;
	private int size;
	private int tilesToWin;
	private int maxLevels;
	private static final int tableSiza = 9433; 
	
	// set the size of board, set the adjacent tiles need to win and quality of program
	public Evaluate (int size, int tilesToWin, int maxLevels) {
		this.size = size;
		this.tilesToWin = tilesToWin;
		this.maxLevels = maxLevels;
		// set gameBoard constructor 
		gameBoard = new char[size][size];
		for(int row=0; row<size; row++) {
			for (int col=0; col<size; col++) {
				gameBoard [row][col] = 'e';
			}
		}}
	
	// add a private string converter 
	private String stringIt() {

		String stringName = "";
		for(int i =0; i<size; i++) {
			for(int j=0; j<size; j++) {
				stringName = gameBoard[i][j] + stringName;
			}
		}
        return stringName;
    }
 
	// return empty dictionary with the prime number size
	public Dictionary createDictionary() {
		Dictionary dict = new Dictionary(tableSiza);
		return dict;
	}
	
	// checks if the board contains the record value if yes return the record object if not return null
	public Record repeatedState(Dictionary dict) {
		
		Record checkBoard = (Record) dict.get(stringIt());
		if(checkBoard != null) {
			return checkBoard;
		}
		
		return null;
		
		
	}
	
	// add string value and put record value in the the game board
	public void insertState(Dictionary dict, int score, int level) {
		String checkInsert= stringIt();
		// it creates an object of the class Record storing this string, score, and level
		Record checkBoard = new Record(checkInsert, score, level);
		
		// store object in dictionary if already exist throw exception
		try {
			dict.put(checkBoard);
		}
		catch(DuplicatedKeyException e){
			System.out.println("ALREADY IN THERE");
		}
	}
	
	// stores symbol in gameBoard[row][col].
	public void storePlay(int row, int col, char symbol) {
		gameBoard [row][col] = symbol;
	}
	
	// checks if gameBoard [row][col] is empty 
	public boolean squareIsEmpty (int row, int col) {
		if (gameBoard [row][col] == 'e') {
			return true;
		}
		return false;
	}
	
	// checks if gameBoard [row][col] is computer  
	public boolean tileOfComputer (int row, int col) {
		if (gameBoard [row][col] == 'c') {
			return true;
		}
		return false;
	}
	
	// checks if gameBoard [row][col] is human 
	public boolean tileOfHuman (int row, int col) {
		if (gameBoard [row][col] == 'h') {
			return true;
		}
		return false;
	}
	
	
	// check for win 
	public boolean wins (char symbol) {
		
		// loop throw the row and see if the diff columns have the symbol if the tilesToWin equals to the value return  true 
		int inRow = 0;
		for (int i = 0; i < size; i++) { 
			inRow = 0;
			for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == symbol){
                	inRow = inRow +1; 
                	if (inRow == tilesToWin ) {
            			return true;
            			}
                	}
               
             else { 
            	 inRow = 0;
            }} }
		
		
		int inCol = 0;
		for (int i = 0; i < size; i++) {
			inCol = 0;
            for (int j = 0; j < size; j++) {
                if (gameBoard[j][i] == symbol){
                	inCol = inCol +1; 
                	if (inCol == tilesToWin) {
            			return true;

                	}
                }
                else {
                	inCol = 0;
                }}}
		
		// to check diagonal add to the row as if the first with symbol is 1,1 second would be 2,2
		int rightDiagonal = 0;
		for (int i = 0; i < size; i++) {
			rightDiagonal = 0;
            for (int j = 0; j < size; j++) {
            	if(i < size && j < size) {
	            	if (gameBoard[i][j] == symbol) {
	            		int row = i;
	            		int col = j;
	            		while (row >= 0 && col >= 0 && row < size && col < size) { 
                			if (gameBoard[row][col] == symbol) {
		                    	rightDiagonal = rightDiagonal +1; 
			                    	if (rightDiagonal == tilesToWin) {
			                			return true;
			                			
			                		}
		                    	row = 1 + row;
		                    	col = 1+ col; 		
		                }  
	            
				            else {
				            	rightDiagonal = 0;
				            	break;
		            }
	        } 
	        row = 0;
	        col = 0; 
	        rightDiagonal = 0;
	        
		}}}}
		
		int leftDiagonal = 0;
		for (int i = 0; i < size; i++) {
			 leftDiagonal = 0;
            for (int j = 0; j < size; j++) {
            	if(i < size && j < size) {
                	if (gameBoard[i][j] == symbol) {
                		int row = 1;
                		int col = 1;
                		while (row >= 0 && col >= 0 && row < size && col < size) { 
                			if (gameBoard[row][col] == symbol) {
		                		leftDiagonal = leftDiagonal +1; 
			                		if (leftDiagonal == tilesToWin) {
			                			return true;
			                		}
		                		row = 1+row;
		                		col =col- 1;
	                    }
			            	else {
			            		leftDiagonal = 0;break;
			            	}}
                		row = 0;
             	       col = 0; 
             	       leftDiagonal = 0;
        }}}}
		
		int rightUp = 0;
		for (int i = 0; i < size; i++) {
			rightUp = 0;
            for (int j = 0; j < size; j++) {
                	if (gameBoard[i][j] == symbol) {
                		int row = i;
                		int col = j;
                		while (row >= 0 && col >= 0 && row < size && col < size) { 
                			if (gameBoard[row][col] == symbol) {
                				rightUp = rightUp +1;
		                		if (rightUp == tilesToWin) {
		                			return true;
		                		}
		                		row =row -1;
		                    	col = 1+col; 
		                    }
                			else {
                				rightUp =0;break;
            }}
                	row = 0;
              	     col = 0; 
              	     rightUp = 0;
        }}}
		
		int leftUp = 0;
		for (int i = 0; i < size; i++) {
			leftUp = 0;
            for (int j = 0; j < size; j++) {
            	if(i < size && j < size) {
                	if (gameBoard[i][j] == symbol) {
                		int row = i;
                		int col = j;
                		while (row >= 0 && col >= 0 && row < size && col < size) { 
                			if (gameBoard[row][col] == symbol) {
	                    		leftUp = leftUp +1; 
			                		if (leftUp == tilesToWin) {
			                			return true;
			                		}else{
			                			row = row-1;
				                		col = col-1; 
			                		}
                			}else {
                				leftUp = 0;break;
                			}
		            }
                		row = 0;
                 	    col = 0; 
                 	    leftUp = 0;}
        }}}
	
		return false;
	}
	
	// check for the value if any is empty if so return false if no empty return true
	public boolean isDraw() {
		int noVal = 0;
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == 'e'){
                	noVal = noVal +1;
                }}}
		
		if(noVal == 0) {
			return true;
		}
		else 
		return false;

	}
	
	// return value, if computer won return 3, if human won return h, if a draw return 2 and if undecided return 1
	public int evalBoard() {
		if (wins('c')){
			return 3;
		}
		else if (wins('h')){
			return 0;
		}
		else if (isDraw()){
			return 2;
		}
		else 
			return 1;
	}

}
