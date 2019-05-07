package assets.entities;

import java.util.ArrayList;
import java.util.List;

import assets.util.Coordinates;

public final class Formation implements BorderReactable {

	private int rows;
	private int columns;
	private List<Invader> units;
	private Direction direction;

	public Formation(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
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

	public void setUnitSpacing(int unitWidth, int unitHeight) {
		for (Invader invader : units) {
			Coordinates indexInArray = invader.getPosition();
			float xIndex = indexInArray.getX(), yIndex = indexInArray.getY();
			invader.teleport(new Coordinates(xIndex * unitWidth, yIndex * unitHeight));
		}
	}

	public List<Invader> getUnits() {
		return units;
	}

	@Override
	public void borderReaction(int width, int height) {
		for (Invader invader : units) {
			float x = invader.getPosition().getX();
			
			// TODO reverify dryness with teach 
			if (direction == Direction.DOWN) {
				if (x >= width)
					direction = Direction.LEFT;
				if (x <= 0)
					direction = Direction.RIGHT;
				updateUnitDirections();
				break;
			} else if (x >= width || x <= 0) {
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
