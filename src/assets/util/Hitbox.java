package assets.util;

/**
 * MAY BE OBSOLETE WILL HAVE TO CHECK LATER
 * @author cid
 *
 */
public class Hitbox {
	
	private Coordinate center;
	private Dimention dimention;
	private Coordinate cornerSR;
	private Coordinate cornerSL;
	private Coordinate cornerIR;
	private Coordinate cornerIL;
	
	public Hitbox(Coordinate center, Dimention dimention) {
		this.center = center;
		this.dimention = dimention;
	}
	
}
