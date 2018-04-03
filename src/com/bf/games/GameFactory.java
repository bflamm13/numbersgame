package com.bf.games;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameFactory
{	
	public enum GameType
	{
		LUCKYFORLIFE,
		MEGABUCKS,
		POWERBALL;	
		
		public static GameType convert(String type)
		{
			GameType gType;
			try
			{
				gType = GameType.valueOf(type);
			}
			catch (Exception e)
			{
				return null;
			}
			return gType;
		}  
		
	};
	
	static Map<GameType, Game> gMap = new HashMap<GameType, Game>();
		
	public GameFactory(ArrayList<Game> games)
	{
		for (Game g: games)
		{
			gMap.put(g.getType(), g);
		}
	}

	static public AbstractGame getGame(GameType type)
	{		
		Game g = gMap.get(type);
		switch (type)
		{
			case LUCKYFORLIFE:
			case MEGABUCKS:
			case POWERBALL:
				return new LotteryGame(g);
			default:
				throw new UnsupportedOperationException("Invalid game type :" + type);
		}	
	}


	public static Collection<Game> getGameList()
	{
		// TODO Auto-generated method stub
		return gMap.values();
	}
}
