package image.model;

/*
 * Author: FES
 * Date: June 2024
 */

import java.io.InputStream;

import jakarta.servlet.http.Part;

public class ImageBean {

	private int id;
	private InputStream file;
	private String photo;
	
	public ImageBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}
}