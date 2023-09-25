package com.cmpsc475.producttracker.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long productID;

    @NonNull
    @ColumnInfo(name = "name")
    private String productName;
    @ColumnInfo(name = "image_src")
    private Integer productImage;

    //For tracking product time owned
    @NonNull
    @ColumnInfo(name = "year_bought")
    private Integer yearBought;
    @NonNull
    @ColumnInfo(name = "month_bought")
    private Integer monthBought;
    @NonNull
    @ColumnInfo(name = "day_bought")
    private Integer dayBought;

    @NonNull
    @ColumnInfo(name = "warranty")
    private Boolean warranty;

    //For warranty
    @ColumnInfo(name = "warran_year_expire")
    private Integer yearExpire;
    @ColumnInfo(name = "warran_month_expire")
    private Integer monthExpire;
    @ColumnInfo(name = "warran_day_expire")
    private Integer dayExpire;


    public Product() {}

    @Ignore
    // Class Constructor
    public Product(
            String productName,
            Integer productImage,

            Integer yearBought,
            Integer monthBought,
            Integer dayBought,

            Integer yearExpire,
            Integer monthExpire,
            Integer dayExpire)
    {

        this.warranty = true;
        this.yearExpire = yearExpire;
        this.monthExpire = monthExpire;
        this. dayExpire = dayExpire;

        this.productName = productName;
        this.productImage = productImage;

        this.yearBought = yearBought;
        this.monthBought = monthBought;
        this.dayBought = dayBought;

        //If we have no warranty entered, set all to -99999

    }
    // End of Class Constructor (With warranty)

    // Get Methods
    public long getProductID() { return productID; }

    public String getProductName() {
        return productName;
    }
    public Integer getProductImage() {
        return productImage;
    }

    public Integer getYearBought() {
        return yearBought;
    }
    public Integer getYear() {return yearBought;}
    public Integer getMonthBought() {
        return monthBought;
    }
    public Integer getMonth() {return monthBought;}
    public Integer getDayBought() {
        return dayBought;
    }
    public Integer getDay() {return dayBought;}

    public Integer getYearExpire() {
        return yearExpire;
    }
    public Integer getYearExp() {return yearExpire;}
    public Integer getMonthExpire() {
        return monthExpire;
    }
    public Integer getMonthExp() {return monthExpire;}
    public Integer getDayExpire() {
        return dayExpire;
    }
    public Integer getDayExp() {return dayExpire;}

    public Boolean getWarranty() {
        return warranty;
    };
    // End of Get Methods

    //Set Methods
    public void setProductID(long newID) { productID = newID; }

    public void setProductName(String newName) {
        productName = newName;
    }
    public void setProductImage(Integer newImage) {
        productImage = newImage;
    }

    public void setYearBought(Integer newYear) {
        yearBought = newYear;
    }
    public void setMonthBought(Integer newMonth) {
        monthBought = newMonth;
    }
    public void setDayBought(Integer newDay) {
        dayBought = newDay;
    }

    public void setYearExpire(Integer newYearExpire) {
        yearExpire = newYearExpire;
    }
    public void setMonthExpire(Integer newMonthExpire) {
        monthExpire = newMonthExpire;
    }
    public void setDayExpire(Integer newDayExpire) {
        dayExpire = newDayExpire;
    }

    public void setWarranty(Boolean warrantyStatus) {
        warranty = warrantyStatus;
    };
    //End of Set Methods
}