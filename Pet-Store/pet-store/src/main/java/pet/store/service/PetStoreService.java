package pet.store.service;

import java.util.List;
import java.util.Objects;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;

	public static List<PetStoreData> retrieveAllContributors() {
		// TODO Auto-generated method stub
		return null;
	}

	private PetStore findOrCreatePetStore(Long petStoreId) {
		

		if (Objects.isNull(petStoreId)) {
			return new PetStore();
		} else {
			return findPetStoreById(petStoreId);
		}
	}

	private PetStore findPetStoreById(Long petStoreId) {
		return petStoreDao.findById(petStoreId)
				.orElseThrow(() -> new NoSuchElementException("Pet store with ID=" + " does not exist."));
	}
	public static PetStoreData saveContributor(PetStoreData contributorData) {
		// TODO Auto-generated method stub
		return null;
	}
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		Long petStoreId  = petStoreData.getPetStoreId();
		PetStore petStore = findOrCreatePetStore(petStoreId);
		copyPetStoreFields(petStore, petStoreData);
		return new PetStoreData(petStoreDao.save(petStore));
		
	}

	private static void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		 petStore.setPetStoreId(petStoreData.getPetStoreId());
		 petStore.setPetStoreName(petStoreData.getPetStoreName());
		  petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		 petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		  petStore.setPetStoreState(petStoreData.getPetStoreState());
		 petStore.setPetStoreZip(petStoreData.getPetStoreZip());
		 petStore.setPetStorePhone(petStoreData.getPetStorePhone());
		
		
	}
}
