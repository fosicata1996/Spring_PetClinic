package guru.springframework.springPetClinic.services.springDataJpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.springPetClinic.model.Owner;
import guru.springframework.springPetClinic.repositories.OwnerRepository;
import guru.springframework.springPetClinic.repositories.PetRepository;
import guru.springframework.springPetClinic.services.OwnerService;
import guru.springframework.springPetClinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService
{
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeService petTypeService;
	
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeService petTypeService)
	{
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public Set<Owner> findAll()
	{
		Set<Owner> owners = new HashSet<>();
		
		ownerRepository.findAll().forEach(owners::add);
		
		return owners;
	}
	
	@Override
	public Owner findById(Long aLong)
	{
		return ownerRepository.findById(aLong).orElse(null);
	}
	
	@Override
	public Owner save(Owner object)
	{
		return ownerRepository.save(object);
	}
	
	@Override
	public void delete(Owner object)
	{
		ownerRepository.delete(object);
	}
	
	@Override
	public void deleteById(Long aLong)
	{
		ownerRepository.deleteById(aLong);
	}
	
	@Override
	public Owner findByLastName(String lastName)
	{
		return ownerRepository.findByLastName(lastName);
	}
}
