package assets.util;

public class Hitbox {

	private Coordinate coordinate;
	private Dimention dimention;

	private int left;
	private int right;
	private int top;
	private int bottom;

	private Coordinate superiorLeft;
	private Coordinate superiorRight;
	private Coordinate inferiorLeft;
	private Coordinate inferiorRight;

	/**
	 * 
	 * @param coordinate superior left corner
	 * @param dimention
	 */
	public Hitbox(Coordinate coordinate, Dimention dimention) {
		this.coordinate = coordinate;
		this.dimention = dimention;
		initSides();
		initCorners();
	}

	private void initSides() {
		left = coordinate.getX();
		right = left + dimention.getWidth();
		top = coordinate.getY();
		bottom = top + dimention.getHeight();
	}

	private void initCorners() {
		superiorLeft = new Coordinate(left, top);
		superiorRight = new Coordinate(right, top);
		inferiorLeft = new Coordinate(left, bottom);
		inferiorRight = new Coordinate(right, bottom);
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public Dimention getDimention() {
		return dimention;
	}
	
	public static boolean intersect(Hitbox hitbox1, Hitbox hitbox2) {
		// TODO
		
		return false;
	}
}
