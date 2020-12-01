package swimC.coach.exec;

import swimC.chairman.Member;
import swimC.coach.models.*;
import swimC.coach.views.*;
import swimC.coach.controllers.*;
import swimC.coach.interfaces.*;
import java.util.*;
import java.io.*;

public class ProgramCoach {
   private static ArrayList<Swimmer>swimmers;
   private static Swimmer swimmer;
   private static ArrayList<Member>members;
   private static Member member;
   private static Discipline discipline;
   private static ArrayList<Discipline> disciplines;
   private static Competition competition;
   private static ArrayList<Competition> competitions;
   private static CompetitionList competitionList;
   private static ArrayList<CompetitionList> competitionLists;
   private static TrainingResult trainingResult;
   private static ArrayList<TrainingResult> trainingResults;
   private static CompetitionResult competitionResult;
   private static ArrayList<CompetitionResult> competitionResults;
  
   static Scanner x;
   private static boolean program;
   
   public static void editRecord(String filepath, int swimmerID, int newDiscipline) {
      String tempFile = "temp.txt";
      File oldFile = new File(filepath);
      File newFile = new File(tempFile);
      int ID = 0; String name = ""; int mobile = 0; int age = 0; int discipline = 0; String coach = "";
      try {
         FileWriter fw = new FileWriter(tempFile, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         x = new Scanner(new File(filepath));
         
         while (x.hasNext()) {
            ID = x.nextInt();
            name = x.next();
            mobile = x.nextInt();
            age = x.nextInt();
            discipline = x.nextInt();
            coach = x.next();
            
            if(ID == swimmerID) {
               pw.println(ID + " " + name + " " + mobile + " " + age + " " + newDiscipline + " " + coach);
            }
            else {
               pw.println(ID + " " + name + " " + mobile + " " + age + " " + discipline + " " + coach);
            }
         }
         x.close();
         pw.flush();
         pw.close();
         oldFile.delete();
         File dump = new File(filepath);
         newFile.renameTo(dump);
      }
      catch (Exception e) {
         System.out.println("Error");
      }
   }
   
   
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
   
   private static void save() {
      swimmers = getSwimmers();
      members = getMembers();
      disciplines = getDisciplines();
      competitions = getCompetitions();
      competitionLists = getCompetitionLists();
      trainingResults = getTrainingResultsLists();
      competitionResults = getCompetitionResultsLists();
   }
   
   private static void clear() {
      swimmers.clear();
      members.clear();
      disciplines.clear();
      competitions.clear();
      competitionLists.clear();
      trainingResults.clear();
      competitionResults.clear();
   }
   
   private static void exec() {
      Storage.connectD();
      swimmers = Storage.getSwimmers();
      members = Storage.getMembers();
      disciplines = Storage.getDisciplines();
      competitions = Storage.getCompetitions();
      competitionLists = Storage.getCompetitionLists();
      trainingResults = Storage.getTrainingResultsLists();
      competitionResults = Storage.getCompetitionResultsLists();
   }
   
   private static Swimmer retrieveSwimmerFromDatabase(int option) {
      for (int i = 0; i < swimmers.size(); i++) {
         swimmer = swimmers.get(i);
         if (swimmer.getID() == option) {
            break;
         }
         else {
            continue;
         }   
      }      
      return swimmer;
   }
   
   private static Member retrieveMemberFromDatabase(int option) {
      for (int i = 0; i < members.size(); i++) {
         member = members.get(i);
         if (member.getID() == option) {
            break;
         }
         else {
            continue;
         }   
      }      
      return member;
   }
   
   private static Discipline retrieveDisciplineFromDatabase(int option) {      
      for (int i = 0; i < disciplines.size(); i++) {
         discipline = disciplines.get(i);
         if (discipline.getID() == option) {
            break;
         }
         else {
            continue;
         }   
      }      
      return discipline;
   }
   
   private static int retrieveIDDisciplineFromDatabase(int option) {
      int j = 0;      
      for (int i = 0; i < disciplines.size(); i++) {
         discipline = disciplines.get(i);
         if (discipline.getID() == option) {
            j = discipline.getID();
            break;
         }
         else {
            continue;
         }   
      }      
      return j;
   }
   
   private static int retrieveIDSwimmerFromDatabase(int option) {
      int j = 0;      
      for (int i = 0; i < swimmers.size(); i++) {
         swimmer = swimmers.get(i);
         if (swimmer.getID() == option) {
            j = swimmer.getID();
            break;
         }
         else {
            continue;
         }   
      }      
      return j;
   }
   
   private static int retrieveIDMemberFromDatabase(int option) {
      int j = 0;      
      for (int i = 0; i < members.size(); i++) {
         member = members.get(i);
         if (member.getID() == option) {
            j = member.getID();
            break;
         }
         else {
            continue;
         }   
      }      
      return j;
   }
   
   private static Member retrieveMembersFromDatabase(int i) {      
      member = members.get(i);
      return member;
   }
   
   private static Swimmer retrieveSwimmersFromDatabase(int i) {      
      swimmer = swimmers.get(i);
      return swimmer;
   }
   
   private static Discipline retrieveDisciplinesFromDatabase(int i) {      
      discipline = disciplines.get(i);
      return discipline;
   }
   
   private static Competition retrieveCompetitionsFromDatabase(int i) {      
      competition = competitions.get(i);
      return competition;
   }
   public static CompetitionList retrieveCompetitionListsFromDatabase(int i) {
      competitionList = competitionLists.get(i);
      return competitionList;
   }
   private static TrainingResult retrieveTrainingResultsFromDatabase(int i) {      
      trainingResult = trainingResults.get(i);
      return trainingResult;
   }
   private static CompetitionResult retrieveCompetitionResultsFromDatabase(int i) {      
      competitionResult = competitionResults.get(i);
      return competitionResult;
   }

   public static void ON() {
      program = true;
      menu();
   }
   
   public static void OFF() {
      program = false;
   }

   public static void menu () {
      exec();
      
      while (program) {
         int option = Coach.startMenu();
         
         if (option == 2) {
            boolean finding = false;
            while(!finding) {
               Swimmer model;
               SwimmerView view = new SwimmerView();
               SwimmerController controller;
               for (int i = 0; i < swimmers.size(); i++) {
                  model = retrieveSwimmersFromDatabase(i);
                  controller = new SwimmerController(model, view);
                  controller.updateView();
               }
               if (swimmers.size() > 0) {
               option = Coach.chooseSwimmer();
//                boolean s;
//                if ((option) instanceOf) Integer)) {
//                   s = true;
//                }
//                if (isInteger(option)) {
//                   s = true;
//                }

               if (option == 0) {
                  System.out.println();
                  System.out.println("Changes saved!");
                  break;
               }
               else if (option <= swimmers.size()) {
                  try {
                     model = retrieveSwimmerFromDatabase(option);
                     controller = new SwimmerController(model, view);
                     controller.updateView();
                  }
                  catch (Exception e) {
                     System.out.println("No Swimmer by that ID..");
                     break;  
                  }
               
                  boolean change = false;
                  while (!change) {
                     int disciplineOption;
                  
                     Discipline modelD;
                     DisciplineView viewD = new DisciplineView();
                     DisciplineController controllerD;
                  
                     for (int i = 0; i < disciplines.size(); i++) {
                        modelD = retrieveDisciplinesFromDatabase(i);
                        controllerD = new DisciplineController(modelD, viewD);
                        controllerD.updateView();
                     }
                     option = Coach.chooseDiscipline();
                  
                     try {
                        disciplineOption = retrieveIDDisciplineFromDatabase(option);
                     }
                     catch (Exception e) {
                        System.out.println("No Discipline by that ID..");
                        break;  
                     }
                     controller.setSwimmerDiscipline(disciplineOption); 
                     System.out.println("Swimmer's Discipline has been changed.");
                     controller.updateView();
                     
                     String optionSave = Coach.saveChanges();
                     if (optionSave.toLowerCase().equals("y")) {
                        editRecord("swimmers.txt", controller.getSwimmerID(), disciplineOption);
                        System.out.println("Changes saved!");
                     }
                     else if (optionSave.toLowerCase().equals("n")) {
                        clear();
                        exec();
                        System.out.println("Changes reverted!");
                     }
                     else {
                        clear();
                        exec();
                        System.out.println("Not a real Option!");
                        break;
                     }
                     
                     change = true;
                  
                     if (change) {
                        continue;
                     } else {
                        System.out.println("Not Found...");
                     }
                     break;
                  }
                  System.out.println("Try with other Swimmer?");
                  System.out.println("<y> for Yes, <n> for No");
                  Scanner what = new Scanner(System.in);
                  if (what.next().toLowerCase().equals("y")) {
                     save();
                     continue;
                  }
                  else {
                     
                     break;
                  }
               }
               
//                else if (!s) {
//                   System.out.println("Not a real Option!");
//                   break;
//                }
               else {
                  System.out.println("Not a real Option!");
                  break;
               }
            }
            else {
              System.out.println("No swimmers here!");
              break; 
            }
            }
            
         }
         
         else if (option == 1) {
            Member model;
            MemberView view = new MemberView();
            MemberController controller;
            for (int i = 0; i < members.size(); i++) {
               model = retrieveMembersFromDatabase(i);
               controller = new MemberController(model, view);
               controller.updateView();
            }
         }
         
         else if (option == 3) {
            Discipline model;
            DisciplineView view = new DisciplineView();
            DisciplineController controller;
            for (int i = 0; i < disciplines.size(); i++) {
               model = retrieveDisciplinesFromDatabase(i);
               controller = new DisciplineController(model, view);
               controller.updateView();
            }
         }
         
         else if (option == 4) {
            boolean start = false;
            while(!start) {
               Competition model;
               CompetitionView view = new CompetitionView();
               CompetitionController controllerC;              
               for (int i = 0; i < competitions.size(); i++) {
                  model = retrieveCompetitionsFromDatabase(i);
                  controllerC = new CompetitionController(model, view);
                  controllerC.updateView();
               }
               
               option = Coach.chooseCompetition();
               if (option == 0) {
                  System.out.println();
                  break;
               }
               else {
                  try {
                     model = retrieveCompetitionsFromDatabase(option-1);
                     controllerC = new CompetitionController(model, view);
                     controllerC.updateView();
                  }
                  catch (Exception e) {
                     System.out.println("No Competition by that ID..");
                     break; 
                  }
                  
                  boolean foundCompetitionList = false;
                  while (!foundCompetitionList) {
                     CompetitionList modelCL;
                     CompetitionListView viewCL = new CompetitionListView();
                     CompetitionListController controllerCL;
                     for (int i = 0; i < competitionLists.size(); i++) {
                        modelCL = retrieveCompetitionListsFromDatabase(i);
                        controllerCL = new CompetitionListController(modelCL, viewCL);
                        if (controllerCL.getCompetitionID() == controllerC.getCompetitionID()) {
                           controllerCL = new CompetitionListController(modelCL, viewCL);
                           controllerCL.updateView();
                           foundCompetitionList = true;
                        }
                        else {
                           continue;
                        }
                     }
                     if (foundCompetitionList) {
                        continue;
                     } else {
                        System.out.println("Not Found...");
                     }
                     break;
                  }
                  System.out.println("Try with other competition?");
                  System.out.println("<y> for Yes, <n> for No");
                  Scanner what = new Scanner(System.in);
                  if (what.next().toLowerCase().equals("y")) {
                     continue;
                  }
                  else {
                     break;
                  }                  
               }
            }
         }
            
         else if (option == 5) {
            TrainingResult model;
            TrainingView view = new TrainingView();
            TrainingController controller;
            for (int i = 0; i < trainingResults.size(); i++) {
               model = retrieveTrainingResultsFromDatabase(i);
               controller = new TrainingController(model, view);
               controller.updateView();
            }
         }
         
         else if (option == 6) {
            CompetitionResult model;
            CompetitionResultView view = new CompetitionResultView();
            CResultController controller;
            for (int i = 0; i < competitionResults.size(); i++) {
               model = retrieveCompetitionResultsFromDatabase(i);
               controller = new CResultController(model, view);
               controller.updateView();
            }
         }
         
         else if (option == 0) {
            System.out.println();
            System.out.println("Goodbye");
            break;
         }
         else {
            System.out.println("No selection made");
            continue;
         }
      }    
      
   }
}
