package countword;

import java.io.*;
import java.util.*;

public class CountWord 
{
    public static void main(String[] args) throws IOException 
    {
        File file = new File("C:\\test.txt");
        try(Scanner sc = new Scanner(new FileInputStream(file)))
        {
            int count=0;
            while(sc.hasNext())
            {
                sc.next();
                count++;
            }
            System.out.println(count);
        }
    }
}