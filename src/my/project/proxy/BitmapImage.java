package my.project.proxy;

import java.awt.geom.Point2D;

public class BitmapImage implements Image {

	private Point2D location;
	private String name;
	
	public BitmapImage(String filename) {
		System.out.println("Loaded from disk: "+filename);
		this.name = filename;
	}
	
	
	@Override
	public void setLocation(Point2D point2d) {
		location = point2d;
	}

	@Override
	public Point2D getLocation() {
		return location;
	}

	@Override
	public void render() {
		System.out.println("Rendered " + this.name);
	}

}
