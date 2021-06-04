package com.astrologer.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astrologer.dao.AstrologerRepository;
import com.astrologer.dao.CustomerRepository;
import com.astrologer.dao.UserRepository;
import com.astrologer.entities.Astrologer;
import com.astrologer.entities.Customer;
import com.astrologer.entities.User;
import com.astrologer.helper.Message;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private AstrologerRepository astrologerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/demo")
	public String dashboard() {
		
		return "normal/user_Dashboard";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Customer findOne(Integer id) {
			
		System.out.println("Hello");
			System.out.println(id);
		
		return customerRepository.getOne(id);
	}
	
	
	
	
	@GetMapping("/index")
	public String index(Model model, Principal principal) {
		
		String userName = principal.getName();
		
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
		
		return "normal/index";
	}
	
	@GetMapping("")
	public String admin() {
		
		return "normal/index";
	}
	
	

	
	@GetMapping("/email")
	public String email(Model model) {
		
		model.addAttribute("title", "Email Page");
		
		return "normal/email";
	}
	
	@GetMapping("/chats")
	public String chats(Model model) {
		
		model.addAttribute("title", "Chats Page");
		
		return "normal/chat";
	}
	
	@GetMapping("/voice-call")
	public String voiceCall(Model model) {
		
		model.addAttribute("title", "voice-call Page");
		
		return "normal/voice-call";
	}
	
	
	@GetMapping("/live-stream")
	public String liveStream(Model model) {
		
		model.addAttribute("title", "live-stream Page");
		
		return "normal/live-stream";
	}
	
	
	
	@GetMapping("/astrologer-approval")
	public String astrologerApproval(Model model) {
		
		model.addAttribute("title", "Astrologer-Approval Page");
		
		return "normal/astrologer-approval";
	}
	
	
	@GetMapping("/astrologer-post")
	public String astrologerPost(Model model) {
		
		model.addAttribute("title", "Astrologer-Post Page");
		
		return "normal/astrologer-post";
	}
	

	@GetMapping("/astrologer-details")
	public String astrolgerDetails(Model m, Principal principal) {
		
		m.addAttribute("title", "Astrologer-Details");
		
		String userName = principal.getName();
		System.out.println(userName);
		User user = this.userRepository.getUserByUserName(userName);
		//System.out.println(user.getId());
		List<Astrologer> astrologerDetails = this.astrologerRepository.findByAstrologerByUser(user.getId());
		
		System.out.println(astrologerDetails);
		
		m.addAttribute("astrologers", astrologerDetails);
		
		return "normal/astrologer-details";
	}
		
	@GetMapping("/customer-details")
	public String customerDetails(Model model,Principal principal) {
		
		model.addAttribute("title", "Customer-Details Page");
		
	List<Customer> customerDetails = this.customerRepository.findAll();
	//System.out.println(customerDetails);
	
	model.addAttribute("customers", customerDetails);
		
		return "normal/customer-details";
	}
	
	@GetMapping("/user-payment")
	public String userPayment(Model model) {
		
		model.addAttribute("title", "User-Payment Page");
		
		return "normal/user-payment";
	}
	
	@GetMapping("/paytoastrologer")
	public String paytoastrologerPage(Model model) {
		
		model.addAttribute("title", "Paytoastrologer Page");
		
		return "normal/paytoastrologer";
	}
	
	@GetMapping("/totalsale")
	public String totalPage(Model model) {
		
		model.addAttribute("title", "total Page");
		
		return "normal/totalsale";
	}
	@GetMapping("/astrologer-payment")
	public String astrologerPayment(Model model) {
		
		model.addAttribute("title", "Astrologer-Payment Page");
		
		return "normal/astrologer-payment";
	}
	
	@GetMapping("/invoices")
	public String invoices(Model model) {
		
		model.addAttribute("title", "invoices Page");
		
		return "normal/invoices";
	}
	
	
	@GetMapping("/delete/{cid}")
	public String deleteContact(@PathVariable("cid") Integer cId, Model model, Principal principal, HttpSession session) {
		
		Optional<Astrologer> astrologerOptional = this.astrologerRepository.findById(cId);
		
			Astrologer astrologer = astrologerOptional.get();
			
			String userName = principal.getName();
			
			User user = this.userRepository.getUserByUserName(userName);
			
			if(user.getId()== astrologer.getUser().getId()) {
			
				
				astrologer.setUser(null);	
				this.astrologerRepository.delete(astrologer);
				session.setAttribute("message", new Message("Customer delete Successfully", "success"));
				
			}
			
			session.setAttribute("message", new Message("Astrologer delete Successfully", "success"));
							
		return "redirect:/admin/astrologer-details";
	} 
	
	@GetMapping("/deleteCustomer/{cid}")
	public String deleteCustomer(@PathVariable("cid") Integer cId, Model model, Principal principal, HttpSession session) {
		
		Optional<Customer> customerOptional = this.customerRepository.findById(cId);
				Customer customer = customerOptional.get();
		String userName = principal.getName();
		
		
		
		User user = this.userRepository.getUserByUserName(userName);

	
		
		if(user.getId()==customer.getUser().getId()) {
			customer.setUser(null);
			this.customerRepository.delete(customer);
		}
		
		
	
		return "redirect:/admin/customer-details";
	}
	
	
	@GetMapping("/findById1/{id}")
	@ResponseBody
	public Customer findById(@PathVariable("id") Integer id) {
		
		Customer customer = this.customerRepository.findById(id).get();
		
		System.out.println(customer.getContact());
	return customer;
		
		
	}
	
	//get by id
		
	/*
	 * @GetMapping("/findById")
	 * 
	 * @ResponseBody public Customer findById1(int id) { Customer customer =
	 * this.customerRepository.findById(id).get();
	 * 
	 * return customer; }
	 */
	
	
	@GetMapping("/findById")
	@ResponseBody
	public Optional<Customer> findById1(int id) {
		 	 		
		
		return this.customerRepository.findById(id);	
	
	}
	
	
	@GetMapping("/demo2")
	public String demo2 () {
		
		System.out.println("Narender");
		
		return "";
	}
	
	
	
}
