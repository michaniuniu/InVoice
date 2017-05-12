import java.lang.String; 

public class InVoice {
	 int ID;
	 String description;
	 double price;
	 int amount;
	
	public InVoice(int ID, String description, int amount, double price){
		this.ID = ID;
		this.amount = amount;
		this.description = description;
		this.price = price;
	}
	
	void setID(int x){
		ID = x;
	}
	
	void setDescription(String name){
		description = name;
	}
	
	void setAmount(int y){
		amount = y;
	}
	
	void setPrice(double z){
		price = z;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getInVoiceAmount(int amount, double price){
		return (double)amount * price;
	}
	
}