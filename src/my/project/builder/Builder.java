package my.project.builder;

import java.time.LocalDate;

public class Builder {

	public static UserDTO directBuild(UserDTOBuilder builder, User user) {
		return builder.withFirstName(user.getFirstName())
					  .withLastName(user.getLastName())
					  .withAddress(user.getAddress())
					  .withBirthday(user.getBirthday())
					  .build();
	}
	
	public static User createUser() {
		
		User user = new User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ricardo");
		user.setLastName("Bueno");
		
		Address address = new Address();
		address.setHouseNumber("342");
		address.setStreet("Numbaya Street");
		address.setCity("Ohayo");
		address.setState("Sao Paulo");
		address.setZipcode("349354");
		user.setAddress(address);
		
		return user;
		
	}
	
}
