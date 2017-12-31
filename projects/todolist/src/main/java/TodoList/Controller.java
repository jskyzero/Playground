package TodoList;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Controller {

    List<Note> notes;
    static final  String fileName = "notes.json";

    public Controller() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path filePath = Paths.get(fileName);
        Type collectionType = new TypeToken<LinkedList<Note>>() {}.getType();
        try {
            notes = gson.fromJson(
                    Files.readAllLines(filePath).stream().collect(Collectors.joining("\n")), collectionType);
            if (notes == null) throw  new IOException("Empty file");
            System.out.println("Read data");
        } catch (IOException e) {
            notes = new LinkedList<Note>();
            System.out.println("Initial data");
        }
    }

    public void addNote(String title, String content) {
        notes.add(new Note(title, content));
    }

    public void deleteNote(String title) {
        notes.removeIf(note -> note.title.equals(title));
    }

    public void printAllNote() {
        // System.out.println(notes);
        for (Note note : notes) {
            note.print();
        }
    }

    public void saveData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {

        try {
            Files.createFile(Paths.get(fileName));
            System.out.println("Create data");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Update data");
        }
        Files.write(Paths.get(fileName),
                new ArrayList<String>(Arrays.asList(gson.toJson(notes).split("\n"))),
                Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}