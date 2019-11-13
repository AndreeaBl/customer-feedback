package services;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import CustomerF.Bug;
import CustomerF.Feedback;
//
@Component
@Scope("singleton") 
public class FeedbackEntityRepository implements IFeedbackEntityRepository{
	private static Logger logger = Logger.getLogger(FeedbackEntityRepository.class.getName());
	
	public FeedbackEntityRepository() {
		//logger.info(">>> BEAN: FeedbackEntityRepository instantiated!");
		
		//Sample feedback
		for(int i=1; i<=3; i++) {
			Integer nextID = this.getNextID();
			LocalDateTime startLocalDate = LocalDateTime.now();
			Feedback newFeedback = new Bug(nextID, "Feedback_sample_" + i, "Tip_"+i);

			logger.info(">>> BEAN: ProjectEntityRepositoryCDI NEW PROJECT:" + newFeedback);
		}
		
	}
	
	private Map<Integer, Feedback> entities = new HashMap<>();
	// 
	private Integer nextID = 0;
	@Override
	public Integer getNextID() {
		nextID++;
		return nextID;
	}
	
	@Override
	public Feedback getFeedbackById(Integer id) {
		return entities.get(id);
	}
	
	@Override
	public Feedback getFeedback(Feedback sample) {
		return getFeedbackById(sample.getIdFeedback());
	}
	
	@Override
	public Collection<Feedback> feedbackToCollection() {
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackList.addAll(this.entities.values());
		return feedbackList;
	}
	
	@Override
	public Feedback add(Feedback entity) {
		if (entity.getIdFeedback() == null) {
			nextID++;
			entity.setIdFeedback(nextID);
		}
		entities.put(entity.getIdFeedback(), entity);
		return entity;
	}
	
	@Override
	public Collection<Feedback> addAllFeedback(Collection<Feedback> entities) {
		for(Feedback entity: entities)
			this.add(entity);
		return entities;
	}
	
	@Override
	public boolean remove(Feedback entity) {
		if (this.entities.containsValue(entity)) {
			this.entities.remove(entity.getIdFeedback());
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeAllFeedback(Collection<Feedback> entities) {
		Boolean flag =  true;
		for(Feedback entity: entities) {
			if (!this.remove(entity))
				flag = false;
		}
		
		return flag;
	}

	@Override
	public int size() {
		return this.entities.values().size();
	}

}
