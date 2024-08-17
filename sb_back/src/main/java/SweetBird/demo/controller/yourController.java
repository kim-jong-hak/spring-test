package SweetBird.demo.controller;

import SweetBird.demo.post.YourRequestData;
import SweetBird.demo.post.postMember;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class yourController {
   // @PostMapping("/Fixing")
   @PostMapping(value = "/Fixing", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void Fixing(@RequestBody YourRequestData requestData) {
        // requestData에는 요청의 본문에서 넘어온 데이터가 자동으로 매핑됩니다.
        // requestData를 사용하여 작업 수행
        System.out.println(requestData.getPostName() + "___" + requestData.getFixName() + "___" + requestData.getPassword() + "___" + requestData.getFixContent());

        // 나머지 코드
    }
    @RequestMapping("/p") // 게시물 내용 보기,localhost:8080/posts?name=지는건가요? 이렇게 보내기
    public void getPost(@RequestParam String name) {

        System.out.println(name);
    }
}
