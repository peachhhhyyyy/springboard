package peachy.md.controller;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;
import peachy.md.filesetting.Path;
import peachy.md.service.BoardService;

@RequestMapping("/board1/*")
@Controller
@Log4j
//@AllArgsConstructor
public class BoardController1 {
  //@Autowired
  @Resource(name = "boardService1")
  private BoardService service;

  //@RequestMapping(value="/list.do", method=RequestMethod.GET)
  @GetMapping("/list.do")
  public ModelAndView list(HttpServletRequest request, HttpSession session) {
    String cpStr = request.getParameter("cp");
    String psStr = request.getParameter("ps");
    String catgo = request.getParameter("catgo");
    String keyword = request.getParameter("keyword");

    //(1) cp
    int cp = 1;
    if (cpStr == null) {
      Object cpObj = session.getAttribute("cp");
      if (cpObj != null) {
        cp = (Integer) cpObj;
      }
    } else {
      cpStr = cpStr.trim();
      cp = Integer.parseInt(cpStr);
    }
    session.setAttribute("cp", cp);

    //(2) ps
    int ps = 3;
    if (psStr == null) {
      Object psObj = session.getAttribute("ps");
      if (psObj != null) {
        ps = (Integer) psObj;
      }
    } else {
      psStr = psStr.trim();
      int psParam = Integer.parseInt(psStr);

      Object psObj = session.getAttribute("ps");
      if (psObj != null) {
        int psSession = (Integer) psObj;
        if (psSession != psParam) {
          cp = 1;
          session.setAttribute("cp", cp);
        }
      } else {
        if (ps != psParam) {
          cp = 1;
          session.setAttribute("cp", cp);
        }
      }
      ps = psParam;
    }
    session.setAttribute("ps", ps);
    BoardListResult listResult = null;
    ModelAndView mv = null;
    //(3) ModelAndView 
    if (catgo != null && keyword != null) {
      listResult = service.getBoardListResult(catgo, keyword, cp, ps);
      mv = new ModelAndView("board1/list", "listResult", listResult);
      List < Board > li = listResult.getList();
      log.info("list size : " + li.size());

      if (listResult.getList().size() == 0) {
        log.info("?");
        if (cp > 1) return new ModelAndView("redirect:list.do?cp=" + (cp - 1));
        else return new ModelAndView("board1/list", "listResult", null);

      } else {
        log.info("성공");
        return mv;
      }
    } else {
      listResult = service.getBoardListResult(cp, ps);
      mv = new ModelAndView("board1/list", "listResult", listResult);
      List < Board > li = listResult.getList();
      log.info("list size : " + li.size());

      if (listResult.getList().size() == 0) {
        log.info("?");
        if (cp > 1) return new ModelAndView("redirect:list.do?cp=" + (cp - 1));
        else return new ModelAndView("board1/list", "listResult", null);

      } else {
        log.info("성공");
        return mv;
      }
    }
  }
  @GetMapping("/write.do")
  public String write() {
    return "board1/write";
  }
  @PostMapping("/write.do")
  public String write(Board board, @RequestParam MultipartFile file) {
	  	log.info("#file" + file);
	  	String path = "C:/spring/tmp/";
	  	String fname = file.getName();
	  	log.info("#path" + path);
	  	log.info("#fname: file.getName()" + fname);
	  	String ofname = file.getOriginalFilename();
	  	long fsize = file.getSize();
	  	if(ofname == null && ofname.length() == 0) {
	  		board.setFname(fname);
	  		board.setOfname(ofname);
	  		board.setFsize(fsize);

	  		fname = null;
	  		ofname = null;
	  		fsize = -1;
	  		
	  		log.info("#fname1: setFName()" + fname);
	  		log.info("#fname1: setOfName()" + ofname);
	  		log.info("#fname1: setFsize()" + fsize);
	  	}else {
	  		board.setFname(fname);
	  		board.setOfname(ofname);
	  		board.setFsize(fsize);
	  		log.info("#fname2: setFName()" + fname);
	  		log.info("#fname2: setOfName()" + ofname);
	  		log.info("#fname2: setFsize()" + fsize);
	  		service.insertS(board);
	  		service.saveStore(file);
	  	}
	  	return "redirect:list.do";
  }
  @GetMapping("/del.do")
  public String delete(@RequestParam long seq) {
    service.deleteS(seq);
    return "redirect:list.do";
  }
  @GetMapping("/content.do")
  public ModelAndView content(@RequestParam long seq) {
    File fStore = new File(Path.FILE_STORE);
    if(!fStore.exists()) fStore.mkdirs();
    File files[] = fStore.listFiles();
    
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
  @GetMapping("download.do")
  public ModelAndView download(@RequestParam String fname) {
     File file = new File(Path.FILE_STORE, fname);
     log.info("file: " + file);
     if(file.exists()) {
    	log.info("다운로드 성공");
        return new ModelAndView("fileDownloadView", "downloadFile", file);
     }else {
    	log.info("다운로드 실패");
        return new ModelAndView("redirect:list.do");
     }
  }
}