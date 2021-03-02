package guru.springframework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springPetClinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>
{
}
