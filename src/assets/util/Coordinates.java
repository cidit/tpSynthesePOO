package assets.util;

public class Coordinates {

	private float x, y, z;

	public Coordinates(float x, float y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public Coordinates(float x, float y, float z) {
		this(x, y);
		this.z = z;
	}

	public Coordinates(String formatedCoordinates) {
		Coordinates coordinates = stringToCoordinates(formatedCoordinates);
		x = coordinates.x;
		y = coordinates.y;
		z = coordinates.z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getX(int precision) {
		return floatToPrecision(x, precision);
	}

	public float getY(int precision) {
		return floatToPrecision(y, precision);
	}

	public float getZ(int precision) {
		return floatToPrecision(z, precision);
	}

	public Coordinates getReflexionFromOrigin() {
		return new Coordinates(-x, -y, -z);
	}

	public static Coordinates getReflexionFromOrigin(Coordinates coordinates) {
		return new Coordinates(-coordinates.x, -coordinates.y, -coordinates.z);
	}
	
	public static Coordinates stringToCoordinates(String formatedCoordinates) {
		char delimiter = ';';
		int amountOfDelimiters = countCharInString(delimiter, formatedCoordinates);
		float x, y = 0, z = 0;
		if (amountOfDelimiters == 0)
			throw new IllegalArgumentException(formatedCoordinates);
		else if (amountOfDelimiters > 2)
			throw new IllegalArgumentException(formatedCoordinates);
		x = Float.parseFloat(formatedCoordinates.substring(0, formatedCoordinates.indexOf(delimiter)));
		if (amountOfDelimiters == 1)
			y = Float.parseFloat(formatedCoordinates.substring(formatedCoordinates.indexOf(delimiter) + 1));
		else if (amountOfDelimiters == 2) {
			y = Float.parseFloat(formatedCoordinates.substring(formatedCoordinates.indexOf(delimiter) + 1,
					formatedCoordinates.lastIndexOf(delimiter)));
			z = Float.parseFloat(formatedCoordinates.substring(formatedCoordinates.lastIndexOf(delimiter)));
		}
		return new Coordinates(x, y, z);
	}
	
	private static float floatToPrecision(float f, int precision) {
		int mult = (int) Math.pow(10, precision);
		float tmp = (int) f * mult;
		return tmp / mult;
	}

	private static int countCharInString(char c, String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == c)
				counter++;
		return counter;
	}

	@Override
	public String toString() {
		return x + ";" + y + ";" + z;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordinates))
			return false;
		Coordinates other = (Coordinates) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}

}
