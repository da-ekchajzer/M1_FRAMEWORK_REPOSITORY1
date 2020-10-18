import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import model.Repositories.InMemoryUserRepository;
import model.Repositories.UserRepository;
import model.generated.Address;
import model.generated.Country;
import model.generated.User;

class RepoTest {
	public List<User> users;
	public UserRepository userRepo;

	void initRepo() {
		users = new ArrayList<User>();
		userRepo = new InMemoryUserRepository(users);

		Country c1 = new Country();
		c1.setIdCountry(1);
		c1.setName("France");
		
		Address a1 = new Address();
		a1.setId(1);
		a1.setStreetName("Elysée");
		a1.setZipCode("75001");
		a1.setCountry(c1);
		
		User manu = new User();
		manu.setName("manu");
		manu.setAddress(a1);
		
		userRepo.saveUser(manu);
	}
	
	@Test
	void caseTest1() {
		initRepo();
		
		assertEquals("manu", userRepo.getUserById(0).getName());
		assertEquals("manu", userRepo.getUsersByCountryName("France").get(0).getName());
		assertTrue(userRepo.deleteUser(userRepo.getUserById(0)));
	}

}
