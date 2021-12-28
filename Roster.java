import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Roster {

    ArrayList<Person> people;

    public Roster(String filename) {
        people = new ArrayList<Person>();
        initializeListFromFile(filename);
    }

    public void initializeListFromFile(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] arrOfStr = line.split(",", 3);
                if (arrOfStr.length == 2) {
                    Person person = new Person(arrOfStr[0], arrOfStr[1]);
                    people.add(person);
                }
                else if (arrOfStr.length == 3) {
                    Student student = new Student(arrOfStr[0], arrOfStr[1], Integer.parseInt(arrOfStr[2]));
                    people.add(student);
                }
                else {
                    System.out.println("error");
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
        Roster r = new Roster("roster.csv");
        for (int i = 0; i < r.people.size(); i++) {
            System.out.println(r.people.get(i));
        }
    }

}