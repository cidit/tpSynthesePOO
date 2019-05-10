package engine;

import assets.util.Dimension;

public enum DimensionProfiles {


	CANON(new Dimension(150, 150)),
	INVADER(new Dimension(100, 100)),
	MISSILE(new Dimension(16, 80));
	
	private Dimension dimension;

	private DimensionProfiles(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Dimension get() {
		return dimension;
	}

}
