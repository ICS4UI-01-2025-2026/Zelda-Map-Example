import java.io.File;
import java.util.Scanner;

public class Controller{

   private Map map;
   private MainScreen screen;
   private int currentRow;
   private int currentCol;
   private Scene currentScene;

   public Controller(String file){
        // create Scanner using the file
        // needs to be in try-catch because of errors
        try{
            Scanner input = new Scanner(new File(file));
            // get the number of rows
            int numRows = input.nextInt();
            // move down
            input.nextLine();
            // get number of cols
            int numCols = input.nextInt();
            // move down
            input.nextLine();

            // create the map
            this.map = new Map(numRows, numCols);

            // scan starting location
            this.currentRow = input.nextInt() - 1;
            input.nextLine();
            this.currentCol = input.nextInt() - 1;
            input.nextLine();

            // scan in all of the Scenes
            for(int i = 0; i < numRows*numCols; i++){
                int row = input.nextInt();
                int col = input.nextInt();
                String imageFile = input.next();
                boolean north = input.nextBoolean();
                boolean east = input.nextBoolean();
                boolean south = input.nextBoolean();
                boolean west = input.nextBoolean();
                // get any test leftover and move to new line
                String description = input.nextLine();

                // make the scene
                Scene s = new Scene(row, col, imageFile, north, east, south, west, description);
                // add the scene to the map - need to change to base 0
                map.addScene(row-1, col-1, s);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        // get the current scene
        this.currentScene = this.map.getScene(currentRow, currentCol);
    
   }

   public void moveNorth(){
        if(this.currentScene.canMove(Scene.NORTH)){
            // move up one row
            this.currentRow--;
            updateScene();
        }
            
   }

   public void moveEast(){
        if(this.currentScene.canMove(Scene.EAST)){
            // move over one col
            this.currentCol++;
            updateScene();
        }
            
   }

   public void moveSouth(){
        if(this.currentScene.canMove(Scene.SOUTH)){
            // move down one row
            this.currentRow++;
            updateScene();
        }
            
   }

   public void moveWest(){
        if(this.currentScene.canMove(Scene.WEST)){
            // move left one col
            this.currentCol--;
            updateScene();
        } 
   }

   private void updateScene(){
        // get the new Scene
        this.currentScene = this.map.getScene(currentRow, currentCol);
   }
    
}
