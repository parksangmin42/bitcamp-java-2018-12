package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;

public class BoardDataLoaderListener implements ApplicationListener {

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("게시판 정보를 작업할 준비 중..");

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("board.data")))){

      context.put("boardList", in.readObject());

    } catch (Exception e) {
      System.out.println("게시판 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("boardList", new ArrayList<Board>());

    }
  }


  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("게시판 정보를 저장하고 종료합니다.");
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("board.data")))) {

      out.writeObject(context.get("boardList"));

    } catch (Exception e) {
      System.out.println("게시판 데이터를 쓰는 중 오류 발생: " + e.toString());

    }
  }
}
