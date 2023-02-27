package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.GoogleBooksAPIException;
import model.VolumesInfo;
import model.publicBookshelvesList;
import model.publicBookshelvesVolume;
import model.GoogleBooksDB.BooksDB;
import model.GoogleBooksDB.ErrorResponse;
import model.GoogleBooksDB.Item;
import model.publicBookshelves.PublicBookshelvesInfo;

public class BooksAPIService {
	private final String API_KEY;
	private final String API_URL;
	
	public BooksAPIService(String API_URL, String API_KEY) {
		this.API_URL = API_URL;
		this.API_KEY = API_KEY;
	}
	
	//
	//search for volumes based on parameters
	public List<VolumesInfo> searchForBooks(String parameter, String keyword) throws GoogleBooksAPIException {
		BooksDB item = getAPIData("volumes", parameter, keyword, API_URL, API_KEY);
		List<VolumesInfo> VolumesInfoList = new ArrayList<>(item.getItems().size());
		for (Item theItem : item.getItems()) {
			VolumesInfoList.add(new VolumesInfo(theItem));
		}
		
		return VolumesInfoList;
	
	}

	//get all available info for specific volume
	public List<VolumesInfo> getInfo() throws GoogleBooksAPIException {
		String parameter;
		BooksDB item = getAPIData("volumes", parameter, "", API_URL, API_KEY);
		List<VolumesInfo> VolumesInfoList = new ArrayList<>(item.getItems().size());
		for (Item theItem : item.getItems()) {
			VolumesInfoList.add(new VolumesInfo(theItem));
		}
		
		return VolumesInfoList;
	
	}
	
	//get list of public bookshelves of a specific user
	 public List<publicBookshelvesList> getBookshelvesInfo() throws GoogleBooksAPIException {
		 	String parameter = null;
	        String userId = "user_id";
	        BooksDB item = getAPIData("users", userId, "/bookshelves", parameter, API_KEY);
	        List<publicBookshelvesList> BookshelvesInfoList = new ArrayList<>(item.getItems().size());
	        for (Item theItem : item.getItems()) {
				BookshelvesInfoList.add(new publicBookshelvesList(theItem));
	        }
	        
	 return BookshelvesInfoList;
	 
	 }
	 
	//get volumes of a specific public bookshelf of a specific user
	 
	 public List<publicBookshelvesVolume> getBookshelvesVolumeInfo() throws GoogleBooksAPIException {
		 	String parameter = null;
	        String userId = "user_id";
	        BooksDB item = getAPIData("users", userId, "/bookshelves", parameter, "volumes", API_KEY);
	        List<publicBookshelvesVolume> BookshelvesVolumeInfoList = new ArrayList<>(item.getItems().size());
	        for (Item theItem : item.getItems()) {
				BookshelvesVolumeInfoList.add(new publicBookshelvesVolume(theItem));
	        }
	        
	 return BookshelvesVolumeInfoList;
	 
	 } 
	 
	//get API data
	
	// https://www.googleapis.com/books/v1/volumes?q=search+terms
	// https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes
	// https://www.googleapis.com/books/v1/volumes?q=flowers+intitle:keyes
	// https://www.googleapis.com/books/v1/volumes?q=flowers+inpublisher:keyes
	// https://www.googleapis.com/books/v1/volumes?q=flowers+subject:keyes
	// https://www.googleapis.com/books/v1/volumes?q=flowers+isbn:keyes
	// https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&download=epub
	// https://www.googleapis.com/books/v1/volumes?q=flowers&filter=free-ebooks
	// https://www.googleapis.com/books/v1/volumes?q=flowers&startIndex=0
    // https://www.googleapis.com/books/v1/volumes?q=flowers&maxResults=10
	// https://www.googleapis.com/books/v1/volumes?q=flowers&printType=magazines
	// https://www.googleapis.com/books/v1/volumes?q=flowers&projection=lite
	// https://www.googleapis.com/books/v1/volumes?q=flowers&orderBy=newest
	// https://www.googleapis.com/books/v1/volumes/zyTCAlFPjgYC?
	// https://www.googleapis.com/books/v1/users/102701940585560677579/bookshelves
	// https://www.googleapis.com/books/v1/users/102701940585560677579/bookshelves/0
	// https://www.googleapis.com/books/v1/users/102701940585560677579/bookshelves/0/volumes
	

	@SuppressWarnings("unused")
	private BooksDB getAPIData(String API_URL, String resourceID, String parameter, String keyword, String API_KEY) throws GoogleBooksAPIException {
		String startIndex = null;
		String maxResults = null;
		String printType = null;
		String projection = null;
		String orderBy = null;
		
		try {
			final URIBuilder uriBuilder = new URIBuilder(API_URL).setPathSegments(resourceID, parameter, keyword).addParameter("API_KEY", API_KEY).addParameter("startIndex", String.valueOf(startIndex));;
			//user enters parameter
			if (parameter != null && !parameter.isBlank()) {
				switch(resourceID) {
				case "volumes":
					uriBuilder.addParameter(parameter, keyword);
					break;	
				case "users":
					uriBuilder.addParameter("userID", parameter);
					 if ("bookshelves".equals(keyword)) {
	                        uriBuilder.setPathSegments(resourceID, parameter, keyword, startIndex.toString());
	                    } else {
	                        uriBuilder.setPathSegments(resourceID, parameter, keyword);
	                    }
	                    break;
	            }
	        }
	        if (startIndex != null) {
	            uriBuilder.addParameter("startIndex", startIndex.toString());
	        }
	        if (maxResults != null) {
	            uriBuilder.addParameter("maxResults", maxResults.toString());
			}
	        if (printType != null && !printType.isBlank()) {
	        	uriBuilder.addParameter("printType", printType);
	        }
	        if (projection != null && !projection.isBlank()) {
	        	uriBuilder.addParameter("projection", projection);
	        }
	        if (orderBy != null && !orderBy.isBlank()) {
	        	uriBuilder.addParameter("orderBy", orderBy);
	        }
			
	        final URI uri = uriBuilder.build();
			final HttpGet getRequest = new HttpGet(uri);
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
				final HttpEntity entity = response.getEntity();
				final ObjectMapper mapper = new ObjectMapper();

				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
					if (errorResponse.getStatusMessage() != null)
						throw new GoogleBooksAPIException("Error occurred on API call: " + errorResponse.getStatusMessage());
				}

				return mapper.readValue(entity.getContent(), BooksDB.class);
			} catch (IOException e) {
				throw new GoogleBooksAPIException("Error requesting data from the GoogleBooks API.", e);
			}
		} catch (URISyntaxException e) {
			throw new GoogleBooksAPIException("Unable to create request URI.", e);
		}
	
}
}

