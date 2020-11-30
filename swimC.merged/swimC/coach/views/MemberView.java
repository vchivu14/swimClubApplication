package swimC.coach.views;

public class MemberView {
   public void printMemberDetails(int MemberID, String MemberName, String MemberEmail, int MemberMobile, 
                                   int MemberAge, int MemberStatus, int MemberType, int MemberDiscipline, 
                                   int MemberFees, String MemberCoach, boolean MemberBehind)                                
   {  String s = "";
      String t = "";
      if (MemberType == 1) {
         t += "elite";
      }
      else if(MemberType == 2) {
         t += "exercise";
      }
      else {
         t += "no data";
      }
      if (MemberStatus == 1) {
         s += "active";
      }
      else if(MemberStatus == 2) {
         s += "passive";
      }
      else {
         s += "no data";
      }
      System.out.println("Swimmer ID: " + MemberID);
      System.out.println("Name: " + MemberName);
      System.out.println("Email: " + MemberEmail);
      System.out.println("Phone: " + MemberMobile);
      System.out.println("Age: " + MemberAge);
      System.out.println("Status: " + s);
      System.out.println("Type: " + t);
      System.out.println("Discipline: " + MemberDiscipline);
      System.out.println("Fees: " + MemberFees);
      System.out.println("Coach: " + MemberCoach);
      System.out.println("Behind: " + MemberBehind);
      System.out.println("--------------------------------");                                       
   }
    
}