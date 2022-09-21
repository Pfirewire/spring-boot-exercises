package com.codeup.springbootexercises.services;

import com.codeup.springbootexercises.models.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service("uploadService")
public class FileUploadService {

    @Value("${file-upload-path}")
    private String uploadPath;

    public void uploadFile(MultipartFile uploadedFile, Post post, Model model) {
        String fileName = post.getId().toString().concat(uploadedFile.getOriginalFilename());
        System.out.println(fileName);
        String filePath = Paths.get(uploadPath, fileName).toString();
        File destinationFile = new File(filePath);
        try {
            uploadedFile.transferTo(destinationFile);
            post.setFilename(fileName);
            model.addAttribute("message", "File uploaded successfully");
        } catch(IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Something went wrong: " + e);
        }
    }
}
