package event.service;

import java.util.List;

import event.entity.Participant;

public interface ParticipantService {

	public List<Participant> getParticipants();

	public void saveParticipant(Participant theParticipant);

	public Participant getParticipant(int theId);

	public void deleteParticipant(int theId);

	public List<Participant> searchParticipant(String theName);
}
