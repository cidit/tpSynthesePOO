package assets.entities.interfaces;

import assets.util.Coordinate;

public interface Movable extends BorderReactable {

	public void move();
	
	public void teleport(Coordinate newCoordonates);
	
}
