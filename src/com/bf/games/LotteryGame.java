
package com.bf.games;

import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import com.bf.generator.Generator;

public class LotteryGame extends AbstractGame
{	
	Generator gen = new Generator();

	public LotteryGame(Game g)
	{
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pair<List<Integer>, List<Integer>> getNumbers() throws Exception
	{
		
		/*
		 * pick 5 out of 48 plus bonus ball 1 out od 18
		 */
		List<Integer> bonuses = null;
		List<Integer> numbers = gen.generateNumbers(gInfo.getMaxBalls(),gInfo.getPicks());
		if (gInfo.getBonusPicks() != 0)
		{
			bonuses = gen.generateNumbers(gInfo.getMaxBonusBalls(),gInfo.getBonusPicks());
		}
		
		Pair<List<Integer>, List<Integer>> p = new ImmutablePair<List<Integer>, List<Integer>>(numbers,(bonuses == null) ? null : bonuses);
		return p;
	}

	public void display()
	{
		display(gInfo.getDescription(), gInfo.getMaxBalls(),gInfo.getPicks(), gInfo.getMaxBonusBalls());
	}
}
