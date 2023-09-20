import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("With which command would you like to proceed:");
        System.out.print("Insert information in the file/ Search for people in the file");
        System.out.println(" Please write 1 or 2.");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice == 1){
            System.out.println("Insert person`s information below:");
            String input = scanner.nextLine();
            String name = input.split(",")[0];
            String id = input.split(",")[1];
            Person person = new Person(name,id);
        }
        else if (choice ==2){
            System.out.println("Insert desired ID:");
            String ID = scanner.nextLine();
            String foundName = findPersonNameByID(ID);

            if (foundName != null) {
                System.out.println("Found person with name: " + foundName + " for ID: " + ID);
            } else {
                System.out.println("No person found with ID: " + ID);
            }

            scanner.close();
        }
    }

    public static String findPersonNameByID(String targetID) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("personRepository.txt"));
        if (reader.readLine() == null) {
            reader.close();
            throw new IOException("The file is empty!");
        }
        String line = reader.readLine();
        while (line != null) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[1].trim().equals(targetID)) {
                reader.close();
                return parts[0].trim(); // Return the name of the person
            }
            line = reader.readLine();
        }

        reader.close();
        return null;
    }
}