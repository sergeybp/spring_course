package helpers;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by sergeybp on 07.05.17.
 */
public class DataProviders {

    @DataProvider(name = "usersSetCsv")
    public static Object[][] usersSetCsv() throws FileNotFoundException {
        ArrayList<Object[]> result = new ArrayList<>();
        InputStream is = DataProviders.class.getClassLoader().getResourceAsStream("users_test_set.csv");
        FastScanner in = new FastScanner(is);
        while(in.hasNext()) {
            String tmp = in.nextString();
            String[] splits = tmp.split("\\,");
            result.add(new Object[]{splits[0], splits[1], Boolean.parseBoolean(splits[2])});
        }
        return result.toArray(new Object[0][]);
    }

    @DataProvider(name = "usersSetHardcoded")
    public static Object[][] usersSetHardcoded(){
        return new Object[][]{
                {"Petr", "petrpetr", false},
                {"Ivan", "ivan12345", false},
                {"epam", "1234", true},
                {"Olga", "olenka", false}
        };
    }

}
