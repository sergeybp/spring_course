package testsite.entities;

import testsite.enums.Months;

import java.text.Format;
import java.util.Formatter;

/**
 * Created by sergeybp on 27.05.17.
 */
public class CustomDate {

    public int year;

    public int month;

    public int day;

    public CustomDate(int year, int day, int month) {
        this.year = year;
        this.day = day;
        this.month = month;
    }

    @Override
    public String toString() {
        return "" + (month / 10 > 0 ? month : "0" + month) + "/" + (day / 10 > 0 ? day : "0" + day) + "/" + year;
    }


}
