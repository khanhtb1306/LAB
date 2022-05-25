/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandlesFiles;

/**
 *
 * @author trinh
 */
public class Person implements Comparable<Person>{
    private String Name, Address;
    private double Salary;

    public Person() {
    }

    public Person(String Name, String Address, double Salary) {
        this.Name = Name;
        this.Address = Address;
        this.Salary = Salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%.1f", Name, Address, Salary);
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(Salary, o.Salary);
    }

}
