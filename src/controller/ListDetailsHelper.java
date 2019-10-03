package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;
import model.ListDetails;

public class ListDetailsHelper {

	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("ConsoleCarMenu");
	
	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
	
	public ListDetails searchForListById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, idToEdit);
		em.close();
		return found;
	}
	
	public void deleteList(ListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("select l from ListDetails l where l.listName = :selectedName", ListDetails.class);
		typedQuery.setParameter("selectedName", toDelete.getListName());
		//typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		//typedQuery.setParameter("selectedDate", toDelete.getSellDate());
		typedQuery.setMaxResults(1);
		ListDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
