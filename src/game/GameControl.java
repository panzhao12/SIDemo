package game;

public class GameControl {

    public int  mousePressedX, mousePressedY, mouseMovedX, mouseMovedY, mouseButton;
    public char keyPressed;

    public GameControl(int mpx,int mpy,int mmx,int mmy,int mb,char kp) {
        mousePressedX = mpx;
        mousePressedY= mpy;
        mouseMovedX = mmx;
        mouseMovedY = mmy;
        mouseButton = mb;
        keyPressed = kp;
    }
}
