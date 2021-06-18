package items;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Damage extends Items {


	
	public Damage(String name, int price) {
		super(name, price);
		
		icon = new ImageIcon("sprites/dup.png");
		img = icon.getImage();
		
	
	}
	
	public Image getImage() {
		return img;
	}
}
