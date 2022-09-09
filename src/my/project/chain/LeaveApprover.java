package my.project.chain;

public interface LeaveApprover {

	void processLeaveApplication(LeaveApplication application);
	
	String getApproverRole();
	
}
