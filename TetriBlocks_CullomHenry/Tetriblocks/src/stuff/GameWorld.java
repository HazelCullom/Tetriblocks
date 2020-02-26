package stuff;

import java.awt.Color;

public class GameWorld {

	private int rows;
	private int cols;
	private int groundLevel;
	private Block[][] grid;
	
	public GameWorld(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.groundLevel = 2;
		this.grid = new Block[this.rows][this.cols];
		
		core.CustomAppearance ca = new core.CustomAppearance(this.rows, this.cols);
		ca.setBorderColor(Color.WHITE);
		//ca.setBorderThicknessX(0);
		//ca.setBorderThicknessY(0);
		ca.setCellColor(Color.BLACK);
		core.API.initialize(ca);
		
		init();
		draw();
	}
	
	public void setGroundLevel(int groundLevel) {
		this.groundLevel = groundLevel;
		for (int r = this.grid.length - this.groundLevel; r < this.grid.length; r++) {
			for (int c = 0; c < this.grid[0].length; c++) {
				this.grid[r][c] = new GrassBlock();
			}
		}
	}
	
	private void init() {
		// sky
		for (int r = 0; r < this.grid.length - 2; r++) {
			for (int c = 0; c < this.grid[0].length; c++) {
				this.grid[r][c] = new SkyBlock();
			}
		}
		// grass
		for (int r = this.grid.length - this.groundLevel; r < this.grid.length; r++) {
			for (int c = 0; c < this.grid[0].length; c++) {
				this.grid[r][c] = new GrassBlock();
			}
		}
	}
	
	private void draw() {
		for (int r = 0; r < this.grid.length; r++) {
			for (int c = 0; c < this.grid[0].length; c++) {
				core.API.paintSolidColor(r, c, this.grid[r][c].getColor());
			}
		}
	}
	
	public void setBlock(int r, int c, Block b) {
		this.grid[r][c] = b;
		draw();
	}
	
	public Block getBlock(int r, int c)
	{
		return this.grid[r][c];
	}
	
	public void processCommand(String input) {
		String[] com = input.split(" ");
		
		if (com[0].equals("set")) {
			setBlock(Integer.parseInt(com[1]), Integer.parseInt(com[2]), toBlock(com[3]));
		} else if (com[0].equals("wait")) {
			passTime(Integer.parseInt(com[1]));
		}
	}
	
	private Block toBlock(String str) {
		
		if (str.equals("sun")) {
			return new SunBlock();
		} else if (str.equals("grass")) {
			return new GrassBlock();
		} else if (str.equals("sky")) {
			return new SkyBlock();
		}
		return null;
	}
	
	
	public void passTime(int hours) {
		
		for (int s = 1; s <= hours; s++) {
			
			for (int r = 0; r < this.rows; r++) {
				for (int c = 0; c < this.cols; c++) {
					
					// checks if block is sun, if so, moves it to the left
					if (this.grid[r][c].getColor().equals(Color.YELLOW)) {
						
						if (c == 0) {
							Block temp = this.grid[r][c];
							this.grid[r][c] = this.grid[r][this.cols-1];
							this.grid[r][this.cols-1] = temp;
						} else {
							Block temp = this.grid[r][c];
							this.grid[r][c] = this.grid[r][c - 1];
							this.grid[r][c - 1] = temp;
						}
					}
					
					
				}
			}
			draw();
			core.API.pause(800);
		}
	}
	
}
