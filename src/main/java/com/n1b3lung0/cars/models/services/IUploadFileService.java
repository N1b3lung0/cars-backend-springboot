package com.n1b3lung0.cars.models.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    public Resource load(String photoName) throws MalformedURLException;
    public String copy(MultipartFile file) throws IOException;
    public boolean delete(String photoName);
    public Path getPath(String photoName);
}
