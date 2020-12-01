package swimC.coach.controllers;

import swimC.coach.models.Swimmer;
import swimC.coach.views.SwimmerView;

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
   public String getSwimmerFirstName() {
      return model.getFirstName();
   }
   public void setSwimmerFirstName(String name) {
      model.setFirstName(name);
   }
   public String getSwimmerLastName() {
      return model.getLastName();
   }
   public void setSwimmerLastName(String name) {
      model.setLastName(name);
   }
   public String getSwimmerMobile() {
      return model.getMobile();
   }
   public void setSwimmerMobile(String mobile) {
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
      view.printSwimmerDetails(model.getID(), model.getFirstName(), model.getLastName(), model.getMobile(), model.getAge(),
                                 model.getDiscipline(), model.getCoach());
   }
}