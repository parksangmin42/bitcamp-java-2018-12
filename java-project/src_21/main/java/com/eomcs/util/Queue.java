// 제네릭 적용
package com.eomcs.util;

// Queue가 보관하는 데이터 타입을 E 라고 가정하자.
// => E라고 가정한 상태에서 코드를 작성한다.
// 
public class Queue<E> extends LinkedList<E> implements Cloneable {
// 상속과 인터페이스 정의 중에 extends 먼저하고 그다음에 implements를 한다
  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  
  // 복제 기능 추가
  // => 그냥 Object에서 상속 받은 clone() 메서드를 오버라이딩 하면 된다.
  // => public으로 공개한다.
  // => 리턴 타입을 클래스 타입으로 변경한다.
  // => 클래스에 대해 복제를 허락하도록 java.lang.Cloneable
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    // Object에서 상속 받은 clone()은 
    // 인스턴스 필드의 값만 복제한다..
    // 인스턴스 필드가 가리키는 다른 인스턴스는 복제하지 않는다.
    // 예를 들어 Stack의 list 배열 레퍼런스가 가리키는 배열 인스턴스는 복제하지 않는다.
    // 배열 인스턴스까지 복제(deep clone)하려면 개발자가 직접 코드를 작성해야 한다.
    //return (Queue<E>) super.clone();
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size; i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
}
