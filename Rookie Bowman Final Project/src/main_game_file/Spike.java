package main_game_file;

import hsa2.GraphicsConsole;

public class Spike {
static boolean spike(int cXint, int cYint, int c_w, int c_h, int Main_x, int Main_y, int Main_w, int Main_h, GraphicsConsole c) throws InterruptedException {
	boolean collision = false;
	boolean r = false;
	int j = 1;
	int j2 = 1;
	//Sets an x,y,h array equal to the length of the spike
	int[] s_x = new int[Main_w];
	int[] s_y = new int[Main_w];
	int[] s_h = new int[Main_w];
	//Width is always 1
	int s_w = 1;
	//Draws the spikes by drawing each pixel width going up then down 
	for(int i = 0; i<Main_w; i++) {
		s_x[i] = i + Main_x;
		if (j < 20) {
			s_y[i] = Main_y + Main_h - j;
			s_h[i] =j;
			j++;
			}
		if (j > 18) {
			s_y[i] = Main_y + Main_h - (20 -j2);
			s_h[i] = 20 - j2;
			j++;
			j2++;
			}
		if (j == 39) {
			 j = 1;
			 j2 = 1;
			}
	}
	//Detects collision with the spikes by detecting collision with each width
	for(int i = 0; i<Main_w; i++) {
		c.fillRect(s_x[i], s_y[i], 1, s_h[i]);
		collision = Collision_Detection.CollisionDetection2(cXint, cYint, c_w, c_h, s_x[i], s_y[i], s_w, s_h[i]);
		if (collision == true) {
			r = true;
		}
		
	}
	return r;
}
}
