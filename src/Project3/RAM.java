package Project3;

import java.util.ArrayList;

public class RAM {

    private ArrayList<Boolean> memory = new ArrayList<>();
    private int mSize;

    public RAM(int mSize){
        this.mSize = mSize;
        initMemory(mSize);
    }

    public void initMemory(int mSize){
        for(int i=0; i<mSize; i++){
            memory.add(true);
        }
    }

    public int occupyMemory(){
        int frameNum = 0;
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).equals(true)){
                frameNum = i;
                memory.set(i,false);
                break;
            }
            if(i == memory.size()){
                frameNum = memory.size();
                break;
            }
        }
        return frameNum;
    }

    public void releaseMemory(int i){
        memory.set(i,true);
    }

    public int getmSize(){
        return mSize;
    }

    public void printRAM(){
        for(int i=0; i<memory.size(); i++){
            System.out.println(memory.get(i)+" ");
        }
        System.out.println();
    }


}
