package com.example.demo.service;

import com.example.demo.model.Associate;
import com.example.demo.repo.AssociateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateserviceImpl implements AssociateService {

    private AssociateRepo associateRepo;

    @Autowired
    public AssociateserviceImpl(AssociateRepo associateRepo) {
        this.associateRepo = associateRepo;
    }

    @Override
    public List<Associate> getAllAssociates() {
        return associateRepo.findAll();
    }

    @Override
    public Associate createAssociate(Associate associate) {
        return associateRepo.save(associate);
    }

    @Override
    public Associate findByAssociateId(int theId) {
        return associateRepo.findByAssociateId(theId);
    }

    @Override
    public Associate findByName(String name) {
        return associateRepo.findByName(name);
    }

    @Override
    public Associate deleteAssociateById(int theId) {
        Optional<Associate> associate=associateRepo.findById(theId);
        if(associate.isPresent())
        {
            associateRepo.deleteById(theId);
        }
        else {
            throw new RuntimeException("Did not find associate id - " + theId);
        }

        return null;
    }

    @Override
    public List<Associate> findByKeyword(String keyword) {
        return associateRepo.findByKeyword(keyword);
    }
}

