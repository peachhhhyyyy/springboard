package peachy.md.dao;

import java.util.List;
import peachy.md.domain.Address;
import peachy.md.domain.Board;

public interface BoardDAO {
	List<Board> list();
	void insert(Board board);
	void delete(long seq);
	Board content(long seq);
	Board update(long seq);
	void updateOk(Board board);
}