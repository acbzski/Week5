package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

public class CarHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCarMenu");
	
	public void insertItem(Car c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Car> showAllCars() {
		EntityManager em = emfactory.createEntityManager();
		List<Car> allCars = em.createQuery("SELECT c FROM Car c").getResultList();
		return allCars;
	}
	
	public void deleteCar(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.make = :selectedMake and c.model = :selectedModel and c.year = :selectedYear", Car.class);
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setMaxResults(1);
		Car result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Car searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Car toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Car> searchForCarByMake(String makeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.make = :selectedMake", Car.class);
		typedQuery.setParameter("selectedMake", makeName);
		List<Car> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}

	public List<Car> searchForCarByModel(String modelName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.model = :selectedModel", Car.class);
		typedQuery.setParameter("selectedModel", modelName);
		List<Car> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}
	
	public List<Car> searchForCarByYear(int year) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.year = :selectedYear", Car.class);
		typedQuery.setParameter("selectedYear", year);
		List<Car> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
