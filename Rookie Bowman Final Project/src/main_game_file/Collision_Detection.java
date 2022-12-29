package main_game_file;

public class Collision_Detection {
	static int d;
	static int d2;
	static int d3;
	static boolean CollisionDetection(double rec_1_x, double rec_1_y, int rec_1_w, int rec_1_h, int rec_2_x, int rec_2_y, int rec_2_w, int rec_2_h) throws InterruptedException {
		boolean collision;
		if (rec_2_x < rec_1_x + rec_1_w && rec_1_x < rec_2_x + rec_2_w && rec_1_y < rec_2_y + rec_2_h
				&& rec_2_y < rec_1_y + rec_1_h) {
			collision = true;
			if (Collision_Detection.d == 0) {
				Collision_Detection.d2 = 0;
			}
			if (Collision_Detection.d == 2) {
				Collision_Detection.d2 = 2;
			}
			if (rec_1_x < rec_2_x + rec_2_w && rec_1_x + rec_1_w > rec_2_x
					&& rec_1_y + rec_1_h > rec_2_y && rec_1_y + rec_1_h < rec_2_y + 2) {
				Collision_Detection.d2 = 3;
			}
			if (Jumping.jump == true && rec_1_y > rec_2_y+rec_2_h - 6) {
				Collision_Detection.d2 = 1;
				Jumping.jump = false;
			}
		} else {
			collision = false;
		}
		return collision;
	}
	static boolean CollisionDetection2(double rec_1_x, double rec_1_y, int rec_1_w, int rec_1_h, int rec_2_x, int rec_2_y, int rec_2_w, int rec_2_h) throws InterruptedException {
		boolean collision;
		if (rec_2_x < rec_1_x + rec_1_w && rec_1_x < rec_2_x + rec_2_w && rec_1_y < rec_2_y + rec_2_h
				&& rec_2_y < rec_1_y + rec_1_h) {
			collision = true;
		} else {
			collision = false;
		}
		return collision;
	}
}
