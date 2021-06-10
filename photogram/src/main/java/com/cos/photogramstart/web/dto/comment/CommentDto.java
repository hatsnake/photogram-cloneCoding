package com.cos.photogramstart.web.dto.comment;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

//NotNull = Null값 체크
//NotEmpty = 빈값이거나 null 체크
//NotBlank = 빈값이거나 null 체크 그리고 빈 공백까지

@Data
public class CommentDto {
	@NotBlank 
	private String content;
	@NotNull
	private Integer imageId;
	
	//toEntity는 필요 없음
}
