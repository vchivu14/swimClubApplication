package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;

public class SwimmerController {
   private Swimmer model;
   private SwimmerView view;
   
   public SwimmerController(Swimmer model, SwimmerView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getSwimmerID() {
      return model.getID();
   }
   public void setSwimmerID(int id) {
      model.setID(id);
   }
   public String getSwimmerName() {
      return model.getName();
   }
   public void setSwimmerName(String name) {
      model.setName(name);
   }
   public int getSwimmerMobile() {
      return model.getMobile();
   }
   public void setSwimmerMobile(int mobile) {
      model.setMobile(mobile);
   }
   public int getSwimmerAge() {
      return model.getAge();
   }
   public void setSwimmerAge(int age) {
      model.setAge(age);
   }
   public int getSwimmerDiscipline() {
      return model.getDiscipline();
   }
   public void setSwimmerDiscipline(int discipline) {
      model.setDiscipline(discipline);
   }
   public String getSwimmerCoach() {
      return model.getCoach();
   }
   public void setSwimmerCoach(String coach) {
      model.setCoach(coach);
   }
   public void updateView() {
      view.printSwimmerDetails(model.getID(), model.getName(), model.getMobile(), model.getAge(),
                                 model.getDiscipline(), model.getCoach());
   }
}