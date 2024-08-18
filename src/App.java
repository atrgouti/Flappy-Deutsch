import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("flappy deutsch");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlappyDeutsch flappyDeutsch = new FlappyDeutsch();
        frame.add(flappyDeutsch);
        frame.pack();
        frame.requestFocus();
        frame.setVisible(true);
    }
}
