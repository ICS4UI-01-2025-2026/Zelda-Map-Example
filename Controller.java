import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Controller implements ActionListener{

    private MainScreen screen;
    private Map map;

    public Controller(){
        // create a screen
        this.screen = new MainScreen();
        // tell the screen Controller will handle button presses
        this.screen.addActionListener(this);

        // create the map
        this.map = new Map("pics.txt");
        // set the first scene
        this.screen.setPicture(this.map.getImage());
        // update the first
        this.screen.setDescription(this.map.getDescription());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get which button is pressed
        String command = e.getActionCommand();
        // determine the button
        if(command.equals("up")){
            this.map.moveUp();
        }else if(command.equals("right")){
            this.map.moveRight();
        }else if(command.equals("left")){
            this.map.moveLeft();
        }else if(command.equals("down")){
            this.map.moveDown();
        }
        // update the image on the screen
        this.screen.setPicture(this.map.getImage());
        // update the description
        this.screen.setDescription(this.map.getDescription());
    }

    
    public static void main(String[] args) {
        new Controller();
    }

    
}
