package my.project.object_pool;

public interface Image extends Poolable {

	void draw();
	
	Point2D getLocation();
	
	void setLocation(Point2D location);
	
}
