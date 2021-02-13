package guru.springframework.springPetClinic.services;

import guru.springframework.springPetClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
	Owner findByLastName(String lastName);
}
