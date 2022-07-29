package org.gs.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.gs.entity.UrlShortener;
import org.gs.entity.UrlShortenerRepository;
import org.gs.exception.UrlShortenerException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class UrlShortenerService {

    @ConfigProperty(name = "exception.message.url_not_created")
    public String URL_NOT_CREATED;

    @ConfigProperty(name = "exception.message.alias_already_exists")
    public String ALIAS_ALREADY_EXISTS;

    @ConfigProperty(name = "exception.message.alias_null")
    public String ALIAS_NULL;

    @Inject
    UrlShortenerRepository shortenerRepository;

    @Transactional
    public List<UrlShortener> createUrlShortener(UrlShortener urlShortener) {
        if (urlShortener == null) {
            throw new UrlShortenerException(URL_NOT_CREATED);
        }
        long alias = shortenerRepository.find("alias", urlShortener.getAlias()).count();
        if (alias > 0) {
            throw new UrlShortenerException(ALIAS_ALREADY_EXISTS);
        }
        shortenerRepository.persist(urlShortener);
        return shortenerRepository.listAll();
    }

    public Optional<UrlShortener> getUrlShortener(String alias) {
        if (alias == null || alias.isBlank()) {
            throw new UrlShortenerException(ALIAS_NULL);
        }
        return shortenerRepository.find("alias", alias).stream().findFirst();
    }
}
