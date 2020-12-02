package swimC.coach.controllers;

import swimC.chairman.Member;
import swimC.coach.views.MemberView;

public class MemberController {
   private Member model;
   private MemberView view;
   
   public MemberController(Member model, MemberView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getID() {
      return model.getID();
   }
   public void setID(int id) {
      model.setID(id);
   }
   public String getFirstName() {
      return model.getFirstName();
   }
   public void setFirstName(String name) {
      model.setFirstName(name);
   }
   public String getLastName() {
      return model.getLastName();
   }
   public void setLastName(String name) {
      model.setLastName(name);
   }
   public String getMemberEmail() {
      return model.getEmail();
   }
   public void setMemberEmail(String email) {
      model.setEmail(email);
   }
   public String getMemberMobile() {
      return model.getMobile();
   }
   public void setMemberMobile(String mobile) {
      model.setMobile(mobile);
   }
   public int getMemberAge() {
      return model.getAge();
   }
   public void setMemberAge(int age) {
      model.setAge(age);
   }
   public boolean getMemberStatus() {
      return model.getIsMemberActive();
   }
   public void setMemberStatus(boolean status) {
      model.setIsMemberActive(status);
   }
   public boolean getMemberType() {
      return model.getIsMemberElite();
   }
   public void setMemberType(boolean status) {
      model.setIsMemberElite(status);
   }
   public int getMemberFees() {
      return model.getFees();
   }
   public void setMemberFees(int fees) {
      model.setFees(fees);
   }
   public int getMemberDiscipline() {
      return model.getDiscipline();
   }
   public boolean getMemberBehind() {
      return model.getBehind();
   }
   public void setMemberBehind(boolean behind) {
      model.setBehind(behind);
   }
   
   public void updateView() {
      view.printMemberDetails(model.getID(), model.getFirstName(), model.getLastName(), model.getEmail(), model.getMobile(), model.getAge(),
                              model.getIsMemberActive(), model.getIsMemberElite(), model.getFees(), model.getBehind());
   }
}