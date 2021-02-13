package guru.springframework.springPetClinic.services;

import java.util.Set;

import guru.springframework.springPetClinic.model.Owner;

public interface OwnerService
{
	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	
}
