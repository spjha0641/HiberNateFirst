package hibernateFirst;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class AlbumTest {
	GenericDao dao = new GenericDao();

	
//	  @Test public void fetchAllSongs() {
	  
/*	  List<Song> songs = dao.fetchAllSongs();
	  
	  for(Song s: songs) { System.out.println("SongId: "+s.getSongId() +
	  "Artist: "+ s.getArtist()+ "Song name: "+s.getSongName()); } }
	 
	
	  @Test public void fetchAlbumByTitle() { Album album=
	  dao.fetchAlbumByTitle("Heart Touching");
	  System.out.println(album.getAlbumId());
	  System.out.println(album.getAlbumName());
	  System.out.println(album.getReleaseDate()); }*/
	 
	@Test
	public void testFetchAllSongsFromAnAlbum() {
		List<Song> songs = dao.fetchAllSongsFromAnAlbum("Heart Touching");
		
		for(Song s: songs) {
			System.out.println("SongId: "+s.getSongId() + "Artist: "
		+ s.getArtist()+ "Song name: "+s.getSongName()+"Album:"+s.getAlbum().getAlbumName());	
		}
	}

}
