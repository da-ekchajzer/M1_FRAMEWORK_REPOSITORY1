package model.Repositories;

import java.util.List;

import javax.persistence.EntityManager;

import model.generated.User;

public class UserRepositoryBDD implements UserRepository {

	private EntityManager entityManager;

	public UserRepositoryBDD(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	public User getUserById(int UserId) {
		return entityManager.find(User.class, UserId);
	}

	@Override
	public List<User> getUsersByName(String userName) {
		return entityManager.createQuery("Select u from User u where u.name = :userName", User.class)
				.setParameter("userName", userName).getResultList();
	}

	@Override
	public List<User> getUsersByCountryName(String userCountry) {
		return entityManager.createQuery(
				"Select u from User u, Country c, Address a where u.address = a.id AND a.country = c.id AND c.name = :test",
				User.class).setParameter("test", userCountry).getResultList();
	}

	@Override
	public User saveUser(User u) {

		if (u.getId() == 0) {
			entityManager.persist(u);
		} else {
			u = entityManager.merge(u);
		}
		return u;
	}

	@Override
	public boolean deleteUser(User u) {
		if(entityManager.contains(u)) {
			entityManager.remove(u);
			return true;
		}
		return false;
	}

}
