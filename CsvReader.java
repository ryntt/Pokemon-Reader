package pokemon;
import java.util.*;

import pokemon.Character;

import java.io.*;
import java.nio.file.Files;

public class CsvReader {

	private File csvFile; //the file to read through
	private HashSet<Character> list; //the list to add Pokemon to
	
	public CsvReader(File csv)
	{
		csvFile = csv;
		list = new HashSet<Character>();
	}
	
	/*
	 * reads the whole file and adds each Pokemon described 
	 * in the file to a HashSet
	 */
	public boolean readFile(File fileName) throws IOException
	{
		if (!fileName.exists())
		{
			return false;
		}
		else
		{
			FileReader fileRead = new FileReader(fileName);
			BufferedReader bfr = new BufferedReader (fileRead);
			String categories = bfr.readLine();
			boolean done = false;
			while (!done)
			{
				try
				{
					String pokeLine = bfr.readLine();
					if (pokeLine == null)
					{
						done = true;
					}
					else
					{
						Character c = new Character(pokeLine);
						list.add(c);
					}
				}
				catch (IOException x)
				{
					System.out.println("Error: " + x.getMessage());
				}
			}
			bfr.close();
			fileRead.close();
			return true;
		}
		
	}
	
	//returns the set of Pokemon characters
	public HashSet<Character> getCharacterSet()
	{
		return list;
	}
	
	public static void main (String[] args) throws IOException
	{
		File pokeFile = new File ("src/data/pokemon.csv");
		CsvReader pokeReader = new CsvReader (pokeFile);
		boolean readFile = pokeReader.readFile(pokeFile);
		HashSet<Character> pokemonList = pokeReader.getCharacterSet();
		
		for (Character c : pokemonList)
		{
			System.out.println("Name: " + c.getName());
			System.out.println("HP: " + c.getHp());
			System.out.println(c.isLegendary() + "\n");
		}
	}
	
}
