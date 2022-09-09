package my.project.chain;

import my.project.chain.LeaveApplication.Type;

public class Director extends Employee {

	public Director(LeaveApprover successor) {
		super("Director", successor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean processRequest(LeaveApplication application) {
		if (application.getType() == Type.PTO) {
			application.approve(getApproverRole());
			return true;
		}
		return false;
	}
	
	

}
