package org.gs;

import org.gs.entity.UrlShortener;
import org.gs.resource.UrlShortenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UrlShortenerMapper {

    UrlShortener toDAO(UrlShortenerDTO dto);

    UrlShortenerDTO toDTO(UrlShortener dao);

}
