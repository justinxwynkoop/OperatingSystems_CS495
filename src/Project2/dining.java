package Project2;

// Use java threads to simulate the Dining Philosophers Problem; Credits given to Prof. Riley
// Justin Wynkoop/

class dining {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Starting the Dining Philosophers Simulation");
        miscsubs.InitializeChecking();
        // Your code here...
        Object mutexLock = new Object();
        Thread[] philosophers = new Thread[miscsubs.NUMBER_PHILOSOPHERS];
        synchronized (mutexLock){
            for (int i=0; i < philosophers.length; i++){
                philosophers[i] = new Thread(new philosopher(i));
                philosophers[i].start();
                while(miscsubs.Used){
                    mutexLock.wait();
                }
            }
        }
        for(int i=0; i < philosophers.length; i++){
            try{
                philosophers[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        // End of your code
        miscsubs.LogResults();
    }
}