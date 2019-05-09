package assets.util;

public class Hitbox {

	private Coordinate coordinate;
	private Dimension dimention;
	private Sides sides;

	/**
	 * 
	 * @param coordinate superior left corner
	 * @param dimention
	 */
	public Hitbox(Coordinate coordinate, Dimension dimention) {
		this.coordinate = coordinate;
		this.dimention = dimention;
		initSides();
	}
	
	private void initSides() {
		sides = new Sides();
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public Dimension getDimention() {
		return dimention;
	}
	
	public Sides getSides() {
		return sides;
	}
	
	public void moveTo(Coordinate coordinate) {
		this.coordinate = coordinate;
		initSides();
	}
	
	public void resize(Dimension dimention) {
		this.dimention = dimention;
		initSides();
	}
	
	public boolean intersects(Hitbox other) {
		final boolean ct, cr, cb, cl;
		final Sides os = other.sides;
		ct = sides.top >= os.top && sides.top <= os.bottom;
		cr = sides.right <= os.right && sides.right >= os.left;
		cb = sides.bottom >= os.top && sides.bottom <= os.bottom;
		cl = sides.left <= os.right && sides.left >= os.left;
		if (ct || cr || cb || cl)
			return true;
		return false;
	}
	
	public boolean contains(Hitbox other) {
		final boolean ct, cr, cb, cl;
		final Sides os = other.sides;
		ct = sides.top <= os.top;
		cr = sides.right >= os.right;
		cb = sides.bottom >= os.bottom;
		cl = sides.left <= os.left;
		if (ct && cr && cb && cl)
			return true;
		return false;
	}
	
	public class Sides {
		
		private int left;
		private int right;
		private int top;
		private int bottom;
		
		public Sides() {
			left = coordinate.getX();
			right = left + dimention.getWidth();
			top = coordinate.getY();
			bottom = top + dimention.getHeight();
		}
		
		public int getLeft() {
			return left;
		}
		
		public int getRight() {
			return right;
		}
		
		public int getTop() {
			return top;
		}
		
		public int getBottom() {
			return bottom;
		}
	}
}
