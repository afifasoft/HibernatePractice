package com.dubai.demonew;

import com.dubai.demonew.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemonewApplicationTests {

	Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private EntityManager em;

	@Test
	public void accessHibernateSession() {
		log.info("... accessHibernateSession ...");

		Author author = new Author();
		author.setFirstName("Harshith");
		author.setLastName("Bannange");

		em.persist(author);
	}

	@Test
	public void contextLoads() {
	}

}
