package event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import event.entity.Participant;
import event.service.ParticipantService;

@Controller
@RequestMapping("/participant")
public class ParticipantController {

//	inject the customer service dependency

	@Autowired
	private ParticipantService participantService;

	@GetMapping("/welcome")
	public String listParticipant(Model theModel) {

		List<Participant> theParticipants = participantService.getParticipants();

		theModel.addAttribute("participants", theParticipants);

		return "welcome-page";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Participant theParticipant = new Participant();

		theModel.addAttribute("participant", theParticipant);

		return "participant-form";
	}

	@PostMapping("/saveParticipant")
	public String saveParticipant(@ModelAttribute("participant") Participant theParticipant) {

		participantService.saveParticipant(theParticipant);

		return "redirect:/participant/welcome";
	}

	@GetMapping("/saveUpdates")
	public String saveUpdates(@RequestParam("participantId") int theId, Model theModel) {

//		get the participant from DB using Id
		Participant theParticipant = participantService.getParticipant(theId);

//		set theParticipant as a model attribute, to populate the form with existing data
		theModel.addAttribute("participant", theParticipant);

		return "participant-form";
	}

	@GetMapping("/deleteParticipant")
	public String deleteParticipant(@RequestParam(name = "participantId") int theId, Model theModel) {

		participantService.deleteParticipant(theId);

		return "redirect:/participant/welcome";
	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(Model theModel) {

		List<Participant> theParticipants = participantService.getParticipants();

		theModel.addAttribute("participants", theParticipants);

		return "delete-form";
	}
	
	@GetMapping("/search")
	public String showFormForSearch(@RequestParam("theName") String theName, Model theModel) {
		
		List<Participant> theParticipant = participantService.searchParticipant(theName);

		theModel.addAttribute("participants", theParticipant);
		
		return "welcome-page";

	}
}
