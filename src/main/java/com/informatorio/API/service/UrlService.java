package com.informatorio.API.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.API.entity.Url;
import com.informatorio.API.entity.UrlDTO;
import com.informatorio.API.repository.IUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UrlService implements IUrlService{
    @Autowired
    IUrlRepository urlRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void crateUrl(Url url) {
        urlRepository.save(url);

    }
    @Override
    public void deleteUrl(Long id) {
        urlRepository.deleteById(id);
    }

    @Override
    public UrlDTO findUrl(Long id) {
        UrlDTO urlDTO=null;
        Optional<Url>url=urlRepository.findById(id);
        if (url.isPresent()){
            urlDTO=mapper.convertValue(url,UrlDTO.class);
        }
        return urlDTO;
    }
    @Override
    public Collection<UrlDTO> getAll() {
        List<Url>urls=urlRepository.findAll();
        Set<UrlDTO>urlDTOS=new HashSet<>();
        for (Url url : urls) {
            urlDTOS.add(mapper.convertValue(url,UrlDTO.class));
        }
        return urlDTOS;
    }
}
