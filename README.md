# numbersgame

Playing around with java and OOD/OOP

using jersey to create restful apis for generating numbers for various lottery games, handles main number and bonus picks

Using spring to configure lottery games available.

Started UI with html/javascript/jquery: NumbersGame.html

TO DO:

1) UI - to allow user to display lottery games, generated numbers, and add new games
2) DB - store games available and history of generated numbers(maybe for analytics)
3) refactor random number generates to decouple from lotterygame - just in case we want different generators
4) refactor lotterygame to regular game, with bonus number game
5) extend games with powerplay feature, if available for game
