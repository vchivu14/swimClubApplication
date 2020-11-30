package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;

public class TrainingController {
   private TrainingResult model;
   private TrainingView view;
   
   public TrainingController(TrainingResult model, TrainingView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getTrainingID() {
      return model.getID();
   }
   public void setTrainingID(int id) {
      model.setID(id);
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
   public void updateView() {
      view.printTrainingDetails(model.getID(), model.getSwimmerID(), model.getDisciplineID(), model.getRally(), model.getTime());
   }
}