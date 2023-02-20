package com.carrot.domain;

public class AttachImageVO {
	private String uploadPath;
	private String uuid;
	private String fileName;
	private int advertId;
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getAdvertId() {
		return advertId;
	}
	public void setAdvertId(int advertId) {
		this.advertId = advertId;
	}
	
	@Override
	public String toString() {
		return "AttachImageVO [uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName + ", advertId="
				+ advertId + "]";
	}
	
}
