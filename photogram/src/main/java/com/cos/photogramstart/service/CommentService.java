package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.comment.Comment;
import com.cos.photogramstart.domain.comment.CommentRepository;
import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	
	@Transactional
	public Comment commentSave(String content, int imageId, int userId) {
		
		Comment comment = new Comment();
		
		//Tip (객체를 만들 때 id값만 담아서 insert할 수 있다)
		//대신 return시에 image객체와 user객체는 id값만 가지고 있는 빈 객체를 리턴받는다.
		Image image = new Image();
		image.setId(imageId);
		
		//User user = new User();
		//user.setId(userId);
		User userEntity = userRepository.findById(userId).orElseThrow(()->{
			throw new CustomApiException("유저 아이디를 찾을 수 없습니다.");
		});
		
		comment.setContent(content);
		comment.setImage(image);
		comment.setUser(userEntity);
		return commentRepository.save(comment);
	}
	
	@Transactional
	public void commentDelete(int id) {
		try {
			commentRepository.deleteById(id);
		} catch(Exception e) {
			throw new CustomApiException(e.getMessage());
		}
	}
}
