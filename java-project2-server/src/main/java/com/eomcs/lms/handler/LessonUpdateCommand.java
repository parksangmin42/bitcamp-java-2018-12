package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();
      int no = Integer.parseInt(in.readLine());

      Lesson lesson = lessonDao.findByNo(no);
      if (lesson == null) {
        out.println("해당 번호의 수업이 없습니다.");
        return;
      }

      Lesson temp = lesson.clone();

      out.printf("수업명(%s)?\n", lesson.getTitle());
      String input = in.readLine();
      if (input.length() > 0) 
        temp.setTitle(input);

      out.printf("설명(%s)?\n", lesson.getContents());
      if ((input = in.readLine()).length() > 0)
        temp.setContents(input);

      out.printf("시작일(%s)?\n", lesson.getStartDate());
      if ((input = in.readLine()).length() > 0)
        temp.setStartDate(Date.valueOf(input));

      out.printf("종료일(%s)?\n", lesson.getEndDate());
      if ((input = in.readLine()).length() > 0)
        temp.setEndDate(Date.valueOf(input));

      out.printf("총수업시간(%d)?\n", lesson.getTotalHours());
      if ((input = in.readLine()).length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      out.printf("일수업시간(%d)?\n", lesson.getDayHours());
      if ((input = in.readLine()).length() > 0)
        temp.setDayHours(Integer.parseInt(input));

      lessonDao.update(temp);

      out.println("변경했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
