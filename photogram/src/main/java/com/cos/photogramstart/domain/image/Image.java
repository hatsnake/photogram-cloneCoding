package com.cos.photogramstart.domain.image;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.cos.photogramstart.domain.comment.Comment;
import com.cos.photogramstart.domain.image.likes.Likes;
import com.cos.photogramstart.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String caption; //이미지 설명
	private String postImageUrl; //사진 경로 URL
	
	@JsonIgnoreProperties({"images"})
	@JoinColumn(name = "userId")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	//이미지 좋아요 (getter메소드를 호출할 때 가져옴)
	@JsonIgnoreProperties({"image"})
	@OneToMany(mappedBy = "image")
	private List<Likes> likes;
	
	//댓글 (양방향 매핑)
	@OrderBy("id DESC")
	@JsonIgnoreProperties({"image"})
	@OneToMany(mappedBy = "image") //FK키 변수이름, Lazy전략
	private List<Comment> comments;
	
	@Transient //DB에 컬럼이 만들어지지 않는다.
	private boolean likeState;
	
	@Transient
	private int likeCount;
	
	private LocalDateTime createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

//	@Override
//	public String toString() {
//		return "Image [id=" + id + ", caption=" + caption + ", postImageUrl=" + postImageUrl
//				+ ", createDate=" + createDate + "]";
//	}
	
	
}
