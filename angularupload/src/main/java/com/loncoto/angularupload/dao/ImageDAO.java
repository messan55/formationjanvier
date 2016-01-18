package com.loncoto.angularupload.dao;

import java.io.File;
import java.util.List;

import com.loncoto.angularupload.metier.Image;
import com.loncoto.angularupload.utils.FileStoreManager;

public class ImageDAO extends GenericDAO<Image> implements IImageDAO {

	private FileStoreManager fileStoreManager;
	public FileStoreManager getFileStoreManager() {return fileStoreManager;}
	public void setFileStoreManager(FileStoreManager fileStoreManager) {this.fileStoreManager = fileStoreManager;}


	public ImageDAO() {
		super(Image.class);
	}
	
	public boolean saveImageFile(int id, File f) {
		return getFileStoreManager().saveFile("Image", id, f);
	}
	
}
