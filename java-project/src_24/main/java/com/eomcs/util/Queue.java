package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    // Queue의 수퍼 클래스인 LinkedList가 복제를 허락하지 않았기 때문에
    // 자식 클래스에서는 직접 복제 기능을 구현해야 한다.
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  
  public void offer(E value) {
    add(value);
  }
  
  public E poll() {
    if (size() > 0)
      return remove(0);
    return null;
  }
  
  public boolean empty() {
    return this.size() == 0;
  }
  
/*
  public static void main(String[] args) throws Exception {
    Queue<String> queue = new Queue<>();
    queue.offer("aaa");
    queue.offer("bbb");
    queue.offer("ccc");
    queue.offer("ddd");
    queue.offer("eee");
    queue.offer("fff");
    
    Queue<String> temp1 = queue.clone();
    while (temp1.size() > 0) {
      System.out.println(temp1.poll());
    }
    System.out.println("----------------------");
    
    Queue<String> temp2 = queue.clone();
    while (temp2.size() > 0) {
      System.out.println(temp2.poll());
    }
  }
*/
  
  public Iterator<E> iterator() {
    
    
    return new Iterator<E>() {
      // 이 클래스는 Queue에서 값을 꺼내주는 일일 전문적으로 한다.
      // => 이런 일을 하는 객체를 "Iterator"라 부른다. (반복자)
      int index = 0;
      
      @Override
      public boolean hasNest() {
        return index < size();
      }
      
      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        return (E) get(index++);
      }
    };
  }
  
}
