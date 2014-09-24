package com.rjynndee.todolist.test;

import java.util.Collection;

import com.rjynndee.todolist.Listener;
import com.rjynndee.todolist.TodoList;
import com.rjynndee.todolist.Todos;
import junit.framework.TestCase;

public class ListoftodosTest extends TestCase {
	public void testEmptyListoftodos(){
		TodoList todolist = new TodoList();
		Collection<Todos> todos = todolist.getTodos();
		assertTrue("Empty To do list", todos.size() == 0);
	}
	public void testAddtodo(){
		TodoList todolist = new TodoList();
		String newTodo = "A to do";
		Todos testToDo = new Todos(newTodo);
		todolist.addtodo(testToDo);
		Collection<Todos> todos = todolist.getTodos();
		assertTrue("To do List Size", todos.size() == 1);
		assertTrue("Does not contain that todo",todos.contains(testToDo));
	}
	public void testRemovetodo(){
		TodoList todolist = new TodoList();
		String newTodo = "A to do";
		Todos testToDo = new Todos(newTodo);
		todolist.addtodo(testToDo);
		todolist.removetodo(testToDo);
		Collection<Todos> todos = todolist.getTodos();
		assertTrue("To do List Size is wrong", todos.size() == 0);
		assertFalse("Does contain that todo",todos.contains(testToDo));
	}
	boolean updated = false;
	
	public void testNotifyListeners(){
		TodoList list = new TodoList();
		updated = false;
		Listener l = new Listener(){
			public void update(){
				ListoftodosTest.this.updated = true;
			}
		};
		list.addListener(l);
		Todos todo = new Todos("todo");
		list.addtodo(todo);
		assertTrue("To do list didn't fire an update", this.updated);
		updated = false;
		list.removetodo(todo);
		assertTrue("Remove didn't fire an update", this.updated);
	}
	
	public void testRemoveListeners(){
		TodoList list = new TodoList();
		updated = false;
		Listener l = new Listener(){
			public void update(){
				ListoftodosTest.this.updated = true;
			}
		};
		list.addListener(l);
		list.removeListener(l);
		list.addtodo(new Todos("todo"));
		assertFalse("To do list didn't fire an update", this.updated);	
	}
}
