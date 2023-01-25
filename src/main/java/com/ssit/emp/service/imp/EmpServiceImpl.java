package com.ssit.emp.service.imp;

import com.ssit.emp.entity.Emp;
import com.ssit.emp.repository.EmpRepository;
import com.ssit.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpRepository repository;
    @Override
    public Emp createEmp(Emp emp) {
        return repository.save(emp);
    }

    @Override
    public Optional<Emp> getEmpById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Emp> allEmp() {
        return repository.findAll();
    }

    @Override
    public int updateEmp(Emp emp) {
        return repository.updateEmp(emp.getName(), emp.getAge(), emp.getDepId(), emp.getId());
    }

    @Override
    public void deleteEmp(Long id) {
         repository.deleteById(id);
    }
}
