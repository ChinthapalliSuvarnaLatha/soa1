package com.klu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/app")
public class AppController {
  
  //StudentDAO sdao = new StudentDAO();
  @Autowired
  StudentDAO1 sdao;
  
  @GetMapping("/f1")
  public String test() {
    return "Welcome to Spring Boot Framework";
  }
  
  //localhost:8080/app/add/10/20
  @RequestMapping("/add/{a}/{b}")
  public int add(@PathVariable("a") int a, @PathVariable("b") int b) {
    return a+b;
  }
  
  //localhost:8080/app/sub?a=10&b=20
  @GetMapping("/sub")
  public int sub(@PathParam("a") int a, @PathParam("b") int b) {
    return a-b;
  }
  
  //@PostMapping("/student")
  @RequestMapping(value = "/student", method = RequestMethod.POST)
  public Student insert(@RequestBody Student s) {
    return sdao.insert(s);
  }
  
  @GetMapping("/student")
  public List<Student> findAll() {
    return sdao.findAll();
  }
  
  //@PutMapping("/student")
  @RequestMapping(value = "/student", method = RequestMethod.PUT)
  public boolean update(@RequestBody Student s) {
    return sdao.update(s);
  }
  
  @DeleteMapping("/student/{id}")
  public boolean delete(@PathVariable("id") int id) {
    return sdao.delete(id);
  }
  
  @GetMapping("/student/name/{name}")
  public Student getByName(@PathVariable("name") String name) {
    return sdao.findByName(name);
  }
  
  @GetMapping("/student/combined/{name}/{cgpa}")
  public Student getByNameAndCgpa(@PathVariable("name") String name, @PathVariable("cgpa") double cgpa) {
    return sdao.findByNameAndCgpa(name, cgpa);
  }
  
  @GetMapping("/student/page/{page}/limit/{limit}")
  public Page<Student> getByPage(@PathVariable("page") int page, @PathVariable("limit") int limit) {
    return sdao.findPage(page, limit);
  }
  
  @PatchMapping("/student/update/{name}/{cgpa}")
  public String updateCgpaByName(@PathVariable("name") String name, @PathVariable("cgpa") double cgpa) {
    return sdao.updateCgpaByName(name, cgpa);
  }

}