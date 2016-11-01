package simplegame;
 
import java.util.*;
 
public class Map {
   
    static String[][] screen = new String [10][20];
    Position d = new Driver();
    Position w = new Walker(); 
    Position c = new Cyclist();
    Random ra = new Random();
    public boolean col = false;
    
    public void SetObject(Position p){
        int x,y;
        do{
         x = (this.ra.nextInt(screen.length));
         y = (this.ra.nextInt(screen[0].length));
        }while(screen[x][y] != " ");
        p.setX(x);
        p.setY(y);
    }
   
    public void SetMap(){
         
        for(int i = 0; i < screen.length; i++)
        {
            for(int j = 0; j < screen[i].length; j++)
            {
                if( j == 0 || j == 19)
                {
                    screen[i][j] = "#";
                }
                if(j != 0 && j != 19 && i != 0 && i != 9)
                {
                    screen[i][j] = " ";
                   
                }
                if (i == 0 && j != 0 && j != 19 || i == 9 && j != 0 && j != 19)
                {
                    screen[i][j] = "#";    
                }
            }
        }
        
        SetObject(this.c);
        SetObject(this.w);
        SetObject(this.d);
    }
    
   public void Draw(){
         
        for(int i = 0; i < screen.length; i++)
        {
            for(int j = 0; j < screen[i].length; j++)
            {
                if(this.w.getX() == i && this.w.getY() == j)
                {
                    w.draw();
                } else if(this.c.getX() == i && this.c.getY() == j){
                    c.draw();
                } else if(this.d.getX() == i && this.d.getY() == j){
                    d.draw();
                } else {
                    System.out.print(screen[i][j]);
                }
            }
            System.out.println("");
        }
    }
   
   public void Logic(){
        for(int i = 0;i < w.speed;i++){
            Move_Object(w);
            Collision_check();
        }

        for(int i = 0;i < c.speed;i++){
            Move_Object(c);
            Collision_check();
        }

        for(int i = 0;i < d.speed;i++){
            Move_Object(d);
            Collision_check();
        }
   }
        
    public void Move_Object(Position p)
    {
    int a = 0;
    boolean block = false;
    Random way = new Random();
    
    do{
        block = false;
        a = (way.nextInt(4));
        if( a == 0)
        {
            if(screen[p.getX() - 1][p.getY()] != "#" && p.getX() - 1 > 0){
                p.setX(p.getX() - 1);
            } else {
                block = true;
            }
        } else if (a == 1){
            if(screen[p.getX() + 1][p.getY()] != "#" && p.getX() + 1 < screen.length){
                p.setX(p.getX() + 1);
            } else {
                block = true;
            }
        } else if (a == 2){
            if(screen[p.getX()][p.getY() - 1] != "#" && p.getY() - 1 > 0){
                p.setY(p.getY() - 1);
            } else {
                block = true;
            }
        } else if (a == 3){
            if(screen[p.getX()][p.getY() + 1] != "#" && p.getY() + 1 < screen[0].length){
                p.setY(p.getY() + 1);
            } else {
                block = true;
            }
         }
        }while(block == true);
        if(p instanceof Walker){
            ((Walker)p).setKm(((Walker)p).getKm() + 1);
            if(((Walker)p).getKm() == 10){
                if(new Random().nextBoolean())
                    w = ((Walker)p).getOn();
                ((Walker)p).setKm(0);
            }
        }
    }
    
    public void Collision_check()
    {
        if(w.getX() == c.getX() && w.getY() == c.getY()){
            System.out.println("Collision W i C, GAME OVER");
            System.exit(0);
        }
        if(w.getX() == d.getX() && w.getY() == d.getY()){
            System.out.println("Collision W i D, GAME OVER");
            System.exit(0);
        }
        if(c.getX() == d.getX() && c.getY() == d.getY()){
            System.out.println("Collision C i D, GAME OVER");
            System.exit(0);
        }
    }
}