package guru.springframework.springPetClinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.springPetClinic.model.Speciality;
import guru.springframework.springPetClinic.model.Vet;
import guru.springframework.springPetClinic.services.SpecialtyService;
import guru.springframework.springPetClinic.services.VetService;

@Service
@Profile({ "map", "default" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
	private final SpecialtyService specialtyService;
	
	public VetServiceMap(SpecialtyService specialtyService)
	{
		this.specialtyService = specialtyService;
	}
	
	@Override
	public Set<Vet> findAll()
	{
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id)
	{
		return super.findById(id);
	}
	
	@Override
	public Vet save(Vet object)
	{
		if (object.getSpecialities().size() > 0)
		{
			object.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null)
				{
					Speciality savedSpeciality = specialtyService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		
		return super.save(object);
	}
	
	@Override
	public void delete(Vet object)
	{
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
}
