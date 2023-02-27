import services.BooksAPIService;

public class BookAPI {
		// method is static, so the user is not needed to create new items 
	public static BooksAPIService getBooksDBService() {
		// API key needed. Register and generate API KEY
		return new BooksAPIService("https://www.googleapis.com/books/v1", "AIzaSyDQfccOcswm8OoGuVgDW7X9_rzA3mrEldo");
	}
}
