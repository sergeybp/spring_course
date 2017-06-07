package helpers;

import testsite.entities.CustomClock;
import testsite.entities.CustomDate;
import testsite.entities.User;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by sergeybp on 07.05.17.
 **/
public class DataProviders {

    @DataProvider(name = "usersSetCsv")
    public static Object[][] usersSetCsv() throws FileNotFoundException {
        ArrayList<Object[]> result = new ArrayList<>();
        InputStream is = DataProviders.class.getClassLoader().getResourceAsStream("users_test_set.csv");
        FastScanner in = new FastScanner(is);
        while (in.hasNext()) {
            String tmp = in.nextString();
            String[] splits = tmp.split("\\,");
            if (splits.length < 5) {
                continue;
            }
            try {
                Boolean.parseBoolean(splits[4]);
            } catch (Exception e) {
                continue;
            }
            result.add(new Object[]{new User(splits[0], splits[1], splits[2], splits[3]), Boolean.parseBoolean(splits[4])});
        }
        return result.toArray(new Object[0][]);
    }

    @DataProvider(name = "usersSetHardcoded")
    public static Object[][] usersSetHardcoded() {
        return new Object[][]{
                {new User("epam", "1234", "testLastName", "some text"), true},
                {new User("epam", "1234", "admin", "aaa. more text."), true},
                {new User("Petr", "petrpetr", "Petrov", "descrrrr"), false},
                {new User("Ivan", "ivan12345", "Ivanov", "Descr"), false},
                {new User("Olga", "olenka", "Olgovna", "another text"), false},
        };
    }

    @DataProvider(name = "clocksProvider")
    public static Object[][] clocksProvider(){
        return new Object[][]{
                {new CustomClock(5, 27, false)},
                {new CustomClock(5, 30, false)},
                {new CustomClock(7, 15, true)},
                {new CustomClock(11, 45, true)},
                {new CustomClock(8, 33, true)}
        };
    }

    @DataProvider(name = "datesProvider")
    public static Object[][] datesProvider(){
        return new Object[][]{
                {new CustomDate(2042, 23, 8)},
                {new CustomDate(1995, 27, 6)},
                {new CustomDate(1987, 1, 12)},
                {new CustomDate(2120, 2, 3)},
                {new CustomDate(2017, 1, 6)}
        };
    }


}
