package org.app.domain.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.app.domain.Atasament;
import org.app.domain.Cerinta;
import org.app.domain.Comentariu;
import org.app.domain.Echipa;
import org.app.domain.Feedback;
import org.app.domain.RootEntity;
import org.app.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//SDI Bean Component 
@Component @Scope("singleton")
public class EntityRepositoryBase implements IEntityRepository{
	
	private static Logger logger = Logger.getLogger(EntityRepositoryBase.class.getName());
	
	public EntityRepositoryBase() {
		logger.info(">>> BEAN: EntityRepositoryBase instantiated!");
	}
	
	// Spring Configuration must provide LocalEntityManagerFactoryBean
	@PersistenceContext //	@Autowired 
	private EntityManager em;
	
	// 
	private Integer nextID = 0;
	@Override
	public Integer getNextID() {
		nextID++;
		return nextID;
	}
	
	//Echipe
	private Collection<Echipa> listaEchipe = new ArrayList<Echipa>();

	@Override
	public int sizeOfEchipa() {
		listaEchipe = echipaToCollection();
		return listaEchipe.size();
	}


	@Override
	public Echipa getEchipaById(Integer id) {
		return em.find(Echipa.class, id);
	}

	@Override
	public Echipa getEchipa(Echipa sample) {
		return getEchipaById(sample.getIdEchipa());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Echipa> echipaToCollection() {
		String queryString ="SELECT e FROM Echipa e";
		Query query = em.createQuery(queryString, Echipa.class);
		return query.getResultList();
	}

	@Override
	public Echipa addEchipa(Echipa entity) {
		return em.merge(entity);
	}

	@Override
	public Collection<Echipa> addAllEchipa(Collection<Echipa> entities) {
		for(Echipa entity: entities)
			this.addEchipa(entity);
		return entities;
	}

	@Override
	public boolean removeEchipa(Echipa entity) {
		if(em.contains(entity)) {
			this.em.remove(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAllEchipa(Collection<Echipa> entities) {
		Boolean flag =  true;
		for(Echipa entity: entities) {
			if (!this.removeEchipa(entity))
				flag = false;
		}
		
		return flag;
	}

	
	//Echipe
	private Collection<User> listaUseri = new ArrayList<User>();
	
	@Override
	public int sizeOfUseri() {
		listaUseri = userToCollection();
		return listaUseri.size();
	}
		
	@Override
	public User getUserById(Integer id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> getUserByName(String name) {
		String queryString= "SELECT u FROM User u WHERE u.numePrescurtat like " + name;
		Query query = em.createQuery(queryString, User.class);
		return query.getResultList();
	}

	@Override
	public User getUser(User sample) {
		return getUserById(sample.getIdUser());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> userToCollection() {
		String queryString= "SELECT u FROM User u";
		Query query = em.createQuery(queryString, User.class);
		return query.getResultList();
	}

	@Override
	public User addUser(User entity) {
		return em.merge(entity);
	}

	@Override
	public Collection<User> addAllUser(Collection<User> entities) {
		for(User entity: entities)
			this.addUser(entity);
		return entities;
	}

	@Override
	public boolean removeUser(User entity) {
		if(em.contains(entity)) {
			this.em.remove(entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAllUser(Collection<User> entities) {
		Boolean flag =  true;
		for(User entity: entities) {
			if (!this.removeUser(entity))
				flag = false;
		}
		
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Atasament> getAtasamentByFeedbackId(Integer id) {
		String queryString = "Select a FROM Atasament a WHERE a.Feedback=" + id;
		Query query = em.createQuery(queryString, Atasament.class);
		return query.getResultList();
	}

	@Override
	public Atasament getAtasamentById(Integer id) {
		return em.find(Atasament.class, id);
	}

	@Override
	public Atasament getAtasament(Atasament sample) {
		return getAtasamentById(sample.getIdAtasament());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Atasament> atasamentToCollection() {
		String queryString = "SELECT a FROM Atasament a";
		Query query = em.createQuery(queryString);
		return query.getResultList();
	}

	@Override
	public Atasament addAtasamentToFeedback(Atasament entity, Feedback feedback) {
		entity.setFeedback(feedback);
		return em.merge(entity);
	}

	@Override
	public Collection<Atasament> addAllAtasamentToFeedback(Collection<Atasament> entities, Feedback feedback) {
		
		return null;
	}

	@Override
	public boolean removeAtasament(Atasament entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllAtasamentOfFeedback(Collection<Atasament> entities, Feedback feedback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllAtasament(Collection<Atasament> entities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Cerinta> getCerintaByFeedbackId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cerinta getCerintaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cerinta getCerinta(Cerinta sample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cerinta> cerintaToCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cerinta addCerinteToFeedback(Cerinta entity, Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cerinta> addAllCerintaToFeedback(Collection<Cerinta> entities, Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCerinta(Cerinta entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllCerinteOfFeedback(Collection<Cerinta> entities, Feedback feedback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllCerinte(Collection<Cerinta> entities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Comentariu> getComentariiByFeedbackId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentariu getComentariuById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentariu getComentariu(Comentariu sample) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Comentariu> comentariuToCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentariu addComentariuToFeedback(Cerinta entity, Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Comentariu> addAllComenatiiToFeedback(Collection<Cerinta> entities, Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeComentariu(Comentariu entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllComenariiOfFeedback(Collection<Cerinta> entities, Feedback feedback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllComentarii(Collection<Cerinta> entities) {
		// TODO Auto-generated method stub
		return false;
	}

}
