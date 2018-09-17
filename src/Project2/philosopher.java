package Project2;

public class philosopher implements Runnable {
    int num;
    conditions condition;
    public enum conditions{
        thinking, eating
    }
    public philosopher(int num){
        this.num = num;
        this.condition = conditions.thinking;
    }

    @Override
    public void run(){
        try{
            while(miscsubs.TotalEats < miscsubs.MAX_EATS){
                miscsubs.RandomDelay();
                this.condition = conditions.eating;
                if(miscsubs.TotalEats < miscsubs.MAX_EATS){
                    miscsubs.Used = true;
                    miscsubs.StartEating(num);
                    this.condition = conditions.thinking;
                    miscsubs.DoneEating(num);
                    miscsubs.Used = false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}