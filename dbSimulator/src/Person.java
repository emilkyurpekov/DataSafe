import java.io.FileWriter;
import java.io.IOException;

public class Person {
    private String name;
    private String id;

    public Person(String name, String id) throws IOException {
        this.name = name;
        this.id = id;
        saveToRepository();
    }

    public void saveToRepository() throws IOException {
        if (this.id.length() != 10) {
            throw new IllegalArgumentException("ID must be ten symbols in order to add person to database!");
        }
        try (FileWriter insertData = new FileWriter("personRepository.txt", true)) {
            insertData.write(name + "," + id + "\n");
        }
    }
}
