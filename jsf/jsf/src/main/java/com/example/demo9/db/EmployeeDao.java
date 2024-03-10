package com.example.demo9.db;

import com.example.demo9.models.Employee;

import java.util.List;

public interface EmployeeDao {
    public  void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public boolean employeesExiste(String email);
    public int employeesExisteAfterUpdate(String email);

    public List<Employee> getAll();
    public void deleteEmployee(int id);


}
