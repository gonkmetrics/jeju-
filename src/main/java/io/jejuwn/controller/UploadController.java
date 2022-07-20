package io.jejuwn.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.jejuwn.model.Address;
import io.jejuwn.model.FileDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/files")
public class UploadController {
	
	@Value("${com.example.upload.path}")
	private String uploadPath;
	
	private String makeFolder() {
		
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		String folderPath = str.replace("/", File.separator);
		
		File uploadPathFolder = new File(uploadPath, folderPath);
		
		if(uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
		}
		
		return folderPath;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<List<FileDTO>> fileUpload(MultipartFile[] uploadFiles){
		
		List<FileDTO> resultFileList = new ArrayList<>();
		for (MultipartFile uploadFile : uploadFiles) {
		
		
		String originalName = uploadFile.getOriginalFilename();
		
		String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
		
		String folderPath = makeFolder();
		
		String uuid = UUID.randomUUID().toString();
		
		String saveFile = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
		
		Path savePath = Paths.get(saveFile);
		try {
			uploadFile.transferTo(savePath);
			
			String thumbnailSaveName = uploadPath + File.separator + folderPath + File.separator + "s_" + uuid + "_" + fileName;
			
			File thumbnailFile = new File(thumbnailSaveName);
			
			Thumbnailator.createThumbnail(savePath.toFile(),thumbnailFile,100,100);
			
			resultFileList.add(new FileDTO(fileName,uuid,folderPath));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	return new ResponseEntity<>(resultFileList, HttpStatus.OK);
	}
}
