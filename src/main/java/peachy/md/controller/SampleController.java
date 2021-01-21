package peachy.md.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;
import peachy.md.domain.Human;
import peachy.md.domain.HumanList;
import peachy.md.domain.ToDoDTO;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
   @RequestMapping("")
   public void m01() {
      log.info("m01 - default URL");
   }
   @RequestMapping("/base1")
   public void m02() {
      log.info("m02 - Get / Post / ...");
   }
   @RequestMapping(value = "/base2", method = RequestMethod.GET)
   public void m03() {
      log.info("m03 - Only Get");
   }
   @RequestMapping(value = "/base3", method = {RequestMethod.GET, RequestMethod.POST})
   public void m04() {
      log.info("m04 - Get / Post");
   }
   @RequestMapping(value = "/form", method = RequestMethod.GET)
   public String form() {
      return "sample/form";
   }
   @RequestMapping("/param1")
   public void m05(Human board) {
	   log.info("m05() dto: " + board);
   }
   @RequestMapping("/param2")
   public void m06(@RequestParam String name, @RequestParam int age) {
	   log.info("m06() name: " + name + ", age:" + age);
   }
   @RequestMapping("/param3")
   public void m07(@RequestParam ArrayList<String> names) {
	   log.info("m07() names:" + names);
   }
   @RequestMapping("/param4")
   public void m08(@RequestParam("ns") ArrayList<String> names) {
	   log.info("m08() names:" + names);
   }
   @RequestMapping("/param5")
   public void m09(@RequestParam String[] names){
	  log.info("m09() names: " + names);
	  for(String name: names) log.info("name: " + name);
   }
   @RequestMapping("/param6")
   public void m10(HumanList hlist) {
	  log.info("m10() hlist: " + hlist);
   }
   @RequestMapping("/param7")
   public void m11(Human dto, @RequestParam int page) {
	  log.info("m11() dto:" + dto + ", page:" + page);
   }
   @RequestMapping("/param8")
   public void m12(ToDoDTO dto)  {
	  log.info("m12() dto.getCdate(): " + dto.getCdate());
   }
   @RequestMapping(value="/json1", method=RequestMethod.GET)
   @GetMapping("/json1")
   public ResponseEntity<String> m13() {
	   String msg = "{\"name:\":\"임연지\", \"age\":25}";
	   HttpHeaders headers = new HttpHeaders();
	   headers.add("Content-Type", "application/json;charset=utf-8");
	   
	   return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
   }
   @GetMapping("/json2")
   public @ResponseBody Human m14() { // *****
	   return new Human("박영후", 31);
   }
}