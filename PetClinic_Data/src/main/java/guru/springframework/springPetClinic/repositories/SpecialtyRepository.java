package guru.springframework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springPetClinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long>
{
}
