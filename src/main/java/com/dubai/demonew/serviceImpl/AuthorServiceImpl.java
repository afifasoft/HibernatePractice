package com.dubai.demonew.serviceImpl;

import com.dubai.demonew.model.Author;
import com.dubai.demonew.service.AuthorService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataSourcesContributor;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Service
public class AuthorServiceImpl implements AuthorService {

    private EntityManagerFactory emf;

    private Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Override
    public void createUpdateRemove() {

        EntityManager em  = emf.createEntityManager();
        em.getTransaction().begin();

        Author au = new Author();
        au.setFirstName("Andrew");
        au.setLastName("mead");

        em.persist(au);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        au = em.find(Author.class, 1L);
        au.setFirstName("Stephen");

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        au = em.find(Author.class, 1L);
        em.remove(au);

        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void emFind() {
        log.info("....emFind.....");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Author author = em.find(Author.class, 1L);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void jpql() {
        log.info("...jpql...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Author> query = em.createQuery("SELECT a FROM author a WHERE a.firstName = :fname", Author.class)
                .setParameter("fname", "Andrew");

        Author author = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void nativeQuery() {
        log.info("......nativeQuery....");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNativeQuery("SELECT a FROM author a WHERE a.firstName = :fname", Author.class);
        query.setParameter("fname", "Andrew");

        Author author = (Author) query.getSingleResult();

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void bootstrapping() {
        log.info("....bootstrapping ....");
        log.info("for hibernate.cfg.xml '''");
        ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory sessionFactory = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Author.class).buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author author = new Author();
        author.setFirstName("Abdul");
        author.setLastName("Atif");
        session.persist(author);
        session.getTransaction().commit();
        session.close();
    }
}
