// do some wildcard imports to import ALL of the graphics stuff
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
* Creates the main screen that displays everything
* @author Mr. Lamont
*/
public class MainScreen extends JFrame implements ActionListener{
    // make a link to the controller
    private Controller controller;
    // need access to the picture for later
    private PicturePanel picture;
    private JTextField description;

    public MainScreen(Controller controller){
        this.controller = controller;

        // set up the window - this class is a window!
        this.setSize(800, 600);
        this.setTitle("NES Zelda Map");
        // tell the program X closes the program
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add components to the window
        // create a JPanel to add into the window
        // JPanel helps us organize other components
        JPanel mainPanel = new JPanel();
        // tell the main panel to use the Border Layout
        mainPanel.setLayout(new BorderLayout());
        // add this panel into the frame
        this.add(mainPanel);

        // from this point forward, only add things to the panel
        // frame can only hold 1 thing, panel can hold many
        
        // make buttons
        JButton northButton = new JButton("Go North");
        JButton eastButton = new JButton("Go East");
        JButton southButton = new JButton("Go South");
        JButton westButton = new JButton("Go West");

        // add stuff to make buttons work
        // action listener is this class - the class that handles input
        northButton.addActionListener(this);
        eastButton.addActionListener(this);
        southButton.addActionListener(this);
        westButton.addActionListener(this);

        // sets a command to tell the buttons appart
        northButton.setActionCommand("N");
        eastButton.setActionCommand("E");
        southButton.setActionCommand("S");
        westButton.setActionCommand("W");


        // add the buttons to the panel
        mainPanel.add(northButton, BorderLayout.PAGE_START);
        mainPanel.add(eastButton, BorderLayout.LINE_END);
        mainPanel.add(westButton, BorderLayout.LINE_START);

        // create the picture panel
        this.picture = new PicturePanel();

        // add the picture to the middle
        mainPanel.add(this.picture, BorderLayout.CENTER);


        // make the description
        this.description = new JTextField();

        // add another JPanel to make the bottom section
        JPanel bottom = new JPanel();
        // make it a grid layout to make 2 rows, 1 column
        bottom.setLayout(new GridLayout(2,1));
        // add the parts in order from top to bottom
        bottom.add(this.description);
        bottom.add(southButton);

        // add the bottom panel to the mainPanel
        mainPanel.add(bottom, BorderLayout.PAGE_END);

        // show the window
        this.setVisible(true);

    }

    public void setImage(BufferedImage image){
        this.picture.setImage(image);
    }

    public void setDescription(String info){
        this.description.setText(info);
    }

    @Override
    // the method that is called when a button is pressed
    public void actionPerformed(ActionEvent e) {
        // determine the command coming in
        String command = e.getActionCommand();
        // handle the command
        // ask the controller to move the correct way
        if(command.equals("N")){
            this.controller.moveNorth();
        }else if(command.equals("E")){
            this.controller.moveEast();
        }else if(command.equals("S")){
            this.controller.moveSouth();
        }else if(command.equals("W")){
            this.controller.moveWest();
        }

    }

}
