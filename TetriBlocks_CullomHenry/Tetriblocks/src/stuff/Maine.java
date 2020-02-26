package stuff;

import java.util.*;
//import java.awt.Color;


public class Maine {
	
	public static void main(String[] args) {
		
		createWorld();

	}

	public static void createWorld() {
		
		Scanner con = new Scanner(System.in);
		System.out.print("Rows => ");
		int rows = Integer.parseInt(con.nextLine());
		System.out.print("Cols => ");
		int cols = Integer.parseInt(con.nextLine());
		
		GameWorld world = new GameWorld(rows, cols);
		
		String input = "";
		
		while(!input.equals("quit")) {
			
			input = con.nextLine();
			world.processCommand(input);
			
			
		}
		
		
	}
	
}
