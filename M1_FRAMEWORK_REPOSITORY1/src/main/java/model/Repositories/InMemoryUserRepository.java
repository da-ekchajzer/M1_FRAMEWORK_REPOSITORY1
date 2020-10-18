package model.Repositories;

import java.util.ArrayList;
import java.util.List;

import model.generated.User;

public class InMemoryUserRepository implements UserRepository {
	List<User> users;

	public InMemoryUserRepository(List<User> u) {
		this.users = u;
	}

	@Override
	public User getUserById(int UserId) {
		return users.get(UserId);
	}

	@Override
	public List<User> getUsersByName(String userName) {
		List<User> usersByName = new ArrayList<User>();
		for (User u : users) {
			if (u.getName() == userName) {
				usersByName.add(u);
			}
		}
		return usersByName;
	}

	@Override
	public List<User> getUsersByCountryName(String userCountry) {
		List<User> usersByCountryName = new ArrayList<User>();
		for (User u : users) {
			if (u.getAddress().getCountry().getName() == userCountry) {
				usersByCountryName.add(u);
			}
		}
		return usersByCountryName;
	}

	@Override
	public User saveUser(User u) {
		u.setId(users.size() - 1);
		users.add(u);
		return u;
	}

	@Override
	public boolean deleteUser(User u) {
		return users.remove(u);
	}

}
