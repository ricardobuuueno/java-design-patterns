package my.project.abstract_factory;

public interface Instance {

	enum Capacity {micro, small, large}
	
	void start();
	
	void attachStorage(Storage storage);
	
	void stop();
	
}
