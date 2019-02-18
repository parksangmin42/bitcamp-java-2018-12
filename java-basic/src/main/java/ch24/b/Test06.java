// JVM의 전체 스레드 계층도 
package ch24.b;

public class Test06 {

  public static void main(String[] args) {

    // JVM의 최상위 스레드 그룹인 system의 계층도 출력하기
    //

    Thread mainThread = Thread.currentThread();
    ThreadGroup maingroup = mainThread.getThreadGroup();
    ThreadGroup systemGroup = maingroup.getParent();
    
    printThreads(systemGroup, "");
  }
  
  static void printThreads(ThreadGroup tg, String indent) {
    System.out.println(indent + tg.getName() + "(TG)");
    
    // 현제 스레드 그룹에 소속된 스레드들 출력하기
    Thread[] threads = new Thread[10];
    int size = tg.enumerate(threads, false);
    for (int i = 0; i < size; i++) {
      System.out.println(indent + "  ==>" + threads[i].getName() + "(T)");
    }
    
    // 현재 스레드 그룹에 소속된 하위 스레드 그룹들 출력하기
    ThreadGroup[] groups = new ThreadGroup[10];
    size = tg.enumerate(groups, false);
    for (int i = 0; i < size; i++) {
      printThreads(groups[i], indent + "  ");
    }
  }

}

/*
JVM의 스레드 계층도:

system(TG)
  ==>Reference Handler(T)  // 레퍼런스를 관리하는 레퍼런스 카운팅을 관리
  ==>Finalizer(T) // 가비지 컬렉터가 가비지를 수집하면 가비지를 마무리하는
  ==>Signal Dispatcher(T) //
  main(TG)
    ==>main(T) // 메인 메서드를 호출한다.
  InnocuousThreadGroup(TG)
    ==>Common-Cleaner(T)


 */


