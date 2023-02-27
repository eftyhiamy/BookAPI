package model;

import java.util.List;
import java.util.Map;

import model.publicBookshelves_volume.ImageLinks;
import model.publicBookshelves_volume.IndustryIdentifier;
import model.publicBookshelves_volume.PanelizationSummary;
import model.publicBookshelves_volume.ReadingModes;

public class publicBookshelvesVolume {
	private final String title;
	private final List<String> authors;
	private final String publisher;
	private final String publishedDate;
    private final String description;
    private final List<IndustryIdentifier> industryIdentifiers;
    private final ReadingModes readingModes;
    private final Integer pageCount;
    private final String printType;
    private final List<String> categories;
    private final Integer averageRating;
    private final Integer ratingsCount;
    private final String maturityRating;
    private final Boolean allowAnonLogging;
    private final String contentVersion;
    private final PanelizationSummary panelizationSummary;
    private final ImageLinks imageLinks;
    private final String previewLink;
    private final String infoLink;
    private final String canonicalVolumeLink;
    private final Map<String, Object> additionalProperties;


public publicBookshelvesVolume (String title, List<String> authors, String publisher, String publishedDate, String description, List<IndustryIdentifier> industryIdentifiers, ReadingModes readingModes, Integer pageCount, String printType, List<String> categories, Integer averageRating, Integer ratingsCount,
String maturityRating, Boolean allowAnonLogging, String contentVersion, PanelizationSummary panelizationSummary, ImageLinks imageLinks, String previewLink, String infoLink, String canonicalVolumeLink, Map<String, Object> additionalProperties){
	this.title = title;
	this.authors = authors;
	this.publisher = publisher;
	this.publishedDate = publishedDate;
	this.description = description;
	this.industryIdentifiers = industryIdentifiers;
	this.readingModes = readingModes;
	this.pageCount = pageCount;
	this.printType = printType;
	this.categories = categories;
	this.averageRating = averageRating;
	this.ratingsCount = ratingsCount;
	this.maturityRating = maturityRating;
	this.allowAnonLogging = allowAnonLogging;
	this.contentVersion = contentVersion;
	this.panelizationSummary = panelizationSummary;
	this.imageLinks = imageLinks;
	this.previewLink = previewLink;
	this.infoLink = infoLink;
	this.canonicalVolumeLink = canonicalVolumeLink;
	this.additionalProperties = additionalProperties;
}


public String getTitle() {
	return title;
}


public List<String> getAuthors() {
	return authors;
}


public String getPublisher() {
	return publisher;
}


public String getPublishedDate() {
	return publishedDate;
}


public String getDescription() {
	return description;
}


public List<IndustryIdentifier> getIndustryIdentifiers() {
	return industryIdentifiers;
}


public ReadingModes getReadingModes() {
	return readingModes;
}


public Integer getPageCount() {
	return pageCount;
}


public String getPrintType() {
	return printType;
}


public List<String> getCategories() {
	return categories;
}


public Integer getAverageRating() {
	return averageRating;
}


public Integer getRatingsCount() {
	return ratingsCount;
}


public String getMaturityRating() {
	return maturityRating;
}

public Boolean getAllowAnonLogging() {
	return allowAnonLogging;
}

public String getContentVersion() {
	return contentVersion;
}

public PanelizationSummary getPanelizationSummary() {
	return panelizationSummary;
}

public ImageLinks getImageLinks() {
	return imageLinks;
}

public String getPreviewLink() {
	return previewLink;
}

public String getInfoLink() {
	return infoLink;
}

public String getCanonicalVolumeLink() {
	return canonicalVolumeLink;
}

public Map<String, Object> getAdditionalProperties() {
	return additionalProperties;
}


@Override
public String toString() {
	return "publicBookshelvesVolume [title=" + title + ", authors=" + authors + ", publisher=" + publisher
			+ ", publishedDate=" + publishedDate + ", description=" + description + ", industryIdentifiers="
			+ industryIdentifiers + ", readingModes=" + readingModes + ", pageCount=" + pageCount + ", printType="
			+ printType + ", categories=" + categories + ", averageRating=" + averageRating + ", ratingsCount="
			+ ratingsCount + ", maturityRating=" + maturityRating + ", allowAnonLogging=" + allowAnonLogging
			+ ", contentVersion=" + contentVersion + ", panelizationSummary=" + panelizationSummary + ", imageLinks="
			+ imageLinks + ", previewLink=" + previewLink + ", infoLink=" + infoLink + ", canonicalVolumeLink="
			+ canonicalVolumeLink + ", additionalProperties=" + additionalProperties + "]";
}
	
}
