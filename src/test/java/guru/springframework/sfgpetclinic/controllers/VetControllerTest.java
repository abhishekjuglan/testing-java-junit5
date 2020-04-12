package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.fauxspring.MapModel;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;

class VetControllerTest implements TestsIfc{
	
	@Test
	@DisplayName("List Vets inside VetController")
	void testListVetsReturnString() {
		assertTrue("vets/index".equalsIgnoreCase(ctrl.listVets(new MapModel())));
	}
	
	@Test
	@DisplayName("List Vets inside VetController")
	void testListVetsModel() {
		MapModel model = new MapModel();
		ctrl.listVets(model);
		Set<Vet> s = (HashSet<Vet>)model.map.get("vets");
		assertTrue(s.size()==2);
		
	}
	
	@BeforeEach
	public void setup1() {
		srvc.save(new Vet(1L, "Abhishek", "Juglan",  specialitySet));
		srvc.save(new Vet(2L, "Tripti", "Juglan",  specialitySet));
	}
	
	@RepeatedTest(4)
	public void testDeleteSpeciality(RepetitionInfo repeatInfo) {
		specialitySet.remove(new Speciality(new Long(repeatInfo.getCurrentRepetition()).longValue(),"ENT"+repeatInfo.getCurrentRepetition()));
		assertEquals(repeatInfo.getTotalRepetitions()-repeatInfo.getCurrentRepetition(), specialitySet.size());
	}

}
