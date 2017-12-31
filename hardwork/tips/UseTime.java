import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;;

public class UseTime {
    public static void main(String[] args) {
        LocalDateTime dataTime = LocalDateTime.now();
        System.out.format("%s", dataTime.format(DateTimeFormatter.ofPattern("yy/MM/dd hh:mm")));
    }
}