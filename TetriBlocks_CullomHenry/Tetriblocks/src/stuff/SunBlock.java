package stuff;

import java.awt.Color;

public class SunBlock implements Block {

	private Color color;
	
	public SunBlock() {
		this.color = color.YELLOW;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	
}
