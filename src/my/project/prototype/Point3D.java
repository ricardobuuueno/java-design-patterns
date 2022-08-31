package my.project.prototype;

public class Point3D {

	private float x;
	private float y;
	private float z;
	
	public Point3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static final Point3D ZERO = new Point3D(0,0,0);

	public Point3D normalize() {
		return this;
	}

	public Point3D multiply(float distance) {
		return new Point3D(x * distance, y * distance, z * distance);
	}

	public Point3D add(Point3D finalMove) {
		x += finalMove.x;
		y += finalMove.y;
		z += finalMove.z;
		return this;
	}

	@Override
	public String toString() {
		return "Point3D [x = "+x+", y = "+y+", z = "+z+"]";
	}

}
