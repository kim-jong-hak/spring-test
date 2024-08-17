package SweetBird.demo;

import SweetBird.demo.Repository.MemoryRepository;
import SweetBird.demo.Repository.MemoryRepositoryC;
import SweetBird.demo.Repository.mapRepository;
import SweetBird.demo.post.postMember;

import java.util.*;

public class test {
    public static void main(String[] args) {

         Map<String,LinkedList<postMember>> Repository=new HashMap<>();
       Repository.put("all",new LinkedList<postMember>());
        Repository.put("front",new LinkedList<postMember>());
        Repository.put("back",new LinkedList<postMember>());



        postMember member1 =new postMember(0,true,"오","2024-1-16","웹해킹","front","게시물의 어떤내용들","134!@#$");
        postMember member2 =new postMember(1,true,"김","2024-1-16","프론트엔드맨","front","게시물의 어떤내용들","134!@#$");
        postMember member3 =new postMember(2,true,"파","2024-1-16","디자인 -해줘-","front","게시물의 어떤내용들","134!@#$");
        postMember member4 =new postMember(3,true,"수","2024-1-16","킹공지능","front","게시물의 어떤내용들","134!@#$");
        postMember member5 =new postMember(4,true,"철","2024-1-16","은밀하고 위대한 js","front","게시물의 어떤내용들","134!@#$");





      Repository.get("all").addFirst(member1);
       Repository.get("all").addFirst(member2);
       Repository.get("all").addFirst(member3);
    Repository.get("all").addFirst(member4);
      Repository.get("all").addFirst(member5);


        Repository.get("front").addFirst(member1);
        Repository.get("front").addFirst(member2);
        Repository.get("front").addFirst(member3);
        Repository.get("front").addFirst(member4);
        Repository.get("front").addFirst(member5);

        for(int i=0;i<Repository.get("front").size();i++)
        System.out.println( Repository.get("front").get(i).name);

        System.out.println( "==");
        {
            int indexmax = Repository.get("front").size() - 1;
            postMember pm = Repository.get("front").get(indexmax - 4);

           int testindex= Repository.get("front").indexOf(pm);
            Repository.get("front").remove(testindex);
        }
   // Repository.get("front").remove( );

        System.out.println( "==");
        for(int i=0;i<Repository.get("front").size();i++)
            System.out.println( Repository.get("front").get(i).name);


    }
}
