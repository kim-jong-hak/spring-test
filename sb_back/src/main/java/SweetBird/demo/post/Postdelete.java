package SweetBird.demo.post;

public class Postdelete {
    public String password;
    public int id;
    public String type;
    public String PasswordGet()
    {
        return this.password;
    }
    public int IdGet()
    {
        return this.id;
    }
    public String typeGet()
    {
        return this.type;
    }
/*
// 데이터 객체를 생성합니다.
const postData = {
    password: "secretpassword",
    id: 123, // id 값을 적절히 설정하세요
    type: "back"
};

// 서버 주소
const url = "http://localhost:8080/posts/delete";

// fetch API를 사용하여 POST 요청을 보냅니다.
fetch(url, {
    method: "DELETE", // 요청 메서드는 DELETE입니다.
    headers: {
        "Content-Type": "application/json" // 요청 본문이 JSON임을 명시합니다.
    },
    body: JSON.stringify(postData) // 데이터 객체를 JSON 문자열로 변환합니다.
})
.then(response => response.json()) // 응답을 JSON으로 변환합니다.
.then(data => {
    console.log("Success:", data); // 성공 시 서버 응답을 로그에 출력합니다.
})
.catch(error => {
    console.error("Error:", error); // 에러 발생 시 에러를 로그에 출력합니다.
});
*/
}
