package io.jejuwn.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class FileDTO {
	

	private String fileName;
	
	private String uuid;
	
	private String folderPath;
	
	public String getImageURL() {
		try {
			return URLEncoder.encode(folderPath + "/" + uuid + fileName, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
