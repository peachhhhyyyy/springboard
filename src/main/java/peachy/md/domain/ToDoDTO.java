package peachy.md.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ToDoDTO {
	private String subject;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date cdate;
}