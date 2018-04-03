package com.bf.games;

import com.bf.generator.AbstractGenerator;

public abstract class AbstractGame 
{
	static public int DEF_PICKS = 1;

	protected AbstractGenerator gen;
	protected Game gInfo;
	
	abstract public GameInfo getNumbers() throws Exception;
	
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
