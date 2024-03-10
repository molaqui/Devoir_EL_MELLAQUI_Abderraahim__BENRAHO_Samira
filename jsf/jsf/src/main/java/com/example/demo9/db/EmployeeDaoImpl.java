package com.example.demo9.db;

import com.example.demo9.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    Connection connection= Conix.getConnection();

    public void addEmployee(Employee employee){

        try {
            PreparedStatement pst=connection.prepareStatement("insert into employee(NAME,DEPARTEMENT,EMAIL,BRTHD) values(?,?,?,?) ");
            pst.setString(1,employee.getName());
            pst.setString(2,employee.getDepartement());

            pst.setString(3,employee.getEmail());
            pst.setDate(4, (Date) employee.getBrthd());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }



    public void updateEmployee(Employee employee){

        try {
            PreparedStatement pst=connection.prepareStatement("UPDATE employee SET NAME=?,DEPARTEMENT=?,EMAIL=?,BRTHD=? WHERE id=? ");
            pst.setString(1,employee.getName());
            pst.setString(2,employee.getDepartement());

            pst.setString(3,employee.getEmail());
            pst.setDate(4, (Date) employee.getBrthd());
            pst.setInt(5,employee.getId());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean employeesExiste(String email) {


        try {
            PreparedStatement pst = connection.prepareStatement("select count(*) from employee where EMAIL=?  ");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int count=rs.getInt("count");
                return  count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int employeesExisteAfterUpdate(String email) {

        int id=-1;
        try {
            PreparedStatement pst = connection.prepareStatement("select id from employee where EMAIL=?  ");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                id=rs.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public List<Employee> getAll(){

        List<Employee> employees=new ArrayList<>();

        try {
            PreparedStatement pst=connection.prepareStatement("select * from employee   ");

            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                employees.add(new Employee(rs.getInt("id"),rs.getString("NAME"),rs.getString("DEPARTEMENT"),rs.getString("EMAIL"), rs.getDate("BRTHD")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(employees);
        return employees;
    }

    public void deleteEmployee(int id){

        try {
            PreparedStatement pst=connection.prepareStatement("DELETE FROM employee WHERE id=? ");
            pst.setInt(1,id);
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
