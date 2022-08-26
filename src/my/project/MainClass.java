package my.project;

import my.project.builder.*;

public class MainClass {

	public static void main(String[] args) {
		User user = Builder.createUser();
		UserDTOBuilder builder = new UserWebDTOBuilder();
		
		UserDTO dto = Builder.directBuild(builder, user);
		System.out.println(dto);
	}

}
