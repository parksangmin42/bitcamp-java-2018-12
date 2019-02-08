package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Member;

public class MemberDataLoaderListener implements ApplicationListener {

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("회원정보를 작업할 준비 중..");

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("member.data")))){

      context.put("memberlist", in.readObject());

    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("memberlist", new LinkedList<Member>());

    }
  }


  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("회원정보를 저장하고 종료합니다.");
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("member.data")))) {

      out.writeObject(context.get("memberlist"));

    } catch (Exception e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());

    }
  }

}
