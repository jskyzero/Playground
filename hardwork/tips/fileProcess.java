import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcess {
    public static void main(String []args) throws IOException {
        Path filePath = Paths.get("README.md");
        List<String> lines = Files.readAllLines(filePath);
            System.out.println(
                lines.stream()
                     .map(line -> line)
                     .collect(Collectors.joining("\n")));
        try {
            Files.createFile(Paths.get("example"));
        } catch(FileAlreadyExistsException e) {
            // pass 
        }
        Files.write(Paths.get("example"), lines, Charset.forName("UTF-8"));
    }
}