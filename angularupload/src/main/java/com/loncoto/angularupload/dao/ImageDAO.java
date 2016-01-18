package com.loncoto.angularupload.dao;

import java.util.List;

import com.loncoto.angularupload.metier.Image;

public class ImageDAO extends GenericDAO<Image> implements IImageDAO {

	public ImageDAO() {
		super(Image.class);
	}
	

}
