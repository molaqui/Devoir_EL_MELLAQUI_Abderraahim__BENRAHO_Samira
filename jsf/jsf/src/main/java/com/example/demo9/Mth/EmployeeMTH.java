package com.example.demo9.Mth;

import com.example.demo9.db.EmployeeDaoImpl;
import com.example.demo9.models.Employee;

import java.util.List;

public class EmployeeMTH {
    EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();

    public boolean addEmployee(Employee employee) {
        if(employeeDao.employeesExiste(employee.getEmail())){
            employeeDao.addEmployee(employee);
            return true;

        }else {
            return  false;
        }
    }

    public boolean updateEmployee(Employee employee) {
        if(employeeDao.employeesExisteAfterUpdate(employee.getEmail())==-1 ||  employeeDao.employeesExisteAfterUpdate(employee.getEmail())==employee.getId()){
            employeeDao.updateEmployee(employee);
            return true;

        }else {
            return  false;
        }
    }



    public List<Employee> getAll(){
        return employeeDao.getAll();

    }

    public List<Employee> getNextTen(int i){


        return  getAll().subList(Math.max(5*i,0),Math.min(5*i+5, getAll().size()));

    }

    public boolean checkDivision(int i){

        return (getAll().size()==5*i+5);

    }


        public boolean checkSubOne(int i){

        return i==0;
    }
    public boolean checkAddOne(int i){
        if(getAll().size()==5){
            return true;
        }
        return i >= (getAll().size()/5);
    }
    public int lastPage(){
        if(getAll().size()==5)
            return 0;
        return getAll().size()/5;
    }

    public double checkLastPage(){

        return (double) getAll().size() /5;
    }

    public void deleteEmployee(int id){

        employeeDao.deleteEmployee(id);
    }

}
