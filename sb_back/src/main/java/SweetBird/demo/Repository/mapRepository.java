package SweetBird.demo.Repository;

import SweetBird.demo.post.NewPost;
import SweetBird.demo.post.postMember;

import java.util.*;

public class mapRepository {

    //private static final LinkedList<postMember> Repository=new LinkedList<>();// 게시물 리스트로 보기
    private static final Map<String,LinkedList<postMember>> Repository=new HashMap<>();


    public mapRepository ()
    {   // 더미 데이터

       this.Repository.put("all",new LinkedList<postMember>());
        this.Repository.put("front",new LinkedList<postMember>());
        this.Repository.put("back",new LinkedList<postMember>());



        postMember member1 =new postMember(0,true,"김철수","2024-1-16","웹해킹","front","게시물의 어떤내용들","134!@#$");
        postMember member2 =new postMember(1,true,"김철수","2024-1-16","프론트엔드맨","front","게시물의 어떤내용들","134!@#$");
        postMember member3 =new postMember(2,true,"김철수","2024-1-16","디자인 -해줘-","front","게시물의 어떤내용들","134!@#$");
        postMember member4 =new postMember(3,true,"김철수","2024-1-16","킹공지능","front","게시물의 어떤내용들","134!@#$");
        postMember member5 =new postMember(4,true,"김철수","2024-1-16","은밀하고 위대한 js","front","게시물의 어떤내용들","134!@#$");
        postMember member6 =new postMember(0,true,"김철수","2024-1-16","은밀하고 위대한 java","back","게시물의 어떤내용들","134!@#$");




        this.Repository.get("all").addFirst(member1);
        this.Repository.get("all").addFirst(member2);
        this.Repository.get("all").addFirst(member3);
        this.Repository.get("all").addFirst(member4);
        this.Repository.get("all").addFirst(member5);
        this.Repository.get("all").addFirst(member6);

        this.Repository.get("front").addFirst(member1);
        this.Repository.get("front").addFirst(member2);
        this.Repository.get("front").addFirst(member3);
        this.Repository.get("front").addFirst(member4);
        this.Repository.get("front").addFirst(member5);
        this.Repository.get("back").addFirst(member6);



    }
    public postMember IndexJoin(String type,int index)
    {
        return Repository.get(type).get(index);
    }

    public int listmax(String type)
    {
        return Repository.get(type).size();
    }

    public postMember Post_IndexJoin(String type,int index)
    {
        int indexmax =listmax(type)-1;
        return Repository.get(type).get(indexmax-index);
    }
    public postMember Post_postMemberJoin(String type,postMember pm)
    {
        int index=Repository.get(type).indexOf(pm);
        return Repository.get(type).get(index);
    }
    public void delete(String type,postMember pm)
    {
        Repository.get(type).remove(pm);
    }
    public void postCreate(NewPost np)
    {
        postMember pm=new postMember(Repository.get(np.type).size(),np.background,np.name,np.date,np.title,np.type,np.PostContent,np.Password);
        Repository.get(np.type).addFirst(pm);
        Repository.get("all").addFirst(pm);





    }

  /*  public void Fixing(String fixName, String name , postMember post)
    {
        int index = Repository.indexOf(name);
        ArrayRepository.set(index,fixName);
        hashRepository.remove(name);
        hashRepository.put(fixName,post);

    }

    public String ListJoin(int num) {
        if(num<=ArrayRepository.size()-1)
        return  ArrayRepository.get(num);
        else return null;
    }

    public postMember InsidePost(String name)
    {
        return hashRepository.get(name);
    }

//    ========================================
    /*public postMember NewPost(String postName, String postContent, String password){
      /*  postMember post = new postMember(postName,postContent,password);
        ArrayRepository.add(postName);
        hashRepository.put(postName,post);

        return post;
    }*/

}
