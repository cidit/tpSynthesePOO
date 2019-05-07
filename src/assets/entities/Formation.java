package assets.entities;

import java.util.ArrayList;
import java.util.List;

import assets.entities.enumerations.Direction;
import assets.entities.interfaces.BorderReactable;
import assets.util.Coordinates;
import assets.util.Dimention;

public final class Formation implements BorderReactable {

	private int rows;
	private int columns;
	private List<Invader> units;
	private Direction direction;

	public Formation(Dimention dimention) {
		columns = dimention.getWidth();
		rows = dimention.getHeight();
		direction = Direction.RIGHT;
		units = new ArrayList<Invader>(columns);
		fill();
	}

	private void fill() {
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= columns; c++) {
				units.add(new Invader(new Coordinates(r, c)));
			}
		}
	}

	public void setUnitSpacing(Dimention spriteDimentions) {
		for (Invader invader : units) {
			Coordinates indexInArray = invader.getPosition();
			int xIndex = indexInArray.getX(), yIndex = indexInArray.getY();
			invader.teleport(new Coordinates(xIndex * spriteDimentions.getWidth(), yIndex * spriteDimentions.getHeight()));
		}
	}

	public List<Invader> getUnits() {
		return units;
	}

	@Override
	public void borderReaction(Dimention game) {
		for (Invader invader : units) {
			int x = invader.getPosition().getX();

			// TODO reverify dryness with teach
			if (direction == Direction.DOWN) {
				if (x >= game.getWidth())
					direction = Direction.LEFT;
				if (x <= 0)
					direction = Direction.RIGHT;
				updateUnitDirections();
				break;
			} else if (x >= game.getWidth() || x <= 0) {
				direction = Direction.DOWN;
				updateUnitDirections();
				break;
			}
		}
	}

	private void updateUnitDirections() {
		for (Invader invader : units) {
			invader.setDirection(direction);
		}
	}
}
