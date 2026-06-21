import java.io.*;
import java.util.*;
class Employee implements Serializable {
	private int employeeId;
	private String name;
	private String department;
	private double salary;
	public Employee(int employeeId, String name, String department, double salary) {
		this.employeeId=employeeId;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	public void display() {
		System.out.println("ID: "+employeeId+", Name: "+name+", Dept: "+department+", Salary: "+salary);
	}
}
public class EmployeeSerialization {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter Employee ID:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Name:");
			String name=sc.nextLine();
			System.out.println("Enter Department:");
			String dept=sc.nextLine();
			System.out.println("Enter Salary:");
			double salary=sc.nextDouble();
			Employee emp=new Employee(id, name, dept, salary);
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employee.ser"));
			oos.writeObject(emp);
			oos.close();
			System.out.println("Employee serialized!");
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("employee.ser"));
			Employee recoveredEmp=(Employee)ois.readObject();
			ois.close();
			System.out.println("Recovered Employee:");
			recoveredEmp.display();
		} catch(IOException|ClassNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		} finally {
			sc.close();
		}
	}
}
