package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		List<Department> list = new ArrayList<>();
		
		System.out.println("=== TESTE 1: deparment findById ===");

		Department department = departmentDao.findById(1);

		System.out.println(department);
		
		System.out.println("\n=== TESTE 2: department findAll ===");

		list = departmentDao.findAll();

		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TESTE 3: department Instert ===");
		
		Department newDepartment = new Department(null, "D3");
		
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TESTE 4: department update ===");
		
		department = departmentDao.findById(1);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 5: seller delete ===");
		
		System.out.print("Enter id for delete teste: ");
		
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
