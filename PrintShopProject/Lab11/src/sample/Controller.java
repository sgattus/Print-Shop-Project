package sample;

/**
 * Controller Class
 * Sonya Gattus
 * 12/5/17
 */

import javafx.scene.control.*;

import java.util.Scanner;

public class Controller {

    public ToggleGroup colorTogGroup;
    public RadioButton P1;
    public RadioButton P2;
    public RadioButton P3;
    public RadioButton GS;
    public ToggleGroup typeTogGroup;
    public RadioButton Matte;
    public RadioButton Glossy;
    public RadioButton Luster;
    public ToggleGroup sizeTogGroup;
    public RadioButton Letter;
    public RadioButton A4;
    public TextField pagesField;
    public Label resultLabel;
    public Label colorErrorLabel;
    public Label typeErrorLabel;
    public Label pagesErrorLabel;
    public Label sizeErrorLabel;
    public Button orderButton;


    /**
     * Listens and handles for orderButton mouse click
     * checks for selectedToggle for each Toggle Group
     * checks for textField input
     * checks to make sure nothing is null and the textField input is a number
     * Creates PrintOrder object and calls methods to calculate the cost per page and the cost of the order
     * returns cost to the GUI
     */
    public void mouseClickHandler(){
        //color Toggle Group
        Toggle colorChoice =colorTogGroup.getSelectedToggle();
        String color="";
        //Set all error labels and result label to invisible
        resultLabel.setVisible(false);
        colorErrorLabel.setVisible(false);
        typeErrorLabel.setVisible(false);
        sizeErrorLabel.setVisible(false);
        pagesErrorLabel.setVisible(false);
        //color Toggle Group continued
        if(colorChoice==P1){
            //System.out.println("works");
            color="P1";
        }

        else if(colorChoice==P2){
            //System.out.println(P2);
            color="P2";
        }

        else if(colorChoice==P3){
            color="P3";
        }

        else if(colorChoice==GS){
            color="GS";
        }

        //To prevent no choice selected
        else if(colorChoice==null){
            colorErrorLabel.setText("You must pick a color for your print order");
            colorErrorLabel.setVisible(true);
        }

        //type Toggle Group
        Toggle typeChoice= typeTogGroup.getSelectedToggle();
        String type="";

        if(typeChoice==Matte){
            type="Matte";

        }

        else if(typeChoice==Glossy){
            type="Glossy";
        }

        else if(typeChoice==Luster){
            type="Luster";
        }


        //Prevent no choice selected
        else if(typeChoice==null){
            typeErrorLabel.setText("You must pick a type for your print order");
            typeErrorLabel.setVisible(true);
        }

        //size Toggle Group
        Toggle sizeChoice=sizeTogGroup.getSelectedToggle();
        String size="";

        if(sizeChoice==Letter){
            size="Letter";
        }

        else if(sizeChoice==A4){
            size="A4";
        }

        //Prevent no choice selected
        else if(sizeChoice==null){
            sizeErrorLabel.setText("You must pick a size for your print order");
            sizeErrorLabel.setVisible(true);
        }


        //pages input
        String pagesStr=pagesField.getText();

        int pages;

        //prevent no pages entered
        if (pagesStr.equals("")){
            pagesErrorLabel.setText("You must enter how many pages you want for the order");
            pagesErrorLabel.setVisible(true);
        }

        else {

            //prevent a character entered instead of a digit
            int ndx=0;
            boolean digit=true;
            while(ndx<pagesStr.length()&&digit){
                digit=Character.isDigit(pagesStr.charAt(ndx));
                ndx++;
            }
            //Scanner scanner = new Scanner(pagesStr);
            if (digit==true) {
                pages=Integer.parseInt(pagesStr);
                //pages = scanner.nextInt();
                //prevent a number less than zero to be entered
                if(pages<0){
                    pagesField.setText("");
                    pagesErrorLabel.setText("You must enter a number greater than zero for pages");
                    pagesErrorLabel.setVisible(true);
                }
                //If everything has an input then calculate the cost and send back to the GUI
                else if(!color.equals("")&&!type.equals("")&&!size.equals("")&&pages>=0) {
                    PrintOrder order = new PrintOrder(color, size, type, pages);
                    order.calcPrintCost();
                    double costPerPage = order.getCostPerPage();
                    double cost = order.getPrintCost();
                    String printCost=String.format("%.2f",cost);
                    String strCostPerPage= String.format("%.2f",costPerPage);
                    resultLabel.setText("cost per page: $" + strCostPerPage + " print cost: $" + printCost);
                    resultLabel.setVisible(true);

                }
            }

            //Tell user they have to enter a number and it has to be greater than zero
            else{
                pagesField.setText("");
                pagesErrorLabel.setText("You must enter a NUMBER greater than zero for how many pages you want for the order");
                pagesErrorLabel.setVisible(true);
            }






        }



        /*
          try
  {
    double d = Double.parseDouble(str);
  }
  catch(NumberFormatException nfe)
  {
    return false;
  }
         */

    }



}
