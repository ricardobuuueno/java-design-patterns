package my.project.proxy;

import java.awt.geom.Point2D;

public class ImageProxy implements Image {

	private String name;
	
	private BitmapImage image;
	
	private Point2D location;
	
	public ImageProxy(String name) {
		this.name = name;
	}
	
	@Override
	public void setLocation(Point2D point2d) {
		if (image != null) {
			image.setLocation(point2d);
		} else {
			location = point2d;
		}
	}

	@Override
	public Point2D getLocation() {
		if (image != null) {
			return image.getLocation();
		} else {
			return location;
		}
	}

	@Override
	public void render() {
		if (image == null) {
			image = new BitmapImage(name);
			if (location != null) {
				image.setLocation(location);
			}
		}
		image.render();
	}

}
