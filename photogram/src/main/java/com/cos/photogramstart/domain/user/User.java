package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.cos.photogramstart.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DB에 INSERT하기 위한 클래스
//JPA - Java Persistence API
@Builder //빌더 사용
@AllArgsConstructor //매개변수 생성자 생성
@NoArgsConstructor //빈 생성자 생성
@Data //Getter,Setter 생성
@Entity //디비에 테이블을 생성
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호증가전략이 DB를 따라감.
	private int id;
	@Column(length=100, unique=true, nullable=false) //OAuth2 로그인을 위해 컬럼 늘리기
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
	
	//나는 연관관계의 주인이 아니다. 그러므로 테이블에 컬럼을 만들지마.
	//User를 Select할 때 해당 User id로 등록된 image들을 다 가져와.
	//, fetch = FetchType.Lazy
	//Lazy = User를 Select할 때 해당 User id로 등록된 image들을 가져오지마. - 대신 getImages()함수의 image들이 호출될 때 가져와 (기본값)
	//Eager = User를 Select할 때 해당 User id로 등록된 image들을 전부 Join해서 가져와
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"user"}) //무한참조 방지를 위해 Image안에 user의 getter를 무시
	private List<Image> images; //양방향 매핑
	
	private LocalDateTime createDate;
	
	@PrePersist //DB에 INSERT되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", website="
				+ website + ", bio=" + bio + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", profileImageUrl=" + profileImageUrl + ", role=" + role + ", createDate="
				+ createDate + "]";
	}
	
}
