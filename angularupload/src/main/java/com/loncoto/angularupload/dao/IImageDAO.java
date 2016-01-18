package com.loncoto.angularupload.dao;

import java.io.File;

import com.loncoto.angularupload.metier.Image;

public interface IImageDAO extends IGenericDAO<Image>{
	
	 boolean saveImageFile(int id, File f);
}
