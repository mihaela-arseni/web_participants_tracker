package event.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import event.entity.Participant;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Participant> getParticipants() {

//		get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

//		Create a HB query, sort the list by the last name
		Query<Participant> theQuery = currentSession.createQuery("from Participant order by lastName",
				Participant.class);

//		get the list using the HB query		
		List<Participant> participants = theQuery.getResultList();

		return participants;
	}

	@Override
	public void saveParticipant(Participant theParticipant) {

//		get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

//		save the participant to the database (used for add and update participant)
		currentSession.saveOrUpdate(theParticipant);

	}

	@Override
	public Participant getParticipant(int theId) {

//		get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

//		get theParticipant from current session using Id
		Participant theParticipant = currentSession.get(Participant.class, theId);

		return theParticipant;
	}

	@Override
	public void deleteParticipant(int theId) {

//		get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

//		create a HB query based on primary key -> id
		Query<?> theQuery = currentSession.createQuery("delete from Participant where id=:participantId");

//		set the param value 
		theQuery.setParameter("participantId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Participant> searchParticipant(String theName) {

//		get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Participant> theQuery = null;

		if (theName != null && theName.trim().length() > 0) {
//			get the participants which names start with string theName
			theQuery = currentSession.createQuery(
					"from Participant where lower(firstName) like :theName or lower(lastName) like :theName",
					Participant.class);
			theQuery.setParameter("theName", theName.toLowerCase() + "%");
		} else {
//			for empty input get all the participants
			theQuery = currentSession.createQuery("from Participant", Participant.class);
		}

		List<Participant> theParticipants = theQuery.getResultList();

		return theParticipants;
	}

}
