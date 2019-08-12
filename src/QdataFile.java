import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class QdataFile {

    private int quizzes;
    private int students;
    private String fileName;
    private double[][] twoDims;
    private String[] allRows;

    public QdataFile(String fileName) {
        this.fileName = fileName;
        System.out.println("a. has been completed");
    }

    public void readFile() throws Exception {

        int rows = 0;
        int cols = 0;
        String textLine;

        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        scanner.useDelimiter(" ");

        while (scanner.hasNextLine()) {
            textLine = scanner.nextLine();
            String[] lineSplit = textLine.split(" ");
            cols = lineSplit.length;
            rows++;
        }
        students = rows;
        quizzes = cols;
        twoDims = new double[rows][cols];
        allRows = new String[students];

        Scanner newScanner = new Scanner(new BufferedReader(new FileReader(fileName)));

        int count = 0;
        while (newScanner.hasNextLine()) {
            textLine = newScanner.nextLine();
            String[] lineSplit = textLine.split(" ");
            allRows[count] = textLine;
            cols = lineSplit.length;
            for (int i = 0; i < cols; i++) {
                twoDims[count][i] = Double.valueOf(lineSplit[i].trim());
            }
            count++;
        }
    }

    public int getStudents() {
        return students;
    }

    public int getQuizzes() {
        return quizzes;
    }

    public String toString() {
        String toString = "";
        for (int i = 0; i < allRows.length; i++) {
            toString = toString + allRows[i] + "\n";
        }

        System.out.println("d. QData Output below:" + "\n" + toString);


        return toString;
    }

    public void printArray() {

        String print = "";
        for (int i = 0; i < getStudents(); i++) {
            print = print + allRows[i] + " ";
        }
        System.out.println("e. Array Printed: " + print);
        System.out.println();


    }

    public void studentAverage(int studentNumber) {
        double sum = 0;
        for(int i=0; i < getQuizzes(); i++){
            sum += Double.valueOf( twoDims[studentNumber][i] );
        }
        double average = sum/getQuizzes();
        System.out.println("f. Student Average: " + average);
        System.out.println();

    }

    public void quizRange(int studentNumber) {
        double[] Arr = twoDims[studentNumber].clone();
        Arrays.sort(twoDims[studentNumber]);
        System.out.println("g. Student Range: " + (Arr[Arr.length-1] - Arr[0]));
        System.out.println();
    }


    public void overallAverage() {
        double sum = 0;
        for(int j = 0; j < getStudents(); j++) {
            for(int i=0; i < getQuizzes(); i++){
                sum += Double.valueOf( twoDims[j][i] );
            }
        }
        double average = sum/(getQuizzes() * getStudents());
        System.out.println("h. All students Average: " + average);


    }

}