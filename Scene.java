import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Scene {
    private BufferedImage image;
    private String description;
    private boolean[] directions;
    private int row;
    private int col;

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public Scene(int row, int col, 
        String imageName, boolean north, 
        boolean east, boolean south, boolean west, 
        String description){

            this.row = row;
            this.col = col;
            this.directions = new boolean[4];
            this.directions[NORTH] = north;
            this.directions[EAST] = east;
            this.directions[SOUTH] = south;
            this.directions[WEST] = west;
            this.description = description;

            // try to load in the image
            this.image = null; // null = nothing
            try{
                this.image = ImageIO.read(new File("images//" + imageName));
            }catch(Exception e){
                // print any errors that happen
                e.printStackTrace();
            }

    }

    public BufferedImage getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean canMove(int direction){
        return this.directions[direction];
    }

}
