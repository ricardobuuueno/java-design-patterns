package my.project.object_pool;

public class ObjectPoolClient {

	public static final ObjectPool<Bitmap> bitmapPool = new ObjectPool<>(()->new Bitmap("Logo.bmp"), 5);
	
}
