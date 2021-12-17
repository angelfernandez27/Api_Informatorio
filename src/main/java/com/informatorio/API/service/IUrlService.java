package com.informatorio.API.service;
import com.informatorio.API.entity.Url;
import com.informatorio.API.entity.UrlDTO;
import java.util.Collection;
public interface IUrlService {
    void crateUrl(Url url);
    void deleteUrl(Long id);
    UrlDTO findUrl(Long id);
    Collection<UrlDTO> getAll();
}
