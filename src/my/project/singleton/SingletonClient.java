package my.project.singleton;

public class SingletonClient {

	public SingletonClient() {
		EagerRegistry registry = EagerRegistry.getInstance();
		EagerRegistry registry2 = EagerRegistry.getInstance();
		System.out.println(registry == registry2);
		
		LazyRegistryWithDCL lz1 = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL lz2 = LazyRegistryWithDCL.getInstance();
		System.out.println(lz1 == lz2);
	}
	
}
