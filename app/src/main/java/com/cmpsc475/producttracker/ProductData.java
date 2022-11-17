package com.cmpsc475.producttracker;

public class ProductData {
    // Attributes
    private String productName;
    private Integer productImage;

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
            Integer productImage,

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
        this.productImage = productImage;

        this.yearBought = yearBought;
        this.monthBought = monthBought;
        this.dayBought = dayBought;
    }
    // End of Class Constructor (Without warranty)

    // Class Ccnstructor (With warranty)
    public ProductData(
            String productName,
            Integer productImage,

            Integer yearBought,
            Integer monthBought,
            Integer dayBought,

            Integer yearExpire,
            Integer monthExpire,
            Integer dayExpire)
    {
        //Now we have warranty expiration date, assign those
        this.warranty = true;
        this.yearExpire = yearExpire;
        this.monthExpire = monthExpire;
        this. dayExpire = dayExpire;

        this.productName = productName;
        this.productImage = productImage;

        this.yearBought = yearBought;
        this.monthBought = monthBought;
        this.dayBought = dayBought;
    }
    // End of Class Constructor (With warranty)

    // Get Methods
    public String getProductName() {
        return productName;
    }
    public Integer getProductImage() {
        return productImage;
    }

    public Integer getBoughtYear() {
        return yearBought;
    }
    public Integer getBoughtMonth() {
        return monthBought;
    }
    public Integer getBoughtDay() {
        return dayBought;
    }

    public Integer getExpireYear() {
        return yearExpire;
    }
    public Integer getExpireMonth() {
        return monthExpire;
    }
    public Integer getExpireDay() {
        return dayExpire;
    }

    public Integer getCurrentYear() {
        return yearCurrent;
    }
    public Integer getCurrentMonth() {
        return monthCurrent;
    }
    public Integer getCurrentDay() {
        return dayCurrent;
    }

    public Boolean hasWarranty() {
        return warranty;
    };
    // End of Get Methods
}