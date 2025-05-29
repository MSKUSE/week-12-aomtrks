public class StackLinkedList<T> implements Stack<T>{

    StackItem<T> top;
    @Override
    public void push(T item) {
        StackItem<T> newBox = new StackItem<T>(item);
        StackItem<T> previousTop = top;
        top = newBox;
        top.setNext(previousTop);
    }
    @Override
    public T pop() throws MyEmptyStackException {
        if(this.top ==null){
            throw new MyEmptyStackException("Stack is Empty, you can't pop anything from empty stack");
        }
        T tempData = top.getData();
        top = top.getNext();
        return tempData;
    }

    @Override
    public void peek() {
        System.out.println("The top is "
        + this.top.getData());
    }
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }
    public void displayStack(){
        StackItem<T> tempNode = top;
        if(this.isEmpty()){
            System.out.println("The stack is empty!!");
        }else{
            do{
                System.out.println(tempNode.getData());
                tempNode = tempNode.getNext();
            }
            while (tempNode != null);
        }
    }

    @Override
    public String toString() {
        return "StackLinkedList{" +
                "top=" + top +
                '}';
    }
}
