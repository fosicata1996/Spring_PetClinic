package guru.springframework.springPetClinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.springPetClinic.model.Owner;

class OwnerMapServiceTest
{
	OwnerMapService ownerMapService;
	
	private final Long OWNER_ID = 1L;
	private final String LAST_NAME = "Smith";
	
	@BeforeEach
	void setUp()
	{
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetServiceMap());
		
		ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
	}
	
	@Test
	void findAll()
	{
		Set<Owner> ownerSet = ownerMapService.findAll();
		
		assertEquals(1, ownerSet.size());
	}
	
	@Test
	void findById()
	{
		Owner owner = ownerMapService.findById(OWNER_ID);
		
		assertEquals(OWNER_ID, owner.getId());
	}
	
	@Test
	void save()
	{
		long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}
	
	@Test
	void saveNoId()
	{
		Owner savedOwner = ownerMapService.save(Owner.builder().build());
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void delete()
	{
		ownerMapService.delete(ownerMapService.findById(OWNER_ID));
		
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void deleteById()
	{
		ownerMapService.deleteById(OWNER_ID);
		
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void findByLastName()
	{
		Owner smith = ownerMapService.findByLastName(LAST_NAME);
		
		assertNotNull(smith);
		assertEquals(OWNER_ID, smith.getId());
		
	}
	
	@Test
	void findByLastNameNotFound()
	{
		Owner smith = ownerMapService.findByLastName("foo");
		
		assertNull(smith);
	}
}