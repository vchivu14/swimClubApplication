package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;

public class MemberController {
   private Member model;
   private MemberView view;
   
   public MemberController(Member model, MemberView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getMemberID() {
      return model.getID();
   }
   public void setMemberID(int id) {
      model.setID(id);
   }
   public String getMemberName() {
      return model.getName();
   }
   public void setMemberName(String name) {
      model.setName(name);
   }
   public String getMemberEmail() {
      return model.getEmail();
   }
   public void setMemberEmail(String email) {
      model.setEmail(email);
   }
   public int getMemberMobile() {
      return model.getMobile();
   }
   public void setMemberMobile(int mobile) {
      model.setMobile(mobile);
   }
   public int getMemberAge() {
      return model.getAge();
   }
   public void setMemberAge(int age) {
      model.setAge(age);
   }
   public int getMemberStatus() {
      return model.getStatus();
   }
   public void setMemberStatus(int status) {
      model.setStatus(status);
   }
   public int getMemberType() {
      return model.getType();
   }
   public void setMemberType(int type) {
      model.setType(type);
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
   public void setMemberDiscipline(int discipline) {
      model.setDiscipline(discipline);
   }
   public String getMemberCoach() {
      return model.getCoach();
   }
   public void setMemberCoach(String coach) {
      model.setCoach(coach);
   }
   public void updateView() {
      view.printMemberDetails(model.getID(), model.getName(), model.getEmail(), model.getMobile(), model.getAge(),
                              model.getStatus(), model.getType(), model.getDiscipline(), model.getFees(),
                              model.getCoach(), model.getBehind());
   }
}