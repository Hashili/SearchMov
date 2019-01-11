package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class SearchMov {

	private static int searchCount = 0;
	private static Set<String> movieList = null;
	public static File file = new File(".\\file.json"); 

	public static void search(String search) throws JsonSyntaxException, IOException {
		searchCount = 0;
		movieList = new HashSet<>();
		String films = "";

		if(!(search.trim().length()>0)) {
			System.out.println("Invalid Search String");
			return;
		}
		Gson gson = new Gson();
		CinemaJSON cinema = gson.fromJson(SearchMov.getJsonAsString(file), CinemaJSON.class);
		List<Movie> movies =cinema.getMovie(); 
		for(Movie movie:movies) {
			Iterator<String> itCast = movie.getCast().iterator();
			Iterator<String> itGenres = movie.getGenres().iterator();
			if(movie.getTitle().contains(search)) {
				movieList.add(movie.getTitle());
				searchCount++;
			};
			runSearch(itCast, movie, search);
			runSearch(itGenres, movie, search);

		}

		for(String mov:movieList) {
			films = films+"\""+mov+"\",";
		}

		if(films.length()>0){
			System.out.println("Input: "+search+" Output: Search Term: "+search+" Movie: "+films.substring(0, films.length()-1)+" count: "+searchCount+"");
		}
		else {
			System.out.println("No Search Results for "+search);
		}


	}
	private static void runSearch(Iterator<String> it,Movie movie,String search) {

		while(it.hasNext()) {
			if(it.next().contains(search)) {
				movieList.add(movie.getTitle());
				searchCount++;
			}
		}

	}

	private static String getJsonAsString(File file) throws IOException {

		String st; 
		String js="";
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		while ((st = br.readLine()) != null) {
			js = js+st;
		}
		return js;
	}
}

