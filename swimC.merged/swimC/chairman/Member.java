package swimC.chairman;

public class Member{

   private int id;
   private String firstName;
   private String lastName;
   private String email;
   private String mobile;
   private int age;
   private boolean isMemberActive;
   private boolean isMemberElite;
   private int disciplineID;
   private int fees;
   private boolean behind = false;
   
   public int getID() {
      return id;
   }
   public void setID(int id) {
      this.id = id;
   }
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getMobile() {
      return mobile;
   }
   public void setMobile(String mobile) {
      this.mobile = mobile;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public boolean getIsMemberActive() {
      return isMemberActive;
   }
   public void setIsMemberActive(boolean isMemberActive) {
      this.isMemberActive = isMemberActive;
   }
   public boolean getIsMemberElite() {
      return isMemberElite;
   }
   public void setIsMemberElite(boolean isMemberElite) {
      this.isMemberElite = isMemberElite;
   }
   public int getDiscipline() {
      return disciplineID;
   }
   public void setDiscipline(int discipline) {
      this.disciplineID = disciplineID;
   }
   public int getFees() {
      return fees;
   }
   public void setFees(int fees) {
      this.fees = fees;
   }
   public String toString(){
      return("ID: ["+id+"]\nName: "+firstName+" "+lastName+"\nAge: "+age+" \nE-mail Adress: "+email+
      "\nPhone Number: "+mobile+"\nIs the member active: "+isMemberActive+ " \nIs the member an elite swimmer: " 
      +isMemberElite+"\n------------------------------------------");
}
}