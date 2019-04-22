package assets.util;

public class EuclidianVector {

	private Coordinates initialPoint;
	private float xProjection, yProjection, zProjection;

	public EuclidianVector(Coordinates initialPoint, Coordinates terminalPoint) {
		this.initialPoint = initialPoint;
		setTerminalPoint(terminalPoint);
	}

	public EuclidianVector(float xProjection, float yProjection) {
		this.xProjection = xProjection;
		this.yProjection = yProjection;
		this.zProjection = 0;
	}

	public EuclidianVector(float xProjection, float yProjection, float zProjection) {
		this(xProjection, yProjection);
		this.zProjection = zProjection;
	}

	public EuclidianVector(String formatedProjections) {
		Coordinates coordinates = Coordinates.stringToCoordinates(formatedProjections);
		xProjection = coordinates.getX();
		yProjection = coordinates.getY();
		zProjection = coordinates.getZ();
	}

	public EuclidianVector(String formatedInitialPoint, String formatedTerminalPoint) {
		this(Coordinates.stringToCoordinates(formatedInitialPoint),
				Coordinates.stringToCoordinates(formatedTerminalPoint));
	}

	public void setInitialPoint(Coordinates initialPoint) {
		this.initialPoint = initialPoint;
	}

	public void moveInitialPoint(Coordinates initialPoint) {
		Coordinates tmpTerminal = getTerminalPoint();
		setInitialPoint(initialPoint);
		xProjection = initialPoint.getX() - tmpTerminal.getX();
		yProjection = initialPoint.getY() - tmpTerminal.getY();
		zProjection = initialPoint.getZ() - tmpTerminal.getZ();
	}

	public void setTerminalPoint(Coordinates terminalPoint) {
		if (initialPoint == null) {
			setInitialPoint(new Coordinates(terminalPoint.getX() - xProjection, terminalPoint.getY() - yProjection,
					terminalPoint.getZ() - zProjection));
		} else {
			xProjection = initialPoint.getX() - terminalPoint.getX();
			yProjection = initialPoint.getY() - terminalPoint.getY();
			zProjection = initialPoint.getZ() - terminalPoint.getZ();
		}

	}

	public Coordinates getInitialPoint() {
		return initialPoint;
	}

	public Coordinates getTerminalPoint() {
		return new Coordinates(initialPoint.getX() + xProjection, initialPoint.getY() + yProjection,
				initialPoint.getZ() + zProjection);
	}

	public float getXProjection() {
		return xProjection;
	}

	public float getYProjection() {
		return yProjection;
	}

	public float getZProjection() {
		return zProjection;
	}

	public float getXProjection(int precision) {
		return floatToPrecision(xProjection, precision);
	}

	public float getYProjection(int precision) {
		return floatToPrecision(yProjection, precision);
	}

	public float getZProjection(int precision) {
		return floatToPrecision(zProjection, precision);
	}

	public float getMagnitude() {
		float hypotenuse = (float) Math.hypot(xProjection, yProjection);
		float magnitude = (float) Math.hypot(hypotenuse, zProjection);
		return magnitude;
	}

	public float getMagnitude(int precision) {
		return floatToPrecision(getMagnitude(), precision);
	}

	public EuclidianVector opposite() {
		return new EuclidianVector(-xProjection, -yProjection, -zProjection);
	}

	public void add(EuclidianVector vector) {
		xProjection += vector.xProjection;
		yProjection += vector.yProjection;
		zProjection += vector.zProjection;
	}

	public void subtract(EuclidianVector vector) {
		xProjection -= vector.xProjection;
		yProjection -= vector.yProjection;
		zProjection -= vector.zProjection;
	}

	public void multiplyByScalar(float scalar) {
		xProjection = xProjection * scalar;
		yProjection = yProjection * scalar;
		zProjection = zProjection * scalar;
	}

	// might be flawed because of the precision of the operations on floating-point
	// numbers
	public static boolean isParallel(EuclidianVector a, EuclidianVector b) {
		if (!(a.xProjection / a.yProjection == b.xProjection / b.yProjection))
			return false;
		if (!(a.zProjection / a.yProjection == b.zProjection / b.yProjection))
			return false;
		if (!(a.xProjection / a.zProjection == b.xProjection / b.zProjection))
			return false;
		return true;
	}

	public static float scalarProduct(EuclidianVector a, EuclidianVector b) {
		return a.xProjection * b.xProjection + a.yProjection * b.yProjection + a.zProjection * b.zProjection;
	}

	public static float scalarProduct(EuclidianVector a, EuclidianVector b, int precision) {
		return floatToPrecision(scalarProduct(a, b), precision);
	}

	private static float floatToPrecision(float f, int precision) {
		int mult = (int) Math.pow(10, precision);
		float tmp = (int) f * mult;
		return tmp / mult;
	}

	@Override
	public String toString() {
		return "initial: " + initialPoint.toString() + " terminal: " + getTerminalPoint().toString() + " projections: "
				+ projectionsToString();
	}

	public String projectionsToString() {
		return xProjection + ";" + yProjection + ";" + zProjection;
	}

}
