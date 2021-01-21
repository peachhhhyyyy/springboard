package peachy.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peachy.md.dao.BoardDAO;
import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public List<Board> listS() {
		return boardDao.list();
	}
	@Override
	public void insertS(Board board) { 
		boardDao.insert(board);
	}
	@Override
	public void deleteS(long seq) {
		boardDao.delete(seq);
	}
	@Override
	public Board contentS(long seq) {
		return boardDao.content(seq);
	}
	@Override
	public Board updateS(long seq) { 
		return boardDao.update(seq);
	}
	@Override
	public void updateOkS(Board board) { 
		boardDao.updateOk(board);
	}
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		// TODO Auto-generated method stub
		return null;
	}
}