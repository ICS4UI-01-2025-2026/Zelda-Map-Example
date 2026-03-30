import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

public class Scene {
    private int row;
    private int col;
    private BufferedImage image;
    private boolean up;
    private boolean right;
    private boolean down;
    private boolean left;
    private String description;

    public Scene(int row, int col, String filename, 
      boolean up, boolean right, boolean down, 
      boolean left, String description){
        this.row = row;
        this.col = col;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.description = description;
        // load in the image
        this.image = null;
        // try to load the image
        try{
            // load the image from the images folder
            this.image = ImageIO.read(new File("images/"+filename));
        }catch(Exception e){
            // print any errors
            e.printStackTrace();
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean canMoveUp() {
        return up;
    }

    public boolean canMoveRight() {
        return right;
    }

    public boolean canMoveDown() {
        return down;
    }

    public boolean canMoveLeft() {
        return left;
    }

    public String getDescription() {
        return description;
    }
}
