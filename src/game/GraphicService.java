package game;

import character.GameCharacter;

public interface GraphicService {
    // prepare to draw a new Screen
    void clear();

    // draw ONE GameCharacter on the Screen
    void draw(GameCharacter character);

    // display the completed Screen
    void redraw();
}
