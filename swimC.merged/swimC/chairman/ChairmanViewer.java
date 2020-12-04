package swimC.chairman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import swimC.coach.models.Swimmer;

public class ChairmanViewer {

    Scanner userInput = new Scanner(System.in);
    String answer;
    private Writer output;
    
    // this function will be used at the moment of registering a new member, if the member is an Elite Swimmer
    //  Takes an object of type member which is the parent class of Swimmer and appends it to another table
    //    so that Coach actor can interfere with just some of the attributes of this member.
    // Ofcourse Swimmer inherits from Member so they are the same person but displayed in two different tables
    //   used for different purposes
    public void addSwimmer(Member member) throws IOException {
        Swimmer swimmer = new Swimmer(member);
        output = new BufferedWriter(new FileWriter("swimmers.txt", true));
        System.out.println(swimmer.toString());
        output.append(swimmer.toString());
        output.close();
    }

    public void menu(ArrayList<Member> members) {
        listMessege();
        printOutAllMembers(members);
        menuMessege();
        askForAnswer();

    }

    public void askForAnswer() {
        answer = userInput.next();
        answer = answer.toLowerCase();
        if (!answer.equals("a") && !answer.equals("d") && !answer.equals("q") && !answer.equals("e")) {
            invalidInputExtended();
            menuMessege();
            askForAnswer();
        }
    }

    public String getAnswer() {
        return answer;
    }

    public void printOutAllMembers(ArrayList<Member> members) {
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }
        System.out.println();
    }
    
    // this is where we interact with the User and start collecting and saving data 
    public void addMember(ArrayList<Member> members, int i) throws IOException {

        Member member = new Member();
        System.out.print("\nFirst Name:");
        member.setFirstName(userInput.next());
        System.out.print("\nLast Name:");
        member.setLastName(userInput.next());
        boolean sentinel = false;
        String answer1, answer2;
        do {
            try {
                sentinel = false;
                System.out.print("\nAge:");
                member.setAge(userInput.nextInt());
            } catch (InputMismatchException e) {
                sentinel = true;
                userInput.next();
                invalidInput();
            }
        } while (sentinel);
        do {
            System.out.print("\nPhone Number:");
            member.setMobile(userInput.next());
            if (!member.getMobile().matches("[0-9]+") || member.getMobile().length() < 7) {
                invalidInput();
            }
        } while (!member.getMobile().matches("[0-9]+") || member.getMobile().length() < 7);
        System.out.print("\nE-mail Adress:");
        member.setEmail(userInput.next());

        do {
            activeMemberMessege();
            answer1 = userInput.next();
            answer1 = answer1.toLowerCase();
            if (answer1.equals("y")) {
                member.setIsMemberActive(true);
                member.controlFees(); // here is where we apply the deciding fee method
            }
            if (answer1.equals("n")) {
                member.setIsMemberActive(false);
                member.setFees(500);
            }
        } while (!answer1.equals("y") && !answer1.equals("n"));

        do {
            eliteMemberMessege();
            answer2 = userInput.next();
            answer2 = answer2.toLowerCase();
            if (answer2.equals("y")) {
                member.setIsMemberElite(true);
                addSwimmer(member); // and if the member is Elite we use the function to append the Swimmers List
            }
            if (answer2.equals("n")) {
                member.setIsMemberElite(false);
            }
        }

        while (!answer2.equals("y") && !answer2.equals("n"));
        members.add(i, member);
    }

    public void deleteMember(ArrayList<Member> members) {
        boolean sentinel = false;
        int answer;
        do {
            System.out.print("Which member would you like to delete ? 0 to quit. [1-" + members.size() + "]:");
            try {
                sentinel = false;
                answer = userInput.nextInt();
                if (answer == 0) {
                    abandonedDeletingMessege();
                    break;
                }
                if (answer < 0 || answer > members.size()) {
                    invalidInput();
                    sentinel = true;
                } else {
                    members.remove(answer - 1);
                    System.out.println("\nYou have removed a member with the id of [" + answer + "].\n");
                }
            } catch (Exception e) {
                sentinel = true;
                userInput.next();
                invalidInput();
            }
        } while (sentinel);
    }

    public void editMember(ArrayList<Member> members) {
        boolean sentinel = false;
        int answer;
        do {
            System.out.print("Which member would you like to edit ? 0 to quit. [1-" + members.size() + "]:");
            try {
                sentinel = false;
                answer = userInput.nextInt();
                if (answer == 0) {
                    abandonedEditingMessege();
                    break;
                }
                if (answer < 0 || answer > members.size()) {
                    invalidInput();
                    sentinel = true;
                } else {
                    members.remove(answer - 1);
                    addMember(members, answer - 1);
                    System.out.println("\nYou have edited a member with the id of [" + answer + "].\n");
                }
            } catch (Exception e) {
                sentinel = true;
                userInput.next();
                invalidInput();
            }
        } while (sentinel);

    }

    public void somethingWentWrongMessege() {
        System.out.println("Something went wrong.");
    }

    public void corruptedFileMessege() {
        System.out.println("The file members is corrupted.");
    }

    private void invalidInput() {
        System.out.println("Invalid input");
    }

    public void invalidInputExtended() {
        System.out.println("\nInvalid input! You can only:");
    }

    public void quitedMessege() {
        System.out.println("You have quited");
    }

    public void noMembersMessege() {
        System.out.println("You have no members. Try adding some.");
    }

    private void menuMessege() {
        System.out.println("[A] - Add a member\n[E] - Edit an existing member\n[D] - Delete a member\n[Q] - Quit");
    }

    public void addMemberMessege() {
        System.out.println("You have added a member.");
    }

    private void activeMemberMessege() {
        System.out.print("\nIs this member active ? [Y/N]");
    }

    private void eliteMemberMessege() {
        System.out.print("\nIs this member elite ? [Y/N]");
    }

    private void abandonedDeletingMessege() {
        System.out.println("\nYou didn't delete any member.");
    }

    private void abandonedEditingMessege() {
        System.out.println("\nYou didn't edit any member.");
    }

    private void listMessege() {
        System.out.println("[MEMBERS LIST]:\n------------------------------------------");
    }

}