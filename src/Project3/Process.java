
public class Process {

    private PageTable pageTable;
    private String pID;
    private int pSize;

    public Process(String pID, int pSize){
        this.pID = pID;
        this.pageTable = new PageTable(pSize);
        this.pSize = pSize;
    }

    public String getpID(){
        return pID;
    }

    public PageTable getPageTable() {
        return pageTable;
    }

    public int getpSize(){
        return pSize;
    }
}
