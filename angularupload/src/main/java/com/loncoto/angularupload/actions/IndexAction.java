package com.loncoto.angularupload.actions;

import java.io.File;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.loncoto.angularupload.dao.IImageDAO;
import com.loncoto.angularupload.dao.ImageDAO;
import com.loncoto.angularupload.metier.Image;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static final Logger log = LogManager.getLogger(IndexAction.class);
	
	private static final long serialVersionUID = 1L;

	private IImageDAO imageDAO;
	public IImageDAO getImageDAO() {return imageDAO;}
	public void setImageDAO(IImageDAO imageDAO) {this.imageDAO = imageDAO;}
	

	private Image img;
	public Image getImg() {return img;}


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
		this.img = new Image(0, uploadFileName, new Date(), uploadFileName, uploadContentType);
		this.img = getImageDAO().save(this.img);
		getImageDAO().saveImageFile(img.getId(), upload);
		return SUCCESS;
	}
}
