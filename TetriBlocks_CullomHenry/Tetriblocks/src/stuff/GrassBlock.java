package stuff;

import java.awt.Color;

public class GrassBlock implements Block {

	private Color color;
	
	public GrassBlock() {
		this.color = color.GREEN;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean isSolid() {
		return true;
	}

}
