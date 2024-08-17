package SweetBird.demo.controller;

import SweetBird.demo.post.NewPost;
import SweetBird.demo.post.Postdelete;
import SweetBird.demo.post.postMember;
import SweetBird.demo.servics.sevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
public class PostController {

    private final sevice Service ;
    @Autowired
    public PostController(sevice Service){
        this.Service=Service;

    }


    @RequestMapping(value="/posts/{type}/{pageNumber}",method=RequestMethod.GET) // 게시판 리스트 보기
    public ArrayList<postMember> getPostList(@PathVariable String type,@PathVariable int pageNumber)
    {
        return Service.page(type,pageNumber);
    }
    @RequestMapping(value="/posts/listmax/{type}",method =RequestMethod.GET)
    public int listmax(@PathVariable String type){
        return  Service.listmax(type);

    }
    @DeleteMapping("/posts/delete")
    public ResponseEntity<String> deletePost(@Valid @RequestBody Postdelete ps,BindingResult result)
    {

        if (result.hasErrors()) {
            // 유효성 검사 실패 시
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
       return Service.postDelet(ps);


    }

    @RequestMapping(value="/posts/join/{type}/{id}",method =RequestMethod.GET)
    public ResponseEntity<String> pagejoin(@PathVariable String type, @PathVariable int id){

        if (!TypeValidator.isValidType(type)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid type value: " + type);
        }

      String result= Service.page_go(type,id);
        return ResponseEntity.ok(result);

    }
    @PostMapping("posts/create")
    public ResponseEntity<String> postCreate(@Valid @RequestBody NewPost newpost, BindingResult result)
    {
        if (result.hasErrors())
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);

        if(newpost.type.equals("front")||newpost.type.equals("back"))
        {
            Service.postCreate(newpost);
        }
        else
        {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
/*
* const newPost = {
    background: false, // 예시 값, 실제 값으로 대체
    userImg: "https://example.com/image.jpg", // 예시 이미지 URL
    name: "John Doe", // 예시 유저 이름
    date: new Date().toISOString().split('T')[0], // 현재 날짜, 형식 yyyy-MM-dd
    title: "Sample Post Title", // 예시 게시물 제목
    type: "back", // 설정한 타입 값
    PostContent: "This is a sample content for the post.", // 예시 게시물 내용
    Password: "secretpassword" // 예시 비밀번호
};

// fetch API를 사용하여 POST 요청을 보냅니다.
fetch('http://localhost:8080/posts/create', {
    method: 'POST', // HTTP 메서드
    headers: {
        'Content-Type': 'application/json', // 요청 본문이 JSON임을 명시
    },
    body: JSON.stringify(newPost) // 객체를 JSON 문자열로 변환하여 전송
})
.then(response => {
    if (!response.ok) {
        return response.text().then(text => {
            throw new Error(`HTTP error! status: ${response.status}, body: ${text}`);
        });
    }
    return response.json(); // 응답을 JSON으로 변환
})
.then(data => {
    console.log('Success:', data); // 성공적으로 전송된 데이터 처리
})
.catch((error) => {
    console.error('Error:', error); // 오류 처리
});
*
*
* */
    }


/*
    @RequestMapping("/posts") // 게시물 내용 보기,localhost:8080/posts?name=지는건가요? 이렇게 보내기
    public postMember getPost(@RequestParam String name) {

        return Service.PostJoin(name);
    }

    @RequestMapping("/new")
    public postMember newPost(@RequestParam String postName, @RequestParam String postContent, @RequestParam String password) {
        return Service.PostCreate(postName,postContent,password);

    }
    //Fixing?postName=지는건가요?&FixName=김치국..&Password=3125!!&FixContent=진다.....
                               //Fixing?postName=궁극적인 김치국 비결&FixName=김치는....&Password=134!@#$&FixContent=프사
    @RequestMapping("/Fixing")

    public void Fixing(@RequestParam String postName,@RequestParam String FixName , @RequestParam String Password , @RequestParam String FixContent)
    {
        postMember pm=Service.PostJoin(postName);

        //System.out.println(postName+ "___"+FixName+"___"+Password+"___"+FixContent);

        if( (pm.getPw()).equals(Password))
        {
            pm.PostName=FixName;
            pm.PostContent=FixContent;
            Service.Repositoryfix(FixName,postName,pm);
            System.out.println("ok");
        }

    }*/


}
