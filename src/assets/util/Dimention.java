package assets.util;

/**
 * made to not have any dependence to the swing package
 * 
 * @author cid
 *
 */
public class Dimention {

	private int width;
	private int height;

	public Dimention(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
