public class Student extends Person {
    private int studentId;
    private int age;
    private double marks;

    public Student(int studentId, String name, int age, double marks) {
        super(name);
        this.studentId = studentId;
        this.age = age;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "Fail";
    }

    public void displayStudent() {
        System.out.println("--------------------------------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + getName());
        System.out.println("Age        : " + age);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("--------------------------------");
    }
}
