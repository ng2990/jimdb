package com.stanrnd.jimdb;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.stanrnd.jimdb.IndexConfig;
import com.stanrnd.jimdb.Table;
import com.stanrnd.jimdb.select.Filter;
import com.stanrnd.jimdb.select.LogOp;
import com.stanrnd.jimdb.select.Op;

public class FindTest {
	
	private static Table<Employee> table;
	
	@BeforeClass
	public static void init() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		table = new Table<Employee>(100, new IndexConfig("department", "address", "gender"));
		table.insert(new Employee("eid02", "Alan", "male", 20000, "HR", "Bangalore", "alan@gmail.com"));
		table.insert(new Employee("eid18", "Krish", "male", 10000, "IT", "Bangalore", "krish@gmail.com"));
		table.insert(new Employee("eid16", "Shiny", "female", 60000, "QA", "Chennai", "shiny@gmail.com"));
		table.insert(new Employee("eid11", "James", "male", 50000, "IT", "Bangalore", "james@gmail.com"));
		table.insert(new Employee("eid20", "Stalin", "male", 50000, "IT", "Chennai", "stalin@gmail.com"));
		table.insert(new Employee("eid12", "Anto", "male", 30000, "ADMIN", "Bangalore", "anto@gmail.com"));
		table.insert(new Employee("eid15", "Stanley", "male", 80000, "IT", "Chennai", "stanley@yahoo.com"));
		table.insert(new Employee("eid13", "Rosy", "female", 90000, "HR", "Bangalore", "rosy@yahoo.com"));
		table.insert(new Employee("eid06", "Jacklin", "female", 10000, "QA", "Bangalore", "jacklin@gmail.com"));
	}
	
	@Test
	public void testFindMethod() throws IllegalArgumentException, IllegalAccessException {
		
		table.update(new Employee(34000, null, null), new Filter(new Filter(new Filter("department", Op.EQ, "IT"), LogOp.OR, new Filter("department", Op.EQ, "QA")), LogOp.AND, new Filter("address", Op.EQ, "Bangalore")));
		
		List<Employee> employees = table.find(new Filter(new Filter(new Filter("department", Op.EQ, "IT"), LogOp.OR, new Filter("department", Op.EQ, "QA")), LogOp.AND, new Filter("address", Op.EQ, "Bangalore")));
		for(Employee employee:employees) {
			System.out.println(employee);
		}
		
		//table.delete(new Filter(new Filter(new Filter("department", Op.EQ, "IT"), LogOp.OR, new Filter("department", Op.EQ, "QA")), LogOp.AND, new Filter("address", Op.EQ, "Bangalore")));
	}

}
