package com.wj.springboot.controller;

import com.wj.springboot.dao.DepartmentDao;
import com.wj.springboot.dao.EmployeeDao;
import com.wj.springboot.entities.Department;
import com.wj.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps",employees);

        //classpath://templates/emp/list.html
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments =  departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){

//        System.out.println("employee :" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){

        Employee employee = employeeDao.get(id);
        System.out.println("edit employee : " + employee);
        model.addAttribute("emp", employee);

        Collection<Department> departments =  departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("employee : " + employee);

        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @ResponseBody
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
