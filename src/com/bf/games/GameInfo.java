package com.bf.games;

import java.util.List;


public class GameInfo
{
	List<Integer> mainNums;
	List<Integer> bonusNums;
	
	
	public List<Integer> getMainNums()
	{
		return mainNums;
	}


	public List<Integer> getBonusNums()
	{
		return bonusNums;
	}


	public GameInfo(List<Integer> main, List<Integer> bonus)
	{
		mainNums = main;
		bonusNums = bonus;
	}
}
