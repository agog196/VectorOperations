import java.util.Scanner;

public class Vectors {

    static class ValidVector {
        double v1;
        double v2;
        double v3;
        boolean validVector;

        public ValidVector(double v1, double v2, double v3, boolean validVector) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
            this.validVector = validVector;
        }
    }

    public static ValidVector inputVector(int vectorNum) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the three components of vector " + vectorNum + ": ");
        double v1 = 0.0;
        double v2 = 0.0;
        double v3 = 0.0;

        if (input.hasNextDouble()) {
            v1 = input.nextDouble();
        } else {
            return new ValidVector(v1, v2, v3, false);
        }
        if (input.hasNextDouble()) {
            v2 = input.nextDouble();
        } else {
            return new ValidVector(v1, v2, v3, false);
        }
        if (input.hasNextDouble()) {
            v3 = input.nextDouble();
        } else {
            return new ValidVector(v1, v2, v3, false);
        }
        return new ValidVector(v1, v2, v3, true);
    }

    public static ValidVector addVectors(ValidVector vector1, ValidVector vector2) {
        double v1 = vector1.v1 + vector2.v1;
        double v2 = vector1.v2 + vector2.v2;
        double v3 = vector1.v3 + vector2.v3;
        return new ValidVector(v1, v2, v3, true);
    }

    public static ValidVector diffVectors(ValidVector vector1, ValidVector vector2) {
        double v1 = vector1.v1 - vector2.v1;
        double v2 = vector1.v2 - vector2.v2;
        double v3 = vector1.v3 - vector2.v3;
        return new ValidVector(v1, v2, v3, true);
    }

    public static double dotProduct(ValidVector vector1, ValidVector vector2) {
        double dot = 0.0;
        dot += vector1.v1 * vector2.v1;
        dot += vector1.v2 * vector2.v2;
        dot += vector1.v3 * vector2.v3;
        return dot;
    }

    public static ValidVector crossProduct(ValidVector vector1, ValidVector vector2) {
        double v1 = (vector1.v2 * vector2.v3) - (vector1.v3 * vector2.v2);
        double v2 = (vector1.v1 * vector2.v3) - (vector1.v3 * vector2.v1);
        double v3 = (vector1.v1 * vector2.v2) - (vector1.v2 * vector2.v1);
        return new ValidVector(v1, -v2, v3, true);
    }

    public static String vectorString(ValidVector vector) {
        String vectorString = "";
        vectorString += "<" + vector.v1 + ", " + vector.v2 + ", " + vector.v3 + ">";
        return vectorString;
    }

    public static void main(String[] args) {
        boolean runProgram = true;
        ValidVector vector1 = inputVector(1);
        ValidVector vector2 = inputVector(2);

        if (!vector1.validVector || !vector2.validVector) {
            runProgram = false;
        }
        if (runProgram) {
            System.out.print("Vector 1: ");
            System.out.println(vectorString(vector1));
            System.out.println();
            System.out.print("Vector 2: ");
            System.out.println(vectorString(vector2));
            System.out.println();
            System.out.print("Sum of vectors: ");
            System.out.println(vectorString(addVectors(vector1, vector2)));
            System.out.println();
            System.out.print("Difference of vectors: ");
            System.out.println(vectorString(diffVectors(vector1, vector2)));
            System.out.println();
            System.out.print("Dot product of vectors: ");
            System.out.println(dotProduct(vector1, vector2));
            System.out.println();
            System.out.print("Cross product of vectors: ");
            System.out.println(vectorString(crossProduct(vector1, vector2)));
        } else {
            System.out.println("Invalid input, program ending.");
        }
    }
}
