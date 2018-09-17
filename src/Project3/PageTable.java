package Project3;

import java.util.ArrayList;

public class PageTable {

    private ArrayList<Integer> table = new ArrayList<>();

    public PageTable(int i){
        initTable(i);
    }

    public void initTable(int tableSize){
        for(int i=0; i<tableSize; i++){
            table.add(null);
        }
    }

    public void fillTable(int pageNum, int frameNum){
        table.set(pageNum, frameNum);
    }

    public ArrayList<Integer> getTable() {
        return table;
    }

    public void printTable(){
        System.out.println("Page Table");
        for(int i=0; i<table.size(); i++){
            System.out.println(" "+table.get(i));
        }
    }
}
