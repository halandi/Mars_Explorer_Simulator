

public class Game {
	
	public String[][] map = new String[5][5];
	public int currentX;
	public int currentY;
	public boolean isExplorerDeployed = false;
	
	public void GameMap() {
	
	for(int x = 0; x < map.length; x++){
	      for(int y = 0; y < map[0].length; y++){
	    	  map[x][y] = "p";
	      }
		}
	}
	
	public static void printGame(String[][] map){
	    for(int c = 0; c < map.length; c++){   
	      for(int r = 0; r < map[0].length ; r++){
	        if(r > 0 && r < map[0].length) {
	        	System.out.print("|");
	        } else {
	        System.out.println(" ");
	        }
	        System.out.print(map[c][r]); 
	      }
	    }
	  }
	
	public void update(){
	    printGame(map);
	    System.out.println("");
	}
	
	public void reportMove() {
		 System.out.print("M:(" + currentX + "," + currentY + ")");

	}
	
	public void reportExplorer() 
	{
		 System.out.print("P:(" + currentX + "," + currentY + ")\n");
	}
	
	public void placeExplorer(int X, int Y) 
	{
		map[currentX][currentY] = "p";
		currentX = X;
		currentY = Y;
		map[currentX][currentY] = "C";
		isExplorerDeployed = true;
		
	}
	
	public void moveExplorer(int X, int Y) {
		if (X < 5 && Y < 5) {
			while(currentX != X || currentY != Y) {
				map[currentX][currentY] = "p";
				
				if (currentX < X) {
					for(int c = currentX; c < map.length; c++){ 
						if (currentX == X) {
							break;
						}
						currentX = c;	
						reportMove();
					}
				}
				
				if (currentY < Y) {
					for(int r = currentY; r < map[X].length ; r++) {
						if (currentY == Y) {
				    		  break;
						}
						 currentY = r;
						 reportMove();
					}
				}
				
				if (currentX > X ) {
					for(int c = currentX; c < map.length; c--){ 
						if (currentX == X) {
							break;
						}
						currentX = c;	
						reportMove();
					}
				}
				
				if (currentY > Y) {
					for(int r = currentY; r < map[X].length ; r--) {
						if (currentY == Y) {
				    		 break;
				    	}
						currentY = r;
						reportMove();
					}
				}
			}
		} else {
			System.out.print("Invalid Command: Out of space");
		}
		map[currentX][currentY] = "C";
	}
}
