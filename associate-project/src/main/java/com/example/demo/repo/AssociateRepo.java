package com.example.demo.repo;

import com.example.demo.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociateRepo extends JpaRepository<Associate, Integer> {
    @Query
    public Associate findByAssociateId(Integer theId);
    @Query
    public Associate findByName(String name);
    @Query(value="select * from ASSOCIATE_DETAIL e where e.associate_id like %:keyword% or e.name like %:keyword% or e.email like %:keyword% or e.mobile_number like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);
}
