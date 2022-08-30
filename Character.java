package pokemon;
import java.util.*;

public class Character implements Comparable<Character>{
	
	private int hp; //hp points of the pokemon
	private int is_legendary; //1 if the pokemon is legendary, 0 otherwise
	private String name; //name of the pokemon 
	
	//splits a dataLine of the Pokemon character's info and
	//extracts its name, HP, and legendary status 
	public Character (String dataLine)
	{
		String[] dataList = dataLine.split(",");
		is_legendary = Integer.parseInt(dataList[dataList.length-1]);
		name = dataList[dataList.length-11];
		hp = Integer.parseInt(dataList[dataList.length-13]);
	}
	
	
	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getIs_legendary() {
		return is_legendary;
	}


	public void setIs_legendary(int is_legendary) {
		this.is_legendary = is_legendary;
	}
	
	public String isLegendary()
	{
		if (getIs_legendary() == 0)
		{
			return "not legendary";
		}
		return "legendary";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo (Character that)
	{
		if (this.name.compareTo(that.name) != 0)
		{
			return this.name.compareTo(that.name);
		}
		return this.hp - that.hp;
	}
	
	public boolean equals(Object o)
	{
		Character that = (Character)o;
		return this.compareTo(that) == 0 && this.is_legendary == that.is_legendary;
	}

	public int hashCode()
	{
		return hp + name.length() + is_legendary;
	}
	
	public static void main (String[] args)
	{
		Character c = new Character("\"['Overgrow', 'Chlorophyll']\",1,1,1,0.5,"
				+ "0.5,0.5,2,2,1,0.25,1,2,1,1,2,1,1,0.5,49,5120,70,318,45,"
				+ "Seed PokÃ©mon,49,1059860,0.7,45,Fushigidaneãƒ•ã‚·ã‚®ãƒ€ãƒ,"
				+ "Bulbasaur,88.1,1,65,65,45,grass,poison,6.9,1,0");
		System.out.println(c.name);
		System.out.println(c.hp);
		System.out.println(c.isLegendary());
		
	}
		
}
