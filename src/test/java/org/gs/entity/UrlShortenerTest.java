package org.gs.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerTest {

    private UrlShortener urlShortener;

    @BeforeEach
    void setUp() throws URISyntaxException {
        urlShortener = new UrlShortener("alias", new URI("http://myurl"));
    }

    @Test
    void urlShortenerNotNull() {
        assertNotNull(urlShortener);
    }

    @Test
    void getAlias() {
        assertEquals("alias", urlShortener.getAlias());
    }

    @Test
    void setAlias() {
        urlShortener.setAlias("newAlias");
        assertEquals("newAlias", urlShortener.getAlias());
    }

    @Test
    void getUrl() {
        assertEquals("http://myurl", urlShortener.getUrl().toString());
    }

    @Test
    void setUrl() throws URISyntaxException {
        urlShortener.setUrl(new URI("http://newUrl"));
        assertEquals("http://newUrl", urlShortener.getUrl().toString());
    }
}