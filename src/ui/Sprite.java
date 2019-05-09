package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import assets.entities.Entity;
import assets.util.Coordinate;

public final class Sprite {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8219829209329828716L;
	
	private BufferedImage img;
	private Entity e;
	
	public Sprite(Entity e, BufferedImage img) {
		// TODO Auto-generated constructor stub
		this.img = img;
		this.e = e;
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public Entity getEntity() {
		return e;
	}
}
