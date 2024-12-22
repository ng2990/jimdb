package com.stanrnd.jimdb.select;

import java.util.List;

import com.stanrnd.jimdb.select.Operation;

public class BSTFilterNode {

	private String field;

	private Object value;

	private BSTFilterNode leftOperand;

	private BSTFilterNode rightOperand;
	
	private Operation operation;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public BSTFilterNode getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(BSTFilterNode leftOperand) {
		this.leftOperand = leftOperand;
	}

	public BSTFilterNode getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(BSTFilterNode rightOperand) {
		this.rightOperand = rightOperand;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public List<Integer> process() {
		if(this.leftOperand != null && this.rightOperand != null) {
			List<Integer> leftList = this.leftOperand.process();
			List<Integer> rightList = this.rightOperand.process();
			return operation.eval(leftList, rightList);
		}
		return operation.eval(field, value);
	}
	
}
