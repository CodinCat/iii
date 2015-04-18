import java.util.*;
import java.io.*;
 
public class Compare {
    public static void main(String[] args) throws IOException {
        FileReader fr1 = new FileReader(args[0]);
        FileReader fr2 = new FileReader(args[1]);
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);
        String userAns = "";
        String correctAns = "";
        while (br1.ready()) {
            String line = "";
            line = br1.readLine();
            if (line.contains("Script started on")) {
                userAns = userAns;
            } else if (line.contains("Script done on")) {
                break;
            } else {
                userAns = userAns + line +"\n";
            }
        }
        fr1.close();
        System.out.println("USER:\n"+userAns);
        while (br2.ready()) {
            correctAns = correctAns + br2.readLine() + "\n";
        }
        fr2.close();
        System.out.println("ANS:\n"+correctAns);
        System.out.print(check(userAns,correctAns));
    }
 
    public static String check(String user, String correct) {
        int countChar = correct.length();
        String show = "";
 
        if (user.equals(correct)) {
            show = "Congrats!\n";
        } else {
            for (int i=0; i<countChar; i++) {
                if (user.charAt(i) == correct.charAt(i)) {
                    show = show + user.charAt(i);
                } else {
                    show = show + "^\n";
                    System.out.println("Error:\n");
                    break;
                }
            }
        }
        return show;
    }
}