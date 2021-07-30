package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.istack.Nullable;

	
	
@Controller
public class HomeController {
	@Autowired
	@Nullable PersonRepository perRepo;
	@Nullable AdminRepository  adminRepo;
	@Nullable JobRepository jobRepo;
	public HomeController(AdminRepository adminRepo, JobRepository jobRepo) {
		
		this.adminRepo = adminRepo;
		this.jobRepo = jobRepo;
	}	
	@GetMapping("/")
	public String homepage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/processregister")
	public String registerSubmit(Person person) {
		perRepo.save(person);
		return "login";		
	}
	
	@PostMapping("/loginsubmit")
	public String loginSubmit(@RequestParam String email, @RequestParam String password)
	{
		Person tempperson;
		tempperson = perRepo.findByEmail(email);
		if(tempperson!=null && tempperson.getPassword().equals(password)) {
			return "successful";
		}
		else {
			return "failure";
		}
	}
		
	@GetMapping("/Adminlogin")
	public String adminloginPage() {
		return "Adminlogin";
	}
	
	@GetMapping("/Adminregister")
	public String adminregisterPage() {
		return "Adminregister";
	}
		
	@PostMapping("/Adminprocessregister")
	public String adminregisterSubmit(Admin admin) {
		 adminRepo.save(admin);
		return "Adminlogin";		
	}
		
	@PostMapping("/Adminloginsubmit")
	public String adminloginSubmit(@RequestParam String email, @RequestParam String password)
	{
		Admin tempadmin;
		tempadmin =  adminRepo.findByEmail(email);
		if(tempadmin!=null && tempadmin.getPassword().equals(password)) {
			return "adminpage1";
		}
		else {
			return "failure";
		}
			
	}
	@GetMapping("/uploadjob")
	public String uploadpage(){
		return "adminpage";		
	}
	
	@PostMapping("/uploading")
	public String uploadingpage(jobs job) {
				jobRepo.save(job);
				return("adminpage1");
	}

}
