package my.project.object_pool;

public class Point2D extends java.awt.geom.Point2D {

	private double x;
	private double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;		
	}
	
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2D [x = "+x+", y = "+y+"]";
	}

}
