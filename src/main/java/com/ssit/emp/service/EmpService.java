package com.ssit.emp.service;

import com.ssit.emp.entity.Emp;

import java.util.List;
import java.util.Optional;

public interface EmpService {

    public Emp createEmp(Emp emp);
    public Optional<Emp> getEmpById(Long id);
    public List<Emp> allEmp();
    public int updateEmp(Emp emp);
    public void deleteEmp(Long id);

 }
