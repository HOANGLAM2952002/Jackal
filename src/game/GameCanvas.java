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

                if (e.getKeyCode() == KeyEvent.VK_M){
                    KeyPressed.getInstance().IronshootPresed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_COMMA){
                    KeyPressed.getInstance().IronshootOnePressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_N){
                    KeyPressed.getInstance().IronReload = true;
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

                if (e.getKeyCode() == KeyEvent.VK_F){
                    KeyPressed.getInstance().CaptainshootOnePressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_G){
                    KeyPressed.getInstance().CaptainshootPresed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_H){
                    KeyPressed.getInstance().CapReload = true;
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


                if (e.getKeyCode() == KeyEvent.VK_M){
                    KeyPressed.getInstance().IronshootPresed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_COMMA){
                    KeyPressed.getInstance().IronshootOnePressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_N){
                    KeyPressed.getInstance().IronReload = false;
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

                if (e.getKeyCode() == KeyEvent.VK_F){
                    KeyPressed.getInstance().CaptainshootOnePressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_G){
                    KeyPressed.getInstance().CaptainshootPresed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_H){
                    KeyPressed.getInstance().CapReload = false;
                }

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.black);
        g.fillRect(600,0, 400,600);
        GameObject.renderAll(g);
        g.setColor(Color.darkGray);
        g.fillRect(600, 0, 3, 600);

        /**
         * IRON MAN STATS
         */
        g.setColor(Color.red);
        g.fillRect(605, 270, 80, 40);
        g.setColor(Color.yellow);
        g.drawString("IRON MAN", 615, 295);
        g.setColor(Color.red);
        g.drawString("Remaining Lives: " + GameObject.remainIron + "", 610, 330);
        g.setColor(Color.yellow);
        g.drawString("Points: " + GameObject.pointIron + "", 610, 360);
        g.setColor(Color.cyan);
        g.drawString("Normal Left: " + GameObject.IronNormal, 610, 390);
        g.setColor(Color.ORANGE);
        g.drawString("Ultimate Left: " + GameObject.IronUltimate, 610, 420);

        /**
         * CAPTAIN AMERICA STATS
         */
        g.setColor(Color.blue);
        g.fillRect(605, 0, 130, 40);
        g.setColor(Color.white);
        g.drawString("CAPTAIN AMERICA", 615, 25);
        g.setColor(Color.red);
        g.drawString("Remaining Lives: " + GameObject.remainCap + "", 610, 60);
        g.setColor(Color.yellow);
        g.drawString("Points: " + GameObject.pointCap + "", 610, 90);
        g.setColor(Color.cyan);
        g.drawString("Normal Left: " + GameObject.CapNormal, 610, 120);
        g.setColor(Color.ORANGE);
        g.drawString("Ultimate Left: " + GameObject.CapUltimate, 610, 150);

        if (GameObject.pointIron >= 100){
            GameObject.remainIron++;
            GameObject.pointIron -= 100;
        }
    }

}
