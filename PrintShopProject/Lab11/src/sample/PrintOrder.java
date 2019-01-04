package sample;

/**
 * Simulates PrintShop that calculate cost per page and cost per order
 */
public class PrintOrder {
    private String color;
    private String paperSize;
    private String paperType;
    private double costPerPage;
    private double cost;
    private int pages;


    /**
     * Sets colorIn to color
     * Sets paperSizeIn to paperSize
     * Sets paperTypeIn to paperType
     * Sets pagesIn to pages
     * Sets costPerPage and sets cost to 0.0
     * @param colorIn color of the paper user enters
     * @param paperSizeIn size of the paper user enters
     * @param paperTypeIn type of the paper user enters
     * @param pagesIn amount of pages in an order user enters
     */
    public PrintOrder(String colorIn, String paperSizeIn, String paperTypeIn, int pagesIn){
        this.color=colorIn;
        this.paperSize=paperSizeIn;
        this.paperType=paperTypeIn;
        this.pages=pagesIn;
        this.costPerPage=0.0;
        this.cost=0.00;
    }

    //methods


    /**
     * Calculates the print cost by conditionally checking what color,type,size, and how many pages the object has
     * Adds the color price per page with the type price per page
     * Adds cost of size price per page to the sum of color and type
     * Processes price per page from this answer
     * Processes order cost by multiplying the price per page by the amount of pages
     */
    public void calcPrintCost() {
        if (color.equals("P1")) {
            cost = cost + .3;
        } else if (color.equals("P2")) {
            cost = cost + .45;
        } else if (color.equals("P3")) {
            cost = cost + .65;
        } else {
            cost = cost + .1;
        }



        if (paperType.equals("Matte")) {
            cost = cost + .2;
        }
        else if (paperType.equals("Glossy")) {
            cost = cost + .3;
        }
        else {
            cost = cost + .6;
        }


        if(paperSize.equals("A4")){
            cost=(cost*.5)+cost;
        }

        else{
            cost=cost+0;
        }

        costPerPage=cost;

        cost=cost*pages;

    }

    /**
     * Sends back the cost per page
     * @return costPerPage
     */
    public double getCostPerPage(){
        return costPerPage;
    }


    /**
     * Sends back total cost of the order
     * @return cost
     */
    public double getPrintCost(){
        return cost;
    }


}
