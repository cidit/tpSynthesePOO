package assets.graphic;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Custom animations.
 * 
 * @author cidit
 *
 */
public class Animation {

	private List<Image> frames;
	private int index;

	/**
	 * custom frames manager
	 */
	public Animation() {
		frames = new ArrayList<Image>();
		index = 0;
	}
	
	/**
	 * creates a new animation from an already existing one
	 * @param composition
	 */
	public Animation(Animation composition) {
		frames = new ArrayList<Image>(composition.frames.size());
		Collections.copy(frames, composition.frames);
		index = 0;
	}

	/**
	 * changes the frame for the next image in the array
	 * 
	 * @return the next frame
	 */
	public Image getNextFrame() {
		if (index == frames.size())
			index = 0;
		return frames.get(index++);
	}

	public Image getFrame() {
		return frames.get(index);
	}

	/**
	 * adds an image to the array. only way to add frames
	 * 
	 * @param an image
	 */
	public void addFrame(Image texture) {
		frames.add(texture);
	}
}
