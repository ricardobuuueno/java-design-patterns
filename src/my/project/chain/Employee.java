package my.project.chain;

public abstract class Employee implements LeaveApprover {

	private String role;

	private LeaveApprover successor;
	
	public Employee(String role, LeaveApprover successor) {
		this.role = role;
		this.successor = successor;
	}
	
	protected abstract boolean processRequest(LeaveApplication application);

	@Override
	public void processLeaveApplication(LeaveApplication application) {
		if (!processRequest(application) && this.successor != null) {
			this.successor.processLeaveApplication(application);
		}
	}
	
	@Override
	public String getApproverRole() {
		return this.role;
	}

}
