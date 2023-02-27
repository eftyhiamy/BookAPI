package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import model.GoogleBooksDB.AccessInfo;
import model.GoogleBooksDB.Epub;
import model.GoogleBooksDB.IndustryIdentifier;
import model.GoogleBooksDB.Item;
import model.GoogleBooksDB.VolumeInfo;

//After relating with VolumeInfo created by postman, will include only the variables that I need for the project//

public class VolumesInfo {
	private final String title;
	private final List<String> authors;
	private final List<String> categories;
	private final String publisher;
	private final String isbn;
	private final Epub epub;
	private final String viewability;
	private final String printType;

	//public VolumesInfo(String title, String authors, String categories; String publisher, String isbn, Epub epub, String viewability, String printType) {
	//	this.title = title;
	//	this.authors = authors;
	//	this.categories = categories;
	//	this.publisher = publisher;
	//	this.isbn = isbn;
	//	this.epub = epub;
	//	this.viewability = viewability;
	//	this.printType = printType;
	//	}
	
	public VolumesInfo(VolumeInfo theVolumeInfo) {
		this.title = theVolumeInfo.getTitle();
		this.authors = theVolumeInfo.getAuthors();
		this.categories = theVolumeInfo.getCategories();
		this.publisher = theVolumeInfo.getPublisher();
		this.printType = theVolumeInfo.getPrintType();
	}
	
	public VolumesInfo(IndustryIdentifier theIndustryIdentifier) {
		this.isbn = theIndustryIdentifier.getIdentifier();	
	}
	
	public VolumesInfo(AccessInfo theAccessInfo) {
		this.epub = theAccessInfo.getEpub();
		this.viewability = theAccessInfo.getViewability();
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the authors
	 */
	public List<String> getAuthors() {
		return authors;
	}
	/**
	 * @return the categories
	 */
	public List<String> getCategories() {
		return categories;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @return the epub
	 */
	public Epub getEpub() {
		return epub;
	}
	/**
	 * @return the viewability
	 */
	public String getViewability() {
		return viewability;
	}
	/**
	 * @return the printType
	 */
	public String getPrintType() {
		return printType;
	}
	@Override
	public String toString() {
		return "VolumesInfo [title=" + title + ", authors=" + authors + ", categories=" + categories + ", publisher="
				+ publisher + ", isbn=" + isbn + ", epub=" + epub + ", viewability=" + viewability + ", printType="
				+ printType + "]";
	}
	
	}
}