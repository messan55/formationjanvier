package com.loncoto.myFirstTDD.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		if (storageRoot == null
			    || !storageRoot.exists()
			    || !storageRoot.isDirectory()) {
				System.out.println("stockage de fichier impossible, storageRoot non utilisable");
				return false;
			}
			if (entityName.matches(".*[*:].*")) {
				//System.out.println("remplacement.....");
				entityName = entityName.replaceAll("[*]", "-etoile-");
				entityName = entityName.replaceAll("[:]", "-colonne-");
				//System.out.println("nouveau nom = " + entityName);
			}
			File entityRep = new File(storageRoot.getAbsolutePath() + File.separatorChar + entityName);
			// si le répertoire de l'entité n'existe pas, le creer
			if (!entityRep.exists()) {
				entityRep.mkdirs();
			}
			if (!entityRep.isDirectory()) {
				System.out.println("impossible d'acceder ou de creer le repertoire pour " + entityName);
				return false;
			}
			try {
				Files.copy(f.toPath(), Paths.get(entityRep.getAbsolutePath(), String.format("FILE_%06d", id))
												, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
				return true;
			} catch (IOException e) {
				System.out.println("erreur" + e);
			}
		return false;
	}
	
	public Optional<File> getFile(String entityName, int id) {
		if (storageRoot == null
			    || !storageRoot.exists()
			    || !storageRoot.isDirectory()) {
			System.out.println("stockage de fichier impossible, storageRoot non utilisable");
				return Optional.empty();
		}
		if (entityName.matches(".*[*:].*")) {
			entityName = entityName.replaceAll("[*]", "-etoile-");
			entityName = entityName.replaceAll("[:]", "-colonne-");
		}
		
		File entityRep = new File(storageRoot.getAbsolutePath() + File.separatorChar + entityName);
		// si le répertoire de l'entité n'existe pas, le creer
		if (!entityRep.isDirectory()) {
			System.out.println("impossible d'acceder ou de creer le repertoire pour " + entityName);
			return Optional.empty();
		}
		
		File f = new File(entityRep.getAbsolutePath() + File.separatorChar + String.format("FILE_%06d", id));
		if (f.exists() && f.isFile()) {
			return Optional.of(f);
		}
		else {
			System.out.println("fichier inconnu" + f.getAbsolutePath());
			return Optional.empty();
		}
	}
	

}
