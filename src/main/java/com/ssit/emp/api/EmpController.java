package com.ssit.emp.api;

import com.ssit.emp.entity.Emp;
import com.ssit.emp.model.Response;
import com.ssit.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @PostMapping
    public ResponseEntity<Object> createEmp(@RequestBody Emp emp){

        Emp resEmp = empService.createEmp(emp);
        return new ResponseEntity<Object>(new Response(resEmp, "New Employee created"),
                    HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getEmpById(@PathVariable("id") Long id){
        Emp resEmp = empService.getEmpById(id).get();

        return new ResponseEntity<Response>(new Response(resEmp,"Employee details"),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> allEmp(){
        List<Emp> empList = empService.allEmp();

        return new ResponseEntity<Response>(new Response(empList,"All Employee details"),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateEmp(@RequestBody Emp emp){
       empService.updateEmp(emp);

        return new ResponseEntity<String>("Employee details updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") Long id){
        empService.deleteEmp(id);
        return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
    }



}
