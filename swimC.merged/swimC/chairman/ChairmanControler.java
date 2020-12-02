package swimC.chairman;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class ChairmanControler {
   ChairmanViewer viewer = new ChairmanViewer();
   public ArrayList<Member> members = new ArrayList<Member>();
   File membersFile = new File("members.txt");

   private Scanner fileInput;

   public void chairman() throws IOException {
      readFromFile(members);
      do {
         viewer.menu(members);
         choice(members, viewer.getAnswer());
      } while (!viewer.getAnswer().equals("q"));
   }

   public void creatAfile() {
      try {
         membersFile.createNewFile();
      } catch (IOException e) {
         viewer.somethingWentWrongMessege();
      }
   }

   private boolean isFileEmpty() {
      if (membersFile.length() == 0) {
         return true;
      } else {
         return false;
      }
   }

   public void readFromFile(ArrayList<Member> members) {
      try {
         fileInput = new Scanner(membersFile);
         try {
            while (fileInput.hasNextLine()) {
               Member member = new Member();
               member.setID(fileInput.nextInt());
               member.setFirstName(fileInput.next());
               member.setLastName(fileInput.next());
               member.setAge(fileInput.nextInt());
               member.setMobile(fileInput.next());
               member.setEmail(fileInput.next());
               member.setIsMemberActive(fileInput.nextBoolean());
               member.setIsMemberElite(fileInput.nextBoolean());
               member.setFees(fileInput.nextInt());
               member.setBehind(fileInput.nextBoolean());
               members.add(member);
            }
         } catch (InputMismatchException b) {
            viewer.corruptedFileMessege();
            System.exit(0);
         }
      } catch (FileNotFoundException e) {
         creatAfile();
         readFromFile(members);

      }
      this.members = members;
      fileInput.close();
   }

   public void choice(ArrayList<Member> members, String answer) throws IOException {
      switch (answer) {
         case "a": {
            viewer.addMember(members, members.size());
            saveToFile(members);
            viewer.addMemberMessege();
            break;
         }
         case "e": {
            if (isFileEmpty()) {
               viewer.noMembersMessege();
            } else {
               viewer.editMember(members);
               saveToFile(members);
            }
            break;
         }
         case "d": {
            if (isFileEmpty()) {
               viewer.noMembersMessege();
            } else {
               viewer.deleteMember(members);
               fixID(members);
               saveToFile(members);
            }
            break;
         }
         case "q": {
            viewer.quitedMessege();
            saveToFile(members);
            break;
         }
      }
   }

   public void saveToFile(ArrayList<Member> members) {
      try {
         FileWriter myWriter = new FileWriter(membersFile);
         for (int i = 0; i < members.size(); i++) {

            myWriter.write(members.get(i).getID() + " " + members.get(i).getFirstName() + " "
                  + members.get(i).getLastName() + " " + members.get(i).getAge() + " " + members.get(i).getMobile()
                  + " " + members.get(i).getEmail() + " " + members.get(i).getIsMemberActive() + " "
                  + members.get(i).getIsMemberElite() + " " + members.get(i).getFees() + " "
                  + members.get(i).getBehind());

            if (i != members.size() - 1) {
               myWriter.write("\n");
            }
         }
         myWriter.close();
      } catch (IOException e) {
         creatAfile();
         saveToFile(members);
      }
   }

   private void fixID(ArrayList<Member> members) {
      for (int i = 1; i <= members.size(); i++) {
         members.get(i - 1).setID(i);
      }
   }
}