package items;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Firerate extends Items {
	
	
	public Firerate(String name, int price) {
		super(name, price);
		icon = new ImageIcon("sprites/stat2.png");
		img = icon.getImage();
	
	}
	
	public Image getImage() {
		return img;
	}

}
