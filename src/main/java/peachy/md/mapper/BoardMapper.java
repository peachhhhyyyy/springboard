package peachy.md.mapper;

import java.util.List;
import peachy.md.domain.Address;
import peachy.md.domain.Board;
import peachy.md.domain.BoardVo;

public interface BoardMapper {
	List<Board> list();
	List<Board> selectPerPage(BoardVo boardVo);
	long selectCount();
	void insert(Board board);
	void delete(long seq);
	Board content(long seq);
	Board update(long seq);
	void updateOk(Board board);
}