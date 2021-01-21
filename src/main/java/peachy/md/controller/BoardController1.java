package peachy.md.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;
import peachy.md.service.BoardService;

@RequestMapping("/board1/*")
@Controller
//@Log4j
//@AllArgsConstructor
public class BoardController1 {
	//@Autowired
	@Resource(name="boardService1")
	private BoardService service;
	
	//@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@GetMapping("/list.do")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		//(3) ModelAndView
		BoardListResult listResult = service.getBoardListResult(cp, ps);
		ModelAndView mv = new ModelAndView("board1/list", "listResult", listResult);
		
		if(listResult.getList().size() == 0) {
			if(cp>1) 
				return new ModelAndView("redirect:list.do?cp="+(cp-1));
			else
				return new ModelAndView("board1/list", "listResult", null);
		}else {
			return mv;
		}
	}
	@GetMapping("/write.do")
	public String write() {
		return "board1/write";
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
		return new ModelAndView("board1/content", "content", content);
	}
	@GetMapping("/update.do")
	public ModelAndView update(@RequestParam long seq) {
		Board update = service.updateS(seq);
		return new ModelAndView("board1/update", "update", update);
	}
	@PostMapping("/update.do")
	public String updateOk(Board board) {
		service.updateOkS(board);
		return "redirect:list.do";
	}
}
