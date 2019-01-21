package com.eomcs.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class ArrayList<E> {
  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list  = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    return a;
  }

  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = obj;
  }

  public int size() {
    return size;
  }

  public E get(int i) {
    if (i < 0 || i >= size) {
      return null;
    }
    return (E) list[i];
  }

  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
     E obj = (E) list[index];
    for (int i = index; i < size -1; i++)
      list[i] = list[i + 1];
    size --;
    return obj;
    


  }

  public E set(int index, E obj) {
    if (index < 0 || index >= size)
      return null;
    
    E old = (E) list[index];
    list[index] = obj; // list[3]번을 파라미터로 받았고 바뀐 temp를 obj에 받고
                         // 수정된 temp 값을 기존 3번 값에 덧 씌운다.
    return old;
    
    
    
  }
}
