package SweetBird.demo.post;

public class YourRequestData {
    private String postName;
    private String FixName;
    private String Password;
    private String FixContent;

    public String getPostName() {
        return postName;
    }

    public String getFixName() {
        return FixName;
    }

    public String getPassword() {
        return Password;
    }

    public String getFixContent() {
        return FixContent;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setFixName(String fixName) {
        FixName = fixName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setFixContent(String fixContent) {
        FixContent = fixContent;
    }
}
