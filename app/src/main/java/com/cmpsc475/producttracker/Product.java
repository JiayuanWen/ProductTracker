package com.cmpsc475.producttracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
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

    //Current time used for calculating time left, not needed for DB
    private Integer yearCurrent;
    private Integer monthCurrent;
    private Integer dayCurrent;

    //For tracking product time owned
    @NonNull
    @ColumnInfo(name = "year_bought")
    private Integer yearBought;
    @NonNull
    @ColumnInfo(name = "month_bought")
    private Integer monthBought;
    @NonNull
    @ColumnInfo(name = "month_bought")
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


    // Class Constructor (Without warranty)
    public Product(
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