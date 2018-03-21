package project.scanner;

public class ReturnedTuple {

    private int next_position;
    private String id_code;

    public ReturnedTuple(int next_position, String id_code) {
        this.next_position = next_position;
        this.id_code = id_code;
    }

    public int getNext_position() {
        return next_position;
    }

    public void setNext_position(int next_position) {
        this.next_position = next_position;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }


}
