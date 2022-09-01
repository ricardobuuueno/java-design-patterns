package my.project.abstract_factory;

public class GoogleCloudStorage implements Storage {

	public GoogleCloudStorage(int capacityInMib) {
		System.out.println("Allocated "+capacityInMib+" on Google Cloud Storage");
	}
	
	@Override
	public String getId() {
		return "gcpcs1";
	}

	@Override
	public String toString() {
		return "Google cloud storage";
	}

}
