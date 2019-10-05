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
        g.setColor(Color.black);
        g.fillRect(600,0, 400,600);
        GameObject.renderAll(g);
        g.setColor(Color.darkGray);
        g.fillRect(600, 0, 5, 600);

        /**
         * IRON MAN STATS
         */
        g.setColor(Color.red);
        g.fillRect(605, 270, 80, 40);
        g.setColor(Color.yellow);
        g.drawString("IRON MAN", 615, 295);
        g.setColor(Color.blue);
        g.drawString("Remaining Lives: " + GameObject.remainIron + "", 610, 330);
        g.setColor(Color.yellow);
        g.drawString("Points: " + GameObject.pointIron + "", 610, 360);
        g.setColor(Color.MAGENTA);
        g.drawString("Ultimate Left: " + GameObject.IronUltimate, 610, 390);

        g.setColor(Color.GREEN);
        g.drawString("UP: [ARROW UP]", 610, 420);
        g.drawString("DOWN: [ARROW DOWN]", 610, 450);
        g.drawString("Shoot ONCE: [COMMA]", 610, 480);
        g.drawString("Ultimate: [M]", 610, 510);

        /**
         * CAPTAIN AMERICA STATS
         */
        g.setColor(Color.white);
        g.fillRect(605, 0, 130, 40);
        g.setColor(Color.blue);
        g.drawString("CAPTAIN AMERICA", 615, 25);
        g.setColor(Color.blue);
        g.drawString("Remaining Lives: " + GameObject.remainCap + "", 610, 60);
        g.setColor(Color.yellow);
        g.drawString("Points: " + GameObject.pointCap + "", 610, 90);
        g.setColor(Color.MAGENTA);
        g.drawString("Ultimate Left: " + GameObject.CapUltimate, 610, 120);

        g.setColor(Color.GREEN);
        g.drawString("UP: [W]", 610, 150);
        g.drawString("DOWN: [S]", 610, 180);
        g.drawString("Shoot ONCE: [F]", 610, 210);
        g.drawString("Ultimate: [G]", 610, 240);

        /**
         * WINS STATE
         */
        if (GameObject.remainCap < 0){
            g.setColor(Color.PINK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("IRON MAN WINS", 740, 25);
        }

        if (GameObject.remainIron < 0){
            g.setColor(Color.PINK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("CAPTAIN AMERICA WINS", 740, 25);
        }

        if (GameObject.pointIron >= 100){
            GameObject.remainIron++;
            GameObject.pointIron -= 100;
        }

        g.setColor(Color.WHITE);
        g.drawString("RULE OF THE GAME", 790, 80);
        g.drawString("   Remaining Lives -1 = PLAYER LOSES", 755, 120);
        g.drawString("   Ultimate -1 = CANNOT SHOOT TRIPLE", 755, 150);
        g.drawString("   100 Points = BONUS LIVE", 755, 180);
        g.drawString("   THANOS = 30 POINTS", 755, 210);
        g.drawString("   GAUNTLET = 5 POINTS", 755, 240);
        g.drawString("   PLAYER = 20 POINTS", 755, 270);
        g.drawString("   HIT BY THANOS GEM = -5 POINTS", 755, 300);

    }

}
