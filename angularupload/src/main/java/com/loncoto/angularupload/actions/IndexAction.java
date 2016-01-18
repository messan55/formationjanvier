package com.loncoto.angularupload.actions;

import java.io.File;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static final Logger log = LogManager.getLogger(IndexAction.class);
	
	private static final long serialVersionUID = 1L;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	public void setUpload(File upload) {this.upload = upload;}
	public void setUploadContentType(String uploadContentType) {this.uploadContentType = uploadContentType;}
	public void setUploadFileName(String uploadFileName) {this.uploadFileName = uploadFileName;}

	public String index() {
		return SUCCESS;
	}

	public String uploadImage() {
		log.info("reception upload: content type = " + uploadContentType);
		log.info("reception upload: FileName = " + uploadFileName);
		log.info("reception upload: file = " + upload.getAbsolutePath());
		return SUCCESS;
	}
}
