package guru.springframework.springPetClinic.services;

import java.util.Set;

import guru.springframework.springPetClinic.model.Pet;

public interface PetService
{
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
