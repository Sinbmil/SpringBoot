package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {

	private UserProfileMapper mapper;
	
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/user/{id}") // 사용자 id를 기준으로 사용자 정보를 조회하는 api
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return mapper.getUserProfile(id);
	}
	
	@GetMapping("/user/all") // 전체 사용자 목록을 조회하는 api
	public List<UserProfile> getUserProfileList(){
		return mapper.getUserProfileList();
	}
	
	@PutMapping("/user/{id}") // 사용자 id를 기반으로 정보를 생성하는 api
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.insertUserProfile(id, name, phone, address);
	}
	
	@PostMapping("/user/{id}") // 사용자 id를 기준으로 정보를 수정하는 api
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.updateUserProfile(id, name, phone, address);
	}
	
	@DeleteMapping("/user/{id}") // 사용자 id를 기준으로 정보를 삭제하는 api
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteUserProfile(id);
	}
}
