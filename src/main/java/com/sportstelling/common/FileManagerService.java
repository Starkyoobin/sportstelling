package com.sportstelling.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
//	public static final String FILE_UPLOAD_PATH = "D:\\web개발_1300\\images/";
	public static final String FILE_UPLOAD_PATH = "/home/ec2-user/images/";
	
	public static String saveFile(int userId, MultipartFile file) {
		//파일 경로
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		String filePath = FILE_UPLOAD_PATH + directoryName;
		//디렉토리 생성
		File directory = new File(filePath);
		
		if(directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes = file.getBytes();
			//파일 경로
			Path path = Paths.get(filePath + file.getOriginalFilename());
			//파일 저장
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//파일을 접근할수있는 경로
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	
	public void deleteFile(String filePath) {
		//삭제할 파일 경로
		String realFilePath = FILE_UPLOAD_PATH + filePath.replace("/images/", "");
		//파일 지우기
		Path path = Paths.get(realFilePath);
		//해당 파일 유무 확인
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 디렉토리(폴더) 지우기
		path = path.getParent();
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
