package com.bf.games;

import com.bf.games.GameFactory.GameType;

public class Game
{	
	private String name;
	private GameType type;
	private int maxBalls;
	private int picks;
	private int maxBonusBalls;
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

	public int getMaxBalls()
	{
		return maxBalls;
	}

	public int getPicks()
	{
		return picks;
	}

	public int getMaxBonusBalls()
	{
		return maxBonusBalls;
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
	
	public void setMaxBalls(int maxBalls)
	{
		this.maxBalls = maxBalls;
	}

	public void setPicks(int picks)
	{
		this.picks = picks;
	}

	public void setMaxBonusBalls(int maxBonusBalls)
	{
		this.maxBonusBalls = maxBonusBalls;
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
	
	public Game(String name, GameType type, int balls, int picks, int bonus, int bonusPicks)
	{
		this.name = name;
		this.type = type;
		this.maxBalls = balls;
		this.picks = picks;
		this.maxBonusBalls = bonus;
		this.bonusPicks = bonusPicks;
	}
}
