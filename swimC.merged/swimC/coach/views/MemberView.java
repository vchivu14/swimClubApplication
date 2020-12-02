package swimC.coach.views;

public class MemberView {
   public void printMemberDetails(int MemberID, String MemberFirstName, String MemberLastName, String MemberEmail, String MemberMobile, 
                                   int MemberAge, boolean MemberStatus, boolean MemberType,
                                   int MemberFees, boolean MemberBehind)                                
   {  
      System.out.println("Swimmer ID: " + MemberID);
      System.out.println("First Name: " + MemberFirstName);
      System.out.println("Last Name: " + MemberLastName);
      System.out.println("Email: " + MemberEmail);
      System.out.println("Phone: " + MemberMobile);
      System.out.println("Age: " + MemberAge);
      System.out.println("Is Member Active: " + MemberStatus);
      System.out.println("Is Member Elite: " + MemberType);
      System.out.println("Fees: " + MemberFees);
      System.out.println("Behind: " + MemberBehind);
      System.out.println("--------------------------------");                                       
   }
    
}