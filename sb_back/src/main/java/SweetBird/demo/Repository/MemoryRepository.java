package SweetBird.demo.Repository;

import SweetBird.demo.post.postMember;

public interface MemoryRepository {
   // List<postMember> Repository = null; // 저장소
    void save(postMember Member); // 저장
 postMember join(int numver); // 찾기
    void all(int numver); // 7개 게시물당 1개의 페이지 규칙으로 7개씩 넘긴다.
    void RepositoryAll(); //메모리 저장소에 있는 모든 데이터를 반환한다. (test용)
    void der(int numver); //삭제
    int Maxindex();

}
