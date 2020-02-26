package stuff;

import java.awt.Color;

public class SkyBlock implements Block {

	private Color color;
	
	public SkyBlock() {
		this.color = color.CYAN;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean isSolid() {
		return false;
	}

}
