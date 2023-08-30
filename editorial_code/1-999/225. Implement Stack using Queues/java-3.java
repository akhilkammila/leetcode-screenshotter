// Removes the element on top of the stack.
public void pop() {
    q1.remove();
    if (!q1.isEmpty()) {
    	top = q1.peek();
    }
}