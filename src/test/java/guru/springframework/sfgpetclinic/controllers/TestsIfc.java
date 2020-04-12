package guru.springframework.sfgpetclinic.controllers;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

@TestInstance(Lifecycle.PER_CLASS)
public interface TestsIfc {
	VetMapService srvc = new VetMapService(new SpecialityMapService());;
	Set<Speciality> specialitySet = new HashSet<Speciality>();
	VetController ctrl = new VetController(srvc);
	
	@BeforeAll
	default public void setup() {
		specialitySet.add(new Speciality(4L,"ENT4"));
		specialitySet.add(new Speciality(3L,"ENT3"));
		specialitySet.add(new Speciality(1L,"ENT1"));
		specialitySet.add(new Speciality(2l,"ENT2"));
	}
	
	@BeforeEach
	@DisplayName(value = "{displayName} kumanki" )
	default void setupEach(RepetitionInfo retInfo) {
		System.out.println(retInfo.getCurrentRepetition());
	}
}
