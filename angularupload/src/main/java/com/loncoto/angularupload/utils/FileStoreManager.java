package com.loncoto.angularupload.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileStoreManager {
	
	private final static Logger log = LogManager.getLogger(FileStoreManager.class);
	
	private File storageRoot;
	public File getStorageRoot() {return storageRoot;}
	public void setStorageRoot(File storageRoot) {this.storageRoot = storageRoot;}
	
	public FileStoreManager() {
		log.info("construction FileStoreManager");
	}

	public boolean saveFile(String entityName, int id, File f) {
		if (storageRoot == null
		    || !storageRoot.exists()
		    || !storageRoot.isDirectory()) {
			log.error("stockage de fichier impossible, storageRoot non utilisable");
			return false;
		}
		File entityRep = new File(storageRoot.getAbsolutePath() + File.separatorChar + entityName);
		// si le répertoire de l'entité n'existe pas, le creer
		if (!entityRep.exists()) {
			entityRep.mkdirs();
		}
		if (!entityRep.isDirectory()) {
			log.error("impossible d'acceder ou de creer le repertoire pour " + entityName);
			return false;
		}
		try {
			Files.copy(f.toPath(), Paths.get(entityRep.getAbsolutePath(), String.format("FILE_%06d", id))
											, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			log.error(e);
		}
		return false;
	}
}
