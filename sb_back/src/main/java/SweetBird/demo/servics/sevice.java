package SweetBird.demo.servics;

import SweetBird.demo.Repository.mapRepository;
import SweetBird.demo.post.NewPost;
import SweetBird.demo.post.Postdelete;
import SweetBird.demo.post.postMember;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class sevice {
     static int pageCount = 5;// 페이지당 게시판 개수 ( 묶음 )
     static ArrayList<postMember> pageArrayList;
     private static  mapRepository Repositorys;

   public sevice (mapRepository Repository){
       this.Repositorys=Repository;
   }

    public int listmax(String type){
       return Repositorys.listmax(type)-1;
    } // 게시판 키워드에 맞는 저장공간에 최대 인덱스값

    public void postCreate(NewPost np) // 글 등록 기능
    {
       Repositorys.postCreate(np);
    }

    public ResponseEntity<String> postDelet(Postdelete pd){

       postMember pm=Repositorys.Post_IndexJoin(pd.typeGet(), pd.IdGet());

       if(pm.getPw().equals(pd.PasswordGet()))
       {
           Repositorys.delete(pd.typeGet(),pm);
           Repositorys.delete("all",pm);


       }else{
           return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
       }

       return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
    public ArrayList<postMember> page(String type,int pageNumber) // 게시판 키워드에 맞는 페이지 가져오기
    {
        pageArrayList =new ArrayList<>();

        int start=pageCount*(pageNumber-1);
        int end=start+pageCount;

       for(;start<end;start++) {
            if(listmax(type)<start)
                break;
           pageArrayList.add(Repositorys.IndexJoin(type,start));

       }
        return pageArrayList;
    }

   public String page_go(String type, int id)
   {
      return (Repositorys.Post_IndexJoin(type,id)).PostContent;
   }

   /* public ArrayList<String> Page(int pageNumber)
    {
       /* int max=Repositorys.listmax();
        if(end>max)
            end=max; //  프론트에서 원하는 게시물을 줄때 array_out 방지 코드
        
        ArrayList<String> Postlist=new ArrayList<>();

        for(int run=start;run<=end;run++) // 게시판목록 json으로 전송 (프론트에서 8개 묶어서 한 페이지에 보여주는게 좋을듯 싶다. )
                Postlist.add( Repositorys.ListJoin(run));

        return Postlist;
    }*/

 /*   public postMember PostJoin(String name) {
     return  Repositorys.InsidePost(name);
    }*/


//    ====================================
    /*public postMember PostCreate(String postName, String postContent, String password) {
       return Repositorys.NewPost(postName, postContent, password);
    }*/


    /*public void Repositoryfix(String Fixname, String name, postMember post)
    {
        Repositorys.Fixing(Fixname,name,post);
    }*/

}
