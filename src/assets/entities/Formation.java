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
	}
	
	private static class Column extends ArrayList<Invader> {
		
	}

}


/*
 * 
 * invader coordinate = index in formation * sprite size + offset
 * 
 */