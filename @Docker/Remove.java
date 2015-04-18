import java.util.*;
import java.io.*;

public class Remove {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        while (br.ready()) {
			str = str + br.readLine() + "\n";
		}
		fr.close();
		String removed = str;
    	String[] filter = {"\\^\\[\\[1~",
    	                   "\\^\\[\\[2~",
    	                   "\\^\\[\\[4~",
    	                   "\\^\\[\\[5~",
    	                   "\\^\\[\\[6~",
    	                   "\\^\\[\\[3~",
    					   "\\^\\[\\[A",
    					   "\\^\\[\\[B",
    					   "\\^\\[\\[C",
    					   "\\^\\[\\[D"};
    	for (int i=0; i<filter.length; i++) {
    		removed = removed.replaceAll(filter[i],"");
    	}
    	//System.out.print(removed + "\n");
    	FileWriter fw = new FileWriter("filtered");
        fw.write(removed);
        fw.flush();
        fw.close();

    	//System.out.print(str + "\n");
    }
}