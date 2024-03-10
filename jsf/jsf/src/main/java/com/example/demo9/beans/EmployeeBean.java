package com.example.demo9.beans;

import  com.example.demo9.models.Employee;
import com.example.demo9.Mth.EmployeeMTH;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean {
    public static int i=0;
    private EmployeeMTH employeeService =new EmployeeMTH();
    private List<Employee> models=employeeService.getNextTen(i);
    private Employee employee=new Employee();
    private boolean checkSubOne=!employeeService.checkSubOne(i);
    private boolean checkAddOne=!employeeService.checkAddOne(i);


    public boolean isCheckSubOne() {
        return checkSubOne;
    }

    public boolean isCheckAddOne() {
        return checkAddOne;
    }

    public void setModels(List<Employee> models) {
        checkSubOne=!employeeService.checkSubOne(i);
        checkAddOne=!employeeService.checkAddOne(i);
        this.models = models;
    }

    public List<Employee> getModels() {
        return models;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void addOneToI(){
//        System.out.println("addOneToI");
        if((models.size()/5)>=i && !employeeService.checkDivision(i) ){
            i=i+1;
//            System.out.println(i);
            setModels(employeeService.getNextTen(i));
        }

    }
    public  void ajouter()
    {

        employeeService.addEmployee(employee);
    }
    public void subsOneToI(){
        if((models.size()/5)<=i )
            i=i-1;
        System.out.println(i);
        setModels(employeeService.getNextTen(i));
    }
    public void lastPage(){
        i=employeeService.lastPage();
        setModels(employeeService.getNextTen(i));
    }
    public void firstPage(){

        i=0;
        setModels(employeeService.getNextTen(i));
    }
//    public boolean checkSubOne(){
//        setModels(employeeService.getNextTen(i));
//        return !employeeService.checkSubOne(i);
//    }
//    public boolean checkAddOne(){
//        setModels(employeeService.getNextTen(i));
//        return !employeeService.checkAddOne(i);
//    }

    public void deleteEmployee(int id){

        employeeService.deleteEmployee(id);
        if( (double)i==employeeService.checkLastPage() ){
            i--;}
        setModels(employeeService.getNextTen(i));
    }
    public void updateEmployee(Employee employee){

//        System.out.println(employee.getId()+"=="+employee.getName()+"=="+employee.getDepartement()+"=="+employee.getEmail()+"=="+employee.getBrthd());
        employeeService.updateEmployee(employee);
        desactivateEdit(employee);

    }

    public void desactivateEdit(Employee employee){
        setModels(employeeService.getNextTen(i));
        employee.setEdit(false);

    }
    public void activateEditButton(Employee employee) {
        for(Employee employee1:models){
            employee1.setEdit(false);
        }
        employee.setEdit(true);
        this.employee = employee;
//        System.out.println(employee.getName());

    }

    public boolean activateEdit(Employee employee) {
        return employee.isEdit();

    }




}





