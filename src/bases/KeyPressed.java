package bases;

public class KeyPressed {
    public boolean upPressed;
    public boolean downPressed;
    public boolean rightPressed;
    public boolean leftPressed;

    public boolean IronshootPresed;
    public boolean IronshootOnePressed;

    public boolean anyKeyPressed;

    public boolean WPressed;
    public boolean SPressed;
    public boolean DPressed;
    public boolean APressed;

    public boolean CaptainshootPresed;
    public boolean CaptainshootOnePressed;


    /**
     * can access globally
     */
    private static final KeyPressed INSTANCE = new KeyPressed();

    private KeyPressed(){
        this.upPressed = false;
        this.downPressed = false;
//        this.rightPressed = false;
//        this.leftPressed = false;
        this.IronshootPresed = false;
        this.IronshootOnePressed = false;

        this.anyKeyPressed = false;

        this.WPressed = false;
        this.SPressed = false;
//        this.DPressed = false;
//        this.APressed = false;
        this.CaptainshootPresed = false;
        this.CaptainshootOnePressed = false;
    }

    public static KeyPressed getInstance(){
        /**
         * static have no 'this'
         */
        return INSTANCE;
    }
}
