package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DB에 INSERT하기 위한 클래스
//JPA - Java Persistence API
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //디비에 테이블을 생성
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호증가전략이 DB를 따라감.
	private int id;
	@Column(length=20, unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String name;
	private String website; //웹 사이트
	private String bio; //자기소개
	@Column(nullable=false)
	private String email;
	private String phone;
	private String gender; 
	
	private String profileImageUrl; //사진
	private String role; //권한
	
	private LocalDateTime createDate;
	
	@PrePersist //DB에 INSERT되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
