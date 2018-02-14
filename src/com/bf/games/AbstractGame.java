package com.bf.games;

import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

import com.bf.generator.AbstractGenerator;

public abstract class AbstractGame 
{
	static public int DEF_PICKS = 1;

	protected AbstractGenerator gen;
	protected Game gInfo;
	
	abstract public Pair<List<Integer>, List<Integer>> getNumbers() throws Exception;
	
	public AbstractGame(Game g)
	{
		this.gInfo = g;
	}
	
	public void set(AbstractGenerator g)
	{
		this.gen = g;
	}
	
	public void display(String title, int maxNums, int maxPicks, int maxBonusNums)
	{
		System.out.println("*************"+ title +"*************");
		System.out.println("Pick "+ maxPicks +" numbers 1 to "+ maxNums);
		System.out.println("Pick "+ DEF_PICKS +" bonus number 1 to "+ maxBonusNums);
		System.out.println("");
	}

}
