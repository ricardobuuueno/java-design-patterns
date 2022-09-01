package my.project.abstract_factory;

public class AbstractFactoryClient {

	private ResourceFactory factory;
	
	public AbstractFactoryClient(ResourceFactory factory) {
		this.factory = factory;
	}
	
	public Instance createServer(Instance.Capacity cap, int storageMib) {
		Instance instance = factory.createInstance(cap);
		Storage storage = factory.createStorage(storageMib);
		instance.attachStorage(storage);
		return instance;
	}
	
}
