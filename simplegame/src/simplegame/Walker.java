
package simplegame;

import java.util.Random;


public class Walker extends User_road {
    Position position;
    private int km;
    Walker(){
        speed = 1;
        km = 0;
    }
    @Override
    public void draw() {
      System.out.print("W");
    }
    public Position getOn(){
        Random rand = new Random(); 
        if(rand.nextInt(2) == 0){
            Driver d = new Driver(this);
            d.setX(this.getX());
            d.setY(this.getY());
            return d;
        } 
        else{
            Cyclist c = new Cyclist(this);
            c.setX(this.getX());
            c.setY(this.getY());
            return c;
        } 
    }
    public int getKm(){
        return km;
    }
    public void setKm(int km){
        this.km = km;
    }
}
