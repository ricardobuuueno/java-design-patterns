package my.project.interpreter;

public class Report {

	private String name;
	
	private String permission;
	
	public Report(String name, String permissions) {
		this.name = name;
		this.permission = permissions;
	}

	public String getName() {
		return name;
	}	
	
	public String getPermission() {
		return permission;
	}	
	
}
