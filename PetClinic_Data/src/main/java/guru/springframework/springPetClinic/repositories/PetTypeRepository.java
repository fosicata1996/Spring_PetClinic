package guru.springframework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springPetClinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>
{
}
