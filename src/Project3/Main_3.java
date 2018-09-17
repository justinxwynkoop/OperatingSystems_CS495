package Project3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_3 {
    public static RAM ram =null;
    public static boolean nRam = true;
    public static ArrayList<Process> processes = new ArrayList<>();
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("Input instruction or q to exit");
            String[] input = console.nextLine().split(",");
            handleInput(input);
            if(input[0].equals("q")){
                break;
            }
        }
    }

    public static RAM initRAM(int RAMsize){
        RAM ram = new RAM(RAMsize);
        nRam = false;
        return ram;
    }

    public static void handleInput(String[] input) {
        if (input[0].equals("R") && nRam) {
            ram = initRAM(Integer.parseInt(input[1]));
        } else if (input[0].equals("R") && !nRam) {
            System.out.println("Error");
        } else if (input[0].equals("P") && (!input[2].equals("done")) && (!input[2].equals("table"))) {
            initProcess(input);
        } else if (input[0].equals("P") && input[2].equals("done")) {
            deleteProcess(input);
        } else if (input[0].equals("P") && input[2].equals("table")) {
            printProcessPageTable(input);
        }
    }

    public static void initProcess(String[] input){
        boolean exist = false;
        String ID = input[1];
        for(int i=0; i<processes.size(); i++){
            if(ID.equals(processes.get(i).getpID())){
                exist=true;

            }
        }
        if(processes.size()==0){
            exist = false;
        }
        if (!exist) {
            Process process = new Process(input[1], Integer.parseInt(input[2]));
            for(int pageNum=0; pageNum<process.getpSize(); pageNum++){
                int frameNum = ram.occupyMemory();
                if(frameNum == ram.getmSize()){
                    System.out.println("Error");
                    break;
                }
                process.getPageTable().fillTable(pageNum, frameNum);
            }
            processes.add(process);
            ram.printRAM();
            System.out.println("Process "+process.getpID()+" has been added to processes.");
        }
        else{
            System.out.println("Error");
        }
    }

    public static void deleteProcess(String[] input){
        String pID = input[1];
        Boolean exist = false;
        for(int i=0; i<processes.size(); i++){
            if(pID.equals(processes.get(i).getpID())){
                exist = true;
                for(int j=0; j<processes.get(i).getpSize(); j++){
                    if (processes.get(i).getPageTable().getTable().get(j)!= null){
                        ram.releaseMemory(processes.get(i).getPageTable().getTable().get(j));
                    }
                }
                processes.remove(i);
                break;
            }
        }
        if(exist == false){
            System.out.println("Error");
        }
    }

    public static void printProcessPageTable(String[] input){
        boolean exist = true;
        String pID = input[1];
        for(int i=0; i<processes.size(); i++){
            if(pID.equals(processes.get(i).getpID())){
                exist = false;
                processes.get(i).getPageTable().printTable();
                break;
            }
            if (i == (processes.size()-1) || exist) {
                System.out.println("Error");
            }
        }
    }






}


