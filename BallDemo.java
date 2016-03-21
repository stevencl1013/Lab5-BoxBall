import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BoxBall> balls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        balls = new ArrayList<BoxBall>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * Simulates n number of balls of random color, size, and speed bouncing in a box.
     */
    public void boxBounce(int n)
    {
        Random rand = new Random();
        myCanvas.drawLine(50, 100, 550, 100); // draws rectangle
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(50, 100, 50, 400);
        myCanvas.drawLine(550, 100, 550, 400);
        for(int i = 0; i < n; i++) // creates n balls
        {
            balls.add(new BoxBall(100, 400, 50, 550, myCanvas));
        }
        for(BoxBall ball : balls) // draws balls
        {
            ball.draw();
        }
        for(int i = 0; i < 100000; i++)
        {
             myCanvas.wait(50);           // small delay
             for(BoxBall ball : balls) // moves balls
             {
                ball.move();
             }
             
        }
    }
}
