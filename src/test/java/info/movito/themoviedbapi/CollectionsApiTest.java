package info.movito.themoviedbapi;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.List;

import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.CollectionInfo;


public class CollectionsApiTest extends AbstractTmdbApiTest {


    @Test
    public void testGetCollectionInfo() {
        CollectionInfo result = tmdb.getCollections().getCollectionInfo(ID_COLLECTION_STAR_WARS, "");

        assertFalse("No collection information", result.getParts().isEmpty());
    }


    @Test
    public void testGetCollectionImages() throws Exception {
        List<Artwork> result = tmdb.getCollections().getCollectionImages(ID_COLLECTION_STAR_WARS, LANGUAGE_DEFAULT);

        assertFalse("No artwork found", result.isEmpty());
    }
}

