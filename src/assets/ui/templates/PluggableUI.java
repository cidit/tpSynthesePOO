package assets.ui.templates;

import assets.util.Dimention;

public abstract class PluggableUI {
	
	private Drawable canon;
	private Drawable invader;
	private Canvas canvas;
	
	private Dimention surface;

	public PluggableUI(Dimention surface) {
		this.surface = surface;
		canvas = canvas.init();
		
	}
	
}
