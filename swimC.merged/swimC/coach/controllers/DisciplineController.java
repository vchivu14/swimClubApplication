package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;

public class DisciplineController {
   private Discipline model;
   private DisciplineView view;
   
   public DisciplineController(Discipline model, DisciplineView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getDisciplineID() {
      return model.getID();
   }
   public void setDisciplineID(int id) {
      model.setID(id);
   }
   public String getDisciplineName() {
      return model.getName();
   }
   public void setDisciplineName(String name) {
      model.setName(name);
   }
   
   public void updateView() {
      view.printDisciplineDetails(model.getID(), model.getName());
   }
}