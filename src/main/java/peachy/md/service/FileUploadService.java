package peachy.md.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
   String saveStore(MultipartFile file);
   boolean writeFile(MultipartFile file, String saveFileName);
}