package project.scanner;

public class TokenOutput {

    String id_code;
    private String description;

    public TokenOutput(String id_code, String description) {
        this.id_code = id_code;
        this.description = description;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
