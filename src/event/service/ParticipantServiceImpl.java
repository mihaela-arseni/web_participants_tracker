package event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import event.dao.ParticipantDAO;
import event.entity.Participant;

@Service
public class ParticipantServiceImpl implements ParticipantService {

//	inject the ParticipantDAO
	@Autowired
	private ParticipantDAO participantDAO;

//	delegate the calls to DAO for each method

	@Override
	@Transactional
	public List<Participant> getParticipants() {

		return participantDAO.getParticipants();
	}

	@Override
	@Transactional
	public void saveParticipant(Participant theParticipant) {

		participantDAO.saveParticipant(theParticipant);
	}

	@Override
	@Transactional
	public Participant getParticipant(int theId) {

		return participantDAO.getParticipant(theId);
	}

	@Override
	@Transactional
	public void deleteParticipant(int theId) {

		participantDAO.deleteParticipant(theId);

	}

	@Override
	@Transactional
	public List<Participant> searchParticipant(String theName) {

		return participantDAO.searchParticipant(theName);
	}

}
