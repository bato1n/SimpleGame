package simplegame;


public class Cyclist extends User_road{
    Position position;
    private Walker w;
    Cyclist(){
        speed = 2;
    }
    Cyclist(Walker w){
        speed = 2;
        this.w = w;
    }
    @Override
    public void draw() {
      System.out.print("C");
    }

}
