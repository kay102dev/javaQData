public class Main {

    public static void main(String[] args) {
            // a: A parameterized constructor class
        QdataFile schoolStudentData = new QdataFile("../text-test.txt");
        try {
            // b: Read file and determine quizzes and students
            schoolStudentData.readFile();
            System.out.println("b. has been completed");


            // c: getters for student and quizzes
            System.out.println("c. Number of students: "
                    + schoolStudentData.getStudents() + ", Number of quizzes: "
                    + schoolStudentData.getQuizzes() + " per students");
            System.out.println();

            // d
            schoolStudentData.toString();

            // e
            schoolStudentData.printArray();

            // f
            schoolStudentData.studentAverage(1);

            // g
            schoolStudentData.quizRange(4);

            // h
            schoolStudentData.overallAverage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}