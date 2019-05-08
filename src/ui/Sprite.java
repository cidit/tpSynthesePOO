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

	private Dimension dimention;
	private Coordinate position;
	
	public Sprite(Entity e, BufferedImage img) {
		// TODO Auto-generated constructor stub
		this.img = img;
		dimention = new Dimension(img.getWidth(), img.getHeight());
		position = e.getPosition();
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(position.getX(), position.getY(), dimention.width, dimention.height);
	}
}
