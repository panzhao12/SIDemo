package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteHandler {

	BufferedImage[] sprites;
	BufferedImage sprite;
	

	public SpriteHandler(int id) {

		try {
			switch (id) {
			case 1:

				sprite = ImageIO.read(new File("sprites/minrsprite.png"));
				sprites = new BufferedImage[6];

				for (int i = 0; i < 6; i++) {
					sprites[i] = sprite.getSubimage(i * 52, 0, 52, 56);
				}

				break;

			case 2:

				sprite = ImageIO.read(new File("sprites/minssprite.png"));
				sprites = new BufferedImage[3];

				for (int i = 0; i < 3; i++) {
					sprites[i] = sprite.getSubimage(i * 78, 0, 78, 78);
				}

				break;

			case 3:

				sprite = ImageIO.read(new File("sprites/bosssprite.png"));
				sprites = new BufferedImage[2];

				for (int i = 0; i < 2; i++) {
					sprites[i] = sprite.getSubimage(i * 160, 0, 160, 176);
				}

				break;
				
			case 4:

				sprite = ImageIO.read(new File("sprites/stat.png"));
				sprites = new BufferedImage[7];

				for (int i = 0; i < 7; i++) {
					sprites[i] = sprite.getSubimage(i * 124, 0, 124, 124);
				}

				break;
				


			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public BufferedImage getSub(int i) {

		BufferedImage img = sprites[i];
		return img;
	}

	public void setSprites(BufferedImage[] sprites) {
		this.sprites = sprites;
	}

}
