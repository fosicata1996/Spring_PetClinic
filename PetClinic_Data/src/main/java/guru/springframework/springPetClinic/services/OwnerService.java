package guru.springframework.springPetClinic.services;

import java.util.List;

import guru.springframework.springPetClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
