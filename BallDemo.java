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
    private ArrayList<BouncingBall> bolas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroDeBolas)
    {
        int ground = 400;   // position of the ground line
        Random rnd = new Random();
        bolas = new ArrayList<>();
        myCanvas.setVisible(true);
        
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i = 0; i < numeroDeBolas; i++){
            int radio = rnd.nextInt(20)+10;
            int rojo = rnd.nextInt(255);
            int azul = rnd.nextInt(255);
            int verde = rnd.nextInt(255);
            int anchura = rnd.nextInt(300);
            int altura = rnd.nextInt(250);
            Color color = new Color(rojo, azul, verde);
            BouncingBall ball = new BouncingBall(anchura +(10*i), altura, radio, color, ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);  // small delay
            for(int i = 0; i < numeroDeBolas; i++){
                bolas.get(i).move();
                if(bolas.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }           
        }
    }
}
