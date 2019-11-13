package services;

import java.util.Collection;

import CustomerF.Feedback;


public interface IFeedbackEntityRepository {
	
	public Integer getNextID() ;
	
	//Feedback 
	public Feedback getFeedbackById(Integer id);
	public Feedback getFeedback(Feedback sample);
	public Collection<Feedback> feedbackToCollection(); // getAll
	
	public Feedback add(Feedback entity);
	public Collection<Feedback> addAllFeedback(Collection<Feedback> entities);
	public boolean remove(Feedback entity);
	public boolean removeAllFeedback(Collection<Feedback> entities);	
	
	
	//
	public int size();
}