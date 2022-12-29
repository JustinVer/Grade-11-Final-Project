/* Name: Justin Verhoog
 * Date: 2022-05-17
 * Program Title: Rookie Archer
 * Description: starting game with collision detection and movement
 */

package main_game_file;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import hsa2.GraphicsConsole;

public class Main_game_file {

	public static void main(String[] args) throws InterruptedException {
		GraphicsConsole c = new GraphicsConsole(900, 650, 18, "Rookie Archer");
		//variables
		int Boss_HitCount = 0;
		int keycount =0;
		double Main_x = 440;
		int MainXint = 0;
		double Main_y = 295;
		int MainYint = 0;
		int Main_h = 40;
		int Main_w = 40;
		int jumpCount = 0;
		double NVelocY = 1;
		boolean jumpable = false;
		double LastX = 10;
		double LastY = 10;
		Jumping.jump = false;
		int speedX = 400;
		int speedY = 540;
		int speedW = 10;
		int speedH = 10;
		int SpCount = 0;
		int speed = 2;
		boolean SpeedAble = true;
		boolean collisionSP = false;
		boolean SpeedGotten = false;
		boolean SpeedOn = false;
		int jumpDS = 0;

		int a_c = 0;
		int a_d = 1;
		boolean draw_a = false;
		int a_d2 = 0;
		int a_x = 0;
		int a_y = 0;
		int a_w = 15;
		int a_h = 5;
		int n_a_x = 0;
		int n_a_y = 0;
		
		
		int[] T_x = {400, 3050, 3200};
		int[] T_y = {-200, -900, 200};
		int[] T_w = {50, 50, 50};
		int[] T_h = {50, 50, 50};
		int[] B_x = {400, 3050, 3200};
		int[] B_y = {-200, -900, 300} ;
		int[] B_w = {20, 20, 20};
		int[] B_h = {20, 20, 20};
		boolean [] draw_B = new boolean [B_x.length];
		int [] B_delay = new int [T_x.length];
		int B_diffx = 0;
		int B_diffy = 0;
		
		int []K_x = {600, 3000, 4530};
		int []K_y = {220, -350, -790};
		int []K_w = {40};
		int []K_h = {40};
		
		int[] JP_x = {2400};
		int[] JP_y = {-388};
		int[] JP_w = {50};
		int[] JP_h = {8};
		boolean JP_active = false;
		
		
		int [] D_platforms_x_1 = {1800, 400, 600, 3200,3500, 3800, 4100 }; 
		int [] D_platforms_y_1 = {250,  80, 80, -650, -650, -650, -650}; 
		int [] D_platforms_w_1 = {50, 50, 50, 50, 50, 50, 50}; 
		int [] D_platforms_h_1 = {20, 20, 20, 20, 20, 20, 20}; 
		int [] D_platforms_x_2 = {1900,  500,  700, 3350, 3650, 3950, 4250}; 
		int [] D_platforms_y_2 = {250, 80, 80, -650, -650, -650, -650}; 
		int [] D_platforms_w_2 = {50, 50, 50, 50, 50, 50, 50}; 
		int [] D_platforms_h_2 = {20, 20, 20, 20, 20, 20, 20}; 
		int D_platforms_timer = 0;
		boolean DP_cycle_1 = true;
		boolean DP_cycle_2 = false;
		
		int[] Boss_x = {0};
		int[] Boss_y = {450};
		int[] Boss_w = {100};
		int[] Boss_h = {50};
		int[] Boss_block_x = {0, -100, 900};
		int[] Boss_block_y = {500, 0, 0};
		int[] Boss_block_w = {900, 100, 100};
		int[] Boss_block_h = {200, 600, 600};
		boolean Boss_active = false;
		boolean Boss_Charge_1 = false;
		boolean Boss_Charge_2 = false;
		boolean Boss_Charge_2_L = false;
		boolean Boss_Charge_2_R = false;
		boolean Boss_Charge_3 = false;
		boolean Boss_Charge_3_L = false;
		boolean Boss_Charge_3_R = false;
		boolean Boss_Charge_3_LL = false;
		boolean Boss_vulnerable_1 = false;
		boolean Boss_vulnerable_2 = false;
		boolean Boss_vulnerable_3 = false;
		int Boss_animation = 0;
		boolean Boss_death = false;
		boolean Boss_hit = false;

		
		int[] block_x = { -100, -100, 0, -100, 1800, 2600, 1630, 3700, 3400, 2900, 2300, 2600, 4400};
		int[] block_y = { 335, -150, -150, 600, 330, 330, -120, 250, -200, -270, -380, -650, -700};
		int[] block_w = { 1600, 440, 1500, 1600, 400, 800, 800, 300, 600, 200, 400, 500, 300};
		int[] block_h = { 150, 800, 250, 150, 150, 150, 150, 100, 150, 150, 150, 100, 150 };

		int[] spikes_x = { 500, 900, 500, 2982 };
		int[] spikes_y = { 315, 315, 580,-290 };
		int[] spikes_w = { 222, 222, 222, 36 };
		int[] spikes_h = { 20, 20, 20, 20 };

		int[] ladder_x = { 1540, 4040 };
		int[] ladder_y = { -100, -200 };
		int[] ladder_w = { 50, 50 };
		int[] ladder_h = { 1000, 450 };
		boolean collisionL2 = false;

		int[] checkpoint_x = { 1480, -1000, 440, 3800};
		int[] checkpoint_y = { 245, 245, 245, 160};
		int[] checkpoint_w = { 10, 10, 10, 10};
		int[] checkpoint_h = { 90, 90,90, 90};

		enemy[] e = new enemy[3];
		e[0] = new enemy();
		e[0].e_x = 3200;
		e[0].e_y = 290;
		e[0].e_w = 40;
		e[0].e_h = 40;
		e[0].e_d = 1;

		e[0].b_x = 3100;
		e[0].b_y = 280;
		e[0].b_w = 200;
		e[0].b_h = 100;

		e[1] = new enemy();
		e[1].e_x = 3300;
		e[1].e_y = 290;
		e[1].e_w = 40;
		e[1].e_h = 40;
		e[1].e_d = 1;

		e[1].b_x = 3200;
		e[1].b_y = 290;
		e[1].b_w = 200;
		e[1].b_h = 100;
		
		e[2] = new enemy();
		e[2].e_x = 2520;
		e[2].e_y = -420;
		e[2].e_w = 40;
		e[2].e_h = 40;
		e[2].e_d = 1;

		e[2].b_x = 2500;
		e[2].b_y = -420;
		e[2].b_w = 200;
		e[2].b_h = 40;
		
		int[] e_x = new int[e.length];
		boolean[] collisionBL1 = new boolean[D_platforms_x_1.length];
		boolean[] collisionBL2 = new boolean[D_platforms_x_2.length];
		boolean[] collisionE = new boolean[e.length];
		boolean[] collisionEL = new boolean[e.length];
		boolean[] collisionER = new boolean[e.length];
		boolean[] collisionB = new boolean[block_x.length];
		boolean[] collisionS = new boolean[spikes_x.length];
		boolean[] collisionL = new boolean[ladder_x.length];
		boolean collisionC = false;
		boolean collision = false;
		
		//Image variables
		Image start_screen_RookBow;
		start_screen_RookBow = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/start_screen_RookBow.png"));
		
		Image Archer_walking_1_R;
		Image Archer_walking_2_R;
		Image Archer_walking_3_R;
		Image Archer_walking_4_R;
		
		
		
		Image Archer_idle_R;
		
		Image Archer_walking_1_L;
		Image Archer_walking_2_L;
		Image Archer_walking_3_L;
		Image Archer_walking_4_L;
		
		Image Archer_idle_L;
		
		Image Arrow_left;
		Image Arrow_right;
		
		Image Turret_left;
		Image Turret_up;
		Image Bullet;
		
		Image Key;
		
		Image Jump_pad;	
		
		Image Enemy_idle_L;
		Image Enemy_idle_R;
		
		
		Image Boss_charging_1_R;
		Image Boss_charging_2_R;
		Image Boss_charging_3_R;
		Image Boss_charging_4_R;
		
		Image Boss_hurt_1_R;
		Image Boss_hurt_2_R;
		Image Boss_hurt_3_R;
		Image Boss_hurt_4_R;
		
		Image Boss_idle_R;
		
		Image Boss_charging_1_L;
		Image Boss_charging_2_L;
		Image Boss_charging_3_L;
		Image Boss_charging_4_L;
		
		Image Boss_hurt_1_L;
		Image Boss_hurt_2_L;
		Image Boss_hurt_3_L;
		Image Boss_hurt_4_L;
		
		Image Boss_idle_L;
		
		Archer_walking_1_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_1_R.png"));
		Archer_walking_2_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_2_R.png"));
		Archer_walking_3_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_3_R.png"));
		Archer_walking_4_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_4_R.png"));

		Archer_idle_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_idle_R.png"));
		  				
		Archer_walking_1_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_1_L.png"));
		Archer_walking_2_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_2_L.png"));
		Archer_walking_3_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_3_L.png"));
		Archer_walking_4_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_walking_4_L.png"));

		Archer_idle_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Archer_idle_L.png"));
		
		Arrow_left = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Arrow_left.png"));
		Arrow_right = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Arrow_right.png"));
		
		Turret_left = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Turret_left.png"));
		Turret_up = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Turret_up.png"));
		Bullet = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Bullet.png"));
		
		Key = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Key.png"));
		
		Jump_pad = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Jump_pad.png"));
		
		Enemy_idle_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Enemy_idle_L.png"));
		Enemy_idle_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Enemy_idle_R.png"));
		
		Boss_charging_1_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_1_R.png"));
		Boss_charging_2_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_2_R.png"));
		Boss_charging_3_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_3_R.png"));
		Boss_charging_4_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_4_R.png"));
		
		Boss_hurt_1_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_1_R.png"));
		Boss_hurt_2_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_2_R.png"));
		Boss_hurt_3_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_3_R.png"));
		Boss_hurt_4_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_4_R.png"));
		
		Boss_idle_R = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_idle_R.png"));
		
		Boss_charging_1_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_1_L.png"));
		Boss_charging_2_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_2_L.png"));
		Boss_charging_3_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_3_L.png"));
		Boss_charging_4_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_charging_4_L.png"));
		
		Boss_hurt_1_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_1_L.png"));
		Boss_hurt_2_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_2_L.png"));
		Boss_hurt_3_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_3_L.png"));
		Boss_hurt_4_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_hurt_4_L.png"));
		
		Boss_idle_L = Toolkit.getDefaultToolkit().getImage(c.getClass().getClassLoader().getResource("pictures/Boss_idle_L.png"));
		
		int Archer_walking_animation = 1;		
		int running = 0;
		int Archer_idle = 0;
		int Archer_L = 0;
		int Archer_R = 1;
		
		// Press any key to start game
				c.drawImage(start_screen_RookBow, 0, 0, 900, 650);
				char start = c.getChar();
				
		while (true) {
			
			if (Boss_active == false) {
			Thread.sleep(3);
			
			synchronized (c) {
				
				c.clear();
				// Movement, moves everything but the main character,also sets direction
				Collision_Detection.d = 7;
				if (c.isKeyDown('W') && jumpable == true) {
					Collision_Detection.d = 1;
					Jumping.jump = true;
				} else if (c.isKeyDown('A')) {
					speedX += speed;
					a_x += speed;
					LastX += speed;
					for (int i = 0; i < block_x.length; i++) {
						block_x[i] += speed;
					}
					for (int i = 0; i < spikes_x.length; i++) {
						spikes_x[i] += speed;
					}
					for (int i = 0; i < ladder_x.length; i++) {
						ladder_x[i] += speed;
					}
					for (int i = 0; i < checkpoint_x.length; i++) {
						checkpoint_x[i] += speed;
					}
					for (int i = 0; i < e.length; i++) {
						e[i].e_x += speed;
						e[i].b_x += speed;
					}
					for (int i = 0; i < T_x.length; i++) {
					T_x[i] += speed;
					}
					for (int i = 0; i < B_x.length; i++) {
					B_x[i] += speed;
					}
					for (int i = 0; i < K_x.length; i++) {
					K_x[i] += speed;
					}
					for (int i = 0; i < JP_x.length; i++) {
					JP_x[i] += speed;
					}
					for (int i = 0; i < D_platforms_x_1.length; i++) {
					D_platforms_x_1[i] += speed;
					}
					for (int i = 0; i < D_platforms_x_2.length; i++) {
					D_platforms_x_2[i] += speed;
					}
					Collision_Detection.d = 2;
				} else if (c.isKeyDown('D')) {
					speedX -= speed;
					a_x -= speed;
					LastX -= speed;
					for (int i = 0; i < block_x.length; i++) {
						block_x[i] -= speed;
					}
					for (int i = 0; i < spikes_x.length; i++) {
						spikes_x[i] -= speed;
					}
					for (int i = 0; i < ladder_x.length; i++) {
						ladder_x[i] -= speed;
					}
					for (int i = 0; i < checkpoint_x.length; i++) {
						checkpoint_x[i] -= speed;
					}
					for (int i = 0; i < e.length; i++) {
						e[i].e_x -= speed;
						e[i].b_x -= speed;
					}
					for (int i = 0; i < T_x.length; i++) {
						T_x[i] -= speed;
						}
						for (int i = 0; i < B_x.length; i++) {
						B_x[i] -= speed;
						}
						for (int i = 0; i < K_x.length; i++) {
						K_x[i] -= speed;
						}
						for (int i = 0; i < JP_x.length; i++) {
						JP_x[i] -= speed;
						}
						for (int i = 0; i < D_platforms_x_1.length; i++) {
						D_platforms_x_1[i] -= speed;
						}
						for (int i = 0; i < D_platforms_x_2.length; i++) {
						D_platforms_x_2[i] -= speed;
						}
					Collision_Detection.d = 0;
				} else if (c.isKeyDown('S')) {
					Collision_Detection.d = 3;
				}
				// Detects collision with blocks and if true reverses the movment
				for (int i = 0; i < block_x.length; i++) {
					collisionB[i] = Collision_Detection.CollisionDetection(Main_x, Main_y, Main_h, Main_w, block_x[i],
							block_y[i], block_w[i], block_h[i]);
					if (collisionB[i] == true) {
						//left
						if (Collision_Detection.d2 == 0) {
							speedX += speed;
							a_x += speed;
							LastX += speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] += speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_x[k] += speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] += speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] += speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x += speed;
								e[k].b_x += speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_x[k] += speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] += speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] += speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_x[k] += speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] += speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] += speed;
								}
						}
						//right
						if (Collision_Detection.d2 == 2) {
							speedX -= speed;
							a_x -= speed;
							LastX -= speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] -= speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_x[k] -= speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] -= speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] -= speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x -= speed;
								e[k].b_x -= speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_x[k] -= speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] -= speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] -= speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_x[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] -= speed;
								}
						}
						//bottom
						if (Collision_Detection.d2 == 1) {
							speedY -= speed;
							a_y -= speed;
							LastY -= speed;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] -= speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] -= speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] -= speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] -= speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y -= speed;
								e[k].b_y -= speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] -= speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] -= speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] -= speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] -= speed;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_y_2[k] -= speed;
								}
							jumpCount = 60;
						}
						//Top
						if (Collision_Detection.d2 == 3) {
							speedY += NVelocY;
							a_y += NVelocY;
							LastY += NVelocY;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] += NVelocY;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] += NVelocY;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] += NVelocY;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] += NVelocY;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y += NVelocY;
								e[k].b_y += NVelocY;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] += NVelocY;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] += NVelocY;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] += NVelocY;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_2.length; k++) {
								D_platforms_y_2[k] += NVelocY;
								}
							jumpable = true;
						}
						collisionB[i] = false;
					}
				}
				// Draws all of the blocks/platforms
				for (int i = 0; i < block_x.length; i++) {
					c.fillRect(block_x[i], block_y[i], block_w[i], block_h[i]);
				}
				// Draws all of the spikes and detects collision with them
				for (int i = 0; i < spikes_x.length; i++) {
					c.setColor(new Color(128, 128, 128));
					collisionS[i] = Spike.spike(MainXint, MainYint, Main_w, Main_h, spikes_x[i], spikes_y[i],
							spikes_w[i], spikes_h[i], c);
				}
				// Draws all of the ladders and detects collision with them
				for (int i = 0; i < ladder_x.length; i++) {
					Ladder.ladder(ladder_x[i], ladder_y[i], ladder_w[i], ladder_h[i], c);
					collisionL[i] = Collision_Detection.CollisionDetection2(MainXint, MainYint, Main_w, Main_h,
							ladder_x[i], ladder_y[i], ladder_w[i], ladder_h[i]);
					if (collisionL[i] == true) {
						if (Main_x < ladder_x[i] + ladder_w[i] && Main_x + Main_w > ladder_x[i]
								&& Main_y + Main_h > ladder_y[i] && Main_y + Main_h < ladder_y[i] + 4) {
							jumpable = true;
						} else {
							Jumping.jump = false;
							jumpable = false;
						}
					}
					// If collision is true and w is down go up
					if (collisionL[i] == true && Collision_Detection.d == 1) {
						for (int j = 0; j < block_x.length; j++) {
							collisionB[j] = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_h, Main_w,
									block_x[j], block_y[j], block_w[j], block_h[j]);
							if (collisionB[j] == false) {
								speedY += NVelocY;
								a_y += NVelocY;
								LastY += NVelocY;
								for (int k = 0; k < block_x.length; k++) {
									block_y[k] += NVelocY;
									}
								for (int k = 0; k < spikes_x.length; k++) {
									spikes_y[k] += NVelocY;
								}
								for (int k = 0; k < ladder_x.length; k++) {
									ladder_y[k] += NVelocY;
								}
								for (int k = 0; k < checkpoint_x.length; k++) {
									checkpoint_y[k] += NVelocY;
								}
								for (int k = 0; k < e.length; k++) {
									e[k].e_y += NVelocY;
									e[k].b_y += NVelocY;
								}
								for (int k = 0; k < T_x.length; k++) {
									T_y[k] += NVelocY;
									}
									for (int k = 0; k < B_x.length; k++) {
									B_y[k] += NVelocY;
									}
									for (int k = 0; k < K_x.length; k++) {
									K_y[k] += NVelocY;
									}
									for (int k = 0; k < JP_x.length; k++) {
									JP_y[k] += NVelocY;
									}
									for (int k = 0; k < D_platforms_y_1.length; k++) {
									D_platforms_y_1[k] += NVelocY;
									}
									for (int k = 0; k < D_platforms_y_2.length; k++) {
									D_platforms_y_2[k] += NVelocY;
									}
							}
							collisionB[j] = false;
						}
						// If s is down go down
					} else if (collisionL[i] == true && Collision_Detection.d == 3) {
						speedY -= 1;
						a_y -= 1;
						LastY -= 1;
						for (int k = 0; k < block_y.length; k++) {
							block_y[k] -= 1;
							}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_y[k] -= 1;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_y[k] -= 1;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_y[k] -= 1;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_y -= 1;
							e[k].b_y -= 1;
						}
						for (int k = 0; k < T_x.length; k++) {
							T_y[k] -= 1;
							}
							for (int k = 0; k < B_x.length; k++) {
							B_y[k] -= 1;
							}
							for (int k = 0; k < K_x.length; k++) {
							K_y[k] -= 1;
							}
							for (int k = 0; k < JP_x.length; k++) {
							JP_y[k] -= 1;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_y_1[k] -= 1;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_y_2[k] -= 1;
							}
					}
					// If nothing is being pressed counteract gravity so you stay in one spot
					else if (collisionL[i] == true) {
						speedY += NVelocY;
						a_y += NVelocY;
						LastY += NVelocY;
						for (int k = 0; k < block_x.length; k++) {
							block_y[k] += NVelocY;
						}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_y[k] += NVelocY;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_y[k] += NVelocY;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_y[k] += NVelocY;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_y += NVelocY;
							e[k].b_y += NVelocY;
						}
						for (int k = 0; k < T_x.length; k++) {
							T_y[k] += NVelocY;
							}
							for (int k = 0; k < B_x.length; k++) {
							B_y[k] += NVelocY;
							}
							for (int k = 0; k < K_x.length; k++) {
							K_y[k] += NVelocY;
							}
							for (int k = 0; k < JP_x.length; k++) {
							JP_y[k] += NVelocY;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_y_1[k] += NVelocY;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_y_2[k] += NVelocY;
							}
						
						jumpable = true;
					}
				}

				// Draws checkpoints
				for (int i = 0; i < checkpoint_x.length; i++) {
					Checkpoint.checkpoint(checkpoint_x[i], checkpoint_y[i], checkpoint_w[i], checkpoint_h[i], c);
					// Checks for collision and if true saves the x and y location of the main
					// character
					collisionC = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_h, Main_w,
							checkpoint_x[i], checkpoint_y[i], checkpoint_w[i], checkpoint_h[i]);
					if (collisionC == true) {
						LastX = 0;
						LastY = 0;
					}
				}
				// Draws speed power up
				if (SpeedGotten == false) {
					c.setColor(new Color(0, 0, 221));
					c.fillRect(speedX, speedY, speedW, speedH);
					c.setColor(new Color(0, 0, 0));
				}
				//Detects collision between main character and the speed pwer up
				collisionSP = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_w, Main_h, speedX, speedY,
						speedW, speedH);
				if (collisionSP == true) {
					SpeedGotten = true;
				}
				// If Q is down activate speed power up
				if (SpeedGotten == true && c.isKeyDown('Q')) {
					SpeedOn = true;
				}
				//Increases speed while the power up is on
				if (SpeedOn == true && SpCount < 2001 && SpeedAble == true) {
					speed = 3;
					SpCount++;
				}
				//stops power up
				if (SpCount > 2000) {
					speed = 2;
					SpeedOn = false;
					SpeedAble = false;
					SpCount++;
				}
				//makes it so that you can use the power up again after a set time
				if (SpCount == 5000) {
					SpeedAble = true;
					SpCount = 0;
				}
				// Sets the direction that the arrow should travel
				if (Collision_Detection.d == 2) {
					a_d = 1;
				}
				if (Collision_Detection.d == 0) {
					a_d = 2;
				}
				// Draws arrow if space is down and the correct amount of time has passed set
				// draw arrow to true
				if (c.isKeyDown(' ') && a_c > 120) {
					if (a_d == 1) {
						a_d2 = 1;
					}
					if (a_d == 2) {
						a_d2 = 2;
					}
					a_c = 0;
					draw_a = true;
					a_x = (int) Main_x;
					a_y = (int) Main_y;
				}
				
				// Detects if the arrow collides with a block and then stops if true
				if (draw_a == true) {
					for (int i = 0; i < block_x.length; i++) {
						collision = Collision_Detection.CollisionDetection2(a_x, a_y, a_w, a_h, block_x[i], block_y[i],
								block_w[i], block_h[i]);
						if (collision == true) {
							draw_a = false;
						}
					}
				}
				// Teleport
				if (draw_a == true && c.isKeyDown('S')) {
					Jump.jump = false;
					//Finds the difference between the character and the arrow then teleport (for teleporting to the right)
					if (a_d2 == 1) {
						n_a_x = (int) (Main_x - a_x);
						n_a_y = (int) (Main_y - a_y);
						speedY += n_a_y;
						a_y += n_a_y;
						LastY += n_a_y;
						for (int k = 0; k < block_x.length; k++) {
							block_y[k] += n_a_y;
						}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_y[k] += n_a_y;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_y[k] += n_a_y;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_y[k] += n_a_y;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_y += n_a_y;
							e[k].b_y += n_a_y;
						}
						for (int k = 0; k < T_y.length; k++) {
							T_y[k] += n_a_y;
							}
							for (int k = 0; k < B_y.length; k++) {
							B_y[k] += n_a_y;
							}
							for (int k = 0; k < K_y.length; k++) {
							K_y[k] += n_a_y;
							}
							for (int k = 0; k < JP_y.length; k++) {
							JP_y[k] += n_a_y;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_y_1[k] += n_a_y;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_y_2[k] += n_a_y;
							}
							
						
						speedX += n_a_x;
						a_x += n_a_x;
						LastX += n_a_x;
						for (int k = 0; k < block_x.length; k++) {
							block_x[k] += n_a_x;
						}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_x[k] += n_a_x;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_x[k] += n_a_x;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_x[k] += n_a_x;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_x += n_a_x;
							e[k].b_x += n_a_x;
						}
						for (int k = 0; k < T_y.length; k++) {
							T_x[k] += n_a_x;
							}
							for (int k = 0; k < B_y.length; k++) {
							B_x[k] += n_a_x;
							}
							for (int k = 0; k < K_y.length; k++) {
							K_x[k] += n_a_x;
							}
							for (int k = 0; k < JP_y.length; k++) {
							JP_x[k] += n_a_x;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_x_1[k] += n_a_x;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_x_2[k] += n_a_x;
							}
						
						draw_a = false;
					}
					//Finds the difference between the character and the arrow then teleport (for teleporting to the left)
					if (a_d2 == 2) {
						n_a_x = (int) (Main_x - a_x + a_w - Main_w);
						n_a_y = (int) (Main_y - a_y);
						speedY += n_a_y;
						a_y += n_a_y;
						LastY += n_a_y;
						for (int k = 0; k < block_x.length; k++) {
							block_y[k] += n_a_y;
						}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_y[k] += n_a_y;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_y[k] += n_a_y;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_y[k] += n_a_y;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_y += n_a_y;
							e[k].b_y += n_a_y;
						}
						for (int k = 0; k < T_y.length; k++) {
							T_y[k] += n_a_y;
							}
							for (int k = 0; k < B_y.length; k++) {
							B_y[k] += n_a_y;
							}
							for (int k = 0; k < K_y.length; k++) {
							K_y[k] += n_a_y;
							}
							for (int k = 0; k < JP_y.length; k++) {
							JP_y[k] += n_a_y;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_y_1[k] += n_a_y;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_y_2[k] += n_a_y;
							}
							
						
						speedX += n_a_x;
						a_x += n_a_x;
						LastX += n_a_x;
						for (int k = 0; k < block_x.length; k++) {
							block_x[k] += n_a_x;
						}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_x[k] += n_a_x;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_x[k] += n_a_x;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_x[k] += n_a_x;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_x += n_a_x;
							e[k].b_x += n_a_x;
						}
						for (int k = 0; k < T_y.length; k++) {
							T_x[k] += n_a_x;
							}
							for (int k = 0; k < B_y.length; k++) {
							B_x[k] += n_a_x;
							}
							for (int k = 0; k < K_y.length; k++) {
							K_x[k] += n_a_x;
							}
							for (int k = 0; k < JP_y.length; k++) {
							JP_x[k] += n_a_x;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_x_1[k] += n_a_x;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_x_2[k] += n_a_x;
							}
					
						draw_a = false;
					}
					// Detects collision with block when you teleport and if you do it puts you to
					// the top or bottom of the block depending on which you are closest to
					for (int i = 0; i < block_x.length; i++) {
						collisionB[i] = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_h, Main_w,
								block_x[i], block_y[i], block_w[i], block_h[i]);
						if (collisionB[i] == true) {
							if (Main_y >= block_y[i] + (block_h[i] / 2)) {
								n_a_y = (int) (Main_y - block_y[i] + block_h[i]);
								
								speedY += n_a_y;
								a_y += n_a_y;
								LastY += n_a_y;
								for (int k = 0; k < block_x.length; k++) {
									block_y[k] += n_a_y;
								}
								for (int k = 0; k < spikes_x.length; k++) {
									spikes_y[k] += n_a_y;
								}
								for (int k = 0; k < ladder_x.length; k++) {
									ladder_y[k] += n_a_y;
								}
								for (int k = 0; k < checkpoint_x.length; k++) {
									checkpoint_y[k] += n_a_y;
								}
								for (int k = 0; k < e.length; k++) {
									e[k].e_y += n_a_y;
									e[k].b_y += n_a_y;
								}
								for (int k = 0; k < T_y.length; k++) {
									T_y[k] += n_a_y;
									}
									for (int k = 0; k < B_y.length; k++) {
									B_y[k] += n_a_y;
									}
									for (int k = 0; k < K_y.length; k++) {
									K_y[k] += n_a_y;
									}
									for (int k = 0; k < JP_y.length; k++) {
									JP_y[k] += n_a_y;
									}
									for (int k = 0; k < D_platforms_y_1.length; k++) {
									D_platforms_y_1[k] += n_a_y;
									}
									for (int k = 0; k < D_platforms_y_2.length; k++) {
									D_platforms_y_2[k] += n_a_y;
									}
								
							}
							if (Main_y < block_y[i] + (block_h[i] / 2)) {
								Main_y = block_y[i] - Main_h;
							}
							collisionB[i] = false;
						}
					}
				}
				// If draw is true draw the arrow and move it the correct direction
				if (draw_a == true) {
					if (draw_a == true) {
						
						if (a_d2 == 1) {
							c.drawImage(Arrow_left,a_x, a_y, a_w, a_h);
							a_x -= 4;
						}
						if (a_d2 == 2) {
							c.drawImage(Arrow_right,a_x, a_y, a_w, a_h);
							a_x += 4;
						}
				
					}
					// Once arrow has travel for a certain amount of time
					if (a_c > 300) {
						draw_a = false;
					}
				}
				a_c++;
				//enemies
				for (int i = 0; i < e.length; i++) {
					// Detects if they are at the left or right side of there designated walking
					// area
					collisionEL[i] = Collision_Detection.CollisionDetection2(e[i].e_x, e[i].e_y, e[i].e_w, e[i].e_h,
							e[i].b_x, e[i].b_y, 2, e[i].b_h);
					collisionER[i] = Collision_Detection.CollisionDetection2(e[i].e_x, e[i].e_y, e[i].e_w, e[i].e_h,
							e[i].b_x + e[i].b_w, e[i].b_y, 2, e[i].b_h);
					// If they are on the left side of there boundary switch direction
					if (collisionEL[i] == true) {
						e[i].e_d = 1;
					}
					// If they are on the right side of there boundary switch direction
					if (collisionER[i] == true) {
						e[i].e_d = 0;
					}
					// If direction is set to right go right
					if (e[i].e_d == 1) {
						e[i].e_x += 0.4;
					}
					// If direction is set to left go left
					if (e[i].e_d == 0) {
						e[i].e_x -= 0.4;
					}
					e_x[i] = (int) e[i].e_x;
					// Draws the enemy
					c.setColor(new Color(150, 0, 0));
					if(e[i].e_d == 0) {
					c.drawImage(Enemy_idle_L,e_x[i], e[i].e_y, e[i].e_w, e[i].e_h);
					}
					if(e[i].e_d == 1) {
						c.drawImage(Enemy_idle_R,e_x[i], e[i].e_y, e[i].e_w, e[i].e_h);
						}
					// Detects collision with main character
					collisionE[i] = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_w, Main_h, e_x[i],
							e[i].e_y, e[i].e_w, e[i].e_h);
					// Detects collision of arrow and enemy and then deletes the enemy from the
					// array if true
					if (draw_a == true) {
						if (Collision_Detection.CollisionDetection2(a_x, a_y, a_w, a_h, e_x[i], e[i].e_y, e[i].e_w,
								e[i].e_h) == true) {
							e[i] = e[e.length - 1];
							enemy new_array[] = new enemy[e.length - 1];
							for (int j = 0; j < new_array.length; j++) {
								new_array[j] = e[j];
							}
							e = new_array;
							draw_a = false;
						}
					}
				}
				
				//Turret
				for(int i = 0; i < T_x.length; i++) {
				c.setColor(new Color(0, 0, 0));
				
				c.drawImage(Turret_left, T_x[i], T_y[i], T_w[i], T_h[i]);
				//Makes the bullet track the main charracter
				if(draw_B[i] == true) {
				 B_delay[i] += 1;
				if (B_delay[i] % 3 ==0) {
					B_diffx = B_x[i] - MainXint;
					B_diffy = B_y[i] - MainYint;
					if (Math.abs(B_diffx) > Math.abs(B_diffy)) {
						if (B_diffx > 0) {								
							B_x[i] -= 2;					
						}
						else if (B_diffx < 0) {
							B_x[i] += 2;
					}						
				}
					if (Math.abs(B_diffy) > Math.abs(B_diffx)) {
						if (B_diffy > 0) {								
							B_y[i] -= 2;					
						}
						else if (B_diffy < 0) {
							B_y[i] += 2;
					}						
				}
					if (Math.abs(B_diffx) == Math.abs(B_diffy)) {
						if (B_diffx > 0) {								
							B_x[i] -= 2;					
						}
						else if (B_diffx < 0) {
							B_x[i] += 2;
					}					
				}															
			}	
				}
				//Detects if the bullet has collided with the main character
				if (MainXint < B_x[i] + B_w[i] && MainYint < B_y[i] + B_h[i] && B_x[i] < MainXint + Main_w && B_y[i] < MainYint + Main_h) {					
					draw_B[i] = false;
					collisionE[0] = true;
					}
				//Detects if the Main character is in the turrets shooting range and then fires if true
				if (Main_x < (T_x[i] + 600) && Main_x > (T_x[i] - 600) && draw_B[i] == false) {
					draw_B[i] = true;
					B_x[0] = T_x[i];
					B_y[0] = T_y[i] + 20;
				}
				if (draw_B[i] == true) {						
						c.drawImage(Bullet,B_x[i], B_y[i], B_w[i], B_h[i]);			
				}
				//bullet collision with Blocks
				for (int j = 0; j < block_x.length; j++) {
					collisionB[j] = Collision_Detection.CollisionDetection2(B_x[i], B_y[i], B_h[i], B_w[i], block_x[j],
							block_y[j], block_w[j], block_h[j]);
					if (collisionB[j] == true) {
							draw_B[i] = false;
							B_x[i] = T_x[i];
							B_y[i] = T_y[i];
						collisionB[j] = false;
					}
				}
				}
				
				//Key
				//Detects collision with main character and then increases the key count
				if (MainXint < K_x[0] + K_w[0] && MainYint < K_y[0] + K_h[0] && K_x[0] < MainXint + Main_w && K_y[0] < MainYint + Main_h) {
					if(keycount == 1) {
						K_x[0]=K_x[1];
						K_y[0]=K_y[1];
					}
					if(keycount == 2) {
						K_x[0]=K_x[2];
						K_y[0]=K_y[2];
					}
					
					
					keycount +=1;
					}	
					c.drawImage(Key,K_x[0], K_y[0], K_w[0], K_h[0]);					
				

				// Left and right variables activate
				if (c.isKeyDown('A')) {
					running = 1;
					Archer_L = 1;
					Archer_R = 0;
					Archer_idle = 1;
					 }
					 
				
				 if (c.isKeyDown('D')) {
				running = 1;
				Archer_L = 0;
				Archer_R = 1;
				Archer_idle = 1;
				 }
				 
				 else if( running == 0) {
					 Archer_idle = 0;
				 }
				 						
				 MainXint = (int) Main_x;
				 MainYint = (int) Main_y;
				 
				// Draws main character with the movement animation
					
				//Archer running left cycle
				if (Archer_L == 1 && running == 1) {
				
					if(Archer_walking_animation > 0 && Archer_walking_animation < 11) {
						
						c.drawImage(Archer_walking_1_L, MainXint, MainYint, Main_w, Main_h);
						Archer_walking_animation += 1;
					
						}
						if(Archer_walking_animation > 10 && Archer_walking_animation < 21) {
							
							c.drawImage(Archer_walking_2_L, MainXint, MainYint, Main_w, Main_h);
							Archer_walking_animation += 1;
					
							}
						if(Archer_walking_animation > 20 && Archer_walking_animation < 31) {
							
							c.drawImage(Archer_walking_3_L,MainXint, MainYint, Main_w, Main_h);
							Archer_walking_animation += 1;
						
							}
						if(Archer_walking_animation > 30 && Archer_walking_animation < 41) {
							
							c.drawImage(Archer_walking_4_L,MainXint, MainYint, Main_w, Main_h);
							
							Archer_walking_animation += 1;
							
							if(Archer_walking_animation == 40) {
							Archer_walking_animation = 1;
						}
					}
						
						running = 0;
														
				}
				
				
				//Archer running right cycle
				if (Archer_R == 1 && running == 1 ) {
					
					if(Archer_walking_animation > 0 && Archer_walking_animation < 11) {
						
						c.drawImage(Archer_walking_1_R,MainXint, MainYint, Main_w, Main_h);
						Archer_walking_animation += 1;
					
						}
						if(Archer_walking_animation > 10 && Archer_walking_animation < 21) {
							
							c.drawImage(Archer_walking_2_R,MainXint, MainYint, Main_w, Main_h);
							Archer_walking_animation += 1;
					
							}
						if(Archer_walking_animation > 20 && Archer_walking_animation < 31) {
							
							c.drawImage(Archer_walking_3_R,MainXint, MainYint, Main_w, Main_h);
							Archer_walking_animation += 1;
						
							}
						if(Archer_walking_animation > 30 && Archer_walking_animation < 41) {
							
							c.drawImage(Archer_walking_4_R,MainXint, MainYint, Main_w, Main_h);
							
							Archer_walking_animation += 1;
							
							if(Archer_walking_animation == 40) {
							Archer_walking_animation = 1;
						}
					}						
						running = 0;																
				}
								
				//Archer idle left
				if (Archer_L == 1 && Archer_idle == 0 ) {					
				c.drawImage(Archer_idle_L,MainXint, MainYint, Main_w, Main_h);																							
				}
				
				//Archer idle right
				if (Archer_R == 1 && Archer_idle == 0 ) {					
					c.drawImage(Archer_idle_R,MainXint, MainYint, Main_w, Main_h);																								
					}
				
				//Disappearing platforms
				//if on cycle one draw all of the cycle one platforms
				if(DP_cycle_1 == true) {
				for (int i = 0; i < D_platforms_x_1.length; i++) {
					c.fillRect(D_platforms_x_1[i], D_platforms_y_1[i], D_platforms_w_1[i], D_platforms_h_1[i]);
					}
				}
				//If on cycle two draw all of the cycle two platforms
				if(DP_cycle_2 == true) {
				for (int i = 0; i < D_platforms_x_2.length; i++) {
					c.fillRect(D_platforms_x_2[i], D_platforms_y_2[i], D_platforms_w_2[i], D_platforms_h_2[i]);
					}
				}
				//Increases the timer
				D_platforms_timer ++;
				
				//When cycle is one set all of the cycle one variables to true and cycle two variables to false 
				if (D_platforms_timer == 1) {
					DP_cycle_1 = true;
					DP_cycle_2 = false;
					// Detects collision with block when it changes and if you do it puts you to
					// The top or bottom of the block depending on which you are closest to
					for (int i = 0; i < D_platforms_x_1.length; i++) {
						collisionB[i] = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_h, Main_w,
								D_platforms_x_1[i], D_platforms_y_1[i], D_platforms_w_1[i], D_platforms_h_1[i]);
						if (collisionB[i] == true) {
								n_a_y = (int) (Main_y - D_platforms_y_1[i] + Main_h);
								speedY += n_a_y;
								a_y += n_a_y;
								LastY += n_a_y;
								for (int k = 0; k < block_x.length; k++) {
									block_y[k] += n_a_y;
								}
								for (int k = 0; k < spikes_x.length; k++) {
									spikes_y[k] += n_a_y;
								}
								for (int k = 0; k < ladder_x.length; k++) {
									ladder_y[k] += n_a_y;
								}
								for (int k = 0; k < checkpoint_x.length; k++) {
									checkpoint_y[k] += n_a_y;
								}
								for (int k = 0; k < e.length; k++) {
									e[k].e_y += n_a_y;
									e[k].b_y += n_a_y;
								}
								for (int k = 0; k < T_y.length; k++) {
									T_y[k] += n_a_y;
									}
									for (int k = 0; k < B_y.length; k++) {
									B_y[k] += n_a_y;
									}
									for (int k = 0; k < K_y.length; k++) {
									K_y[k] += n_a_y;
									}
									for (int k = 0; k < JP_y.length; k++) {
									JP_y[k] += n_a_y;
									}
									for (int k = 0; k < D_platforms_y_1.length; k++) {
									D_platforms_y_1[k] += n_a_y;
									}
									for (int k = 0; k < D_platforms_y_2.length; k++) {
									D_platforms_y_2[k] += n_a_y;
									}
							
							collisionB[i] = false;
						}
					}

				}
				//When cycle is 200 set all of the cycle two variables to true and cycle one variables to false 
				if (D_platforms_timer == 200) {
					DP_cycle_1 = false;
					DP_cycle_2 = true;
					// Detects collision with block when it changes and if you do it puts you to
					// the top or bottom of the block depending on which you are closest to
					for (int i = 0; i < D_platforms_x_2.length; i++) {
						collisionB[i] = Collision_Detection.CollisionDetection2(Main_x, Main_y, Main_h, Main_w,
								D_platforms_x_2[i], D_platforms_y_2[i], D_platforms_w_2[i], D_platforms_h_2[i]);
						if (collisionB[i] == true) {
								n_a_y = (int) (Main_y + Main_h - D_platforms_y_1[i] );
								speedY += n_a_y;
								a_y += n_a_y;
								LastY += n_a_y;
								for (int k = 0; k < block_x.length; k++) {
									block_y[k] += n_a_y;
								}
								for (int k = 0; k < spikes_x.length; k++) {
									spikes_y[k] += n_a_y;
								}
								for (int k = 0; k < ladder_x.length; k++) {
									ladder_y[k] += n_a_y;
								}
								for (int k = 0; k < checkpoint_x.length; k++) {
									checkpoint_y[k] += n_a_y;
								}
								for (int k = 0; k < e.length; k++) {
									e[k].e_y += n_a_y;
									e[k].b_y += n_a_y;
								}
								for (int k = 0; k < T_y.length; k++) {
									T_y[k] += n_a_y;
									}
									for (int k = 0; k < B_y.length; k++) {
									B_y[k] += n_a_y;
									}
									for (int k = 0; k < K_y.length; k++) {
									K_y[k] += n_a_y;
									}
									for (int k = 0; k < JP_y.length; k++) {
									JP_y[k] += n_a_y;
									}
									for (int k = 0; k < D_platforms_y_1.length; k++) {
									D_platforms_y_1[k] += n_a_y;
									}
									for (int k = 0; k < D_platforms_y_2.length; k++) {
									D_platforms_y_2[k] += n_a_y;
									}
							
							collisionB[i] = false;
						}
					}

				}
				//once timer reaches 400 reset to one
				if (D_platforms_timer == 400) {
					D_platforms_timer = 0;

				}
				

				                            
						
				//Platform collision
				//Does collision with cycle one platforms
				if(DP_cycle_1 == true) {
				for (int i = 0; i < D_platforms_x_1.length; i++) {
					collisionB[i] = Collision_Detection.CollisionDetection(Main_x, Main_y, Main_h, Main_w, D_platforms_x_1[i],
							D_platforms_y_1[i], D_platforms_w_1[i], D_platforms_h_1[i]);
					if (collisionB[i] == true) {
						
						if (Collision_Detection.d2 == 0) {
							speedX += speed;
							a_x += speed;
							LastX += speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] += speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_x[k] += speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] += speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] += speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x += speed;
								e[k].b_x += speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_x[k] += speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] += speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] += speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_x[k] += speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] += speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] += speed;
								}
						}
						if (Collision_Detection.d2 == 2) {
							speedX -= speed;
							a_x -= speed;
							LastX -= speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] -= speed;
							}
							for (int k= 0; k < spikes_x.length; k++) {
								spikes_x[k] -= speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] -= speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] -= speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x -= speed;
								e[k].b_x -= speed;
							}
							for (int k= 0; k < T_x.length; k++) {
								T_x[k] -= speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] -= speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] -= speed;
								}
								for (int k= 0; k< JP_x.length; k++) {
								JP_x[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] -= speed;
								}
						}
						if (Collision_Detection.d2 == 1) {
							speedY -= speed*2;
							a_y -= speed*2;
							LastY -= speed*2;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] -= speed*2;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] -= speed*2;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] -= speed*2;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] -= speed*2;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y -= speed*2;
								e[k].b_y -= speed*2;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] -= speed*2;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] -= speed*2;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] -= speed*2;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] -= speed*2;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] -= speed*2;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_y_2[k] -= speed*2;
								}
							jumpCount = 60;
						}
						if (Collision_Detection.d2 == 3) {
							speedY += NVelocY;
							a_y += NVelocY;
							LastY += NVelocY;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] += NVelocY;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] += NVelocY;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] += NVelocY;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] += NVelocY;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y += NVelocY;
								e[k].b_y += NVelocY;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] += NVelocY;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] += NVelocY;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] += NVelocY;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_2.length; k++) {
								D_platforms_y_2[k] += NVelocY;
								}
							jumpable = true;
							JP_active = false;
						}
						collisionB[i] = false;
					}
				}
			}
				//Does collision with cycle two platforms
				if(DP_cycle_2 == true) {
				for (int i = 0; i < D_platforms_x_2.length; i++) {
					collisionB[i] = Collision_Detection.CollisionDetection(Main_x, Main_y, Main_h, Main_w, D_platforms_x_2[i],
							D_platforms_y_2[i], D_platforms_w_2[i], D_platforms_h_2[i]);
					if (collisionB[i] == true) {

						if (Collision_Detection.d2 == 0) {
							speedX += speed;
							a_x += speed;
							LastX += speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] += speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_x[k] += speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] += speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] += speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x += speed;
								e[k].b_x += speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_x[k] += speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] += speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] += speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_x[k] += speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] += speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] += speed;
								}
						}
						if (Collision_Detection.d2 == 2) {
							speedX -= speed;
							a_x -= speed;
							LastX -= speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] -= speed;
							}
							for (int k= 0; k < spikes_x.length; k++) {
								spikes_x[k] -= speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] -= speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] -= speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x -= speed;
								e[k].b_x -= speed;
							}
							for (int k= 0; k < T_x.length; k++) {
								T_x[k] -= speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] -= speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] -= speed;
								}
								for (int k= 0; k< JP_x.length; k++) {
								JP_x[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] -= speed;
								}
						}
						if (Collision_Detection.d2 == 1) {
							speedY -= speed*2;
							a_y -= speed*2;
							LastY -= speed*2;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] -= speed*2;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] -= speed*2;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] -= speed*2;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] -= speed*2;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y -= speed*2;
								e[k].b_y -= speed*2;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] -= speed*2;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] -= speed*2;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] -= speed*2;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] -= speed*2;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] -= speed*2;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_y_2[k] -= speed*2;
								}
							jumpCount = 60;
						}
						if (Collision_Detection.d2 == 3) {
							speedY += NVelocY;
							a_y += NVelocY;
							LastY += NVelocY;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] += NVelocY;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] += NVelocY;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] += NVelocY;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] += NVelocY;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y += NVelocY;
								e[k].b_y += NVelocY;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] += NVelocY;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] += NVelocY;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] += NVelocY;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_2.length; k++) {
								D_platforms_y_2[k] += NVelocY;
								}
							jumpable = true;
							JP_active = false;
						}
						collisionB[i] = false;
					}
				}
			}
				
				//Platform cycle one collision for bullet
				for (int i = 0; i < B_x.length; i++) {
				for (int j = 0; j < D_platforms_x_1.length; j++) {
					collisionBL1[i] = Collision_Detection.CollisionDetection2(B_x[i], B_y[i], B_h[i], B_w[i], D_platforms_x_1[j],
							D_platforms_y_1[j], D_platforms_w_1[j], D_platforms_h_1[j]);
					
					if (collisionBL1[i] == true) {
							draw_B[i] = false;
					}
				}
				}
				//Platform cycle two collision for bullet
				for (int i = 0; i < B_x.length; i++) {
				for (int j = 0; j < D_platforms_x_2.length; j++) {
					collisionBL2[i] = Collision_Detection.CollisionDetection2(B_x[i], B_y[i], B_h[i], B_w[i], D_platforms_x_2[j],
							D_platforms_y_2[j], D_platforms_w_2[j], D_platforms_h_2[j]);
					if (collisionBL2[i] == true) {
							draw_B[i] = false;
					}
				}
				}
				//Platform cycle one collision for arrow
				if (draw_a == true && DP_cycle_1 == true) {
					for (int i = 0; i < D_platforms_x_1.length; i++) {
						collision = Collision_Detection.CollisionDetection2(a_x, a_y, a_w, a_h, D_platforms_x_1[i], D_platforms_y_1[i],
								D_platforms_w_1[i], D_platforms_h_1[i]);
						if (collision == true) {
							draw_a = false;
						}
					}
				}
				//Platform cycle two collision for arrow
				if (draw_a == true && DP_cycle_2 == true) {
					for (int i = 0; i < D_platforms_x_2.length; i++) {
						collision = Collision_Detection.CollisionDetection2(a_x, a_y, a_w, a_h, D_platforms_x_2[i], D_platforms_y_2[i],
								D_platforms_w_2[i], D_platforms_h_2[i]);
						if (collision == true) {
							draw_a = false;
						}
					}
				}
				
				
				//Jump pad
				
				c.drawImage(Jump_pad,JP_x[0], JP_y[0], JP_w[0], JP_h[0]);		
				//Detects collision with main character
				for (int i = 0; i < JP_x.length; i++) {
					collisionB[i] = Collision_Detection.CollisionDetection(Main_x, Main_y, Main_h, Main_w, JP_x[i],
							JP_y[i], JP_w[i], JP_h[i]);
					//if collision is true with left or right reverse the movment
					if (collisionB[i] == true) {
						if (Collision_Detection.d2 == 0) {
							//Left-collision
							speedX += speed;
							a_x += speed;
							LastX += speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] += speed;
							}
							for (int k= 0; k < spikes_x.length; k++) {
								spikes_x[k] += speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] += speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] += speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x += speed;
								e[k].b_x += speed;
							}
							for (int k = 0; k < T_x.length; k++) {
							T_x[k] += speed;
							}
							for (int k = 0; k < B_x.length; k++) {
							B_x[i] += speed;
							}
							for (int k = 0; k < K_x.length; k++) {
							K_x[k] += speed;
							}
							for (int k= 0; k < JP_x.length; k++) {
							JP_x[k] += speed;
							}
							for (int k = 0; k < D_platforms_x_1.length; k++) {
							D_platforms_x_1[k] += speed;
							}
							for (int k = 0; k < D_platforms_x_2.length; k++) {
							D_platforms_x_2[k] += speed;
							}
						}
						if (Collision_Detection.d2 == 2) {
							//right-collision
							speedX -= speed;
							a_x -= speed;
							LastX -= speed;
							for (int k = 0; k < block_x.length; k++) {
								block_x[k] -= speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_x[k] -= speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_x[k] -= speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_x[k] -= speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_x -= speed;
								e[k].b_x -= speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_x[k] -= speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_x[k] -= speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_x[k] -= speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_x[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_1.length; k++) {
								D_platforms_x_1[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_x_2[k] -= speed;
								}
						}
						//if collision is bottom reverse it
						if (Collision_Detection.d2 == 1) {
							//bottom-nothing
							speedY -= speed;
							a_y -= speed;
							LastY -= speed;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] -= speed;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] -= speed;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] -= speed;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] -= speed;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y -= speed;
								e[k].b_y -= speed;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] -= speed;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] -= speed;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] -= speed;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] -= speed;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] -= speed;
								}
								for (int k = 0; k < D_platforms_x_2.length; k++) {
								D_platforms_y_2[k] -= speed;
								}
							jumpCount = 60;
						}
						//if there is collision with top bounce
						if (Collision_Detection.d2 == 3) {
							JP_active = true;
							speedY += NVelocY;
							a_y += NVelocY;
							LastY += NVelocY;
							for (int k = 0; k < block_x.length; k++) {
								block_y[k] += NVelocY;
							}
							for (int k = 0; k < spikes_x.length; k++) {
								spikes_y[k] += NVelocY;
							}
							for (int k = 0; k < ladder_x.length; k++) {
								ladder_y[k] += NVelocY;
							}
							for (int k = 0; k < checkpoint_x.length; k++) {
								checkpoint_y[k] += NVelocY;
							}
							for (int k = 0; k < e.length; k++) {
								e[k].e_y += NVelocY;
								e[k].b_y += NVelocY;
							}
							for (int k = 0; k < T_x.length; k++) {
								T_y[k] += NVelocY;
								}
								for (int k = 0; k < B_x.length; k++) {
								B_y[k] += NVelocY;
								}
								for (int k = 0; k < K_x.length; k++) {
								K_y[k] += NVelocY;
								}
								for (int k = 0; k < JP_x.length; k++) {
								JP_y[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_1.length; k++) {
								D_platforms_y_1[k] += NVelocY;
								}
								for (int k = 0; k < D_platforms_y_2.length; k++) {
								D_platforms_y_2[k] += NVelocY;
								}
							Jumping.jump = true;
							jumpable = true;
						}
					}
				}
				
			
				// Jumping while on jump pad
				if (JP_active == true) {
					
				jumpDS = 90 / speed;
				
				if (Jumping.jump == true && jumpCount < jumpDS) {
					jumpable = false;
					speedY += speed * 4;
					a_y += speed * 4;
					LastY += speed * 4;
					for (int k = 0; k < block_x.length; k++) {
						block_y[k] += speed * 4;
					}
					for (int k = 0; k < spikes_x.length; k++) {
						spikes_y[k] += speed * 4;
					}
					for (int k = 0; k < ladder_x.length; k++) {
						ladder_y[k] += speed * 4;
					}
					for (int k = 0; k < checkpoint_x.length; k++) {
						checkpoint_y[k] += speed * 4;
					}
					for (int k = 0; k < e.length; k++) {
						e[k].e_y += speed * 4;
						e[k].b_y += speed * 4;
					}
					for (int k = 0; k < T_y.length; k++) {
						T_y[k] += speed * 4;
						}
						for (int k = 0; k < B_y.length; k++) {
						B_y[k] += speed * 4;
						}
						for (int k = 0; k < K_y.length; k++) {
						K_y[k] += speed * 4;
						}
						for (int k = 0; k < JP_y.length; k++) {
						JP_y[k] += speed * 4;
						}
						for (int k = 0; k < D_platforms_y_1.length; k++) {
						D_platforms_y_1[k] += speed * 4;
						}
						for (int k = 0; k < D_platforms_y_2.length; k++) {
						D_platforms_y_2[k] += speed * 4;
						}
					jumpCount++;
					
				}
				}
				// Jumping while not on jump pad
				if (JP_active == false) {
					jumpDS = 90 / speed;
					if (Jumping.jump == true && jumpCount < jumpDS) {
						jumpable = false;
						speedY += speed * 2;
						a_y += speed * 2;
						LastY += speed * 2;
						for (int k = 0; k < block_x.length; k++) {
							block_y[k] += speed * 2;
						}
						for (int k = 0; k < spikes_x.length; k++) {
							spikes_y[k] += speed * 2;
						}
						for (int k = 0; k < ladder_x.length; k++) {
							ladder_y[k] += speed * 2;
						}
						for (int k = 0; k < checkpoint_x.length; k++) {
							checkpoint_y[k] += speed * 2;
						}
						for (int k = 0; k < e.length; k++) {
							e[k].e_y += speed * 2;
							e[k].b_y += speed * 2;
						}
						for (int k = 0; k < T_y.length; k++) {
							T_y[k] += speed * 2;
							}
							for (int k = 0; k < B_y.length; k++) {
							B_y[k] += speed * 2;
							}
							for (int k = 0; k < K_y.length; k++) {
							K_y[k] += speed * 2;
							}
							for (int k = 0; k < JP_y.length; k++) {
							JP_y[k] += speed * 2;
							}
							for (int k = 0; k < D_platforms_y_1.length; k++) {
							D_platforms_y_1[k] += speed * 2;
							}
							for (int k = 0; k < D_platforms_y_2.length; k++) {
							D_platforms_y_2[k] += speed * 2;
							}
						jumpCount++;
						
					}
				}
					
				
					
	
					
				//stops jumping once time limit has been met
				if (Jumping.jump == true && jumpCount >= jumpDS) {
					Jumping.jump = false;
					JP_active = false;
					jumpCount = 0;
				}
				// Gravity
				speedY -= NVelocY;
				a_y -= NVelocY;
				LastY -= NVelocY;
				for (int k = 0; k < block_x.length; k++) {
					block_y[k] -= NVelocY;
				}
				for (int k = 0; k < spikes_x.length; k++) {
					spikes_y[k] -= NVelocY;
				}
				for (int k = 0; k < ladder_x.length; k++) {
					ladder_y[k] -= NVelocY;
				}
				for (int k = 0; k < checkpoint_x.length; k++) {
					checkpoint_y[k] -= NVelocY;
				}
				for (int k = 0; k < e.length; k++) {
					e[k].e_y -= NVelocY;
					e[k].b_y -= NVelocY;
				}
				for (int k = 0; k < T_y.length; k++) {
					T_y[k] -= NVelocY;
					}
					for (int k = 0; k < B_y.length; k++) {
					B_y[k] -= NVelocY;
					}
					for (int k = 0; k < K_y.length; k++) {
					K_y[k] -= NVelocY;
					}
					for (int k = 0; k < JP_y.length; k++) {
					JP_y[k] -= NVelocY;
					}
					for (int k = 0; k < D_platforms_y_1.length; k++) {
					D_platforms_y_1[k] -= NVelocY;
					}
					for (int k = 0; k < D_platforms_y_2.length; k++) {
					D_platforms_y_2[k] -= NVelocY;
					}
			}
			// If there is collision with any of the spikes go back to the last checkpoint
			for (int i = 0; i < collisionS.length; i++) {
				if (collisionS[i] == true) {
					c.clear();
					Thread.sleep(200);
					speedY -= LastY;
					a_y -= LastY;
					for (int k = 0; k < block_x.length; k++) {
						block_y[k] -= LastY;
					}
					for (int k = 0; k < spikes_x.length; k++) {
						spikes_y[k] -= LastY;
					}
					for (int k = 0; k < ladder_x.length; k++) {
						ladder_y[k] -= LastY;
					}
					for (int k = 0; k < checkpoint_x.length; k++) {
						checkpoint_y[k] -= LastY;
					}
					for (int k = 0; k < e.length; k++) {
						e[k].e_y -= LastY;
						e[k].b_y -= LastY;
					}
					for (int k = 0; k < T_y.length; k++) {
						T_y[k] -= LastY;
						}
						for (int k = 0; k < B_y.length; k++) {
						B_y[k] -= LastY;
						}
						for (int k = 0; k < K_y.length; k++) {
						K_y[k] -= LastY;
						}
						for (int k = 0; k < JP_y.length; k++) {
						JP_y[k] -= LastY;
						}
						for (int k = 0; k < D_platforms_y_1.length; k++) {
						D_platforms_y_1[k] -= LastY;
						}
						for (int k = 0; k < D_platforms_y_2.length; k++) {
						D_platforms_y_2[k] -= LastY;
						}
					
					
					speedX -= LastX;
					a_x -= LastX;
					for (int k = 0; k < block_x.length; k++) {
						block_x[k] -= LastX;
					}
					for (int k = 0; k < spikes_x.length; k++) {
						spikes_x[k] -= LastX;
					}
					for (int k = 0; k < ladder_x.length; k++) {
						ladder_x[k] -= LastX;
					}
					for (int k = 0; k < checkpoint_x.length; k++) {
						checkpoint_x[k] -= LastX;
					}
					for (int k = 0; k < e.length; k++) {
						e[k].e_x -= LastX;
						e[k].b_x -= LastX;
					}
					for (int k = 0; k < T_y.length; k++) {
						T_x[k] -= LastX;
						}
						for (int k = 0; k < B_y.length; k++) {
						B_x[k] -= LastX;
						}
						for (int k = 0; k < K_y.length; k++) {
						K_x[k] -= LastX;
						}
						for (int k = 0; k < JP_y.length; k++) {
						JP_x[k] -= LastX;
						}
						for (int k = 0; k < D_platforms_y_1.length; k++) {
						D_platforms_x_1[k] -= LastX;
						}
						for (int k = 0; k < D_platforms_y_2.length; k++) {
						D_platforms_x_2[k] -= LastX;
						}
						for(int j = 0; j < B_x.length; j++) {
							draw_B[j] = false;
							B_x[j] = T_x[j];
							B_y[j] = T_y[j] + 20;
							}
					collisionS[i] = false;
					draw_a = false;
				}
			}
			// If there is collision with an enemy go back to the last checkpoint
						for (int i = 0; i < e.length; i++) {
							if (collisionE[i] == true) {
								c.clear();
								Thread.sleep(200);
								speedY -= LastY;
								a_y -= LastY;
								for (int k = 0; k < block_x.length; k++) {
									block_y[k] -= LastY;
								}
								for (int k = 0; k < spikes_x.length; k++) {
									spikes_y[k] -= LastY;
								}
								for (int k = 0; k < ladder_x.length; k++) {
									ladder_y[k] -= LastY;
								}
								for (int k = 0; k < checkpoint_x.length; k++) {
									checkpoint_y[k] -= LastY;
								}
								for (int k = 0; k < e.length; k++) {
									e[k].e_y -= LastY;
									e[k].b_y -= LastY;
								}
								for (int k = 0; k < T_y.length; k++) {
									T_y[k] -= LastY;
									}
									for (int k = 0; k < B_y.length; k++) {
									B_y[k] -= LastY;
									}
									for (int k = 0; k < K_y.length; k++) {
									K_y[k] -= LastY;
									}
									for (int k = 0; k < JP_y.length; k++) {
									JP_y[k] -= LastY;
									}
									for (int k = 0; k < D_platforms_y_1.length; k++) {
									D_platforms_y_1[k] -= LastY;
									}
									for (int k = 0; k < D_platforms_y_2.length; k++) {
									D_platforms_y_2[k] -= LastY;
									}
								LastY = 0;
								speedX -= LastX;
								a_x -= LastX;
								for (int k = 0; k < block_x.length; k++) {
									block_x[k] -= LastX;
								}
								for (int k = 0; k < spikes_x.length; k++) {
									spikes_x[k] -= LastX;
								}
								for (int k = 0; k < ladder_x.length; k++) {
									ladder_x[k] -= LastX;
								}
								for (int k = 0; k < checkpoint_x.length; k++) {
									checkpoint_x[k] -= LastX;
								}
								for (int k = 0; k < e.length; k++) {
									e[k].e_x -= LastX;
									e[k].b_x -= LastX;
								}
								for (int k = 0; k < T_y.length; k++) {
									T_x[k] -= LastX;
									}
									for (int k = 0; k < B_y.length; k++) {
									B_x[k] -= LastX;
									}
									for (int k = 0; k < K_y.length; k++) {
									K_x[k] -= LastX;
									}
									for (int k = 0; k < JP_y.length; k++) {
									JP_x[k] -= LastX;
									}
									for (int k = 0; k < D_platforms_y_1.length; k++) {
									D_platforms_x_1[k] -= LastX;
									}
									for (int k = 0; k < D_platforms_y_2.length; k++) {
									D_platforms_x_2[k] -= LastX;
									}
								LastX = 0;
										for(int j = 0; j < B_x.length; j++) {
										draw_B[i] = false;
										B_x[j] = T_x[j];
										B_y[j] = T_y[j] + 20;
										}
								collisionS[i] = false;
								draw_a = false;
								}
							}
			}
			//activate boss
			if(keycount == 4) {
				Boss_active = true;
			}
			
			
			//Boss

			
			if (Boss_active == true) {
				Thread.sleep(3);
				synchronized (c) {
					c.clear();

			
			//Movement
			Collision_Detection.d = 7;
			if (c.isKeyDown('W') && jumpable == true) {
				Collision_Detection.d = 1;
				Jumping.jump = true;
			
			} else if (c.isKeyDown('A')) {

		
				Main_x -= speed;
				Collision_Detection.d = 2;
			} else if (c.isKeyDown('D')) {
				Main_x += speed;
				Collision_Detection.d = 0;
		
			} else if (c.isKeyDown('S')) {
				Collision_Detection.d = 3;
		
			}
			
			// Detects collision with blocks and in true corrects it
			for (int i = 0; i < Boss_block_x.length; i++) {
				collisionB[i] = Collision_Detection.CollisionDetection(Main_x, Main_y, Main_h, Main_w, Boss_block_x[i],
						Boss_block_y[i], Boss_block_w[i], Boss_block_h[i]);
				if (collisionB[i] == true) {
					if (Collision_Detection.d2 == 0) {
						Main_x -= speed;
					}
					if (Collision_Detection.d2 == 2) {
						Main_x += speed;
					}
					if (Collision_Detection.d2 == 1) {
						Main_y += speed;
						jumpCount = 60;
					}
					if (Collision_Detection.d2 == 3) {
						Main_y -= NVelocY;
						jumpable = true;
					}
					collisionB[i] = false;
				}
			}
			// Draws all of the blocks/platforms
			for (int i = 0; i < Boss_block_x.length; i++) {
				c.fillRect(Boss_block_x[i], Boss_block_y[i], Boss_block_w[i], Boss_block_h[i]);
			}
			
																														
			if (c.isKeyDown('A')) {
				running = 1;
				Archer_L = 1;
				Archer_R = 0;
				Archer_idle = 1;
				 }
				 
			
			 if (c.isKeyDown('D')) {
			running = 1;
			Archer_L = 0;
			Archer_R = 1;
			Archer_idle = 1;
			 }
			 
			 else if( running == 0) {
				 Archer_idle = 0;
			 }
			 					
			 
			 
			 
			 
			// Draws main character
			c.setColor(new Color(0, 0, 200));
			MainXint = (int) Main_x;
			MainYint = (int) Main_y;
				
			//Archer running left
			if (Archer_L == 1 && running == 1) {
			
				if(Archer_walking_animation > 0 && Archer_walking_animation < 31) {
					
					c.drawImage(Archer_walking_1_L,MainXint, MainYint, Main_w, Main_h);
					Archer_walking_animation += 1;
				
					}
					if(Archer_walking_animation > 30 && Archer_walking_animation < 61) {
						
						c.drawImage(Archer_walking_2_L,MainXint, MainYint, Main_w, Main_h);
						Archer_walking_animation += 1;
				
						}
					if(Archer_walking_animation > 60 && Archer_walking_animation < 91) {
						
						c.drawImage(Archer_walking_3_L,MainXint, MainYint, Main_w, Main_h);
						Archer_walking_animation += 1;
					
						}
					if(Archer_walking_animation > 90 && Archer_walking_animation < 120) {
						
						c.drawImage(Archer_walking_4_L,MainXint, MainYint, Main_w, Main_h);
						
						Archer_walking_animation += 1;
						
						if(Archer_walking_animation == 120) {
						Archer_walking_animation = 1;
					}
				}
					
					running = 0;
													
			}
			
			
			//archer running right
			if (Archer_R == 1 && running == 1 ) {
				
				if(Archer_walking_animation > 0 && Archer_walking_animation < 31) {
					
					c.drawImage(Archer_walking_1_R,MainXint, MainYint, Main_w, Main_h);
					Archer_walking_animation += 1;
				
					}
					if(Archer_walking_animation > 30 && Archer_walking_animation < 61) {
						
						c.drawImage(Archer_walking_2_R,MainXint, MainYint, Main_w, Main_h);
						Archer_walking_animation += 1;
				
						}
					if(Archer_walking_animation > 60 && Archer_walking_animation < 91) {
						
						c.drawImage(Archer_walking_3_R,MainXint, MainYint, Main_w, Main_h);
						Archer_walking_animation += 1;
					
						}
					if(Archer_walking_animation > 90 && Archer_walking_animation < 120) {
						
						c.drawImage(Archer_walking_4_R,MainXint, MainYint, Main_w, Main_h);
						
						Archer_walking_animation += 1;
						
						if(Archer_walking_animation == 120) {
						Archer_walking_animation = 1;
					}
				}
					
					running = 0;
															
			}
			

			
			//archer idle left
			if (Archer_L == 1 && Archer_idle == 0 ) {
				
			c.drawImage(Archer_idle_L,MainXint, MainYint, Main_w, Main_h);
																						
			}
			
			//archer idle right
			if (Archer_R == 1 && Archer_idle == 0 ) {
				
				c.drawImage(Archer_idle_R,MainXint, MainYint, Main_w, Main_h);
																							
				}
																				
			c.setColor(new Color(0, 0, 0));
			// Jumping
			jumpDS = 120 / speed;
			if (Jumping.jump == true && jumpCount < jumpDS) {
				jumpable = false;
				Main_y = Main_y - (speed * 1.5);
				jumpCount++;
			}
			if (Jumping.jump == true && jumpCount >= jumpDS) {
				Jumping.jump = false;
				jumpCount = 0;
			}
			// Gravity
			Main_y = Main_y + NVelocY;
			// Makes sure that the main character doesn't go out of the border
			
			if (Main_x < 0) {
				Main_x = 0;
			}
			if (Main_x + Main_w > 1200) {
				Main_x = 1200 - Main_w;
			}
			if (Main_y < 0) {
				Main_y = 0;
			}
			if (Main_y + Main_h > 900) {
				Main_y = 900 - Main_h;
				
				
			}
			
			//Sets the direction that the arrow should travel
			if (Collision_Detection.d == 2) {
				a_d = 1;
			}
			if (Collision_Detection.d == 0) {
				a_d = 2;
			}
			// Draws arrow if space is down and the correct amount of time has passed set
			// draw arrow to true
			if (c.isKeyDown(' ') && a_c > 10) {
				if (a_d == 1) {
					a_d2 = 1;
				}
				if (a_d == 2) {
					a_d2 = 2;
				}
				a_c = 0;
				draw_a = true;
				a_x = (int) Main_x;
				a_y = (int) Main_y;
			}
			
			// Teleport
			if (draw_a == true && c.isKeyDown('S')) {
				Jump.jump = false;
				if (a_d2 == 1) {
					Main_x = a_x;
					Main_y = a_y;
					draw_a = false;
				}
				if (a_d2 == 2) {
					Main_x = a_x + a_w - Main_w;
					Main_y = a_y;
					draw_a = false;
				}
			}
			// If draw is true draw the arrow and move it the correct direction
			if (draw_a == true) {

			if (Archer_L == 1) {
				c.drawImage(Arrow_left,a_x, a_y, a_w, a_h);
			}
			
			if (Archer_R == 1) {
				c.drawImage(Arrow_right,a_x, a_y, a_w, a_h);
			}
			
				if (a_d2 == 1) {
					a_x -= 4;
				}
				if (a_d2 == 2) {
					a_x += 4;
				}
				// Once arrow has travel for a certain amount of time
				if (a_c > 300) {
					draw_a = false;
				}
			}
			a_c++;
			
			//Boss-arrow collision
			if(Boss_Charge_1 == false && Boss_Charge_2 == false) {
			for (int j = 0; j < Boss_block_x.length; j++) {
				collisionB[j] = Collision_Detection.CollisionDetection2(a_x, a_y, a_h, a_w, Boss_block_x[j],
						Boss_block_y[j], Boss_block_w[j], Boss_block_h[j]);
				if (collisionB[j] == true && Boss_Charge_1 == false && Boss_Charge_2 == false && Boss_Charge_3 == false) {
				Boss_Charge_1 = true;
				draw_a = false;

				}
			}
			}
			//Boss Movement
			if(Boss_Charge_1 == false && Boss_Charge_2 == false) {
				c.drawImage(Boss_idle_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
			}
			
			//First charge
			if(Boss_Charge_1 == true) {
				Boss_animation = Boss_animation + 1;
				if(Boss_vulnerable_1 == false) {
				if (Boss_animation > 0 && Boss_animation < 30 && Boss_x[0] < 800) {
					c.drawImage(Boss_charging_1_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 30 && Boss_animation < 60 && Boss_x[0] < 800) {
					c.drawImage(Boss_charging_2_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 60 && Boss_animation < 90 && Boss_x[0] < 800) {
					c.drawImage(Boss_charging_3_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 90 && Boss_animation < 120 && Boss_x[0] < 800) {
					c.drawImage(Boss_charging_4_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 120) {
					Boss_animation = 0;
				}
				if (Boss_x[0] < 800) {
				Boss_x[0] += 2;
				}
				if (Boss_x[0] == 800) {
				Boss_vulnerable_1 = true;
				}
				}
				if (Boss_vulnerable_1 == true) {
					if (Boss_animation > 0 && Boss_animation < 30 ) {
						c.drawImage(Boss_hurt_1_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation > 30 && Boss_animation < 60 ) {
						c.drawImage(Boss_hurt_2_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation > 60 && Boss_animation < 90 ) {
						c.drawImage(Boss_hurt_3_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation > 90 && Boss_animation < 120 ) {
						c.drawImage(Boss_hurt_4_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation >= 119) {
						Boss_vulnerable_1 = false;
						Boss_Charge_1 = false;
						Boss_Charge_2 = true;
						Boss_Charge_2_L = true;
						Boss_animation = 0;
						}
				}
				
				//arrow-boss collision
				for (int j = 0; j < Boss_block_x.length; j++) {
					collisionB[j] = Collision_Detection.CollisionDetection2(a_x, a_y, a_h, a_w, Boss_block_x[j],
							Boss_block_y[j], Boss_block_w[j], Boss_block_h[j]);
					if (collisionB[j] == true && Boss_vulnerable_1 == true) {
						Boss_animation = 0;
						a_x = 0;
						a_y = 0;
						Boss_HitCount += 1;
						Boss_vulnerable_1 = false;
						draw_a = false;
						Boss_Charge_1 = false;
						Boss_Charge_2 = true;
						Boss_Charge_2_L = true;
						Boss_animation = 0;

					}
				}				
			}
		
			
			//Second charge
			if(Boss_Charge_2 == true) {
				Boss_animation = Boss_animation + 1;
				
				//First Charge
				
				if(Boss_Charge_2_L == true) {
					if(Boss_vulnerable_2 == false) {
				if (Boss_animation > 0 && Boss_animation < 30 && Boss_x[0] > 0) {
					c.drawImage(Boss_charging_1_L, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 30 && Boss_animation < 60 && Boss_x[0] > 0) {
					c.drawImage(Boss_charging_2_L, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 60 && Boss_animation < 90 && Boss_x[0] > 0) {
					c.drawImage(Boss_charging_3_L, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 90 && Boss_animation < 120 && Boss_x[0] > 0) {
					c.drawImage(Boss_charging_4_L, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
					}
				if (Boss_animation > 120) {
					Boss_animation = 0;
				}
				if (Boss_x[0] > 0) {
				Boss_x[0] -= 2;
				}
				if (Boss_x[0] == 0) {
				Boss_vulnerable_2 = true;
				}
				}
				}
				if (Boss_vulnerable_2 == true) {
					if (Boss_animation > 0 && Boss_animation < 30 ) {
						c.drawImage(Boss_hurt_1_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation > 30 && Boss_animation < 60 ) {
						c.drawImage(Boss_hurt_2_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation > 60 && Boss_animation < 90 ) {
						c.drawImage(Boss_hurt_3_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation > 90 && Boss_animation < 120 ) {
						c.drawImage(Boss_hurt_4_R, Boss_x[0] ,Boss_y[0],Boss_w[0],Boss_h[0]);
						}
					if (Boss_animation >= 119) {
						Boss_Charge_2 = false;
						Boss_Charge_1 = true;
						}
				}
				//Arrow-boss collision
				for (int j = 0; j < Boss_block_x.length; j++) {
					collisionB[j] = Collision_Detection.CollisionDetection2(a_x, a_y, a_h, a_w, Boss_block_x[j],
							Boss_block_y[j], Boss_block_w[j], Boss_block_h[j]);
					if (collisionB[j] == true &&Boss_vulnerable_2 == true ) {
						Boss_Charge_2_L =false;
						Boss_animation = 0;
						a_x = 0;
						a_y = 0;
						Boss_HitCount += 1;
						Boss_vulnerable_2 = false;
						draw_a = false;
						Boss_Charge_2 = false;
						Boss_Charge_1 = true;
					}
				}				
			}						
			
			
			c.print("hits needed for boss kill " + Boss_HitCount + "/4");
				}
				//Boss death
				if(Boss_HitCount == 4) {
					Boss_Charge_2=false;
					Boss_Charge_1=false;
					c.clear();
					c.println("you win");
					c.println("good job");
					Thread.sleep(20000);
						}
			}												
		}
	}
}
