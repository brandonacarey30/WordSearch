// Brandon Carey
// CSC 215
// Professor Duncan 
// 10/13/2014
// This program utilizes an input from a file that searches for a set consecutive letter arrangement in
// a word and prints them to screen. This program can search horizontally, vertically, and even at a 45 
// degree angle. 
// *In order to compile from the file I will supply the file used.
// Command line prompt will be as follows:
// javac WordSearch1.java
// java WordSearch1 < input.1

import java.util.Scanner;
import java.io.*;

public class WordSearch1
{

    private static int numRows;
    private static int numCols;
    private static char[][] puzzle;
    private static String [] words;
    private static int wordAmount;
    private boolean identify = false;

    public static void main(String[] args)
    {
	Scanner input = new Scanner (System.in);
	numRows = input.nextInt();
	numCols = input.nextInt();
	puzzle = new char[numRows][numCols];

	input.nextLine();  // Eat up the end of the last line (Cols)

	for (int i=0; i<numRows; i++)
	{
	    String line = input.nextLine();
	    for(int j=0; j<numCols; j++)
	    {
		puzzle[i][j]=line.charAt(j);
	    }
	}

        
	
	wordAmount = input.nextInt();
	words = new String[wordAmount];

       
	for (int i=0; i<wordAmount; i++) {
		words[i] = input.next();
	}
      

	
	WordSearch1 newSearch = new WordSearch1();

	// newSearch.printGrid(); Use this for debugging 
	newSearch.findWord();
	
        
    }
   
     /***
     * printGrid:
     *   Print out the array of characters passed.
     *   Mostly for debugging purposes.
     ***/
    public static void printGrid() {
	for (int r = 0; r < numRows; r++) {
	    for (int c = 0; c < numCols; c++) {
		System.out.print(puzzle[r][c]);
		
	    }
	    System.out.println();
	}
	for (int i=0; i<wordAmount; i++){
	    System.out.println(words[i]);
	}
    }

    public int  moveX(int x, int dx){
	x = x + dx;

	if (x < 0){
	    x = numRows - 1;
	}

	if (x >= numRows){
	    x = 0;
	}
	return x;
    }

    public int  moveY(int y, int dy){
	y = y + dy;

	if (y < 0){
	    y = numCols - 1;
	}

	if (y >= numCols){
	    y = 0;
	}
	return y;
    }

    public boolean moveDirection(int x, int y, int k, String word, int dx, int dy){
	if(k == word.length()) return true;
	if(puzzle[x][y] == word.charAt(k)){
		return moveDirection(moveX(x, dx), moveY(y, dy), k+1, word, dx, dy);
	}
	else  return false;
    }

    public void findWord(){
	for(int i=0;i<wordAmount;i++){

	    String search = words[i];
	    // set up the boolean to determine if the word has been found or not
	    
	    identify = false;
	    for(int p=0; p<numRows; p++){

		for(int j=0; j<numCols; j++){
		    if(puzzle[p][j] == search.charAt(0)){

			if(moveDirection(p, j, 0, search, -1, -1) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
		        }

		        else if(moveDirection(p, j, 0, search, -1, 1) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}

		        else if(moveDirection(p, j, 0, search, 1, -1) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}

	                else if(moveDirection(p, j, 0, search, 1, 1) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}

	                else if(moveDirection(p, j, 0, search, 0, -1) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}

                        else if(moveDirection(p, j, 0, search, 0, 1) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}

                        else if(moveDirection(p, j, 0, search, -1, 0) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}

	                else if(moveDirection(p, j, 0, search, 1, 0) == true){
			    System.out.println("Found at " + p + " " + j);
			    identify = true;
			}
		        
	            }
	         }
	    }
	    if (identify == false){
		System.out.println("Item was not found");
	    }
	}

    }
   
}
