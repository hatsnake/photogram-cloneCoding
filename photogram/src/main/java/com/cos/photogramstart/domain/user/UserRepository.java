package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

//어노테이션이 없어도 JPARepository를 상속하면 IOC등록이 자동으로 된다.
public interface UserRepository extends JpaRepository<User, Integer> {
	//JPA QUERY METHOD
	User findByUsername(String username);
}
