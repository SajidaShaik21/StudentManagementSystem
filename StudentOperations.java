public interface StudentOperations<T> {
    void addStudent(T student) throws DuplicateStudentException;
    void displayStudents();
    void searchStudent(int studentId);
    void updateStudent(int studentId, String name, int age, double marks)
            throws InvalidStudentException;
    void deleteStudent(int studentId);
}
