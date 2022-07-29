package org.gs.service;

import io.quarkus.test.junit.QuarkusTest;
import org.gs.entity.UrlShortener;
import org.gs.exception.UrlShortenerException;
import org.junit.jupiter.api.*;

import javax.inject.Inject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UrlShortenerServiceTest {

    @Inject
    UrlShortenerService shortenerService;

    private UrlShortener item;

    @BeforeEach
    void setUp() throws URISyntaxException {
        item = new UrlShortener("alias", new URI("http://myurl"));
    }

    @Test
    @Order(1)
    void createUrlShortener() {
        List<UrlShortener> shortenerList = shortenerService.createUrlShortener(item);
        assertNotNull(shortenerList);
        assertFalse(shortenerList.isEmpty());
    }

    @Test
    @Order(1)
    void createUrlShortenerInputNull() {
        assertThrows(UrlShortenerException.class, () -> shortenerService.createUrlShortener(null));
    }

    @Test
    @Order(2)
    void createUrlShortenerInputAlreadyExists() {
        assertThrows(UrlShortenerException.class, () -> shortenerService.createUrlShortener(item));
    }

    @Test
    @Order(3)
    void getUrlShortener() {
        Optional<UrlShortener> result = shortenerService.getUrlShortener(item.getAlias());
        assertNotNull(result);
        assertFalse(result.isEmpty());
        result.ifPresent(url -> {
            assertEquals(item.getUrl(), url.getUrl());
            assertEquals(item.getAlias(), url.getAlias());
        });
    }

    @Test
    @Order(3)
    void getUrlShortenerNotFound() {
        Optional<UrlShortener> result = shortenerService.getUrlShortener("aliasNotPresent");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @Order(3)
    void getUrlShortenerInputNull() {
        assertThrows(UrlShortenerException.class, () -> shortenerService.getUrlShortener(null));
    }

    @Test
    @Order(3)
    void getUrlShortenerInputEmpty() {
        assertThrows(UrlShortenerException.class, () -> shortenerService.getUrlShortener(""));
    }
}