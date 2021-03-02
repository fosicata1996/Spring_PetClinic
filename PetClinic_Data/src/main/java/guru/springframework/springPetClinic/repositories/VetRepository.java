package guru.springframework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springPetClinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>
{
}
