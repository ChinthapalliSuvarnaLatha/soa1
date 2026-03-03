package com.klu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentDAO1 {

  @Autowired
  StudentRepo1 srepo;
  
  public Student insert(Student s) {
    return srepo.save(s);
  }
  public boolean update(Student s) {
    Student s1 = srepo.findById(s.getId()).get();
    if(s1 == null) {
      return false;
    }
    else {
      srepo.delete(s1);
      srepo.save(s);
      return true;
    }
  }
     
  public boolean delete(int sid) {
    if(srepo.findById(sid) == null) {
      return false;
    }
    else {
      srepo.deleteById(sid);
      return true;
    }
  }
  
  public List<Student> findAll(){
    return srepo.findAll();
  }
  
  public Student findByName(String name) {
    return srepo.findByName(name);
  }
  
  public Student findByNameAndCgpa (String name, double cgpa) {
    return srepo.findByNameAndCgpa(name, cgpa);
  }
  
  public Page<Student> findPage(int page, int limit) {
    Pageable pageable = PageRequest.of(page, limit, Sort.by("name").descending());
    return srepo.findAll(pageable);
  }
  
  public String updateCgpaByName(String name, double cgpa) {
    if(srepo.findByName(name) == null) {
       throw new RuntimeException("Student Not Found with Name: " + name);
    }
    if (srepo.updateCgpaByName(name, cgpa) == 1) {
      return "Updated Successfully";
    }
    else {
      return "Not Updated";
    }
  }
  
}