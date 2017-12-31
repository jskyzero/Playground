package TodoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    LocalDateTime dataTime;
    String title;
    String content;

    static DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");

    public Note(String newTitle, String newContent) {
        dataTime = LocalDateTime.now();
        title = newTitle;
        content = newContent;
    }

    public void print() {
        System.out.format("dataTime: %s\ntitle: %s\ncontent: %s\n\n",
                dataTime.format(dataTimeFormatter), title, content);
    }

    public String toString() {
        return dataTime.format(dataTimeFormatter) + " " + title+ " "+ content;
    }
}