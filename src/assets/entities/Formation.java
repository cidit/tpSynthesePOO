package assets.entities;

import java.util.ArrayList;
import java.util.List;

public final class Formation{

	private final int rows;
	private int columns;
	private List<Column> array;

	public Formation(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		array = new ArrayList<Column>(columns);
		fill();
	}
	
	private void fill() {
		for (int i = 0; i < columns; i++) {
			Column c = new Column(rows);
		}
	}

	private static class Column extends ArrayList<Invader> {
		
		public Column(int capacity) {
			super(capacity);
		}
		
		public Invader last() {
			return get(size()-1);
		}
		
	}

}


/*
 * 
 * invader coordinate = index in formation * sprite size + offset
 * 
 */