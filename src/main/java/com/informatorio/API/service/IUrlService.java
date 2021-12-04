package com.informatorio.API.service;

import com.informatorio.API.entity.Url;
import com.informatorio.API.entity.UrlDTO;
import com.informatorio.API.entity.UserDTO;

import java.util.Collection;

public interface IUrlService {
    void crateUrl(Url url);
    void deleteUrl(Long id);
    UrlDTO findUrl(Long id);
    public Collection<UrlDTO> getAll();
}
