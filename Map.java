import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;

public class Map {
    private Scene[] scenes;
    private int maxRows;
    private int maxCols;
    private int currentRow;
    private int currentCol;

    public Map(String mapFile){
        // create the scanner to read the file
        try{
            Scanner input = new Scanner(new File(mapFile));
            // scanning map dimensions
            this.maxRows = input.nextInt();
            // drop to new line
            input.nextLine();
            this.maxCols = input.nextInt();
            // drop to new line
            input.nextLine();

            // get player location
            this.currentRow = input.nextInt();
            input.nextLine();
            this.currentCol = input.nextInt();
            input.nextLine();

            // create the scenes array
            this.scenes = new Scene[this.maxCols*this.maxRows];
            // read in all of the scenes
            for(int i = 0; i < this.scenes.length; i++){
                // row and column of the scene
                int row = input.nextInt();
                int col = input.nextInt();
                // picture file name
                String filename = input.next();
                // directions to move
                boolean up = input.nextBoolean();
                boolean right = input.nextBoolean();
                boolean down = input.nextBoolean();
                boolean left = input.nextBoolean();
                // get any description left AND move to the next line
                String description = input.nextLine();
                // create the scene
                Scene s = new Scene(row, col, filename, up, right, down, left, description);
                // put it into the array
                this.scenes[i] = s;
            }

        }catch(Exception e){
            // print out any errors
            e.printStackTrace();
        }
    }

    // find a specific scene
    private Scene findScene(int row, int col){
        // go through each Scene
        for(int i = 0; i < this.scenes.length; i++){
            // grab the current scene
            Scene s = this.scenes[i];
            // if we have matching rows and cols
            if(s.getRow() == row && s.getCol() == col){
                // found it!
                return s;
            }
        }
        // no match found
        return null;
    }

    public BufferedImage getImage() {
        // find the scene we are on
        Scene s = findScene(this.currentRow, this.currentCol);
        // return the image
        return s.getImage();
    }

    public void moveDown() {
      // find current scene
      Scene s = findScene(currentRow, currentCol);
      // can we move down?
      if(s.canMoveDown()){
          // move to the down
          this.currentRow++;
      }
    }

    public void moveLeft() {
       // find current scene
       Scene s = findScene(currentRow, currentCol);
       // can we move left?
       if(s.canMoveLeft()){
           // move to the left
           this.currentCol--;
       }
    }

    public void moveRight() {
        // find current scene
        Scene s = findScene(currentRow, currentCol);
        // can we move right?
        if(s.canMoveRight()){
            // move to the right
            this.currentCol++;
        }
    }

    public void moveUp() {
        // find current scene
      Scene s = findScene(currentRow, currentCol);
      // can we move up?
      if(s.canMoveUp()){
          // move to the up
          this.currentRow--;
      }
    }

    public String getDescription(){
      // find current scene
      Scene s = findScene(currentRow, currentCol);
      // return the description
      return s.getDescription();
    }
}
