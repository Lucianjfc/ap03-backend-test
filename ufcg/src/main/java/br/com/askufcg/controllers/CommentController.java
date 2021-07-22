package br.com.askufcg.controllers;

import br.com.askufcg.dtos.comment.PostCommentDTO;
import br.com.askufcg.models.Comment;
import br.com.askufcg.services.comment.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @PostMapping("/answers/{answerId}/users/{userId}")
    public ResponseEntity<Comment> addCommentAnswer(@RequestBody PostCommentDTO comment, @PathVariable Long userId, @PathVariable Long answerId){
        Comment commentResult = this.commentServiceImpl.addCommentAnswer(comment, userId, answerId);
        return new ResponseEntity<>(commentResult, HttpStatus.CREATED);
    }

    @PostMapping("/questions/{questionId}/users/{userId}")
    public  ResponseEntity<Comment> addCommentQuestion(@RequestBody PostCommentDTO comment, @PathVariable Long userId, @PathVariable     Long questionId){
        Comment commentResult = this.commentServiceImpl.addCommentQuestion(comment, userId, questionId);;
        return new ResponseEntity<>(commentResult, HttpStatus.CREATED);
    }
    @GetMapping("{commentId}/answers/{answerId}")
    public ResponseEntity<Comment> getCommentAnswer(@PathVariable Long commentId, @PathVariable Long answerId){
        Comment commentResult = this.commentServiceImpl.getCommentAnswer(commentId, answerId);
        return new ResponseEntity<>(commentResult, HttpStatus.OK);
    }

    @GetMapping("/answers/{answerId}")
    public ResponseEntity<List<Comment>> getAllCommentsAnswer(@PathVariable Long answerId){
        List<Comment> comments = this.commentServiceImpl.getAllCommentsAnswer(answerId);
        return new ResponseEntity<>(comments,HttpStatus.OK);

    }

    @GetMapping("{commentId}/questions/{questionId}")
    public ResponseEntity<Comment> getCommentQuestion(@PathVariable Long commentId, @PathVariable   Long questionId){
        Comment commentResult = this.commentServiceImpl.getCommentQuestion(commentId, questionId);
        return new ResponseEntity<>(commentResult, HttpStatus.OK);
    }

    @GetMapping("/questions/{questionId}")
    public ResponseEntity<List<Comment>> getAllCommentsQuestion(@PathVariable    Long questionId){
        List<Comment> comments = this.commentServiceImpl.getAllCommentsQuestion(questionId);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @DeleteMapping("{commentId}/answers/{answerId}")
    public ResponseEntity<Comment> deleteCommentAnswer(@PathVariable Long commentId, @PathVariable Long answerId){
        Comment commentResult = this.commentServiceImpl.deleteCommentAnswer(commentId, answerId);
        return new ResponseEntity<>(commentResult, HttpStatus.OK);
    }

    @DeleteMapping("{commentId}/questions/{questionId}")
    public ResponseEntity<Comment> deleteCommentQuestion(@PathVariable Long commentId, @PathVariable    Long questionId){
        Comment commentResult = this.commentServiceImpl.deleteCommentQuestion(commentId, questionId);
        return new ResponseEntity<>(commentResult, HttpStatus.OK);
    }

    @PutMapping("{commentId}/questions/{questionId}")
    public ResponseEntity<Comment> updateCommentQuestion(@RequestBody PostCommentDTO comment, @PathVariable Long commentId, @PathVariable   Long questionId){
        Comment commentResult = this.commentServiceImpl.updateCommentQuestion(comment, commentId, questionId);
        return new ResponseEntity<>(commentResult, HttpStatus.OK);
    }

    @PutMapping("{commentId}/answers/{answerId}")
    public ResponseEntity<Comment> updateCommentAnswer(@RequestBody PostCommentDTO commentDTO, @PathVariable Long commentId, @PathVariable Long answerId){
        Comment commentResult = this.commentServiceImpl.updateCommentAnswer(commentDTO, commentId, answerId);
        return new ResponseEntity<>(commentResult, HttpStatus.OK);
    }
}
