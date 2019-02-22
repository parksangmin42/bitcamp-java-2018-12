package com.eomcs.lms.handler;

public class Test {
public static void main(String[] args) {
  int a = 0;
  int b = 1;
  int c = 2;
  
  while (true) {
    
    if (a > b) {
      System.out.println("참");
      break;
    } else if (a < c) {
      System.out.println("참참");
      break;
    } 
    System.out.println("dd");
    
  } // while
  System.out.println("빠져나옴");
}
}
