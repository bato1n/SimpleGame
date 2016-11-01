package simplegame;


public class Driver extends User_road {
    Position position;
    private Walker w;
    Driver(){
        speed = 3;
    }
    Driver(Walker w){
        speed = 3;
        this.w = w;
    }
    @Override
    public void draw() {
      System.out.print("D");
    }
}

