package my.project.adapter;

public class AdapterClient {

	public AdapterClient() {
		
	}
	
	public static void populateEmployeeData(Employee emp) {
		emp.setFullName("Elliot Alderson");
		emp.setJobTitle("Security Engineer");
		emp.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
	
}
