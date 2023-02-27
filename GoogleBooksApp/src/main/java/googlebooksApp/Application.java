package googlebooksApp;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import exception.GoogleBooksAPIException;
import model.VolumesInfo;
import model.publicBookshelvesList;
import model.publicBookshelvesVolume;
import services.BooksAPIService;

public class Application {

	public static void main(String[] args) {
		final BooksAPIService booksAPIService = BookAPI.getBooksDBService();
		// TODO Auto-generated method stub
		System.out.println("Welcome to the GoogleBooksApp.");		
	
		while (true) {
			System.out.println("Select one of the following options:");
			System.out.println("1. Search for volumes");
			System.out.println("2. Save the 5 latest user searches");
			System.out.println("3. Get detailed info for search results");
			System.out.println("4. Get public bookshelves for user 102701940585560677579");
			System.out.println("5. Get volumes of public bookshelves for user 102701940585560677579");
			System.out.println("6. Exit");
			
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch (input) {
			case "1":
				System.out.println("Selected 1");
				System.out.println("Enter parameter");
				String searchParam = sc.nextLine();
				String keyword = sc.nextLine();
				try {
					final List<VolumesInfo> results = BooksAPIService.searchForBooks(searchParam, keyword);
					System.out.println("Results are: ");
					System.out.println(results);
				} catch(GoogleBooksAPIException e) {
					System.err.println(e.getMessage());
				}
				
				break;
				
			case "2":
				System.out.println("Selected 2");
				class BookSearchHistory {
					   private Queue<String> searchHistory;
					   private static final int MAX_HISTORY_SIZE = 5;
					   
					   public BookSearchHistory() {
					      searchHistory = new LinkedList<String>();
					   }
					   
					   public void addSearch(String searchTerm) {
					      if (searchHistory.size() >= MAX_HISTORY_SIZE) {
					         searchHistory.remove();
					      }
					      searchHistory.add(searchTerm);
					   }
					   
					   public Queue<String> getSearchHistory() {
					      return searchHistory;
					   }
					}
				
				break;
			case "3":
				System.out.println("Selected 3");
				System.out.println("Enter search parameter");
				String parameter = sc.nextLine();
				try {
					final List<VolumesInfo> results = BooksAPIService.getInfo(parameter);
					System.out.println("Results are: ");
					System.out.println(results);
				} catch(GoogleBooksAPIException e) {
					System.err.println(e.getMessage());
					
				}
				
				break;
			case "4":
				System.out.println("Selected 4");
				System.out.println("Get public bookshelves for user 102701940585560677579");
				String userId = "102701940585560677579";
				String API_KEY = sc.nextLine();
				try {
					final List<publicBookshelvesList> BookshelvesInfoList = BooksAPIService.getBookshelvesInfo();
					String url = "https://www.googleapis.com/books/v1/users/" + userId + "/bookshelves?access_token=" + API_KEY;
					System.out.println("Results are: ");
					System.out.println(BookshelvesInfoList);       
				} catch(GoogleBooksAPIException e) {
					System.err.println(e.getMessage());
					
				}
				
				break;	
			case "5":
				System.out.println("Selected 5");
				System.out.println("Get volumes of public bookshelves for user 102701940585560677579");
				String userId1 = "102701940585560677579";
				String API_KEY1 = sc.nextLine();
				try {
					final List<publicBookshelvesVolume> BookshelvesVolumeInfoList = BooksAPIService.getBookshelvesVolumeInfo();
					String url = "https://www.googleapis.com/books/v1/users/" + userId1 + "/bookshelves/volumes?access_token=" + API_KEY1;
					System.out.println("Results are: ");
					System.out.println(BookshelvesVolumeInfoList);  
				} catch(GoogleBooksAPIException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			case "6":
				System.out.println("Selected 6. Exiting ...");
				System.exit(0);
				break;	
			default:
				System.err.println("Invalid input.");
			}
			
		}
	}
}