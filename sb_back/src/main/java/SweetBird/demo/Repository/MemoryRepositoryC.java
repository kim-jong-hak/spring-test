package SweetBird.demo.Repository;

import SweetBird.demo.post.postMember;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepositoryC implements MemoryRepository{

   private static  List<postMember> Repository=new ArrayList<>();

    @Override
    public void save(postMember Member)  {

        Repository.add(Member);
    }

    @Override
    public postMember join(int numver) {
      return  Repository.get(numver);
    }

    @Override
    public void all(int numver) {

    }

    @Override // test용
    public void RepositoryAll() {


        }

    @Override
    public void der(int numver) {

    }
    @Override
    public int Maxindex()
    {

        return Repository.size();
    }
}
