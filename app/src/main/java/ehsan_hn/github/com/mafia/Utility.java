package ehsan_hn.github.com.mafia;

/**
 * Created by ehsan on 1/31/17.
 */
public class Utility {

    public static String ConvertNumber2Persian(String Number){
        Number = Number.replace("0","۰");
        Number = Number.replace("1","۱");
        Number = Number.replace("2","۲");
        Number = Number.replace("3","۳");
        Number = Number.replace("4","۴");
        Number = Number.replace("5","۵");
        Number = Number.replace("6","۶");
        Number = Number.replace("7","۷");
        Number = Number.replace("8","۸");
        Number = Number.replace("9","۹");
        return Number;
    }
    public static String ConvertNumber2English(String Number){
        Number = Number.replace("۰","0");
        Number = Number.replace("۱","1");
        Number = Number.replace("۲","2");
        Number = Number.replace("۳","3");
        Number = Number.replace("۴","4");
        Number = Number.replace("۵","5");
        Number = Number.replace("۶","6");
        Number = Number.replace("۷","7");
        Number = Number.replace("۸","8");
        Number = Number.replace("۹","9");
        return Number;
    }
}
