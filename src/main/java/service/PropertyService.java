package service;

import dto.CreatePropertyDTO;
import model.Owner;
import model.Property;
import repository.InMemoryRepository;

import java.util.List;
import java.util.Optional;

public class PropertyService {
    private final InMemoryRepository<Property> propertyRepo;

    public PropertyService(InMemoryRepository<Property> propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public Property createProperty(CreatePropertyDTO dto) {
        Owner owner = new Owner(dto.ownerName, dto.ownerPhone);
        Property property = new Property(dto.title, dto.address, dto.price, owner);
        propertyRepo.save(property.getId(), property);
        return property;
    }

    public List<Property> listAll() {
        return propertyRepo.findAll();
    }

    public Optional<Property> getById(String id) {
        return propertyRepo.findById(id);
    }

    public boolean delete(String id) {
        if (propertyRepo.exists(id)) {
            propertyRepo.delete(id);
            return true;
        }
        return false;
    }
}