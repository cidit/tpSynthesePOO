package assets.entities;

public interface Movable {

	public void move();
	
	/**
	 * must enter coordinate limits!!
	 * @param screen width - sprite width
	 * @param screen height - sprite height
	 */
	public void borderReaction(int width, int height);
}
