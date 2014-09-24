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
	
	public void testTodoEquals(){
		String todostring = "a test";
		String todostringc = "a c test";
		Todos todoa = new Todos(todostring);
		Todos todob = new Todos(todostring);
		Todos todoc = new Todos(todostringc);
		assertTrue("a does not equal b", todoa.equals(todob));
		assertTrue("b does not equal a", todob.equals(todoa));
		assertFalse("a equals c", todoa.equals(todoc));
		assertFalse("b equals c", todob.equals(todoc));
		assertFalse("c equals a", todoc.equals(todoa));
		assertFalse("c equals b", todoc.equals(todob));
		assertTrue("a does not equal a", todoa.equals(todoa));
		assertTrue("b does not equal b", todob.equals(todob));
		assertTrue("c does not equal c", todoc.equals(todoc));
	}
}
