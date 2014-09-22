package com.rjynndee.todolist.test;

import junit.framework.TestCase;
import com.rjynndee.todolist.Todos;
public class ToDoTest extends TestCase {
	public void testTodos(){
		String todostring = "To do element";
		Todos todo = new Todos(todostring);
		assertTrue("to do name is not equal", todostring.equals(todo.getName()));
		assertTrue("To Do name.toString is not equal", todostring.toString().equals(todo.getName()));
	}
	
	public void testchecked(){
		String todostring = "to do element";
		Todos todo = new Todos(todostring);
		boolean boolcheck = todo.getchecked();
		assertTrue("Checked is false", boolcheck == false);
		todo.changeCheck();
		assertTrue("Checked changed", boolcheck != todo.getchecked());
		
	}
	
	public void testarchived(){
		String todostring = "to do element";
		Todos todo = new Todos(todostring);
		boolean boolcheck = todo.getarchived();
		assertTrue("Not archived", boolcheck == false);
		todo.changeArchived();
		assertTrue("Archived", boolcheck != todo.getarchived());
	}
}
