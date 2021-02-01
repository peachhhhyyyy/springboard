package peachy.md.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;

public interface BoardService {
	List<Board> listS();
	BoardListResult getBoardListResult(int cp, int ps);
	BoardListResult getBoardListResult(String catgo, String keyword, int cp, int ps);
	void insertS(Board board);
	void deleteS(long seq);
	Board contentS(long seq);
	Board updateS(long seq);
	void updateOkS(Board board);
	String saveStore(MultipartFile file);
    boolean writeFile(MultipartFile file, String saveFileName);
}