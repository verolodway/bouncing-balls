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
        bolas = new ArrayList<>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroDeBolas)
    {
        int ground = 400;   // position of the ground line
        Random rnd = new Random();

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i = 0; i < numeroDeBolas; i++){
            int radio = rnd.nextInt(20)+10;
            int rojo = rnd.nextInt(255);
            int azul = rnd.nextInt(255);
            int verde = rnd.nextInt(255);
            Color color = new Color(rojo, azul, verde);
            BouncingBall ball = new BouncingBall(50 + (20*i), 50, radio, color, ground, myCanvas);
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
