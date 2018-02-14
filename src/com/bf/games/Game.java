package com.bf.games;

import com.bf.games.GameFactory.GameType;

public class Game
{	
	private String name;
	private GameType type;
	private int maxNums;
	private int picks;
	private int maxBonusNums;
	private int bonusPicks;
	private String description;
	
	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type.toString();
	}

	public int getMaxNums()
	{
		return maxNums;
	}

	public int getPicks()
	{
		return picks;
	}

	public int getMaxBonusNums()
	{
		return maxBonusNums;
	}

	public int getBonusPicks()
	{
		return bonusPicks;
	}

	public String getDescription()
	{
		return description;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(String type)
	{
		this.type = GameType.valueOf(type) ;
	}

	public void setType(GameType type)
	{
		this.type = type;
	}
	
	public void setMaxNums(int maxNums)
	{
		this.maxNums = maxNums;
	}

	public void setPicks(int picks)
	{
		this.picks = picks;
	}

	public void setMaxBonusNums(int maxBonusBalls)
	{
		this.maxBonusNums = maxBonusBalls;
	}

	public void setBonusPicks(int bonusPicks)
	{
		this.bonusPicks = bonusPicks;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Game()
	{
		
	}
	
	public Game(String name, GameType type, int nums, int picks, int bonus, int bonusPicks)
	{
		this.name = name;
		this.type = type;
		this.maxNums = nums;
		this.picks = picks;
		this.maxBonusNums = bonus;
		this.bonusPicks = bonusPicks;
	}
}
