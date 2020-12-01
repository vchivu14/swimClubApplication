package swimC.coach.exec;

import swimC.coach.models.*;
import swimC.chairman.Member;
import java.util.*;
import java.io.*;

public class Storage {   
   
   private static Member member;
   private static ArrayList<Member> members = new ArrayList<Member>();
   private static Swimmer swimmer;
   private static ArrayList<Swimmer> swimmers = new ArrayList<Swimmer>();
   private static Discipline discipline;
   private static ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
   private static Competition competition;
   private static ArrayList<Competition> competitions = new ArrayList<Competition>();
   private static CompetitionList competitionList;
   private static ArrayList<CompetitionList> competitionLists = new ArrayList<CompetitionList>();
   private static TrainingResult trainingResult;
   private static ArrayList<TrainingResult> trainingResults = new ArrayList<TrainingResult>();
   private static CompetitionResult competitionResult;
   private static ArrayList<CompetitionResult> competitionResults = new ArrayList<CompetitionResult>();

   static Scanner inputMS;
   static Scanner line;
   
   public static ArrayList<Member> getMembers() {
      return members;
   }
   public static ArrayList<Swimmer> getSwimmers() {
      return swimmers;
   }
   public static ArrayList<Discipline> getDisciplines() {
      return disciplines;
   }
   public static ArrayList<Competition> getCompetitions() {
      return competitions;
   }
   public static ArrayList<CompetitionList> getCompetitionLists() {
      return competitionLists;
   }
   public static ArrayList<TrainingResult> getTrainingResultsLists() {
      return trainingResults;
   }
   public static ArrayList<CompetitionResult> getCompetitionResultsLists() {
      return competitionResults;
   }

   public static void connectD() {
      try {
         inputMS = new Scanner(new File("members.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               member = new Member();
               member.setID(line.nextInt());
               member.setFirstName(line.next());
               member.setLastName(line.next());
               member.setEmail(line.next());
               member.setMobile(line.next());
               member.setAge(line.nextInt());
               member.setIsMemberActive(line.nextBoolean());
               member.setIsMemberElite(line.nextBoolean());
               member.setDiscipline(line.nextInt());
               member.setFees(line.nextInt());
               member.setBehind(line.nextBoolean());
               members.add(member);
            }
         }
         inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }
   
   
      try {
         inputMS = new Scanner(new File("swimmers.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               swimmer = new Swimmer();
               swimmer.setID(line.nextInt());
               swimmer.setFirstName(line.next());
               swimmer.setLastName(line.next());
               swimmer.setMobile(line.next());
               swimmer.setAge(line.nextInt());
               swimmer.setDiscipline(line.nextInt());
               swimmer.setCoach(line.next());
               swimmers.add(swimmer);
            }
         }
         inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }
      
      try {
         inputMS = new Scanner(new File("disciplines.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               discipline = new Discipline();
               discipline.setID(line.nextInt());
               discipline.setName(line.next());
               disciplines.add(discipline);
            }
         }
      inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }
      
      try {
         inputMS = new Scanner(new File("competitions.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               competition = new Competition();
               competition.setID(line.nextInt());
               competition.setName(line.next());
               competitions.add(competition);
            }
         }
      inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }
      
      try {
         inputMS = new Scanner(new File("competitionLists.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               competitionList = new CompetitionList();
               competitionList.setID(line.nextInt());
               competitionList.setCompetitionID(line.nextInt());
               while (line.hasNextInt()) {
                  competitionList.setSwimmerID(line.nextInt());
               }
               competitionLists.add(competitionList);
            }
         }
      inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }
      
      try {
         inputMS = new Scanner(new File("trainingResults.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               trainingResult = new TrainingResult();
               trainingResult.setID(line.nextInt());
               trainingResult.setSwimmerID(line.nextInt());
               trainingResult.setDisciplineID(line.nextInt());
               trainingResult.setRally(line.nextInt());
               trainingResult.setTime(line.nextDouble());
               trainingResults.add(trainingResult);
            }
         }
      inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }
      
      try {
         inputMS = new Scanner(new File("competitionResults.txt"));
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);   
            if (line.hasNext()) {
               competitionResult = new CompetitionResult();
               competitionResult.setID(line.nextInt());
               competitionResult.setCompetitionID(line.nextInt());
               competitionResult.setSwimmerID(line.nextInt());
               competitionResult.setDisciplineID(line.nextInt());
               competitionResult.setRally(line.nextInt());
               competitionResult.setTime(line.nextDouble());
               competitionResult.setPosition(line.nextInt());
               competitionResults.add(competitionResult);
            }
         }
      inputMS.close();
      }
      catch (Exception e) {
         System.out.println("File not Found");
      }    
 

   }
   
}