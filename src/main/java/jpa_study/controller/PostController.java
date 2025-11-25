package jpa_study.controller;

import jpa_study.dto.AddPostReqDto;
import jpa_study.dto.EditPostReqDto;
import jpa_study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
* JPA (JAVA Persistence API)
* 객체 지향 언의 객체와 관계형 데이터베이스의 테이블간의 매핑을 자동으로 처리
* -> SQL을 직접 쓰지 않고 자바 객체 중심으로 DB를 다룸
* 장점: SQL없이 빠르게 CRUD가능, 코드량 줄어든다
* 단점: 복잡한 쿼리는 어렵고, 디버깅이 힘들다.
* */

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    ResponseEntity<?>addPost(@RequestBody AddPostReqDto addPostReqDto){
        return  ResponseEntity.ok(postService.addPost(addPostReqDto));
    }
    @GetMapping("/all")
    ResponseEntity<?>getPostAll(){
        return ResponseEntity.ok(postService.getPostAll());
    }
    @GetMapping("/{postId}")
    public ResponseEntity<?>getPostByPostId(@RequestBody Integer postId){
        return ResponseEntity.ok(postService.getPostByPostId(postId));
    }
    @GetMapping("/get/user")
    public ResponseEntity<?>getPostListByUserId(@RequestParam Integer userId){
        return ResponseEntity.ok(postService.getPostListByUserId(userId));
    }

    @PostMapping("/edit")
    public ResponseEntity<?>editPost(@RequestBody EditPostReqDto editPostReqDto){
        return ResponseEntity.ok(postService.editPost(editPostReqDto));
    }
    @PostMapping("/remove")
    public ResponseEntity<?> removePost(@RequestBody Integer postId){
        return ResponseEntity.ok(postService.removePost(postId));
    }
}
