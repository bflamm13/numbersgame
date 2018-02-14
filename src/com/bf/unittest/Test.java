package com.bf.unittest;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.bf.games.Game;
import com.bf.games.GameFactory;
import com.bf.games.LotteryGame;
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
		Game g = new Game();
		g.setType(type);
		
		assertEquals(g.getType(), type);
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
				assertTrue(num >=1 && num <= max);
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
				assertTrue(num >=1 && num <= max);
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
				assertTrue(num >=1 && num <= max);
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
	public void testGeneratorPickGEMax()
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
			fail("Exception Did Not Occurred: The picks(11) greater than balls available(10)");
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
			Pair<List<Integer>,List<Integer>> p = ll.getNumbers();
			for (Integer num : p.getLeft())
			{
				System.out.println("num: " + num);
			}
			
			System.out.println("bonus: " + p.getRight());
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
		
		System.out.println("TYPE: " + ((t == null) ? "INVALID": t));
		type = "BAD";
		t = GameFactory.GameType.convert(type);		
		System.out.println("TYPE: " + ((t == null) ? "INVALID": t));
	}
	
}
