package util.function;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    /**
     * 현재 시간 yyyyMMdd 가져오기
     */
    public String getTimeNow(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return currentDate.format(formatter);
    }
}
