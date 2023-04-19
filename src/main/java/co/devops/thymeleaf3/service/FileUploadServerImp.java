package co.devops.thymeleaf3.service;

import co.devops.thymeleaf3.model.FileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class FileUploadServerImp implements FileUploadService{
    @Value("${file.server.path}")
    private String fileServerPath;
    @Override
    public FileUpload uploadSingle(MultipartFile file) {
        UUID uuid=UUID.randomUUID();
        int lastIndex=file.getOriginalFilename().lastIndexOf(".");
        String ext=file.getOriginalFilename().substring(lastIndex+1);
        String newFileName=String.format("%s%s%s",uuid,".",ext);
        Path paths= Paths.get(fileServerPath+newFileName);
        try {
            Files.copy(file.getInputStream(),paths);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileUpload(newFileName,true);
    }
}
