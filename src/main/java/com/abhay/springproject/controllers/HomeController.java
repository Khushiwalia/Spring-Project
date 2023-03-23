package com.abhay.springproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhay.springproject.Entity.Meeting;
import com.abhay.springproject.Entity.Member;
import com.abhay.springproject.Entity.User;
import com.abhay.springproject.dto.ListReq;
import com.abhay.springproject.repository.MeetingRepository;
import com.abhay.springproject.repository.MemberRepository;
import com.abhay.springproject.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	MeetingRepository meetingRepository;
	
	@Autowired
	MemberRepository memberRepository;

//	@Autowired
//	BCryptPasswordEncoder encoder;
//	@RequestMapping("/hello")
//	public String add() {
//		
//		return "registration";
//	}
//	

	@PostMapping("/adduser")
	@ResponseBody
	public String addUser(@RequestBody User user) {

//		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println("Inside addUser");
		user.setStatus(1);
		userRepository.save(user);

		return "User Registered";
	}
	@GetMapping("/listuser")
	@ResponseBody
	public List<User> ListUsers(@RequestBody ListReq listReq) {
		
		if(listReq.getEmail()!=null && listReq.getPhone()!=0) {
			
			return userRepository.findByEmail(listReq.getEmail());
		}
		else if(listReq.getEmail()!=null && listReq.getPhone()==0){
			return userRepository.findByEmail(listReq.getEmail());
		}
		
		else if(listReq.getEmail()==null && listReq.getPhone()!=0){
			return userRepository.findByPhone(listReq.getPhone());
			
		}
		
		return userRepository.findAll();
	}
	
	@GetMapping("/deactivateuser")
	@ResponseBody
	public String deactivateUser(@RequestBody int id) {
		User user =	userRepository.findById(id).orElse(null);
		user.setStatus(0);
		return "User Deactivated ";
	}
	
	@PostMapping("/createMeeting")
	@ResponseBody
	public Meeting createmeeting(@RequestBody Meeting request) {
		List<Member> mem=request.getMembers();
		for(Member val:mem) {
			val.setMeeting(request);
			
		}
		request.setMembers(mem);
	   return  meetingRepository.save(request);
	}
	
//	@GetMapping("/listOfMembers/{id}")
//	public List<Member> listOfMembers(@PathVariable int id){
//		return meetingRepository.findMembersById(id);
//	}
	
}

