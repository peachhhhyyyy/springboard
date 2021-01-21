package peachy.md.service;

import java.util.List;
import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;

public interface BoardService {
	List<Board> listS();
	BoardListResult getBoardListResult(int cp, int ps);
	void insertS(Board board);
	void deleteS(long seq);
	Board contentS(long seq);
	Board updateS(long seq);
	void updateOkS(Board board);
}