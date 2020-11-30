package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;

public class CResultController {
   private CompetitionResult model;
   private CompetitionResultView view;
   
   public CResultController(CompetitionResult model, CompetitionResultView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getCResultID() {
      return model.getID();
   }
   public void setCResultID(int id) {
      model.setID(id);
   }
   public int getCompetitionID() {
      return model.getCompetitionID();
   }
   public void setCompetitionID(int i) {
      model.setCompetitionID(i);
   }
   public int getSwimmerID() {
      return model.getSwimmerID();
   }
   public void setSwimmerID(int id) {
      model.setSwimmerID(id);
   }
   public int getDisciplineID() {
      return model.getDisciplineID();
   }
   public void setDisciplineID(int i) {
      model.setDisciplineID(i);
   }
   public int getRally() {
      return model.getRally();
   }
   public void setRally(int i) {
      model.setRally(i);
   }
   public double getTime() {
      return model.getTime();
   }
   public void setTime(double i) {
      model.setTime(i);
   }
   public int getPosition() {
      return model.getPosition();
   }
   public void setPosition(int i) {
      model.setPosition(i);
   }
   
   public void updateView() {
      view.printCompetitionResultDetails(model.getID(), model.getCompetitionID(), model.getSwimmerID(), model.getDisciplineID(), model.getRally(), model.getTime(), model.getPosition());
   }
}