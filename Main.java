import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        int choice;

        System.out.println("====================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");

        do {
            System.out.println("\\n========== MAIN MENU ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Exit");
            System.out.println("===============================");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent(manager);
                    break;
                case 2:
                    manager.displayStudents();
                    break;
                case 3:
                    manager.searchStudent(readInt("Enter Student ID: "));
                    break;
                case 4:
                    updateStudent(manager);
                    break;
                case 5:
                    manager.deleteStudent(readInt("Enter Student ID: "));
                    break;
                case 6:
                    manager.calculateStudentGrade(readInt("Enter Student ID: "));
                    break;
                case 7:
                    System.out.println("Thank you for using Student Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1 to 7.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static void addStudent(StudentManager manager) {
        try {
            System.out.println("\\n===== ADD NEW STUDENT =====");
            int id = readInt("Enter Student ID: ");
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine().trim();
            int age = readInt("Enter Student Age: ");
            double marks = readDouble("Enter Student Marks: ");

            validateStudentDetails(id, name, age, marks);
            manager.addStudent(new Student(id, name, age, marks));
        } catch (InvalidStudentException | DuplicateStudentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateStudent(StudentManager manager) {
        try {
            System.out.println("\\n===== UPDATE STUDENT =====");
            int id = readInt("Enter Student ID to update: ");
            System.out.print("Enter New Name: ");
            String name = sc.nextLine().trim();
            int age = readInt("Enter New Age: ");
            double marks = readDouble("Enter New Marks: ");
            manager.updateStudent(id, name, age, marks);
        } catch (InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void validateStudentDetails(int id, String name, int age, double marks)
            throws InvalidStudentException {
        if (id <= 0) {
            throw new InvalidStudentException("Student ID must be positive.");
        }
        if (name.isEmpty()) {
            throw new InvalidStudentException("Student name cannot be empty.");
        }
        if (age <= 0 || age > 120) {
            throw new InvalidStudentException("Age must be between 1 and 120.");
        }
        if (marks < 0 || marks > 100) {
            throw new InvalidStudentException("Marks must be between 0 and 100.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}
