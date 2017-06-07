package testsite.entities;

/**
 * Created by sergeybp on 30.05.17.
 */
public class CustomClock {

    private int hours;

    private int minutes;

    private boolean am;


    public CustomClock(int hours, int minutes, boolean am) {
        this.hours = hours;
        this.minutes = minutes;
        this.am = am;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isAm() {
        return am;
    }

    @Override
    public String toString(){
        String result = ""+hours+":"+minutes+" ";
        result+= isAm() ? "AM" : "PM";
        return result;
    }
}
