package game.asteroids;

import org.joml.Vector2f;

public class MathHelper {
	public static float toroidalDistance(Vector2f a, Vector2f b, float width, float height) {
		float dx = Math.abs(a.x - b.x);
		float dy = Math.abs(a.y - b.y);

		if (dx > width / 2.0f )
			dx = width - dx;
		if (dy > height / 2.0f )
			dy = height - dy;

		return (float)Math.sqrt(dx * dx + dy * dy);
	}

	public static float distance(float x1, float y1, float x2, float y2){
		return (float)Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static boolean pointIntersectsCircle(float x, float y, float c_x, float c_y, float radius){
		return distance(x, y, c_x, c_y) <= radius;
	}

	public static boolean rectIntersectsCircle(float rx1, float ry1, float rx2, float ry2, float cx, float cy, float radius){
		float dx = cx - Math.max(rx1, Math.min(cx, rx2));
		float dy = cy - Math.max(ry1, Math.min(cy, ry2));
		return (dx * dx + dy * dy) < radius * radius;
	}
}
