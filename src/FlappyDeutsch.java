import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.random;
import javax.swing.*;

public class FlappyDeutsch extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360;
    int boardHeight = 640;

    //images
    Image backgroundImg;
    Image birdImg;
    Image topPipImg;
    Image buttomPipImg;

    //bird 
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;


    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }
    }

    //pipes
    int pipex = boardWidth;
    int pipey = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe{
        int x = pipex;
        int y = pipey;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed;

        Pipe(Image img){
            this.img = img;
        }
    }

    //game logic
    Bird bird;
    int velocityY = 0;
    int velocityX = -4;
    int gravity = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    Timer gameLoop;
    Timer PlacePipesTimer;


    FlappyDeutsch(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);

        setFocusable(true);
        addKeyListener(this);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        buttomPipImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //bird
        bird = new Bird(birdImg);
        pipes = new ArrayList<Pipe>();

        //place pipes timer
        PlacePipesTimer = new Timer(1500, new ActionListener(){
            @Override
            public  void  actionPerformed(ActionEvent e){
                placePipes();
            }
        });

        PlacePipesTimer.start();

        // gamejava.util. timer 
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    public void placePipes(){
        int randomPipY = (int) (pipey - pipeHeight/4 - Math.random()*(pipeHeight/2));
        Pipe topPipe = new Pipe(topPipImg);
        topPipe.y = randomPipY;
        pipes.add(topPipe);
    }


    @Override
    public void paintComponent(Graphics g){
            super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        //pipis
        for(int i = 0; i < pipes.size(); i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }
    }

    void move(){
        //bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);

        //pipes
        for(int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

   

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            velocityY = -9;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

}
