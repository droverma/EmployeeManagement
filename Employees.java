package pkgDay4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Employee {
	static int empCount = 0;
	private int empId;
	private String empName;
	private int empAge;
	private double salary;

	public Employee() {
		empId = 101;
		empName = "Drishti verma";
		empAge = 20;
		salary = 120000;
	}

	public Employee(int empId, String empName, int des, double sal) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = des;
		this.salary = sal;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getempAge() {
		return empAge;
	}

	public void setempAge(int empAge) {
		this.empAge = empAge;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		Employee.empCount = empCount;
	}

	@Override
	public String toString() {
		return "\nEmpId\tEmpName\teEmpAge\tSalary\n" + empId + "\t" + empName + "\t" + empAge + "\t" + salary + "\n";
	}

}

public class Employees {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Employee> empList = new ArrayList<Employee>();

	static boolean find(int idNumber) {
		for (Employee id : empList) {
			if (id.getEmpId() == idNumber) {
				return true;
			}
		}
		return false;
	}

	static Employee findRecord(int id) {
		for (Employee empId : empList) {
			if (empId.getEmpId() == id) {
				return empId;
			}
		}

		return null;
	}

	static boolean validateAge(int age) {
		if (age == 0)
			throw new ArithmeticException("Ghosts not allowed in Company");
		else if (age < 18)
			throw new ArithmeticException("Children not allowed in Company");
		else if (age >= 60)
			throw new ArithmeticException("Senior Citizens not allowed in Company");
		else if (age >= 200)
			throw new ArithmeticException("Zombies not allowed in Company");
		else if (age >= 18 && age <= 60)
			return true;
		else
			throw new ArithmeticException("Please enter correct age");
	}

	static void add(Employee record) {

		if (!find(record.getEmpId())) {
			System.out.println("\nRecord Saved Successfully\nEmployee List:" + record.toString());
			empList.add(record);
		} else {
			System.out.println("Record already exists in the Record list");
		}
	}

	static void details(int id) {
		if (find(id)) {
			Employee record = findRecord(id);
			System.out.println("\nEmployee List:" + record.toString());
		} else {
			System.out.println("Record Not Found!!!");
		}
	}

	static void display(Employee rec) {
		if (empList.isEmpty()) {
			System.out.println("The list has no records\n");
		}

		System.out.println("No of Employees:" + Employee.empCount + "\nEmployee List:");
		for (Employee list : empList) {
			System.out.println(list.toString());
		}
	}

	static void delete(int id) {
		Employee record = null;

		for (Employee list : empList) {
			if (list.getEmpId() == id) {
				record = list;
			}
		}

		if (record == null) {
			System.out.println("Invalid Employee Id");
		} else {
			record.setEmpCount(Employee.empCount - 1);
			empList.remove(record);
			System.out.println("Successfully delete record from the list");
		}
	}

	static void appraisal(int id) {
		if (find(id)) {
			Employee record = findRecord(id);

			System.out.print("Give appraisal percentage: ");
			double per = scan.nextInt();
			double sal = record.getSalary();
			double appraisal = sal * (per / 100) + sal;
			System.out.println(appraisal + "appraisal");

			record.setSalary(appraisal);
			System.out.println("\nEmployee List:" + record.toString());
		} else {
			System.out.println("Record Not Found!!!");
		}
	}

	static void menu() {
		System.out.println("Menu:");
		System.out.println(
				"1.Add Employee\n2.Details of Employee\n3.View Employee\n4.Delete Employee\n5.Give appraisal\n6.Exit");
		System.out.println("Enter choice:(1-5)");
	}

	public static void main(String[] args) {
		Employee record = new Employee();

		int option = 0;
		while (true) {
			menu();
			option = scan.nextInt();

			switch (option) {

			case 1:
				try {
					System.out.print("What is the new Employee id ? ");
					int empId = scan.nextInt();

					System.out.print("What is the new Employee Name ? ");
					String name = scan.next();
					System.out.print("What is the new Employee Age ? ");
					int age = scan.nextInt();
					validateAge(age);

					System.out.print("What is the new Salary ? ");
					double sal = scan.nextDouble();
					record.setEmpCount(Employee.empCount + 1);

					record = new Employee(empId, name, age, sal);
					add(record);
				} catch (ArithmeticException e) {
					System.out.println(e);
				} catch (InputMismatchException e) {
					System.out.println(e);
				}
				break;

			case 2:
				System.out.print("What is the Employee id ? ");
				int updateEmpid = scan.nextInt();
				details(updateEmpid);
				break;

			case 3:
				Employee rec = new Employee();
				display(rec);
				break;

			case 4:
				System.out.print("What is the Employee id ? ");
				int id = scan.nextInt();
				delete(id);
				break;
			case 5:
				System.out.print("What is the Employee id ? ");
				int eId = scan.nextInt();
				appraisal(eId);
				break;
			case 6:
				System.out.println("\nThank you for using the program. Goodbye!\n");
				System.exit(0);
				break;

			default:
				System.out.println("\nInvalid input\n");
				break;
			}
		}
	}

}



output:
Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
1
What is the new Employee id ? 101
What is the new Employee Name ? Drishti
What is the new Employee Age ? 25
What is the new Salary ? 120000

Record Saved Successfully
Employee List:
EmpId	EmpName	EmpAge	Salary
101	Drishti	25	120000.0

Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
1
What is the new Employee id ? 102
What is the new Employee Name ? Ajay
What is the new Employee Age ? 29
What is the new Salary ? 230000

Record Saved Successfully
Employee List:
EmpId	EmpName	EmpAge	Salary
102	Ajay	29	230000.0

Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
3
No of Employees:2
Employee List:

EmpId	EmpName	EmpAge	Salary
101	Drishti	25	120000.0


EmpId	EmpName	EmpAge	Salary
102	Ajay	29	230000.0

Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
2
What is the Employee id ? 101

Employee List:
EmpId	EmpName	EmpAge	Salary
101	Drishti	25	120000.0

Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
5
What is the Employee id ? 102
What is the new Salary ? 555000

Employee List:
EmpId	EmpName	EmpAge	Salary
102	Ajay	29	555000.0

Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
4
What is the Employee id ? 102
Successfully delete record from the list

Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
1
What is the new Employee id ? 105
What is the new Employee Name ? Megha
What is the new Employee Age ? 1
java.lang.ArithmeticException: Children not allowed in Company
Menu:
1.Add Employee
2.Details of Employee
3.View Employee
4.Delete Employee
5.Give appraisal
6.Exit
Enter choice:(1-6)
6

Thank you for using the program. Goodbye!

