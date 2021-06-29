package items;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Items {

    protected int price;
    protected int lvl = 0;
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
	
	public int getLevel() {
		return lvl;
		
	}
	
	public void setLevel() {
		++lvl;
	}
}

