package swimC.coach.controllers;

import swimC.coach.models.*;
import swimC.coach.views.*;
import java.util.ArrayList;

public class CompetitionListController {
   private CompetitionList model;
   private CompetitionListView view;
   
   public CompetitionListController(CompetitionList model, CompetitionListView view) {
      this.model = model;
      this.view = view;
   }
   
   public int getCompetitionListID() {
      return model.getID();
   }
   public void setCompetitionListID(int id) {
      model.setID(id);
   }
   public int getCompetitionID() {
      return model.getCompetitionID();
   }
   public void setCompetitionID(int id) {
      model.setCompetitionID(id);
   }
   public int getSwimmerID() {
      return model.getSwimmerID();
   }
   public void setSwimmerID(int id) {
      model.setSwimmerID(id);
   }
   public ArrayList<Integer> getCompetitionSwimmers() {
      return model.getSwimmers();
   }
   public void updateView() {
      view.printCompetitionListDetails(model.getID(), model.getCompetitionID(), model.getSwimmers());
   }
}