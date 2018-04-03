package com.bf.api;
import java.util.Collection;

import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.bf.games.AbstractGame;
import com.bf.games.Game;
import com.bf.games.GameFactory;
import com.bf.games.GameFactory.GameType;
import com.bf.games.GameInfo;

@Path("/NumberService") 
public class NumberService { 
	
	@GET 
	@Path("/Numbers/{type}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getNumbers(@PathParam("type") String type)
	{ 
		try
		{
			GameType gType = GameFactory.GameType.convert(type);
			if (gType == null)
			{
				return Response.serverError().entity("Invalid game type("+type+")").build();
			}
			
			AbstractGame numGame = GameFactory.getGame(gType);
			GameInfo nums = numGame.getNumbers();
			if (nums!=null)
			{
				return Response.ok(nums, MediaType.APPLICATION_JSON).build();
			}
			else
			{
				return Response.serverError().entity("No game found for type:" + type).build();
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		} 	
	}

	@GET
	@Path("/games")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGames()
	{
		Collection<Game> games = GameFactory.getGameList();
		return Response.ok(games, MediaType.APPLICATION_JSON).build();
	}
	

}
