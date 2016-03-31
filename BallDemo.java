import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
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
    
    /**
     * Método que cuando se invoque debe dibujar un rectángulo sin relleno en la pantalla y tantas bolas como se indiquen como parámetro en la invocación del método 
     * dentro de dicho rectángulo.

     * Los objetos bola de esta actividad no serán del tipo BouncingBall: lo que debes hacer es crear una nueva clase denominada BoxBall (basándote en 
     * la clase BouncingBall, evidentemente). Las bolas de tipo BoxBall llevan siempre la misma velocidad (1 pixel cada vez), dirección oblicua (no pueden moverse ni en horizontal ni 
     * en vertical) y no les afecta la gravedad. La posición inicial, el color y la direccion de cada bola debe fijarse de manera aleatoria.

     * Finalmente, consigue que las bolas de tipo "BoxBall" reboten cambiando de dirección cuando golpeen las paredes del rectángulo.
     */
    public void boxBounce(){
        Canvas rectangulo = new Canvas ("Rectangulo", 600,500);
        rectangulo.drawLine(50,50, 550,50);
        rectangulo.drawLine(550,50, 550,400);
        rectangulo.drawLine(550,400, 50,400);
        rectangulo.drawLine(50,400, 50,50);
        rectangulo.setVisible(true);
    }
}
