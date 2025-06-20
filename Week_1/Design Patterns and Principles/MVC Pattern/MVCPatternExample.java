public class MVCPatternExample {
    public static void main(String[] args) {
        Student student = new Student("John Doe", "S123", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
