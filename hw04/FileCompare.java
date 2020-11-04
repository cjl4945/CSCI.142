import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chase Lewis
 *
 */
public class FileCompare {

    private int diffLength;

    private int unmatchedChar;


    /**
     *  this method takes in two files and compares them line by line, character by character
     *
     * @param filename1 string of file name one
     * @param filename2 string of file name two
     * @throws FileNotFoundException
     */
    public static void charByChar(String filename1, String filename2) throws FileNotFoundException {
        File file = new File(filename1);
        File file2 = new File(filename2);
        try {
            Scanner input = new Scanner(file);
            input.close();
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Bad filename " + filename1);
        }

        try {
            Scanner input2 = new Scanner(file2);
            input2.close();
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Bad filename " + filename2);
        }
        ArrayList<String> unmatchedlist = new ArrayList<>();
        Scanner input = new Scanner(file, "UTF-8");
        Scanner input2 = new Scanner(file2, "UTF-8");
        int diffLength = 0;
        int unmatchedChar = 0;
        int char1 = 0;
        int char2 = 0;
        int line = 0;
        String str;
        String str2;
        while (input.hasNextLine() && input2.hasNextLine()) {
            str = input.nextLine();
            str2 = input2.nextLine();
            System.out.println(str);
            line++;
            char1 += str.length();
            char2 += str2.length();
            if (str.length() != str2.length()) {
                diffLength++;
                unmatchedlist.add(Integer.toString(line));
            }
            else {

                    int counter = 1;
                for (int i = 0; i <= str.length() - 1; i++) {
                    if (str.charAt(i) != str2.charAt(i)) {
                        unmatchedChar++;
                        unmatchedlist.add(line + ":" + counter);

                    }
                    counter++;
                }
            }
        }
        if ((input.hasNextLine()  &&  (!(input2.hasNextLine())))
                || (!(input.hasNextLine()))  &&  input2.hasNextLine()) {
            unmatchedlist.add(Integer.toString(line));
        }
        System.out.println("Character by character:");
        System.out.print("Unmatched characters: " );
        for (String s : unmatchedlist) {
            System.out.print(s + ", ");
        }
        System.out.println("\nThere are " + char1 + " characters in " + filename1);
        System.out.println("There are " + char2 + " characters in " + filename2);
        System.out.println("There were " + unmatchedChar + " unmatched characters in the files");
        System.out.println("There were " + diffLength + " lines of different length");
    }
//        ArrayList<String> unmatchedlist = new ArrayList<>();
//        Scanner input = new Scanner(file1);
//        Scanner input2 = new Scanner(file2);
//        int diffLength = 0;
//        int unmatchedChar = 0;
//        int char1 = 0;
//        int char2 = 0;
//        int line = 0;
//        while (input.hasNextLine() && input2.hasNextLine()){
//            line++;
//            char1 += input.nextLine().length();
//            char2 += input2.nextLine().length();
//            if ((input.nextLine() == null && input2.nextLine() != null)
//                    || (input.nextLine() != null && input2.nextLine() == null){
//                unmatchedlist.add(Integer.toString(line));
//            }
//            if (input.nextLine().length() != input2.nextLine().length()){
//                diffLength++;
//                unmatchedlist.add(Integer.toString(line));
//            }
//
//            for (int i = 1; i  <= input.nextLine().length(); i++){
//               if (input.nextLine().indexOf(i) != input2.nextLine().indexOf(i)){
//                   unmatchedChar++;
//                   unmatchedlist.add(line + ":" + i);
//               }
//            }
//            }
//
//
//        }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first filename: ");
        String filename1 = scanner.next();
//        File file = new File(filename);
        System.out.println("Enter the second filename: ");
        String filename2 = scanner.next();
        charByChar(filename1, filename2);
//        File file2 = new File(filename2);
//        try{
//            Scanner input = new Scanner(file);
//            input.close();
//        }
//        catch (IOException ioe) {
//            throw new IllegalArgumentException("Bad filename " + filename);
//        }
//
//        try{
//            Scanner input2 = new Scanner(file2);
//            input2.close();
//        }
//        catch (IOException ioe) {
//            throw new IllegalArgumentException("Bad filename " + filename2);
//        }
//        ArrayList<String> unmatchedlist = new ArrayList<>();
//        Scanner input = new Scanner(file);
//        Scanner input2 = new Scanner(file2);
//        int diffLength = 0;
//        int unmatchedChar = 0;
//        int char1 = 0;
//        int char2 = 0;
//        int line = 0;
//        while (input.hasNextLine() && input2.hasNextLine()){
//            line++;
//            char1 += input.nextLine().length();
//            char2 += input2.nextLine().length();
//            if ((input.nextLine() == null && input2.nextLine() != null)
//                    || (input.nextLine() != null && input2.nextLine() == null)){
//                unmatchedlist.add(Integer.toString(line));
//            }
//            if (input.nextLine().length() != input2.nextLine().length()){
//                diffLength++;
//                unmatchedlist.add(Integer.toString(line));
//            }
//
//            for (int i = 1; i  <= input.nextLine().length(); i++){
//                if (input.nextLine().indexOf(i) != input2.nextLine().indexOf(i)){
//                    unmatchedChar++;
//                    unmatchedlist.add(line + ":" + i);
//                }
//            }
//        }
//        System.out.println("Character by character:");
//        System.out.print("Unmatched characters: ");
//        for (String s : unmatchedlist ){
//            System.out.print(s + ", ");
//        }
//        System.out.println("There are " + char1 + " characters in " + filename);
//        System.out.println("There are " + char2 + " characters in " + filename2);
//        System.out.println("There were " + unmatchedChar + " unmatched characters in the files");
//        System.out.println("There were " + diffLength + " lines of different length");
//        }


    }
}

