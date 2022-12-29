package main_game_file;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class Ladder {
static void ladder(int x, int y, int w, int h, GraphicsConsole c) {
	//Draws the ladder and all the ladder handles according to the width and height
	c.setColor(new Color(101, 67, 33));
	c.fillRect(x, y, 5, h);
	c.fillRect(x+w-5, y, 5, h);
	for(int i = y + 2;i<y+h;i+=6) {
		c.fillRect(x, i, w, 3);
	}
	c.setColor(new Color(0, 0, 0));
}
}
