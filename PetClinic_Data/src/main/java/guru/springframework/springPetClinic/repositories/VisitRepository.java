package guru.springframework.springPetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springPetClinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>
{
}
