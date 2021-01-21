package peachy.md.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import peachy.md.domain.Address;
import peachy.md.service.AddressService;

@Controller
@RequestMapping("/address/*")
public class AddressController {
	//@Autowired
	@Resource(name="addressService")
	private AddressService service;
	
	//@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@GetMapping("/list.do")
	public ModelAndView list() {
		List<Address> list = service.listS();
		
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("address/list");
		mv.addObject("list", list);*/
		/*ModelAndView mv = new ModelAndView("address/list", "list", list);
		 return mv;*/
		
		return new ModelAndView("address/list", "list", list);
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "address/write";
	}
	@PostMapping("/write.do")
	public String write(Address address) {
		service.insertS(address);
		return "redirect:list.do";
	}
	@GetMapping("del.do")
    public String delete(@RequestParam long seq) {
		service.deleteS(seq);
		return "redirect:list.do";
	}
}
