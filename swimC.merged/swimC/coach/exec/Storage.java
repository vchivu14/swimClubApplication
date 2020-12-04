package swimC.coach.exec;

import swimC.coach.models.*;
import swimC.chairman.Member;
import java.util.*;
import java.io.*;

public class Storage {
   
   // we create the variables and ArrayLists that will help us retrieve data from files
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

   private static File filepathMembers = new File("./members.txt");
   private static File filepathSwimmers = new File("./swimmers.txt");
   private static File filepathDisciplines  = new File("./disciplines.txt");
   private static File filepathCompetition  = new File("./competitions.txt");
   private static File filepathCompetitionLists = new File("./competitionLists.txt");
   private static File filepathTrainingResults = new File("./trainingResults.txt");
   private static File filepathCompetitionResults = new File("./competitionResults.txt");
 
   // this function will start reading from each of the above files the records they keep
   //    this function will be used in the Coach Program
   public static void connectD() {
      try {
         inputMS = new Scanner(filepathMembers);
         while (inputMS.hasNextLine()) {
            String s = inputMS.nextLine();
            line = new Scanner(s);
            if (line.hasNext()) {
               member = new Member();
               member.setID(line.nextInt());
               member.setFirstName(line.next());
               member.setLastName(line.next());
               member.setAge(line.nextInt());
               member.setMobile(line.next());
               member.setEmail(line.next());
               member.setIsMemberActive(line.nextBoolean());
               member.setIsMemberElite(line.nextBoolean());
               member.setFees(line.nextInt());
               member.setBehind(line.nextBoolean());
               members.add(member);
            }
         }
         inputMS.close();
      } catch (Exception e) {
         System.out.println("File not Found");
      }

      try {
         inputMS = new Scanner(filepathSwimmers);
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
               swimmer.setDisciplineID(line.nextInt());
               swimmer.setCoach(line.next());
               swimmers.add(swimmer);
            }
         }
         inputMS.close();
      } catch (Exception e) {
         System.out.println("File not Found");
      }

      try {
         inputMS = new Scanner(filepathDisciplines);
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
      } catch (Exception e) {
         System.out.println("File not Found");
      }

      try {
         inputMS = new Scanner(filepathCompetition);
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
      } catch (Exception e) {
         System.out.println("File not Found");
      }

      try {
         inputMS = new Scanner(filepathCompetitionLists);
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
      } catch (Exception e) {
         System.out.println("File not Found");
      }

      try {
         inputMS = new Scanner(filepathTrainingResults);
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
      } catch (Exception e) {
         System.out.println("File not Found");
      }

      try {
         inputMS = new Scanner(filepathCompetitionResults);
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
      } catch (Exception e) {
         System.out.println("File not Found");
      }

   }

}