package swimC.coach.models;

public class Member {
   private int id;
   private String name;
   private String email;
   private int mobile;
   private int age;
   private int status;
   private int type;
   private int discipline;
   private int fees;
   private String coach;
   private boolean behind = false;
   
   public int getID() {
      return id;
   }
   public void setID(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public int getMobile() {
      return mobile;
   }
   public void setMobile(int mobile) {
      this.mobile = mobile;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public int getStatus() {
      return status;
   }
   public void setStatus(int status) {
      this.status = status;
   }
   public int getType() {
      return type;
   }
   public void setType(int type) {
      this.type = type;
   }
   public int getDiscipline() {
      return discipline;
   }
   public void setDiscipline(int discipline) {
      this.discipline = discipline;
   }
   public int getFees() {
      return fees;
   }
   public void setFees(int fees) {
      this.fees = fees;
   }
   public void controlFees() {
      this.fees = determineFee();
   }
   public int determineFee() {
      int fees;
      if (status == 1) {
         fees = 1000;
         if (age > 18) {
            fees += 600;
         }
      }
      else {
         fees = 500;
      }
      if (age >= 60) {
         fees *= 0.75; 
      }
      return fees;        
   }
   public String getCoach() {
      return coach;
   }
   public void setCoach(String coach) {
      this.coach = coach;
   }
   public boolean getBehind() {
      return behind;
   }
   public void setBehind(boolean i) {
      this.behind = i;
   }  
   
}