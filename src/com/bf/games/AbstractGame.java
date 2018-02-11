package com.bf.games;

import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public abstract class AbstractGame 
{
	static public int DEF_PICKS = 1;

	protected Game gInfo;
	
	abstract public Pair<List<Integer>, List<Integer>> getNumbers() throws Exception;
	
	public AbstractGame(Game g)
	{
		this.gInfo = g;
	}
	public void display(String title, int maxBalls, int maxPicks, int maxBonusBalls)
	{
		System.out.println("*************"+ title +"*************");
		System.out.println("Pick "+ maxPicks +" numbers 1 to "+ maxBalls);
		System.out.println("Pick "+ DEF_PICKS +" bonus number 1 to "+ maxBonusBalls);
		System.out.println("");
	}

}
