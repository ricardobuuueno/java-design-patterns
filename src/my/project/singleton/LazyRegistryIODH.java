package my.project.singleton;

public class LazyRegistryIODH {

	private LazyRegistryIODH() {
		System.out.println("In LazyRegistryIODH singleton");
	}
	
	private static class RegistryHolder {
		static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
	}
	
	public static LazyRegistryIODH getInstance() {
		return RegistryHolder.INSTANCE;
	}
	
}
