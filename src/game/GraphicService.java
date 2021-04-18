package game;

import character.GameObject;

public interface GraphicService {
    // prepare to draw a new Screen
    void clear();

    // draw ONE GameCharacter on the Screen
    void draw(GameObject character);

    // display the completed Screen
    void redraw();
}
