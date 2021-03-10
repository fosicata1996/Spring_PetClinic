package guru.springframework.springPetClinic.services.springDataJpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.springPetClinic.model.Owner;
import guru.springframework.springPetClinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest
{
	protected static final String SMITH = "Smith";
	
	@Mock
	OwnerRepository repository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;
	
	@BeforeEach
	void setUp()
	{
		returnOwner = Owner.builder().id(1L).lastName(SMITH).build();
	}
	
	@Test
	void findByLastName()
	{
		returnOwner = Owner.builder().id(1L).lastName(SMITH).build();
		
		when(repository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = service.findByLastName(SMITH);
		
		assertEquals(SMITH, smith.getLastName());
		verify(repository).findByLastName(any());
		
	}
	
	@Test
	void findAll()
	{
		Set<Owner> returnOwnersSet = new HashSet<>();
		returnOwnersSet.add(Owner.builder().id(1L).build());
		returnOwnersSet.add(Owner.builder().id(2L).build());
		
		when(repository.findAll()).thenReturn(returnOwnersSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}
	
	@Test
	void findById()
	{
		when(repository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = service.findById(1L);
		
		assertNotNull(owner);
	}
	
	@Test
	void findByIdNotFound()
	{
		when(repository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner owner = service.findById(1L);
		
		assertNull(owner);
	}
	
	@Test
	void save()
	{
		Owner ownerToSave = Owner.builder().id(1L).build();
		
		when(repository.save(any())).thenReturn(returnOwner);
		
		Owner savedOwner = service.save(ownerToSave);
		
		assertNotNull(savedOwner);
		verify(repository).save(any());
	}
	
	@Test
	void delete()
	{
		service.delete(returnOwner);
		
		verify(repository).delete(any());
	}
	
	@Test
	void deleteById()
	{
		service.deleteById(1L);
		
		verify(repository).deleteById(anyLong());
	}
}