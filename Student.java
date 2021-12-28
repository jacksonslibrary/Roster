public class Student extends Person {
    public int id;

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
    }
    public String toString() {
        return "Student: " + firstName + " " + lastName + " " + id;
    }



}