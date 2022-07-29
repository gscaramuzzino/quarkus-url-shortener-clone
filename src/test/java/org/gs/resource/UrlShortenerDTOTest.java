package org.gs.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerDTOTest {

    private UrlShortenerDTO urlShortenerDTO;

    @BeforeEach
    void setUp() throws URISyntaxException {
        urlShortenerDTO = new UrlShortenerDTO("alias", new URI("http://myurl"));
    }

    @Test
    void urlShortenerNotNull() {
        assertNotNull(urlShortenerDTO);
    }

    @Test
    void getAlias() {
        assertEquals("alias", urlShortenerDTO.getAlias());
    }

    @Test
    void setAlias() {
        urlShortenerDTO.setAlias("newAlias");
        assertEquals("newAlias", urlShortenerDTO.getAlias());
    }

    @Test
    void getUrl() {
        assertEquals("http://myurl", urlShortenerDTO.getUrl().toString());
    }

    @Test
    void setUrl() throws URISyntaxException {
        urlShortenerDTO.setUrl(new URI("http://newUrl"));
        assertEquals("http://newUrl", urlShortenerDTO.getUrl().toString());
    }
}