package com.rjynndee.todolist.test;

import java.io.IOException;

import com.rjynndee.todolist.ToDoListManager;
import com.rjynndee.todolist.TodoList;
import com.rjynndee.todolist.Todos;

import android.test.AndroidTestCase;

public class TodoListManagerTest extends AndroidTestCase{
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
