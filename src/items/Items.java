package items;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Items {

    protected int price;
    protected String name;
    protected ImageIcon icon;
    protected Image img;

    public Items(String name, int price) {
    	this.name = name;
    	this.price = price;
    	 
    }
    
    public int getPrice() {
    	return price;
    }   
    public String getName() {
    	return name;
    }
    
	public Image getImage() {
		return img;
	}
}
