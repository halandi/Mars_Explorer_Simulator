import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UnitTest {
	@Test
	public void createGameMapTest() {
		Game game = new Game();
		
		game.GameMap();
		
		for(int x = 0; x < game.map.length; x++){
		      for(int y = 0; y < game.map[0].length; y++){
		    	  Assert.assertEquals("p", game.map[x][y]);
		      }
			}
	}
	
	@Test
	public void placeExplorerTest() {
		Game game = new Game();
		
		game.GameMap();
		
		game.placeExplorer(1, 1);
		
		Assert.assertEquals(1, game.currentX);
		Assert.assertEquals(1, game.currentY);
	}
	
	@Test
	public void moveExplorerTest() {
		Game game = new Game();
		
		game.GameMap();
		
		game.placeExplorer(1, 1);
		
		Assert.assertTrue(game.isExplorerDeployed);
		
		game.moveExplorer(3, 4);		
		Assert.assertEquals(3, game.currentX);
		Assert.assertEquals(4, game.currentY);
		
		game.moveExplorer(4, 3);
		Assert.assertEquals(4, game.currentX);
		Assert.assertEquals(3, game.currentY);
		
		game.moveExplorer(2, 2);
		Assert.assertEquals(2, game.currentX);
		Assert.assertEquals(2, game.currentY);
	}

}
