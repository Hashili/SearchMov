package core;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CinemaJSON {

	@SerializedName("movie")
	@Expose
	private List<Movie> movie = null;

	public List<Movie> getMovie() {
		return movie;
	}

}
