package model.Repositories;

import java.util.List;

import model.generated.User;

public interface UserRepository {
	
	public User getUserById(int UserId);
	List<User> getUsersByName(String userName);
	List<User> getUsersByCountryName(String userCountry);
	User saveUser(User u);
	boolean deleteUser(User u);	
}
