package com.example.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository <Admin,String>{	
	Admin findByEmail(String email);

}
