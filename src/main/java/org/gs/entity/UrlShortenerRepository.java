package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UrlShortenerRepository implements PanacheRepository<UrlShortener> {
}
