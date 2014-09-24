package com.rjynndee.todolist.test;

import com.rjynndee.todolist.ToDoListManager;
import com.rjynndee.todolist.TodoList;
import com.rjynndee.todolist.Todos;

import android.test.AndroidTestCase;

public class TodoListManagerTest extends AndroidTestCase{
	public void testToDoListManager(){
		TodoList tl = new TodoList();
		Todos todo = new Todos("test");
		tl.addtodo(todo);
		ToDoListManager tdlm = new ToDoListManager(getContext());
		tdlm.saveTodoList(tl);
		TodoList tl2 = tdlm.loadTodoList();
		assertTrue("Test in todolist1", tl.contains(todo));
		assertTrue("Test in todolist2", tl2.contains(todo));
		
	}
}
