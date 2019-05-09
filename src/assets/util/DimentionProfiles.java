package assets.util;

public class DimentionProfiles {

	private static Dimention canonDimention;
	private static Dimention invaderDimention;
	private static Dimention missileDimention;
	private static boolean initialised = false;

	public static void setProfiles(Dimention canon, Dimention invader, Dimention missile) {
		canonDimention = canon;
		invaderDimention = invader;
		missileDimention = missile;
		initialised = true;
	}
	
	public static Dimention getCanon() {
		if (!initialised) {
			System.out.println("DIMENTION PROFILES UNINITIALISED");
			return null;
		}
		return canonDimention;
	}

	public static Dimention getInvader() {
		if (!initialised) {
			System.out.println("DIMENTION PROFILES UNINITIALISED");
			return null;
		}
		return invaderDimention;
	}

	public static Dimention getMissile() {
		if (!initialised) {
			System.out.println("DIMENTION PROFILES UNINITIALISED");
			return null;
		}
		return missileDimention;
	}
	
	public static boolean isInitialised() {
		return initialised;
	}

}
