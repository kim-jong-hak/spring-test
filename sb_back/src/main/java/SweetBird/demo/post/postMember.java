package SweetBird.demo.post;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class postMember {

    public int id; // 게시물 번호

    public boolean background; // 몰라

    public  String userImg= "http://via.placeholder.com/50"; // 게시물 썸내일

    public String name; // 유저이름

    public String date; //날짜

    public String title; // 게시물 이름

    public  String type; // 백,프

    public String PostContent; // 게시판 내용물

    private String Password; // 게시판 비번





    public postMember(int id ,boolean background, String name,String date,String title, String type,String PostContent,String Password) {
        this.id=id;
        this.background = background;
        this.name=name;
       this.date=date;
        this.title=title;
        this.type=type;
        this.PostContent=PostContent;
        this.Password=Password;

    }
    @JsonIgnore
    public String getPw() {
        return Password;
    }

}
