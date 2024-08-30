package com.lloyd.crud.repositories;

import com.lloyd.crud.models.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationDao extends JpaRepository<Designation, Integer> {
}
