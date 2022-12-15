package org.example.composite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String name;
    private String job;
    private Integer salary;
    List<Employee> subordinates;
    public Employee(String name, String job, Integer salary){
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }
    public void add(Employee e){
        subordinates.add(e);
    }
    public void remove(Employee e){
        subordinates.remove(e);
    }
    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                '}';
    }
}
