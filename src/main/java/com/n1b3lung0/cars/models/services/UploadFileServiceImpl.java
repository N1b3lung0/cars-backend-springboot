package com.n1b3lung0.cars.models.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    private final static String UPLOAD_DIRECTORY = "uploads";

    @Override
    public Resource load(String photoName) throws MalformedURLException {
        Path filePath = getPath(photoName);
        log.info(filePath.toString());

        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() && !resource.isReadable()) {
            filePath = Paths.get("src/main/resources/static/images").resolve("no-available-image.png").toAbsolutePath();
            resource = new UrlResource(filePath.toUri());

            log.error("There was an error trying to upload the image " + photoName);
        }
        return resource;
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
        Path filePath = getPath(fileName);
        log.info(filePath.toString());

        Files.copy(file.getInputStream(), filePath);

        return fileName;
    }

    @Override
    public boolean delete(String photoName) {
        if (photoName != null && photoName.length() > 0) {
            Path previousFilePath = getPath(photoName);
            File previousFile = previousFilePath.toFile();
            if (previousFile.exists() && previousFile.canRead()) {
                previousFile.delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public Path getPath(String photoName) {
        return Paths.get(UPLOAD_DIRECTORY).resolve(photoName).toAbsolutePath();
    }
}
