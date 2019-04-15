package com.wj.springboot.controller;

import com.wj.springboot.dao.EmployeeDao;
import com.wj.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps",employees);

        //classpath://templates/emp/list.html
        return "emp/list";
    }
}
