package assets.entities.interfaces;

import assets.util.Dimention;

public interface BorderReactable {

	/**
	 * must enter coordinate limits!!
	 * @param screen width - sprite width
	 * @param screen height - sprite height
	 */
	public void borderReaction(Dimention game);
	
}
