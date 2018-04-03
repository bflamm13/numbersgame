
package com.bf.games;

import java.util.List;
import com.bf.generator.AbstractGenerator;
import com.bf.generator.DefaultGenerator;

public class LotteryGame extends AbstractGame
{	
	AbstractGenerator gen = new DefaultGenerator();

	public LotteryGame(Game g)
	{
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public GameInfo getNumbers() throws Exception
	{
		
		/*
		 * pick 5 out of 48 plus bonus ball 1 out od 18
		 */
		List<Integer> bonuses = null;
		List<Integer> numbers = gen.generateNumbers(gInfo.getMaxNums(),gInfo.getPicks());
		if (gInfo.getBonusPicks() != 0)
		{
			bonuses = gen.generateNumbers(gInfo.getMaxBonusNums(),gInfo.getBonusPicks());
		}
		
		GameInfo info = new GameInfo(numbers, bonuses);
		
		return info;
	}

	public void display()
	{
		display(gInfo.getDescription(), gInfo.getMaxNums(),gInfo.getPicks(), gInfo.getMaxBonusNums());
	}
}
