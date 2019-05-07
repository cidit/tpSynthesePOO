package assets.entities.interfaces;

import assets.util.Coordinates;

public interface Movable extends BorderReactable {

	public void move();
	
	//developer tool
	public void teleport(Coordinates newCoordonates);
	
}
