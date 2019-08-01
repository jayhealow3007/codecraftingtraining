package stack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {

	List<Object> stack = new ArrayList<>(); 

	public void push(Object object) {
		stack.add(object);
	}
	
	public Object pop() throws EmptyStackException {
		if(stack.isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		}
		Object object = stack.get(stack.size() - 1);
		stack.remove(object);
		return object;
	}
	
}
