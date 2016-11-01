
package simplegame;

import java.util.Scanner;


public class Simplegame {


  public static void main(String[] args) 
    {
        boolean end = false;
        String line = "";
        Scanner scan = new Scanner(System.in);
        Map map = new Map();
        map.SetMap();
        while(end == false){
            System.out.println("Write end to end or press enter");
            line = scan.nextLine();
            if(line.equals("end")){
                end = true;
            }
            map.Logic();
            map.Draw();
        }
    }
    
}
