package BasicPractices;

import java.util.Scanner;

public class Basicx {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("Please Enter your name: ");
        String name = reader.nextLine();

        System.out.print("Please Enter your Gender: ");
        String gender = reader.nextLine();
        char test = gender.charAt(0);

        System.out.println(name);
        System.out.println(test);

    }
}
