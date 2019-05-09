package assets.util;

public class DimentionProfiles {

//	private static Dimension canonDimention;
//	private static Dimension invaderDimention;
//	private static Dimension missileDimention;
//	private static boolean initialised = false;
	private static Dimension canonDimention = new assets.util.Dimension(150, 150);
	private static Dimension invaderDimention = new assets.util.Dimension(100, 100);
	private static Dimension missileDimention = new assets.util.Dimension(16, 80);

	public static void setProfiles(Dimension canon, Dimension invader, Dimension missile) {
		System.out.println("initializing profiles");
		canonDimention = canon;
		invaderDimention = invader;
		missileDimention = missile;
//		initialised = true;
	}
	
	public static Dimension getCanon() {
//		if (!initialised) {
//			System.out.println("DIMENTION PROFILES UNINITIALISED");
//			return null;
//		}
		return canonDimention;
	}

	public static Dimension getInvader() {
//		if (!initialised) {
//			System.out.println("DIMENTION PROFILES UNINITIALISED");
//			return null;
//		}
		return invaderDimention;
	}

	public static Dimension getMissile() {
//		if (!initialised) {
//			System.out.println("DIMENTION PROFILES UNINITIALISED");
//			return null;
//		}
		return missileDimention;
	}
	
//	public static boolean isInitialised() {
//		return initialised;
//	}

}
