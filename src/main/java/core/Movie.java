package core;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("year")
	@Expose
	private Integer year;
	@SerializedName("cast")
	@Expose
	private List<String> cast = null;
	@SerializedName("genres")
	@Expose
	private List<String> genres = null;

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public List<String> getCast() {
		return cast;
	}

	public List<String> getGenres() {
		return genres;
	}

}