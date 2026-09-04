package model;

import java.util.Objects;

public class Employee {
    private Integer id;
    private String name;
    private int age;
    private String department;
    private String designation;
    private String reporting_to;


    public Employee(int id, String name, int age, String department, String designation, String reporting_to) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.reporting_to = reporting_to;
    }

    public int getId() {
        return id;
    }

    public String getReporting_to() {
        return reporting_to;
    }

    public void setReporting_id(String reporting_to) {
        this.reporting_to = reporting_to;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && reporting_to == employee.reporting_to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reporting_to);
    }

    @Override
    public String toString() {
        return id+"\t"+name+"\t"+age+"\t"+department+"\t"+designation+"\t"+ (reporting_to == "" ? "---" : reporting_to);
    }
}
