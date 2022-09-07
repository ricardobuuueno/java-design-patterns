package my.project.proxy;

import java.lang.reflect.Proxy;

public class ImageFactory {

	public static Image getImage(String name) {
		return new ImageProxy(name);
	}
	
	public static Image getDynamicImage(String name) {
		return (Image)Proxy.newProxyInstance(
				ImageFactory.class.getClassLoader(), 
				new Class[] {Image.class}, 
				new ImageInvocationHandler(name)
			);
	}
	
}
