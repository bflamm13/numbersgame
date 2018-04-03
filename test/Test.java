package com.bf.unittest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.bf.games.Game;
import com.bf.games.GameFactory;
import com.bf.games.GameInfo;
import com.bf.games.LotteryGame;
import com.bf.games.GameFactory.GameType;
import com.bf.generator.AbstractGenerator;
import com.bf.generator.DefaultGenerator;

public class Test
{
	@Rule public TestName name = new TestName();
	
	@Before
	public void Before()
	{
		System.out.println("");
		System.out.println("#######" + name.getMethodName() + "#######");
	}
	
	@org.junit.Test
	public void testGame()
	{
		String type = "LUCKYFORLIFE";
		String name = "LFL";
		GameType typeE = GameType.MEGABUCKS;
		int maxNums = 10;
		int picks = 4;
		int maxBonusNums = 5;
		int bonusPicks = 2;
		String description = "game description";

		Game g = new Game();
		g.setType(type);
		g.setName(name);
		g.setPicks(picks);
		g.setBonusPicks(bonusPicks);
		g.setMaxNums(maxNums);
		g.setMaxBonusNums(maxBonusNums);
		g.setDescription(description);
		
		assertEquals(g.getType(), GameType.LUCKYFORLIFE);
		assertEquals(g.getName(), name);
		assertEquals(g.getPicks(), picks);
		assertEquals(g.getBonusPicks(), bonusPicks);
		assertEquals(g.getMaxNums(), maxNums);
		assertEquals(g.getMaxBonusNums(), maxBonusNums);
		assertEquals(g.getDescription(), description);

		g.setType(typeE);
		assertEquals(g.getType(), typeE);

	}
	
	@org.junit.Test
	public void testGenerator()
	{
		int max = 48;
		int picks = 5;
		AbstractGenerator g = new DefaultGenerator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				assertTrue("Error, random("+max+") is too high", max >= num);
				assertTrue("Error, random("+max+") is too low",  1  <= num);
				System.out.println("num: " + num);
			}
			
		} 
		catch (Exception e)
		{
			fail("Exception Occurred:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void testGeneratorSingle()
	{
		int max = 18;
		int picks = 1;
		AbstractGenerator g = new DefaultGenerator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				assertTrue("Error, random("+max+") is too high", max >= num);
				assertTrue("Error, random("+max+") is too low",  1  <= num);
				System.out.println("num: " + num);
			}
			
		} 
		catch (Exception e)
		{
			fail("Exception Occurred:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void testGeneratorPickEQMax()
	{
		int max = 10;
		int picks = 10;
		AbstractGenerator g = new DefaultGenerator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				assertTrue("Error, random("+max+") is too high", max >= num);
				assertTrue("Error, random("+max+") is too low",  1  <= num);
				System.out.println("num: " + num);
			}
			
		} 
		catch (Exception e)
		{
			fail("Exception Occurred:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testGeneratorPickGreaterMax()
	{
		int max = 10;
		int picks = 11;
		AbstractGenerator g = new DefaultGenerator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				System.out.println("num: " + num);
			}
			fail("Exception Did Not Occurred: The picks for (11) are greater than numbers available(10)");
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@org.junit.Test
	public void testLuckForLife()
	{
		Game g = new Game();
		g.setDescription("TEST");
		g.setBonusPicks(1);
		g.setMaxNums(100);
		g.setMaxBonusNums(26);
		g.setPicks(6);
		
		LotteryGame ll = new LotteryGame(g);
		try
		{
			GameInfo p = ll.getNumbers();
			assertEquals(6, p.getMainNums().size());
			for (Integer num : p.getMainNums())
			{
				assertTrue("Error, random(100) is too high", 100 >= num);
				assertTrue("Error, random(100) is too low",  1  <= num);
				System.out.println("num: " + num);
			}
			assertEquals(1, p.getBonusNums().size());
			assertTrue("Error, random(26) is too high", 26 >= p.getBonusNums().get(0));
			assertTrue("Error, random(26) is too low",  1  <= p.getBonusNums().get(0));
			System.out.println("bonus: " + p.getBonusNums());
		} 
		catch (Exception e)
		{
			fail("Exception Occurred:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testLuckForLifeDisplay()
	{
		Game g = new Game();
		g.setDescription("TEST");
		g.setBonusPicks(1);
		g.setMaxNums(100);
		g.setMaxBonusNums(26);
		g.setPicks(6);
		LotteryGame ll = new LotteryGame(g);
		ll.display();
	}
	
	@org.junit.Test
	public void testType()
	{
		String type = "POWERBALL";
		GameFactory.GameType t = GameFactory.GameType.convert(type);
		
		assertEquals(GameFactory.GameType.POWERBALL, t);
		System.out.println("TYPE: " + ((t == null) ? "INVALID": t));
		type = "BAD";
		t = GameFactory.GameType.convert(type);		
		assertEquals(null, t);
		System.out.println("TYPE: " + ((t == null) ? "INVALID": t));
	}
	
}
