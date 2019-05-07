package assets.entities;

import assets.util.Coordinates;

public interface Movable extends BorderReactable {

	public void move();
	
	//developer tool
	public void teleport(Coordinates newCoordonates);
	
}
