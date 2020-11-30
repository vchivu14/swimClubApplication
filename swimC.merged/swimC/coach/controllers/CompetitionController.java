package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;

public class CompetitionController {
   private Competition model;
   private CompetitionView view;
   
   public CompetitionController(Competition model, CompetitionView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getCompetitionID() {
      return model.getID();
   }
   public void setCompetitionID(int id) {
      model.setID(id);
   }
   public String getCompetitionName() {
      return model.getName();
   }
   public void setCompetitionName(String name) {
      model.setName(name);
   }

   public void updateView() {
      view.printCompetitionDetails(model.getID(), model.getName());
   }
}