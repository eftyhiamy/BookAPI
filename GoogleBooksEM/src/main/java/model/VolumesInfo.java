package model;

import java.util.ArrayList;

public class VolumesInfo {
//Creating variables for book details
	private final String title;
	private final ArrayList<String> authors;
	private final String subject;
	private final String publisher;
	private final String isbn;
	private final String download;
	private final String filter;
	private final String langRestrict;
	private final String maxResults;
	private final String orderBy;
	private final String printType;
	private final String projection;
	private final String startIndex;
	private final String Id;
	
//Creating a constructor class
	
	public VolumesInfo(String title, ArrayList<String> authors, String subject, String publisher, String isbn, String download, String filter, String langRestrict, String maxResults, String orderBy, String printType, String projection, String startIndex, String Id) {
		this.title = title;
		this.authors = authors;
		this.subject = subject;
		this.publisher = publisher;
		this.isbn = isbn;
		this.download = download;
		this.filter = filter;
		this.langRestrict = langRestrict;
		this.maxResults = maxResults;
		this.orderBy = orderBy;
		this.printType = printType;
		this.projection = projection;
		this.startIndex = startIndex;
		this.Id = Id;
	}
	
//Creating setter and getter methods
	public String getTitle() {
		return title;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public String getSubject() {
		return subject;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDownload() {
		return download;
	}

	public String getFilter() {
		return filter;
	}

	public String getLangRestrict() {
		return langRestrict;
	}

	public String getMaxResults() {
		return maxResults;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getPrintType() {
		return printType;
	}

	public String getProjection() {
		return projection;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public String getId() {
		return Id;
	}

	@Override
    public String toString() {
        return "VolumesInfo{" +
                "title='" + title + "'\n" +
                ", authors ='" + authors + "'\n" +
                ", subject='" + subject + "'\n" +
                ", publisher='" + publisher + "'\n" +
                ", isbn='" + isbn + "'\n" +
                ", download='" + download + "'\n" +
                ", filter='" + filter + "'\n" +
                ", langRestrict='" + langRestrict + "'\n" +
                ", maxResults='" + maxResults + "'\n" +
                ", orderBy='" + orderBy + "'\n" +
                ", printType='" + printType + "'\n" +
                ", projection='" + projection + "'\n" +
                ", startIndex='" + startIndex + "'\n" +
                ", Id='" + Id + "'\n" +
                '}';
    }
	
	
	

	//
	
}
