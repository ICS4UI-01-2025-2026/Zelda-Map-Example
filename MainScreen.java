import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.*;

import javax.swing.*;

/**
* Creates the main screen that displays everything
* @author Mr. Lamont
*/
public class MainScreen extends JFrame{

    // buttons to move around
    private JButton upButton;
    private JButton downButton;
    private JButton rightButton;
    private JButton leftButton;
    // picture to display
    private PicturePanel picture;
    // text to display
    private JTextField description;

    // constructor
    public MainScreen(){
        
        // show the window
        this.setVisible(true);
        // make the close button work
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the panel to put in the frame
        JPanel mainPanel = new JPanel();
        // set the layout to a border layout
        mainPanel.setLayout(new BorderLayout());

        // create the buttons
        this.upButton = new JButton("UP");
        this.leftButton = new JButton("LEFT");
        this.rightButton = new JButton("RIGHT");
        this.downButton = new JButton("DOWN");
        // set action commands to tell which button was pressed
        this.upButton.setActionCommand("up");
        this.downButton.setActionCommand("down");
        this.leftButton.setActionCommand("left");
        this.rightButton.setActionCommand("right");

        // make the description area
        this.description = new JTextField();

        // make the picture panel
        this.picture = new PicturePanel();

        // make bottom section
        JPanel bottomSection = new JPanel();
        // grid with 2 rows, 1 column
        bottomSection.setLayout(new GridLayout(2,1));

        // assemble all the pieces together
        mainPanel.add(BorderLayout.PAGE_START, upButton);
        mainPanel.add(BorderLayout.LINE_START, leftButton);
        mainPanel.add(BorderLayout.CENTER, picture);
        mainPanel.add(BorderLayout.LINE_END, rightButton);
        // add things to the grid first for the bottom part
        bottomSection.add(downButton);
        bottomSection.add(description);
        // add the bottom part
        mainPanel.add(BorderLayout.PAGE_END, bottomSection);

        // add the main panel to the frame to see it
        this.add(mainPanel);
        // sets the window size
        this.setSize(800,600);
    }

    // links the listener with all the buttons
    public void addActionListener(ActionListener listener){
        this.upButton.addActionListener(listener);
        this.downButton.addActionListener(listener);
        this.rightButton.addActionListener(listener);
        this.leftButton.addActionListener(listener);
    }

    // change the bottom text on the screen
    public void setDescription(String text){
        this.description.setText(text);
    }

    // change the picture on the panel
    public void setPicture(BufferedImage image){
        this.picture.setImage(image);
    }

}
