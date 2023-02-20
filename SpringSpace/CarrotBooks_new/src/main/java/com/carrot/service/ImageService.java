package com.carrot.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carrot.domain.AttachImageVO;
import com.carrot.repository.ImageRepository;

@Service
public class ImageService {
	
	private ImageRepository imageRepository;
	
	@Autowired
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	public List<AttachImageVO> getImageList(int refId){
		return imageRepository.getAttachList(refId);
	}
	
	// 이미지 파일 저장
	public List<AttachImageVO> uploadImage(String rootPath, MultipartFile[] uploadFile) throws IllegalStateException, IOException {
		List<AttachImageVO> list = new ArrayList<>();
		
		// 하위 폴더 이름 생성(date별로 구분)
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		String datePath = str.replace("-", File.separator);
		
		// 폴더 생성
		File uploadPath = new File(rootPath, datePath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		// 이미지를 폴더에 업로드
		for(MultipartFile file : uploadFile) {
			AttachImageVO image = new AttachImageVO();
			String uploadFileName = file.getOriginalFilename();
			image.setFileName(uploadFileName);
			image.setUploadPath(datePath);

			// uuid적용
			String uuid = UUID.randomUUID().toString();
			uploadFileName = uuid + "_" + uploadFileName;
			image.setUuid(uuid);
			
			File saveFile = new File(uploadPath, uploadFileName);
			
			file.transferTo(saveFile);
			
			list.add(image);
		}
		
		return list;
	}
	
	// 이미지 파일인지 체크
	public boolean checkImageFile(MultipartFile[] uploadFile) throws IOException {
		
		for(MultipartFile file: uploadFile) {
			File checkFile = new File(file.getOriginalFilename());
			String type = null;
			
			type = Files.probeContentType(checkFile.toPath());

			if(!type.startsWith("image")) {
				return false;
			}
		}
		return true;
	}
	
}
