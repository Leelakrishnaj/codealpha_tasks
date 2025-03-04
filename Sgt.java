import java.util.Scanner;
public class Sgt
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numofStudents = sc.nextInt();
        int[] grades = new int[numofStudents];
        for (int i = 0; i < numofStudents; i++)
        {
            System.out.print("Enter grade for student " + (i + 1)+":");
            grades[i] = sc.nextInt();
        }
        int sum = 0;
        int highest = grades[0];
        int lowest = grades[0];
        for (int i = 0; i < numofStudents; i++)
        {
            sum += grades[i];
            if (grades[i] > highest) 
            {
                highest = grades[i];
            }
            if (grades[i] < lowest)
            {
                lowest = grades[i];
            }
        }
        double average = (double) sum / numofStudents;
        System.out.println("\nGrade Summary:");
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }
}
