package assets.entities;

import java.util.ArrayList;
import java.util.List;

import assets.entities.enumerations.Direction;
import assets.entities.interfaces.BorderReactable;
import assets.util.Coordinate;
import assets.util.Dimention;
import assets.util.DimentionProfiles;
import assets.util.Hitbox;

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
		updateUnitDirections();
	}

	private void fill() {
		Dimention dimention = DimentionProfiles.getInvader();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				units.add(new Invader(new Coordinate(c * dimention.getWidth(), r * dimention.getHeight())));
			}
		}
	}

	public List<Invader> getUnits() {
		return units;
	}

	@Override
	public void rectify(Hitbox game) {
		for (Invader invader : units) {
			Hitbox hitbox = invader.getHitbox();
			if (direction == Direction.DOWN) {
				if (hitbox.getSides().getRight() >= game.getSides().getRight())
					direction = Direction.LEFT;
				if (hitbox.getSides().getLeft() <= game.getSides().getLeft())
					direction = Direction.RIGHT;
				updateUnitDirections();
				break;
			} else if (hitbox.getSides().getRight() >= game.getSides().getRight()
					|| hitbox.getSides().getLeft() <= game.getSides().getLeft()) {
				direction = Direction.DOWN;
				updateUnitDirections();
				break;
			}
		}
	}

	private void updateUnitDirections() {
		for (Invader invader : units) {
			invader.changeDirection(direction);
		}
	}
}
