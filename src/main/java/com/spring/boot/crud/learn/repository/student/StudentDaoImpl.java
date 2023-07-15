package com.spring.boot.crud.learn.repository.student;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.spring.boot.crud.learn.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

    //define field for entity manager
    private EntityManager entityManager;
    
    //inject entity manager using constructors injection
    //@Autowired
    public StudentDaoImpl(EntityManager manager) {
	this.entityManager = manager;
    }
    
    @Override
    @Transactional
    public int save(Students student) {
	int result = 0;
	try {
	    entityManager.persist(student);
	}catch (Exception e) {
	    result = 1;
	}
	return result;
    }

    @Override
    public Students findById(Integer id) {
	return entityManager.find(Students.class, id);
    }

    @Override
    public List<Students> findAll() {
	
//	String normalQuery = "FROM students";
	String sortQuery = " FROM students order by lastName asc";
	
	TypedQuery<Students> query = entityManager.createQuery("FROM students", Students.class);
	System.out.println("finall");
	System.out.println(query.getMaxResults());
	
	return query.getResultList();
    }

    @Override
    public Students findByName(String name) {
	
	String strQuery = " FROM students WHERE lastName=:name";
	TypedQuery<Students> query = entityManager.createQuery(strQuery, Students.class);
	query.setParameter("name", name);
	
	return query.getSingleResult();
    }

    @Override
    @Transactional
    public int update(Students student) {
	int result = 0;
	try {
	    entityManager.merge(student);
	}catch (Exception e) {
	    result = -1;
	}
	return result;
    }

    @Override
    @Transactional
    public int delete(int id) {
	int result =0;
	try {
	    Students student = entityManager.find(Students.class, id);
	    entityManager.remove(student);
	}catch (Exception e) {
	   result = -1;
	}
	return result;
    }

    @Override
    @Transactional
    public int deleteAll() {
	int result = 1;
	try {
	    String strQuery = " DELETE FROM students";
	    result = entityManager.createNamedQuery(strQuery).executeUpdate();
	}catch (Exception e) {
	    result = -1;
	}
	return result;
    }

}
