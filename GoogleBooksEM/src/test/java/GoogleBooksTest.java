import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import exception.GoogleBooksAPIException;
import model.VolumesInfo;
import model.publicBookshelvesList;
import model.publicBookshelvesVolume;
import services.BooksAPIService;

public class GoogleBooksTest {
	@Test
	public void testVolumesAPI() throws GoogleBooksAPIException {
		final BooksAPIService booksSearchService = BookAPI.getBooksDBService();
		final List<VolumesInfo> results = booksSearchService.searchForBooks("flowers", "inauthor");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	}
	
	@Test
	public void testVolumesInfoAPI() throws GoogleBooksAPIException {
		final BooksAPIService booksSearchService = BookAPI.getBooksDBService();
		final List<VolumesInfo> results = booksSearchService.getInfo();
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	}
	
	@Test
	public void testPublicBookshelfAPI() throws GoogleBooksAPIException {
		final BooksAPIService booksSearchService = BookAPI.getBooksDBService();
		final List<publicBookshelvesList> results = booksSearchService.getBookshelvesInfo();
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	}
	
	@Test
	public void testpublicBookshelfVolumeAPI() throws GoogleBooksAPIException {
		final BooksAPIService booksSearchService = BookAPI.getBooksDBService();
		final List<publicBookshelvesVolume> results = booksSearchService.getBookshelvesVolumeInfo();
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	}
	
	
}
