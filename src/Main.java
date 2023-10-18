import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("Input.txt"));
        int tRoom = sc.nextInt();
        int tCond = sc.nextInt();
        sc.nextLine();
        String mode = sc.nextLine();
        int result = Result(mode, tRoom,tCond);
        writeToFile(result);
    }

    public static int Result(String mode, int tRoom, int tCond)  {
        int result = 0;
        if (Objects.equals(mode, "fan"))
            result =  tRoom;
        if (Objects.equals(mode, "auto"))
            result =  tCond;
        if (Objects.equals(mode, "heat")) {
            result = heat(tRoom,  tCond);
        }
        if (Objects.equals(mode, "freeze")) {
            result = freeze(tRoom,  tCond);
        }
        return result;
    }
    public static int heat(int tRoom, int tCond)  {
        if (tRoom >= tCond)
            return  tRoom;
        else
            return  tCond;
    }
    public static int freeze(int tRoom, int tCond)  {
        if (tRoom <= tCond)
            return tRoom;
        else
            return tCond;
    }
        public static void writeToFile(int result) throws IOException {
        String s = String.valueOf(result);
        Files.writeString(Path.of("OUTPUT.TXT"), s);
    }
}