package guru.springframework.springPetClinic.services.map;

import java.util.Set;

import guru.springframework.springPetClinic.model.Speciality;
import guru.springframework.springPetClinic.services.SpecialitiesService;

public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService
{
	@Override
	public Set<Speciality> findAll()
	{
		return super.findAll();
	}
	
	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
	
	@Override
	public void delete(Speciality object)
	{
		super.delete(object);
	}
	
	@Override
	public Speciality save(Speciality object)
	{
		return super.save(object);
	}
	
	@Override
	public Speciality findById(Long id)
	{
		return super.findById(id);
	}
}
