package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class LessonDataLoaderListener implements ApplicationListener {

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("수업정보를 작업할 준비 중..");

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("lesson3.data")))){

      context.put("lessonlist", in.readObject());

    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("lessonlist", new ArrayList<Lesson>());

    }
  }


  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("수업정보를 저장하고 종료합니다.");
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("lesson3.data")))) {

      out.writeObject(context.get("lessonlist"));

    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());

    }
  }
}


