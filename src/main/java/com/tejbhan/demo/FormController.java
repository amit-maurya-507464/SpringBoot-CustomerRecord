package com.tejbhan.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	CustomerRepo repo;
	
	@GetMapping("/")
	public String form() {
		return "form";
	}
	
	@RequestMapping("save")
	public String add(Customer customer) {
		repo.save(customer);
		return "form";
	}
	
	@RequestMapping("findbyid")
	public String findbyid() {
		return "findbyid";
	}
	
	@RequestMapping("find")
	public ModelAndView find(@RequestParam("cid")String cid) {
		ModelAndView mv = new ModelAndView();
		Customer customer = repo.findById(cid).orElse(new Customer());
		mv.addObject(customer);
		mv.setViewName("find");
		return mv;
	}
	
	@RequestMapping("customers")
	@ResponseBody
	public List<Customer> findall() {
		return repo.findAll();
	}
	
	@RequestMapping("customers/{cid}")
	@ResponseBody
	public String findfromid(@PathVariable("cid") String cid) {
		return repo.findById(cid).toString();
	}
	
	@PostMapping("customers")
	@ResponseBody
	public Customer post(@RequestBody Customer customer) {
		repo.save(customer);
		return(customer);
	}
	
	@DeleteMapping("customers/{cid}")
	@ResponseBody
	public Customer delete(@PathVariable("cid") String cid) {
		Customer c = repo.getOne(cid);
		repo.delete(c);
		return c;
	}
	
	@PutMapping(path="/customers", consumes={"application/json"})
	@ResponseBody
	public Customer put(@RequestBody Customer customer) {
		repo.save(customer);
		return(customer);
	}
	
//	@PostMapping("/save")
//	public String save(@RequestParam("cid")String cid,
//			@RequestParam("cname")String cname,
//			@RequestParam("email")String email, ModelMap modelmap) {
//		
//		modelmap.put("cid", cid);
//		modelmap.put("cname", cname);
//		modelmap.put("email", email);
//		return "formdetail";
//	}
}
