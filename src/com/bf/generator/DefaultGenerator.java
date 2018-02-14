package com.bf.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultGenerator extends AbstractGenerator
{
	private Random rd;
	
	public DefaultGenerator()
	{
		rd = new Random();
	}
	
	public List<Integer> generateNumbers(int maxNums, int picks) throws Exception
	{
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> pickedNums = new ArrayList<Integer>();
		
		
		if(picks > maxNums)
		{
			throw new Exception("The picks("+picks+") greater than numbers available("+maxNums+")");
		}
		
		for (int i=1; i <= maxNums; i++)
		{
			numbers.add(i);
		}		
		int max = maxNums;
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
