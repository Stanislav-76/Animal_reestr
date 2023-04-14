import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Date data = new Date();
        String dat = "2020.04.11";
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        try {
            data = df.parse(dat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(df.format(data));
    }
}
