package assets.util;

public enum DimentionProfiles {


	CANON(new Dimension(150, 150)),
	INVADER(new Dimension(100, 100)),
	MISSILE(new Dimension(16, 80));
	
	private Dimension dimension;

	private DimentionProfiles(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Dimension get() {
		return dimension;
	}

}
