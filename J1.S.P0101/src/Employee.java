
public class Employee implements Comparable<Employee> {

    public String Id, FirstName, LastName, Phone, Email, Address, DOB, Sex, Agency;
    public double Salary;

    public Employee() {
    }

    public Employee(String Id, String FirstName, String LastName, String Phone, String Email, String Address, String DOB, String Sex, double Salary, String Agency) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.Agency = Agency;
        this.Salary = Salary;
    }
    
    //copy constructor
    public Employee(Employee emp) {

        this.Id = emp.Id;
        this.FirstName = emp.FirstName;
        this.LastName = emp.LastName;
        this.Phone = emp.Phone;
        this.Email = emp.Email;
        this.Address = emp.Address;
        this.DOB = emp.DOB;
        this.Sex = emp.Sex;
        this.Agency = emp.Agency;
        this.Salary = emp.Salary;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        //String , String , String , String , String , String , String , String , double , String 
        return String.format("%-10s%-15s%-15s%-15s%-20s%-20s%-16s%-10s%-10.1f%s",
                Id, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency);
    }

    public boolean Compare(Employee o) {
        if (Id.equalsIgnoreCase(o.getId())
                && FirstName.equalsIgnoreCase(o.getFirstName())
                && LastName.equalsIgnoreCase(o.getLastName())
                && Phone.equals(o.getPhone())
                && Email.equalsIgnoreCase(o.getEmail())
                && Address.equalsIgnoreCase(o.getAddress())
                && DOB.equalsIgnoreCase(o.getDOB())
                && Sex.equalsIgnoreCase(o.getSex())
                && Double.compare(Salary, o.getSalary()) == 0
                && Agency.equalsIgnoreCase(o.getAgency())) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(Salary, o.getSalary());
    }

}
