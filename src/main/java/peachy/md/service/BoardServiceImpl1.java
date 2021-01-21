package peachy.md.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;
import peachy.md.domain.BoardVo;
import peachy.md.mapper.BoardMapper;

@Service("boardService1")
@AllArgsConstructor
public class BoardServiceImpl1 implements BoardService {
	//@Autowired
	@Resource
	private BoardMapper boardMapper;
	
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		long totalCount = boardMapper.selectCount();
		BoardVo boardVo = new BoardVo(null, cp, ps);
		List<Board> list = boardMapper.selectPerPage(boardVo);
		
		return new BoardListResult(cp, totalCount, ps, list);
	}
	@Override
	public List<Board> listS() {
		return null;
	}
	@Override
	public void insertS(Board board) { 
		boardMapper.insert(board);
	}
	@Override
	public void deleteS(long seq) {
		boardMapper.delete(seq);
	}
	@Override
	public Board contentS(long seq) {
		return boardMapper.content(seq);
	}
	@Override
	public Board updateS(long seq) { 
		return boardMapper.update(seq);
	}
	@Override
	public void updateOkS(Board board) { 
		boardMapper.updateOk(board);
	}
}