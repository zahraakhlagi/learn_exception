package lexicon.se;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.sql.DriverManager;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
       /* int a=20;
        int b= 0;


        try {
            int result= a/b;
            IO.println("result is : "+ result);
        }catch (ArithmeticException e){
            IO.println("can not devide by zero");

            //get a exception type: ArithmeticException
            IO.println("Exception type: "+ e.getClass().getSimpleName());
            //get error message, what were wrong
            IO.println("Error message: "+ e.getMessage());
            //stack trace: include class name, method name and line number
            IO.println("stack trace: ");
            e.printStackTrace();
        }*/

       /* //files not found IDE exception
        BufferedReader reader= Files.newBufferedReader(Paths.get("dir/test.txt"));
        //sql exception
        DriverManager.getConnection("");*/
        //double number=tackeDecimalInput("Enter a decimal number: ");
       // IO.println("number:" + number);
        //readTextFile();
        //readImageAndCopy();
        writeTextToFile();



    }
    public static double tackeDecimalInput(String prompt){
        while (true){
            try {
                String input= IO.readln(prompt);
                double result = Double.parseDouble(input);
                return result;
            }catch (NumberFormatException e){
                IO.println("invalid number, please entre a valid number.");
            }catch (NullPointerException e){
                IO.println("input should not be string");
            }
        }
    }
    public static void readTextFile(){
        //Files.readAllLines();//best for small files
        //Files.newBufferedReader(); //suitable for large file
        //Files.lines();//returns a stream of data
        Path path= Path.of("dir/1111.txt");
        try {
            List<String> lines= Files.readAllLines(path);
            lines.forEach(line->IO.println(line));
        }catch(NoSuchFileException e){
            IO.println("file not found."+ e.getMessage());
        }
        catch (IOException e) {
            IO.println("Error reading file: ");
            IO.println("Reason: "+ e.getMessage());
            e.printStackTrace();
        }

    }
    public static void readImageAndCopy(){
        //define a two path
        Path sourcePath = Paths.get("source/111.jpg");
        Path destinationPath = Paths.get("destination/images.jpg");
        try {
            Files.copy(sourcePath,destinationPath,StandardCopyOption.REPLACE_EXISTING);
        } catch (NoSuchFileException |FileAlreadyExistsException e){
            IO.println("File error:" +e.getMessage());

        } catch (IOException e) {
            IO.println("Error coping file: ");
            IO.println("reason: "+ e.getMessage());
            e.printStackTrace();
        }
    }
    public static void writeTextToFile(){
        Path paths = Paths.get(("dir/test.txt"));
        BufferedWriter writer=null;
        try {
            writer = Files.newBufferedWriter(paths,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            writer.append("this is a test new buffer writer");
            writer.append("test one more time");
            IO.println("data written successfully.");
            //writer.close();
        } catch (IOException e) {
            System.err.println("Error closing writer");
            e.printStackTrace();
        }finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void writeTextToFileNew(){
        Path paths = Paths.get(("dir/test.txt"));
        //try() : auto closable because writer implements closable, we put resources in the ()

        try (
                                        BufferedWriter writer =
                                        Files.newBufferedWriter(paths,
                                            StandardOpenOption.CREATE,
                                            StandardOpenOption.APPEND);
            )
        {
            writer.append("this is a test new buffer writer");
            writer.append("test one more time");
            IO.println("data written successfully.");
            //writer.close();
        } catch (IOException e) {
            System.err.println("Error closing writer");
            e.printStackTrace();
        }
    }

}
