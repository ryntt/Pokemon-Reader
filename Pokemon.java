package pokemon;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Pokemon{
	
	private HashSet<Character> baseSet;
	
	public Pokemon(HashSet<Character> set)
	{
		baseSet = set;
	}

	//returns a list of all pokemon with HP points
	//lower than the maxHP
	public HashSet<Character> getHitPointList(int maxHP, HashSet<Character> baseSet)
	{
		HashSet<Character> pokemonInHpRange = new HashSet<Character>();
		for (Character c : baseSet)
		{
			if (c.getHp() >= 0 && c.getHp() <= maxHP)
			{
				pokemonInHpRange.add(c);
			}
		}
		return pokemonInHpRange;
	}
	
	//returns the number of legendary pokemon 
	public int getIsLegendaryCount(HashSet<Character> baseSet)
	{
		int legendaries = 0;
		for (Character c : baseSet)
		{
			if (c.getIs_legendary() == 1)
			{
				legendaries++;
			}
		}
		return legendaries;
	}
	
	//returns a treeset of pokemon with names starting with firstLetter
	public TreeSet<Character> getCharacterByFirstLetter (char firstLetter, HashSet<Character> baseSet)
	{
		TreeSet<Character> pokemonStartingWithFirstletter = new TreeSet<Character>();
		for (Character c : baseSet)
		{
			if (c.getName().toUpperCase().charAt(0) == firstLetter
					|| c.getName().toLowerCase().charAt(0) == firstLetter)
			{
				pokemonStartingWithFirstletter.add(c);
			}
		}
		return pokemonStartingWithFirstletter;
	}
		
	public static void main(String[] args) throws IOException {
	
		File pokeFile = new File ("src/data/pokemon.csv");
		CsvReader pokeReader = new CsvReader (pokeFile);
		boolean readFile = pokeReader.readFile(pokeFile);
		HashSet<Character> pokemonList = pokeReader.getCharacterSet();
		
		Pokemon testList = new Pokemon (pokemonList);
		HashSet<Character> hpList = testList.getHitPointList(45, pokemonList);
		for (Character p : hpList)
		{
			System.out.println("Name: " + p.getName());
			System.out.println("HP: " + p.getHp());
			System.out.println(p.isLegendary() + "\n");
		}
		System.out.println("--------------------");
		System.out.println("There are " + testList.getIsLegendaryCount(pokemonList) + " "
				+ "legendary pokemon in the entire list.");
		System.out.println("--------------------");
		TreeSet<Character> pokemonStartingWithA = testList.getCharacterByFirstLetter('c', pokemonList);
		for (Character p : pokemonStartingWithA)
		{
			System.out.println("Name: " + p.getName());
			System.out.println("HP: " + p.getHp());
			System.out.println(p.isLegendary() + "\n");
		}
	
	}

}
