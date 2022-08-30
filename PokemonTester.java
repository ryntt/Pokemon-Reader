package pokemon;
import java.io.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.util.HashSet;
import java.util.TreeSet;

// each of the three methods in Pokemon has a positive and negative test here
// i got a "true" output in the runner by commenting the negative tests
// i got a "false" output with three errors by not commenting the negative tests
public class PokemonTester {
	File pokeFile = new File ("src/data/pokemon.csv");
	CsvReader pokeReader = new CsvReader (pokeFile);
	{
		try
		{
			boolean readFile = pokeReader.readFile(pokeFile);
		}
		catch (IOException x)
		{
			System.out.println("Error: " + x.getMessage());
		}
	}	
	HashSet<Character> list = pokeReader.getCharacterSet();
	Pokemon pokeList = new Pokemon (list);
	HashSet<Character> hpList = pokeList.getHitPointList(50, list);
	int legendaryCount = pokeList.getIsLegendaryCount(list);
	TreeSet<Character> nameList = pokeList.getCharacterByFirstLetter('A', list);
	
	@Test
	public void positiveTestHPList()
	{
		boolean allGood = true;
		for (Character c : hpList)
		{
			if (c.getHp() < 0 || c.getHp() > 50)
			{
				allGood = false;
				break;
			}
		}
		assertTrue(allGood);
	}
	
	
	@Test
	public void negativeTestHPList()
	{
		hpList.add(new Character("['Guts', 'Scrappy'],0.5,1,1,2,1,1,1,1,0,0.5,0,2,1"
				+ ",1,1,2,1,1,85,3840,70,455,45,Swallow PokÃ©mon,60,1059860,0.7,"
				+ "60,Ohsubameã‚ªã‚ªã‚¹ãƒãƒ¡,Swellow,"
				+ "50,277,75,50,125,normal,flying,19.8,3,0"));
		boolean allGood = true;
		for (Character c : hpList)
		{
			if (c.getHp() < 0 || c.getHp() > 50)
			{
				allGood = false;
				break;
			}
		}
		assertTrue(allGood);
	}
	
	
	@Test
	public void positiveTestLegendaryCount()
	{
		assertEquals(legendaryCount, 70);
	}
	
	
	@Test
	public void negativeTestLegendaryCount()
	{
		assertEquals(legendaryCount, 71);
	}
	
	
	@Test
	public void positiveTestLetterList()
	{
		boolean allGood = true;
		for (Character c : nameList)
		{
			if (c.getName().toUpperCase().charAt(0) != 'A')
			{
				allGood = false;
				break;
			}
		}
		assertTrue(allGood);
	}
	
	
	@Test
	public void negativeTestLetterList()
	{
		nameList.add(new Character ("\"['Overgrow', 'Chlorophyll']\",1,1,1,0.5,0.5"
				+ ",0.5,2,2,1,0.25,1,2,1,1,2,1,1,0.5,49,5120,70,318,45,"
				+ "Seed PokÃ©mon,49,1059860,0.7,45,Fushigidaneãƒ•ã‚·ã‚®ãƒ€ãƒ,"
				+ "Bulbasaur,88.1,1,65,65,45,grass,poison,6.9,1,0"));
		boolean allGood = true;
		for (Character c : nameList)
		{
			if (c.getName().toUpperCase().charAt(0) != 'A')
			{
				allGood = false;
				break;
			}
		}
		assertTrue(allGood);
	}
	
}
