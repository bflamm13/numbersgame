package com.bf.unittest;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.bf.games.Game;
import com.bf.games.LotteryGame;
import com.bf.generator.Generator;

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
		Game g = new Game();
		g.setType("LUCKYFORLIFE");
	}
	
	@org.junit.Test
	public void testGenerator()
	{
		int max = 48;
		int picks = 5;
		Generator g = new Generator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				System.out.println("num: " + num);
			}
			
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void testGeneratorSingle()
	{
		int max = 18;
		int picks = 1;
		Generator g = new Generator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				System.out.println("num: " + num);
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void testGeneratorPickEQMax()
	{
		int max = 10;
		int picks = 10;
		Generator g = new Generator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				System.out.println("num: " + num);
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testGeneratorPickGEMax()
	{
		int max = 10;
		int picks = 11;
		Generator g = new Generator();
		try
		{
			List<Integer> nums = g.generateNumbers(max, picks);
			assertEquals(picks, nums.size());
			for (Integer num : nums)
			{
				System.out.println("num: " + num);
			}
			
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
		g.setMaxBalls(100);
		g.setMaxBonusBalls(26);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testLuckForLifeDisplay()
	{
		Game g = new Game();
		g.setDescription("TEST");
		g.setBonusPicks(1);
		g.setMaxBalls(100);
		g.setMaxBonusBalls(26);
		g.setPicks(6);
		LotteryGame ll = new LotteryGame(g);
		ll.display();
	}
}
