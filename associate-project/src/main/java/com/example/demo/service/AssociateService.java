package com.example.demo.service;

import com.example.demo.model.Associate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssociateService {
    public List<Associate> getAllAssociates();
    public Associate createAssociate(Associate associate);
    public Associate findByAssociateId(int theId);
    public Associate findByName(String name);
    public Associate deleteAssociateById(int theId);
    @Query(value="select * from ASSOCIATE_DETAIL e where e.associate_id like %:keyword% or e.name like %:keyword% or e.email like %:keyword%  or e.mobile_number like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);
}

