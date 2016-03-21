import java.awt.*;
import java.awt.geom.*;
import java.util.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author Steven Lee
 * @version 3/21/2016
 */
public class BoxBall
{
   private int xPosition;
   private int yPosition;
   private int diameter;
   private int topWallPosition;
   private int bottomWallPosition;
   private int leftWallPosition;
   private int rightWallPosition;
   private Ellipse2D.Double circle;
   private Color color;
   private Canvas canvas;
   private int xSpeed;
   private int ySpeed;
   private Random rand;
   
   /**
     * Parameters: positions of walls, canvas. Speed, color, and position set randomly.
     **/
   public BoxBall(int topWall, int bottomWall, int leftWall, int rightWall, Canvas drawingCanvas)
   {
       rand = new Random();
       topWallPosition = topWall;
       bottomWallPosition = bottomWall;
       leftWallPosition = leftWall;
       rightWallPosition = rightWall;
       diameter = 10 + rand.nextInt(30);
       color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
       canvas = drawingCanvas;
       xPosition = leftWallPosition + rand.nextInt(rightWallPosition-leftWallPosition-diameter);
       yPosition = topWallPosition + rand.nextInt(bottomWallPosition-topWallPosition-diameter);
       xSpeed = rand.nextInt(10) - 5;
       ySpeed = rand.nextInt(10) - 5;
   }
   
   /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        xPosition += xSpeed;
        yPosition += ySpeed;

        // check if it has hit any walls;
        if(xPosition >= (rightWallPosition - diameter)) 
        {
            xPosition = rightWallPosition - diameter;
            xSpeed = -xSpeed; 
        }
        
        if(xPosition <= leftWallPosition)
        {
            xPosition = leftWallPosition;
            xSpeed = -xSpeed;
        }
        
        if(yPosition >= (bottomWallPosition - diameter)) 
        {
            yPosition = bottomWallPosition - diameter;
            ySpeed = -ySpeed; 
        }
        
        if(yPosition <= topWallPosition)
        {
            yPosition = topWallPosition;
            ySpeed = -ySpeed;
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
   
   
}
