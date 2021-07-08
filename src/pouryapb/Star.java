package pouryapb;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Star {

	public float x, y, z, pz;
	
	Star(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		pz = z;
	}
	
	public void update() {
		pz = z;
		z -= 10;
		if (z < 1) {
			z = StarTrace.WIDTH;
			x = new Random().nextInt(StarTrace.WIDTH * 2) - StarTrace.WIDTH;
			y = new Random().nextInt(StarTrace.HEIGHT * 2) - StarTrace.HEIGHT;
			pz = z;
		}
	}
	
	public void show(Graphics g) {
		
		float sx = map(x / z, 0, 1, 0, StarTrace.WIDTH);
		float sy = map(y / z, 0, 1, 0, StarTrace.HEIGHT);
		float px = map(x / pz, 0, 1, 0, StarTrace.WIDTH);
		float py = map(y / pz, 0, 1, 0, StarTrace.HEIGHT);
		
		g.setColor(Color.white);

//		float r = map(z, 0, StarTrace.WIDTH, 6, 0);
//		g.fillOval((int)sx, (int)sy, (int)r, (int)r);
		g.drawLine((int)px, (int)py, (int)sx, (int)sy);
		
	}
	
	public static float map(float input, float inputRangeA, float inputRangeB, float outputRangeA, float outputRangeB) {
		return (input - inputRangeA) / (inputRangeB - inputRangeA) * (outputRangeB - outputRangeA) + outputRangeA;
	}
}
