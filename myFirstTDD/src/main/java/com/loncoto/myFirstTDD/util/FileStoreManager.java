package com.loncoto.myFirstTDD.util;

import java.io.File;
import java.util.Optional;

public class FileStoreManager {
	
	private File storageRoot;

	public File getStorageRoot() {
		return storageRoot;
	}

	public void setStorageRoot(File storageRoot) {
		this.storageRoot = storageRoot;
	}

	public FileStoreManager() {
		
	}
	
	
	public boolean saveFile(String entityName, int id, File f) {
		return true;
	}
	
	public Optional<File> getFile(String entityName, int id) {
		return Optional.empty();
	}
	

}
