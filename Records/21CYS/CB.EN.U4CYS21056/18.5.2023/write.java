import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class write {
    public static void main(String[] args)
        throws IOException
    {
        
        String str = "Hello My Name is Pranav";
        try {
            FileWriter fw
                = new FileWriter("../18.5.2023/20cys383.txt");
            for (int i = 0; i < str.length(); i++)
                fw.write(str.charAt(i));
            System.out.println("Successfully written");
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
