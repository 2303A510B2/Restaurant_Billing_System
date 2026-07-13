import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }
}

public class Student_Management_System {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, age, course, marks));

        System.out.println("Student Added Successfully.");

    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-8s %-15s %-8s\n",
                "ID", "Name", "Age", "Course", "Marks");
        System.out.println("--------------------------------------------------------------");

        for (Student s : students) {

            System.out.printf("%-8d %-20s %-8d %-15s %-8.2f\n",
                    s.id,
                    s.name,
                    s.age,
                    s.course,
                    s.marks);

        }

    }

    static void updateStudent() {

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();

                System.out.println("Student Updated Successfully.");
                return;
            }

        }

        System.out.println("Student Not Found.");

    }

    static void deleteStudent() {

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).id == id) {

                students.remove(i);

                System.out.println("Student Deleted Successfully.");

                return;
            }

        }

        System.out.println("Student Not Found.");

    }

    static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                System.out.println("\nStudent Details");
                System.out.println("---------------------------");
                System.out.println("ID      : " + s.id);
                System.out.println("Name    : " + s.name);
                System.out.println("Age     : " + s.age);
                System.out.println("Course  : " + s.course);
                System.out.println("Marks   : " + s.marks);

                return;
            }

        }

        System.out.println("Student Not Found.");

    }

}