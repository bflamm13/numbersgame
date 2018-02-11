package com.bf.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator
{
	private Random rd;
	public Generator()
	{
		rd = new Random();
	}
	
	public List<Integer> generateNumbers(int maxBalls, int picks) throws Exception
	{
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> pickedNums = new ArrayList<Integer>();
		
		
		if(picks > maxBalls)
		{
			throw new Exception("The picks("+picks+") greater than balls available("+maxBalls+")");
		}
		
		for (int i=1; i <= maxBalls; i++)
		{
			numbers.add(i);
		}		
		int max = maxBalls;
		for (int i=0; i < picks; i++)
		{
			int pos = rd.nextInt(max);
			pickedNums.add(numbers.get(pos));
			numbers.remove(pos);
			max--;
		}
		
		return pickedNums;
	}
}
