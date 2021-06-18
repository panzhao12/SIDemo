package items;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Health extends Items {
	
	

	

	public Health(String name, int price) {
		super(name, price);
		icon = new ImageIcon("sprites/hup.png");
		img = icon.getImage();

	
	}
	public Image getImage() {
		return img;
	}

}
