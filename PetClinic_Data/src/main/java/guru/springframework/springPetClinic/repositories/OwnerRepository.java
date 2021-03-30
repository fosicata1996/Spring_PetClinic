package guru.springframework.springPetClinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springPetClinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
