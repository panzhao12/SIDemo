package items;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Health extends Items {

	public Health(String name, int price) {
		super(name, price);
		icon = new ImageIcon("sprites/stat3.png");
		img = icon.getImage();

	}

	public Image getImage() {
		return img;
	}

}
