import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.random;
import javax.swing.*;

public class FlappyDeutsch extends JPanel {
    int boardWidth = 360;
    int boardHeight = 640;

    FlappyDeutsch(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.blue);
    }
}
