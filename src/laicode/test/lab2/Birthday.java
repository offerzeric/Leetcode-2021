package laicode.test.lab2;


import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Birthday {
      public static void main(String[] args) {
            while(Boolean.TRUE){
                  System.out.print("Enter your birth month [1..12]: ");
                  Scanner in = new Scanner(System.in);
                  int month = in.nextInt();
                  System.out.print("Enter your birth day of month: ");
                  int day = in.nextInt();
                  System.out.print("Enter your birth year [4-digit year]: ");
                  int year = in.nextInt();
                  LocalDate userBirth  = LocalDate.of(year,month,day);
                  LocalDate now = LocalDate.now();
                  if(userBirth.isBefore(now)){
                        System.out.println("Your birthday has already happened this year.");
                  }else if(userBirth.isAfter(now)){
                        System.out.println("Your birthday has not yet happened this year.");
                  }else {
                        System.out.println("Happy Birthday!");
                  }
                  Period until = userBirth.until(now);
                  System.out.println("You're "+until.getYears()+" years old.");
            }
      }
}
