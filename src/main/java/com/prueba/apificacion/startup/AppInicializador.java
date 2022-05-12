package com.prueba.apificacion.startup;

import com.microsoft.playwright.options.LoadState;

import com.prueba.apificacion.db.ApiKeyDTO;
import com.prueba.apificacion.db.ApiKeyRepository;
import com.prueba.apificacion.noticia.NoticiaDto;
import com.prueba.apificacion.noticia.NoticiaUtils;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.microsoft.playwright.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;


@Component
public class AppInicializador {
    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @PostConstruct
    private void init() {
        System.out.println("Inicializando app!!!!!!!!!!!!!!!!!!!");
        String signedPassword="";
        try {
            signedPassword = NoticiaUtils.hmacEncode("HmacSHA256","user:abc123","admin");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        ApiKeyDTO apikeyDTO= new ApiKeyDTO();
        apikeyDTO.setApiName("Consultas Abc");
        apikeyDTO.setHashType("HmacSHA256");
        apikeyDTO.setPassword(signedPassword);
        ApiKeyDTO apiKeyDTONew = apiKeyRepository.save(apikeyDTO);
        System.out.println(apiKeyDTONew.toString());



    }



}
