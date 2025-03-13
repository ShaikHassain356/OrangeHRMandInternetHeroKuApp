package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Adjust this if needed
public class FileController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Your server is running.";
    }

    @PostMapping("/upload-single")
    public ResponseEntity<String> uploadSingleFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "directory", required = false) String directory) {
        return uploadFileInternal(file, directory);
    }

    @PostMapping("/upload-multiple")
    public ResponseEntity<String> uploadMultipleFiles(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam(value = "directory", required = false) String directory) {

        if (files.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No files provided for upload!");
        }

        StringBuilder responseMessage = new StringBuilder();
        for (MultipartFile file : files) {
            ResponseEntity<String> response = uploadFileInternal(file, directory);
            responseMessage.append(response.getBody()).append("\n");
        }
        return ResponseEntity.ok(responseMessage.toString());
    }

    private ResponseEntity<String> uploadFileInternal(MultipartFile file, String directory) {
        System.out.println("Received upload request...");
        System.out.println("Directory: " + directory);
        System.out.println("File received: " + (file != null ? file.getOriginalFilename() : "null"));

        if (file.isEmpty()) {
            System.out.println("❌ File is missing or empty!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is missing or empty!");
        }

        // Set default directory if not provided
        if (directory == null || directory.trim().isEmpty()) {
            directory = "uploads";
        }

        try {
            Path uploadPath = Paths.get(directory).toAbsolutePath().normalize();

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("✅ File uploaded successfully to: " + filePath);
            return ResponseEntity.ok("File uploaded successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error uploading file: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading file: " + e.getMessage());
        }
    }

    // HTML Upload Form for Browser Testing
    @GetMapping("/upload-form")
    public String getUploadForm() {
        return "<html><body>"
                + "<h2>Upload Single File</h2>"
                + "<form method='POST' action='/api/upload-single' enctype='multipart/form-data'>"
                + "<input type='file' name='file' required><br><br>"
                + "<input type='text' name='directory' placeholder='Optional directory'><br><br>"
                + "<button type='submit'>Upload</button>"
                + "</form>"
                + "<h2>Upload Multiple Files</h2>"
                + "<form method='POST' action='/api/upload-multiple' enctype='multipart/form-data'>"
                + "<input type='file' name='files' multiple required><br><br>"
                + "<input type='text' name='directory' placeholder='Optional directory'><br><br>"
                + "<button type='submit'>Upload</button>"
                + "</form>"
                + "</body></html>";
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("filename") String filename,
                                               @RequestParam(value = "directory", required = false) String directory) {
        try {
            // Default directory if not provided
            if (directory == null || directory.trim().isEmpty()) {
                directory = "uploads";
            }

            Path filePath = Paths.get(directory).resolve(filename).toAbsolutePath().normalize();

            if (!Files.exists(filePath)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            byte[] fileBytes = Files.readAllBytes(filePath);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + filename)
                    .body(fileBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}