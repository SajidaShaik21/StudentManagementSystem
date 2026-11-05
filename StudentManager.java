import java.util.ArrayList;

public class StudentManager implements StudentOperations<Student> {
    private final ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) throws DuplicateStudentException {
        for (Student existing : students) {
            if (existing.getStudentId() == student.getStudentId()) {
                throw new DuplicateStudentException("Student ID already exists!");
            }
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }

    @Override
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\\n===== ALL STUDENT RECORDS =====");
        for (Student student : students) {
            student.displayStudent();
        }
    }

    @Override
    public void searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("\\nStudent found!");
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    @Override
    public void updateStudent(int studentId, String name, int age, double marks)
            throws InvalidStudentException {
        Student found = null;
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                found = student;
                break;
            }
        }

        if (found == null) {
            System.out.println("Student ID not found!");
            return;
        }
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentException("Name cannot be empty.");
        }
        if (age <= 0 || age > 120) {
            throw new InvalidStudentException("Age must be between 1 and 120.");
        }
        if (marks < 0 || marks > 100) {
            throw new InvalidStudentException("Marks must be between 0 and 100.");
        }

        found.setName(name.trim());
        found.setAge(age);
        found.setMarks(marks);
        System.out.println("Student updated successfully!");
    }

    @Override
    public void deleteStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void calculateStudentGrade(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Student Name: " + student.getName());
                System.out.println("Marks: " + student.getMarks());
                System.out.println("Grade: " + student.calculateGrade());
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
