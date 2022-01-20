package laicode.test.lab2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;


public class LocalDateTest {
   public static final long TWENTY_DAYS = 20L;
   public static void main(String[] args) {
      LocalDate myDate = LocalDate.of(1995, Month.JANUARY, 20);
      getDate(myDate);
      LocalDate later = plusDaysNew(myDate);
      myDate = plusDaysChange(myDate);
   }

   private static LocalDate plusDaysChange(LocalDate myDate) {
      myDate = myDate.plusDays(LocalDateTest.TWENTY_DAYS);
      return myDate;
   }

   private static LocalDate plusDaysNew(LocalDate timeParam) {
      LocalDate later = timeParam.plusDays(LocalDateTest.TWENTY_DAYS);
      return later;
   }

   private static void getDate(LocalDate timeParam) {
      int dayOfMonth = timeParam.getDayOfMonth();
      int dayOfYear = timeParam.getYear();
      int monthValue = timeParam.getMonthValue();
      System.out.println(monthValue+"/"+dayOfMonth+"/"+dayOfYear);
   }
}
