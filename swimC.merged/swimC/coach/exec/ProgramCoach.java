package swimC.coach.exec;

import swimC.chairman.Member;
import swimC.coach.models.*;
import swimC.coach.views.*;
import swimC.coach.controllers.*;
import java.util.*;
import java.io.*;

public class ProgramCoach {
    private static ArrayList<Swimmer> swimmers;
    private static Swimmer swimmer;
    private static ArrayList<Member> members;
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

    private static Scanner x;
    private static boolean program;
    private static Scanner what;

    public static void editRecord(String filepath, int swimmerID, int newDiscipline) {
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        int ID = 0;
        String firstName = "";
        String lastName = "";
        String mobile = "";
        int age = 0;
        int discipline = 0;
        String coach = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));

            while (x.hasNext()) {
                ID = x.nextInt();
                firstName = x.next();
                lastName = x.next();
                mobile = x.next();
                age = x.nextInt();
                discipline = x.nextInt();
                coach = x.next();

                if (ID == swimmerID) {
                    pw.println(ID + " " + firstName + " " + lastName + " " + mobile + " " + age + " " + newDiscipline
                            + " " + coach);
                } else {
                    pw.println(ID + " " + firstName + " " + lastName + " " + mobile + " " + age + " " + discipline + " "
                            + coach);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
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

    private static Swimmer retrieveSwimmerFromDatabase(int swimmerID) {
        for (int i = 0; i < swimmers.size(); i++) {
            swimmer = swimmers.get(i);
            if (swimmer.getID() == swimmerID) {
                break;
            } else {
                continue;
            }
        }
        return swimmer;
    }

    private static Competition retrieveCompetitionFromDatabase(int competitionID) {
        for (int i = 0; i < competitions.size(); i++) {
            competition = competitions.get(i);
            if (competition.getID() == competitionID) {
                break;
            } else {
                continue;
            }
        }
        return competition;
    }

    private static boolean verifyIDDiscipline(int disciplineID) {
        boolean status = false;
        for (int i = 0; i < disciplines.size(); i++) {
            discipline = disciplines.get(i);
            if (discipline.getID() == disciplineID) {
                status = true;
                break;
            } else {
                continue;
            }
        }
        return status;
    }

    private static boolean verifyIDSwimmer(int swimmerID) {
        boolean status = false;
        for (int i = 0; i < swimmers.size(); i++) {
            swimmer = swimmers.get(i);
            if (swimmer.getID() == swimmerID) {
                status = true;
                break;
            } else {
                continue;
            }
        }
        return status;
    }

    private static boolean verifyCompetitionList(int competitionID) {
        boolean status = false;
        for (int i = 0; i < competitionLists.size(); i++) {
            competitionList = competitionLists.get(i);
            int competitionListID = competitionList.getCompetitionID();
            if (competitionListID == competitionID) {
                status = true;
                break;
            } else {
                continue;
            }
        }
        return status;
    }

    public static CompetitionList retrieveCompetitionList(int i) {
        competitionList = competitionLists.get(i);
        return competitionList;
    }

    private static TrainingResult retrieveTrainingResult(int i) {
        trainingResult = trainingResults.get(i);
        return trainingResult;
    }

    private static CompetitionResult retrieveCompetitionResult(int i) {
        competitionResult = competitionResults.get(i);
        return competitionResult;
    }

    private static Discipline retrieveDiscipline(int i) {
        discipline = disciplines.get(i);
        return discipline;
    }

    private static Member retrieveMember(int i) {
        member = members.get(i);
        return member;
    }
    
    private static Swimmer retrieveSwimmer(int i) {
        swimmer = swimmers.get(i);
        return swimmer;
    }

    private static Competition retrieveCompetition(int i) {
        competition = competitions.get(i);
        return competition;
    }

    public static void ON() {
        program = true;
        menu();
    }

    public static void OFF() {
        program = false;
    }

    public static void showDisciplines() {
        Discipline model;
        DisciplineView view = new DisciplineView();
        DisciplineController controller;
        for (int i = 0; i < disciplines.size(); i++) {
            model = retrieveDiscipline(i);
            controller = new DisciplineController(model, view);
            controller.updateView();
        }
    }

    public static void showSwimmers() {
        Swimmer model;
        SwimmerView view = new SwimmerView();
        SwimmerController controller;
        for (int i = 0; i < swimmers.size(); i++) {
            model = retrieveSwimmer(i);
            controller = new SwimmerController(model, view);
            controller.updateView();
        }
    }

    public static void showMembers() {
        Member model;
        MemberView view = new MemberView();
        MemberController controller;
        for (int i = 0; i < members.size(); i++) {
            model = retrieveMember(i);
            controller = new MemberController(model, view);
            controller.updateView();
        }
    }

    public static void showCompetitions() {
        boolean start = false;
        while (!start) {
            Competition model;
            CompetitionView view = new CompetitionView();
            CompetitionController controllerC;
            for (int i = 0; i < competitions.size(); i++) {
                model = retrieveCompetition(i);
                controllerC = new CompetitionController(model, view);
                controllerC.updateView();
            }
        }
    }

    private static String filepath = "swimmers.txt";

    public static void saveChages(String filepath, SwimmerController controller, int disciplineID) {
        String optionSave = CoachView.saveChanges();
        if (optionSave.toLowerCase().equals("y")) {
            editRecord(filepath, controller.getSwimmerID(), disciplineID);
            System.out.println("Changes saved!");
            System.out.println();
        } else if (optionSave.toLowerCase().equals("n")) {
            clear();
            exec();
            System.out.println("Changes reverted!");
            System.out.println();
        } else {
            clear();
            exec();
            System.out.println("Not a real Option!");
            System.out.println();
        }
    }

    static int swimmerID;
    static int competitionID;

    public static void manageSwimmer() {
        boolean finding = false;
        while (!finding) {

            if (swimmers.size() > 0) {
                Swimmer model;
                SwimmerView view = new SwimmerView();
                SwimmerController controller;
                for (int i = 0; i < swimmers.size(); i++) {
                    model = retrieveSwimmerFromDatabase(i);
                    controller = new SwimmerController(model, view);
                    controller.updateView();
                }
                System.out.println();
                swimmerID = CoachView.chooseSwimmer();
                System.out.println();
                if (swimmerID == 0) {
                    System.out.println();
                    System.out.println("Now going back...");
                    System.out.println();
                    break;
                } else if (swimmerID == -1) {
                    System.out.println("Something went wrong!");
                    System.out.println("----------------------");
                    System.out.println("Let's try again!");
                    System.out.println();
                }
                else if (swimmerID != -1 && swimmerID <= swimmers.size()) {
                    model = retrieveSwimmerFromDatabase(swimmerID);
                    controller = new SwimmerController(model, view);
                    controller.updateView();
                    
                    int tries = 3;
                    int disciplineID;
                    boolean change = false;
                    while (!change) {
                        if (tries == 0) {
                           System.out.println("Too many wrong inputs");
                           System.out.println("Now going back...");
                           break;  
                        } 
                        showDisciplines();
                        System.out.println();
                        disciplineID = CoachView.chooseDiscipline();
                        
                        if (disciplineID == -1 && tries >= 1) {
                            System.out.println("Something went wrong!");
                            System.out.println("----------------------");
                            System.out.println("Let's try again!");
                            tries--;
                        } else if (disciplineID == 0) {
                            System.out.println();
                            System.out.println("Now going back...");
                            System.out.println();
                            break;
                        } else if (disciplineID != -1 && disciplineID <= disciplines.size()) {
                            controller.setSwimmerDiscipline(disciplineID);
                            controller.updateView();
                            saveChages(filepath, controller, disciplineID);
                            change = true;
                        } else if (disciplineID != -1 && disciplineID > disciplines.size()) {
                            System.out.println();
                            System.out.println("No Discipline found!");
                            System.out.println();
                            tries--;
                        }

                        if (change) {
                           System.out.println("Try with other Swimmer?");
                           System.out.println("<y> for Yes, <n> for No");
                           System.out.println();
                           what = new Scanner(System.in);
                           if (what.next().toLowerCase().equals("y")) {
                              save();
                              continue;
                           } else {
                              break;
                           }
                        } else if (!change && tries > 0) {
                            System.out.println("You still have: " + tries + " more tries");
                            System.out.println();
                        } else if (!change && tries <= 0) {
                            System.out.println();
                            System.out.println("Nothing solved");
                            System.out.println();
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("No Swimmer by that ID..");
                    System.out.println();
                }
            } else {
                System.out.println("No Swimmers here...");
                break;
            }
        }
    }

    public static void manageCompetitions() {
        boolean start = false;
        while (!start) {
            
            if (competitions.size() > 0) {
               Competition model;
               CompetitionView view = new CompetitionView();
               CompetitionController controllerC;
               for (int i = 0; i < competitions.size(); i++) {
                  model = retrieveCompetition(i);
                  controllerC = new CompetitionController(model, view);
                  controllerC.updateView();
               }
               competitionID = CoachView.chooseCompetition();
               System.out.println();
               if (competitionID == 0) {
                  System.out.println();
                  System.out.println("Now going back...");
                  break;
               } else if (competitionID == -1) {
                    System.out.println("Something went wrong!");
                    System.out.println("----------------------");
                    System.out.println("Let's try again!");
                    System.out.println();
               } else if (competitionID != -1 && competitionID <= competitions.size()) {
                    model = retrieveCompetitionFromDatabase(competitionID);
                    controllerC = new CompetitionController(model, view);
                    controllerC.updateView();

                    boolean foundCompetitionList = false;
                    while (!foundCompetitionList) {
                        CompetitionList modelCL;
                        CompetitionListView viewCL = new CompetitionListView();
                        CompetitionListController controllerCL;
                        for (int i = 0; i < competitionLists.size(); i++) {
                            modelCL = retrieveCompetitionList(i);
                            controllerCL = new CompetitionListController(modelCL, viewCL);
                            if (controllerCL.getCompetitionID() == controllerC.getCompetitionID()) {
                                controllerCL = new CompetitionListController(modelCL, viewCL);
                                controllerCL.updateView();
                                foundCompetitionList = true;
                            } else {
                                continue;
                            }
                        }
                        if (foundCompetitionList) {
                            continue;
                        } else {
                            System.out.println();
                            System.out.println("No Competition List Found...");
                            System.out.println();
                        }
                        break;
                    }  
                    System.out.println("Try with other competition?");
                    System.out.println("<y> for Yes, <n> for No");
                    what = new Scanner(System.in);
                    if (what.next().toLowerCase().equals("y")) {
                        continue;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("No Competition by that ID..");
                    System.out.println();
                    continue;
                }
            } else {
                System.out.println("No competitions here!");
                break;
            }
        }
    }

    public static void showTrainingResults() {
        TrainingResult model;
        TrainingView view = new TrainingView();
        TrainingController controller;
        for (int i = 0; i < trainingResults.size(); i++) {
            model = retrieveTrainingResult(i);
            controller = new TrainingController(model, view);
            controller.updateView();
        }
    }

    public static void showCompetitionResults() {
        CompetitionResult model;
        CompetitionResultView view = new CompetitionResultView();
        CResultController controller;
        for (int i = 0; i < competitionResults.size(); i++) {
            model = retrieveCompetitionResult(i);
            controller = new CResultController(model, view);
            controller.updateView();
        }
    }

    private static int option;

    public static void menu() {
        exec();

        while (program) {
            option = CoachView.startMenu();

            if (option == 1) {
                showMembers();
            } else if (option == 2) {
                manageSwimmer();
            } else if (option == 3) {
                showDisciplines();
            } else if (option == 4) {
                manageCompetitions();
            } else if (option == 5) {
                showTrainingResults();
            } else if (option == 6) {
                showCompetitionResults();
            } else if (option == 0) {
                System.out.println();
                System.out.println("See you next time!");
                System.out.println();
                break;
            } else if (option == -1) {
                continue;
            } else {
               System.out.println();
               System.out.println("No selection made");
               System.out.println();
               continue;
            }
        }
    }
}
