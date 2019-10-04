package game;
import Scene.SceneManager;
import Scene.welcomeScene.GameWelcomeScene;
import bases.GameObject;
import bases.KeyPressed;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameCanvas extends JPanel {
    Random rand = new Random();
    int move[] = {-5,5};

    public GameCanvas(){
        SceneManager.signNewScene(new GameWelcomeScene());
        this.keyListener();
    }

    private void keyListener() {
        this.setFocusable(true);
        // catch event clicking buttons
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    /**
                     * get static from KeyPressed
                     */
                    KeyPressed.getInstance().upPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = true;
                }

//                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
//                    KeyPressed.getInstance().rightPressed = true;
//                }
//
//                if (e.getKeyCode() == KeyEvent.VK_LEFT){
//                    KeyPressed.getInstance().leftPressed = true;
//                }

                if (e.getKeyCode() == KeyEvent.VK_M){
                    KeyPressed.getInstance().IronshootPresed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_COMMA){
                    KeyPressed.getInstance().IronshootOnePressed = true;
                }

                /**
                 * Captain America
                 */

                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyPressed.getInstance().WPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyPressed.getInstance().SPressed = true;
                }

//                if (e.getKeyCode() == KeyEvent.VK_D){
//                    KeyPressed.getInstance().DPressed = true;
//                }
//
//                if (e.getKeyCode() == KeyEvent.VK_A){
//                    KeyPressed.getInstance().APressed = true;
//                }

                if (e.getKeyCode() == KeyEvent.VK_F){
                    KeyPressed.getInstance().CaptainshootOnePressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_G){
                    KeyPressed.getInstance().CaptainshootPresed = true;
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed = false;
                /**
                 * Iron Man
                 */
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = false;
                }

//                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
//                    KeyPressed.getInstance().rightPressed = false;
//                }
//
//                if (e.getKeyCode() == KeyEvent.VK_LEFT){
//                    KeyPressed.getInstance().leftPressed = false;
//                }
                if (e.getKeyCode() == KeyEvent.VK_M){
                    KeyPressed.getInstance().IronshootPresed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_COMMA){
                    KeyPressed.getInstance().IronshootOnePressed = false;
                }

                /**
                 * Captain America
                 */

                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyPressed.getInstance().WPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyPressed.getInstance().SPressed = false;
                }

//                if (e.getKeyCode() == KeyEvent.VK_D){
//                    KeyPressed.getInstance().DPressed = false;
//                }
//
//                if (e.getKeyCode() == KeyEvent.VK_A){
//                    KeyPressed.getInstance().APressed = false;
//                }

                if (e.getKeyCode() == KeyEvent.VK_F){
                    KeyPressed.getInstance().CaptainshootOnePressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_G){
                    KeyPressed.getInstance().CaptainshootPresed = false;
                }

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        GameObject.renderAll(g);
    }

}
