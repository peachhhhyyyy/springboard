package peachy.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import peachy.md.controller.FileController;
import peachy.md.dao.BoardDAO;
import peachy.md.domain.Board;
import peachy.md.domain.BoardListResult;
import peachy.md.filesetting.Path;

@Log4j
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
	@Override
	public BoardListResult getBoardListResult(String catgo, String keyword, int cp, int ps) {
		// TODO Auto-generated method stub
		return null;
	}
   @Override
   public String saveStore(MultipartFile file) {
      String ofname = file.getOriginalFilename();
      int idx = ofname.lastIndexOf(".");
      String ofheader = ofname.substring(0, idx);
      String ext = ofname.substring(idx);
      long ms = System.currentTimeMillis();
      StringBuilder sb = new StringBuilder();
      sb.append(ofheader);
      sb.append("_");
      sb.append(ms);
      sb.append(ext);
      String saveFileName = sb.toString();
      
      long fsize = file.getSize();
      log.info("#ofname: " + ofname + ", saveFileName: " + saveFileName + ", fsize: "+fsize);
      
      boolean flag = writeFile(file, saveFileName);
      if(flag) {
         log.info("#업로드 성공");
      }else {
         log.info("#업로드 실패");
      }
      return Path.FILE_STORE + saveFileName;
   }

   @Override
   public boolean writeFile(MultipartFile file, String saveFileName) {
      File rDir = new File(Path.FILE_STORE);
      if(!rDir.exists()) rDir.mkdirs();
      
      FileOutputStream fos = null;
      try {
         byte data[] = file.getBytes();
         fos = new FileOutputStream(Path.FILE_STORE+saveFileName);
         fos.write(data);
         fos.flush();
         
         return true;
      }catch(IOException ie) {
         return false;
      }finally {
         try {
            if(fos != null) fos.close();
         }catch(IOException ie) {}
      }
   }
}