package items;

abstract class Items {

    protected int price;
    protected String name;

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
}
