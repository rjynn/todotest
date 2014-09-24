package com.rjynndee.todolist.test;

import java.io.IOException;

import com.rjynndee.todolist.ToDoListManager;
import com.rjynndee.todolist.TodoList;
import com.rjynndee.todolist.Todos;

import android.test.AndroidTestCase;

public class TodoListManagerTest extends AndroidTestCase{
	public void testTodoListToString(){
		TodoList tl = new TodoList();
		Todos test = new Todos("Test");
		tl.addtodo(test);
		try {
			String str = ToDoListManager.TodoListToString(tl);
			assertTrue("String is too small", str.length() >0);
			TodoList tl2 = ToDoListManager.TodoListFromString(str);
			assertTrue("Tl2<0 size", tl2.size() >0);
			assertTrue("tl2 does not contain test here"+str, tl2.contains(test));
			
		} catch (IOException e) {
			assertTrue("IOException "+e,false);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			assertTrue("CLASSNOTFOUND E"+e,false);
			e.printStackTrace();
		}
	}
	
	public void testToDoListManager(){
		try {
			TodoList tl = new TodoList();
			Todos todo = new Todos("test");
			tl.addtodo(todo);
			ToDoListManager tdlm = new ToDoListManager(getContext());
			tdlm.saveTodoList(tl);
			TodoList tl2 = tdlm.loadTodoList();
			assertTrue("Test not in todolist2 1",tl2.size() == 1);
			assertTrue("Test not in todolist1", tl.contains(todo));
			assertTrue("Test not in todolist2", tl2.contains(todo));
			}
		catch (IOException e){
			assertTrue("IOEXCEPTION THROWN"+e.toString(),false);
		} catch (ClassNotFoundException e) {
			assertTrue("Class not found"+e.toString(),false);
			e.printStackTrace();
		}
		
		
	}
}
