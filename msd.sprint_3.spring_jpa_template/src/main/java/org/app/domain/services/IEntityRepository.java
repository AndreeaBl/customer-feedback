package org.app.domain.services;

import java.util.Collection;
import java.util.Map;

import org.app.domain.Atasament;
import org.app.domain.Cerinta;
import org.app.domain.Comentariu;
import org.app.domain.Echipa;
import org.app.domain.Feedback;
import org.app.domain.User;

public interface IEntityRepository {
	public Integer getNextID() ;
	
	//Echipa
	public Echipa getEchipaById(Integer id);
	public Echipa getEchipa(Echipa sample);
	public Collection<Echipa> echipaToCollection(); // getAll
	
	//Echipa
	public Echipa addEchipa(Echipa entity);
	public Collection<Echipa> addAllEchipa(Collection<Echipa> entities);
	public boolean removeEchipa(Echipa entity);
	public boolean removeAllEchipa(Collection<Echipa> entities);	
	
	//User
	public User getUserById(Integer id);
	public Collection<User> getUserByName(String name);
	public User getUser(User sample);
	public Collection<User> userToCollection(); // getAll
	
	//User
	public User addUser(User entity);
	public Collection<User> addAllUser(Collection<User> entities);
	public boolean removeUser(User entity);
	public boolean removeAllUser(Collection<User> entities);	
	
	//Atasamente
	public Collection<Atasament> getAtasamentByFeedbackId(Integer id);
	public Atasament getAtasamentById(Integer id);
	public Atasament getAtasament(Atasament sample);
	public Collection<Atasament> atasamentToCollection(); // getAll
	
	//Atasamente
	public Atasament addAtasamentToFeedback(Atasament entity, Feedback feedback);
	public Collection<Atasament> addAllAtasamentToFeedback(Collection<Atasament> entities, Feedback feedback);
	public boolean removeAtasament(Atasament entity);
	public boolean removeAllAtasamentOfFeedback(Feedback feedback);
	public boolean removeAllAtasament(Collection<Atasament> entities);
	
	//Cerinte
	public Collection<Cerinta> getCerintaByFeedbackId(Integer id);
	public Cerinta getCerintaById(Integer id);
	public Cerinta getCerinta(Cerinta sample);
	public Collection<Cerinta> cerintaToCollection(); // getAll
	
	//Cerinte
	public Cerinta addCerintaToFeedback(Cerinta entity, Feedback feedback);
	public Collection<Cerinta> addAllCerintaToFeedback(Collection<Cerinta> entities, Feedback feedback);
	public boolean removeCerinta(Cerinta entity);
	public boolean removeAllCerinteOfFeedback(Feedback feedback);
	public boolean removeAllCerinte(Collection<Cerinta> entities);
	
	//Comentarii
	public Collection<Comentariu> getComentariiByFeedbackId(Integer id);
	public Comentariu getComentariuById(Integer id);
	public Comentariu getComentariu(Comentariu sample);
	public Collection<Comentariu> comentariuToCollection(); // getAll
		
	//Comentarii
	public Comentariu addComentariuToFeedback(Comentariu entity, Feedback feedback);
	public Collection<Comentariu> addAllComenatiiToFeedback(Collection<Comentariu> entities, Feedback feedback);
	public boolean removeComentariu(Comentariu entity);
	public boolean removeAllComenariiOfFeedback(Feedback feedback);
	public boolean removeAllComentarii(Collection<Comentariu> entities);	
	
	
	//
	public int sizeOfEchipa();
	public int sizeOfUseri();
	public int sizeOfAtasamente();
	public int sizeOfCerinte();
	public int sizeOfComentarii();
}
