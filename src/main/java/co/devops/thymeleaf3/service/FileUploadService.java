package co.devops.thymeleaf3.service;

import co.devops.thymeleaf3.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
