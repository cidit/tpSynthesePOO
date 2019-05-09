package assets.util;

public class DimentionProfiles {

	private static Dimention canonDimention;
	private static Dimention invaderDimention;
	private static Dimention missileDimention;

	public static void setProfiles(Dimention canon, Dimention invader, Dimention missile) {
		canonDimention = canon;
		invaderDimention = invader;
		missileDimention = missile;
	}
	
	public static Dimention getCanon() {
		return canonDimention;
	}

	public static Dimention getInvader() {
		return invaderDimention;
	}

	public static Dimention getMissile() {
		return missileDimention;
	}
	

}
