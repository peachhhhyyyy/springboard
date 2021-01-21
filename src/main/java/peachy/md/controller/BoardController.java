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

import peachy.md.domain.Board;
import peachy.md.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	//@Autowired
	@Resource(name="boardService")
	private BoardService service;
	
	//@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@GetMapping("/list.do")
	public ModelAndView list() {
		List<Board> list = service.listS();
		
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("address/list");
		mv.addObject("list", list);*/
		/*ModelAndView mv = new ModelAndView("address/list", "list", list);
		 return mv;*/
		
		return new ModelAndView("board/list", "list", list);
	}
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	@PostMapping("/write.do")
	public String write(Board board) {
		service.insertS(board);
		return "redirect:list.do";
	}
	@GetMapping("/del.do")
	public String delete(@RequestParam long seq) {
		service.deleteS(seq);
		return "redirect:list.do";
	}
	@GetMapping("/content.do")
	public ModelAndView content(@RequestParam long seq) {
		Board content = service.contentS(seq);
		return new ModelAndView("board/content", "content", content);
	}
	@GetMapping("/update.do")
	public ModelAndView update(@RequestParam long seq) {
		Board update = service.updateS(seq);
		return new ModelAndView("board/update", "update", update);
	}
	@PostMapping("/update.do")
	public String updateOk(Board board) {
		service.updateOkS(board);
		return "redirect:list.do";
	}
}
