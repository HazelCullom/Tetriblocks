package stuff;

import java.awt.Color;

public class DudeBlock implements Block {
	
	private Color color;
	
	public DudeBlock() {
		this.color = Color.RED;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
