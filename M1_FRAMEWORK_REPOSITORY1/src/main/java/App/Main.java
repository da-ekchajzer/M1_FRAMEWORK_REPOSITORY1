package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Repositories.UserRepository;
import model.Repositories.UserRepositoryBDD;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M1_FRAMEWORK_REPOSITORY1");
		EntityManager em = emf.createEntityManager();
		
		UserRepository userRepo = new UserRepositoryBDD(em);
		
		System.out.println(userRepo.getUserById(1).getName());
		System.out.println(userRepo.getUsersByCountryName("France").get(0).getName());
		System.out.println(userRepo.getUsersByCountryName("UK").get(0).getName());
		
		em.close();
	}

}
