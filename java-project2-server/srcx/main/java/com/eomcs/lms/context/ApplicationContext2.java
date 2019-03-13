package com.eomcs.lms.context;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.handler.Command;

public class ApplicationContext2 {

  List<Class<?>> classes = new ArrayList<>();

  public ApplicationContext2(String packageName) throws Exception {
    File packageDir = Resources.getResourceAsFile(packageName.replaceAll(".", "/"));
    // packageDir 변수에는 이니셜라이져에서 보낸 com.eomcs.lms경로를 com/eomcs/lms로
    // 변환하여 저장한다. spring framework는 디렉토리나 경로를 .이 아닌 /로 구분하기 때문이다.

    findClasses(packageDir, packageName);

    prepareCommand();

  }


  private void findClasses(File dir, String packageName) throws Exception {
    File[] files = dir.listFiles((File pathname) -> {
      if (pathname.isDirectory())
        return true;

      if (pathname.getName().endsWith(".class") && 
          !pathname.getName().contains("$"))
        return true;

      return false;
    });

    for (File f : files) {
      if (f.isFile()) {
        String filename = f.getName();
        String className = packageName + "." +
            filename.substring(0, filename.indexOf('.'));

        Class<?> clazz = Class.forName(className);

        if (clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum())
          continue;

        if (Modifier.isAbstract(clazz.getModifiers()) || 
            !Modifier.isPublic(clazz.getModifiers()))
          continue;

        classes.add(clazz);
      } else {
        findClasses(f, packageName + "." + f.getName());
      }
    }
  }


  private void prepareCommand() {
    for (Class<?> clazz : classes) {
      List<Class<?>> interfaces = getAllInterfaces(clazz);
      
      for (Class<?> i : interfaces) {
        if (i == Command.class) {
          System.out.println(clazz.getName());
          break;
        }
      }
    }
  }


  private List<Class<?>> getAllInterfaces(Class<?> clazz) {
    ArrayList<Class<?>> list = new ArrayList<>();

    while (clazz != Object.class) {
      Class<?>[] interfaces = clazz.getInterfaces();
      for(Class<?> i : interfaces)
        list.add(i);
      clazz = clazz.getSuperclass();

    }
    return list;
  }
}



















