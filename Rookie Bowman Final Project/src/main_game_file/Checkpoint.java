package main_game_file;

import java.awt.Color;

import hsa2.GraphicsConsole;

public class Checkpoint {

	static void checkpoint(int x, int y, int w, int h, GraphicsConsole c) {
		//Draws the checkpoint according to the width and height
		int h2;
		c.setColor(new Color(130, 130, 130));
		c.fillRect(x, y, 7, h);
		c.setColor(new Color(200, 200, 10));
		for(int i = 0;i<x+w;i+=2) {
			int x2 = x+i+5;
			int y2 = y+i;
			if(h<60) {
			h2 = (h/2)-(2*i);
			}else {
			h2 = 50-(2*i);
			}
		c.fillRect(x2, y2, 2, h2);
		}
		c.setColor(new Color(0, 0, 0));
	}
}
