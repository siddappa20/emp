package com.ssit.emp.repository;

import com.ssit.emp.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
    @Transactional
    @Modifying
    @Query("update Emp e set e.name = ?1, e.age = ?2, e.depId = ?3 where id = ?4")
    int updateEmp(String name, Integer age, Long depId, Long id);
}
