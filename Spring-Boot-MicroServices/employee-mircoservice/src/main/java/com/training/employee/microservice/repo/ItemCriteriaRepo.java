package com.training.employee.microservice.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.training.employee.microservice.entity.Item;

@Repository
public class ItemCriteriaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Item> buildQuery() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
		Root<Item> itemRoot = criteriaQuery.from(Item.class);
		Predicate predicateForBlueColor
		  = criteriaBuilder.equal(itemRoot.get("color"), "Blue");
		Predicate predicateForRedColor
		  = criteriaBuilder.equal(itemRoot.get("color"), "Red");
		Predicate predicateForColor
		  = criteriaBuilder.or(predicateForBlueColor, predicateForRedColor);
		
		Predicate predicateForGradeA
		  = criteriaBuilder.equal(itemRoot.get("grade"), "A");
		Predicate predicateForGradeB
		  = criteriaBuilder.equal(itemRoot.get("grade"), "B");
		Predicate predicateForGrade
		  = criteriaBuilder.or(predicateForGradeA, predicateForGradeB);
		
		Predicate finalPredicate = criteriaBuilder.and(predicateForColor, predicateForGrade);
		criteriaQuery.where(finalPredicate);
		List<Item> items = entityManager.createQuery(criteriaQuery).getResultList();
		
		return items;
	}
}
