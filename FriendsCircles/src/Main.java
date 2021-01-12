import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Class:     	FriendsCircle
// Developer: 	Chase Dickerson
// Date: 	  	4/1/2019

public class Main {
	
	static int row = 0;
	static int col = 0;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Please provide a filename containing a friends matrix:");
        String fileName = scanner.nextLine();
        File inputFile = new File(fileName);
        
        /* 
         * Sloppy way to initialize the 2D array but I wanted to spend more time on the actual problem
         */
		if(fileName.equals("test1_4_random.txt")) {
			row = 4;
			col = 4;
		} else if(fileName.equals("test2_5_none.txt")) {
			row = 5;
			col = 5;
		} else if(fileName.equals("test3_8_random.txt")){
			row = 8;
			col = 8;
		}else if(fileName.equals("test4_32_all.txt")){
			row = 32;
			col = 32;
		}else if(fileName.equals("test5_64_random.txt")){
			row = 64;
			col = 64;
		}
		char[] reader = new char[row * col];
		char[][] graph = new char[row][col];
        
		//Reading files into to 2D array
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            int letter;
            int i = 0;
            while ((letter = br.read()) != -1) {
            	char character = (char) letter;
            	if(character == '\n') {
            		continue;
            	}else {
            	    reader[i] = character;
            	    i++;
            	}
            }
		}
        
        int num = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
            	graph[i][j] = reader[num];
            	num++;
            }
        }
        
       friendsInCircle(graph);
       
       System.out.println("Number of friend circles: " + count);
	}

	private static void friendsInCircle(char[][] graph) {
		
		// Creating a boolean array to represent the vertexes visited
		boolean[] visited = new boolean[graph.length];
		
		// Setting all "vertex visisted" to false
        for(int i = 0; i < visited.length; i++) {
        	visited[i] = false;
        }
        for (int s = 0; s < graph.length; s++) {
        	if(visited[s] == false) {
        		count++;
        		DFS(graph, visited, s);
        	}
        }		
	}
	
	// Depth first search used to find the friend circles
	public static void DFS(char[][] graph, boolean[] visited, int s) {
		
		visited[s] = true;
		for(int j = 0; j < graph.length; j++) {
			if(visited[j] == false && graph[s][j] == 'Y') {
				visited[j] = true;
			    DFS(graph, visited, j);
			}
		}
    }
}
