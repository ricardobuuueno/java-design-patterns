package my.project;

import my.project.builder.*;
import my.project.factory_method.*;
import my.project.simple_factory.*;

public class MainClass {

	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg);
	}
	
	public static void main(String[] args) {

		System.out.println("\nBuilder");
		User user = BuilderDirector.createUser();
		UserDTOBuilder builder = new UserWebDTOBuilder();
		
		UserDTO dto = BuilderDirector.directBuild(builder, user);
		System.out.println(dto);

		System.out.println("\nSimple factory");
		Post post = PostFactory.createPost("news");
		System.out.println(post);
		
		System.out.println("\nFactory method");
		printMessage(new JSONMessageCreator());
		printMessage(new TextMessageCreator());
	}

}
