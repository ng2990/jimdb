package com.stanrnd.jimdb;

import java.util.List;

import com.stanrnd.jimdb.IndexConfig;
import com.stanrnd.jimdb.Table;
import com.stanrnd.jimdb.select.Filter;
import com.stanrnd.jimdb.select.LogOp;
import com.stanrnd.jimdb.select.Op;

public class SequentialReadsEventuallySucceed {
	/*
	 * Validates that sequential reads eventually succeed
	 */
		
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Table<Employee> table = new Table<Employee>(100, new IndexConfig("department", "address", "gender"));
    	table.insert(new Employee("eid02", "Alan", "male", 20000, "HR", "Bangalore", "alan@gmail.com"));
    	
    	int completed_reads = 0;
    	for (int i = 0; i < 50; i++) {
    		table.find(new Filter("department", Op.EQ, "IT"));
    		completed_reads = completed_reads + 1;
    	}
    	
    	assert completed_reads == 49;    	
    }
}
