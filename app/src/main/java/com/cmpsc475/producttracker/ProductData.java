package com.cmpsc475.producttracker;

public class ProductData {
    // Attributes
    private String productName;

    private Integer yearCurrent; //Current time
    private Integer monthCurrent;
    private Integer dayCurrent;

    private Integer yearBought; //For tracking product time owned
    private Integer monthBought;
    private Integer dayBought;

    private Boolean warranty;

    private Integer yearExpire; //For warranty
    private Integer monthExpire;
    private Integer dayExpire;
    // End of Attributes

    // Class Ccnstructor (Without warranty)
    public ProductData(
            String productName,

            Integer yearBought,
            Integer monthBought,
            Integer dayBought)
    {
        //Since we have no warranty, set all to 0
        this.warranty = false;
        this.yearExpire = 0;
        this.monthExpire = 0;
        this. dayExpire = 0;

        this.productName = productName;

        this.yearBought = yearBought;
        this.monthBought = monthBought;
        this.dayBought = dayBought;
    }
    // End of Class Constructor

    // Class Ccnstructor (With warranty)
    public ProductData(
            String productName,

            Integer yearBought,
            Integer monthBought,
            Integer dayBought,

            Integer yearExpire,
            Integer monthExpire,
            Integer dayExpire)
    {
        //Since we have no warranty, set all to 0
        this.warranty = true;
        this.yearExpire = yearExpire;
        this.monthExpire = monthExpire;
        this. dayExpire = dayExpire;

        this.productName = productName;

        this.yearBought = yearBought;
        this.monthBought = monthBought;
        this.dayBought = dayBought;
    }
    // End of Class Constructor
}