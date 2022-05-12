package com.prueba.apificacion.noticia;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.prueba.apificacion.db.ApiKeyDTO;
import com.prueba.apificacion.db.ApiKeyRepository;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NoticiaService {
    @Autowired
    private  ApiKeyRepository apiKeyRepository;

    public NoticiaFotoDto[] getNoticiasWithoutPhoto(String textoBuscado) {
        System.out.println("buscando noticias relacionadas con: ");
        System.out.println(textoBuscado);
        String url = "https://www.abc.com.py/buscar/"+textoBuscado;
        ArrayList<NoticiaFotoDto> listaNoticias = new ArrayList<>();
        NoticiaFotoDto noticia = null;
        try (Playwright playwright = Playwright.create()) {
            final BrowserType chromium = playwright.chromium();
            final Browser browser = chromium.launch();
            Page page = browser.newPage();
            page.navigate(url);
            page.waitForLoadState(LoadState.NETWORKIDLE);
            final ElementHandle contentElement = page.querySelector("[class=article-list-wrapper]");
            //System.out.println(page.innerHTML("body"));
            Document docPrueba = null;
            if(contentElement==null) {
                listaNoticias.toArray(NoticiaFotoDto[]::new);
            }
            docPrueba = Jsoup.parse(contentElement.innerHTML());
            Elements articulos = docPrueba.select("div.item-article");
            String enlaceFoto="";
            String enlace="";
            String titulo="";
            String resumen="";
            String fecha="";
            String contenidoFoto="";
            String contentTypeFoto = "";
            for (Element articulo: articulos) {
                //obtener enlace de foto de noticia
                noticia = new NoticiaFotoDto();
                if(articulo.selectFirst("div.article-photo").selectFirst("img")!=null) {
                    enlaceFoto = articulo.selectFirst("div.article-photo").selectFirst("img").attr("src");
                    noticia.setEnlaceFoto(enlaceFoto);
//                    System.out.println("contenidoFoto");
//                    contenidoFoto=NoticiaUtils.getBase64EncodedImage(enlaceFoto);
//                    System.out.println(contenidoFoto);
//                    contentTypeFoto = NoticiaUtils.getImageContentType(enlaceFoto);
//                    System.out.println("contentTypeFoto");
//                    System.out.println(contentTypeFoto);
                }
                else {
                    System.out.println("no tiene atributo definido de img");
                }
                //obtener titulo noticia
                if(articulo.selectFirst("div.article-info").selectFirst("div.article-title")!=null) {
                    titulo = articulo.selectFirst("div.article-info").selectFirst("div.article-title").selectFirst("span").text();
                    noticia.setTitulo(titulo);
                }
                else {
                    System.out.println("no tiene definido titulo");
                }

                //obtener enlace noticia
                if(articulo.selectFirst("div.article-info").selectFirst("a")!=null) {
                    enlace = articulo.selectFirst("div.article-info").selectFirst("a").attr("href");
                    noticia.setEnlace(enlace);
                }
                else {
                    System.out.println("no tiene definido enlace");
                }

                //obtener texto de resumen de noticia
                if(articulo.selectFirst("div.article-info").selectFirst("div.article-intro")!=null) {
                    resumen = articulo.selectFirst("div.article-info").selectFirst("div.article-intro").selectFirst("p").text();
                    noticia.setResumen(resumen);
                }
                else {
                    System.out.println("no tiene definido resumen");
                }

                //obtener fecha de noticia
                if(articulo.selectFirst("div.article-info").selectFirst("div.article-time")!=null) {
                    fecha = articulo.selectFirst("div.article-info").selectFirst("div.article-time").selectFirst("span").text();
                    System.out.println(fecha);
                    noticia.setFecha(NoticiaUtils.getFechaIso(fecha));
                }else {
                    System.out.println("no tiene definida fecha.Estableciendo fecha default");

                }
                System.out.println(noticia.toString());
                listaNoticias.add(noticia);
            }

            browser.close();
        } catch (Exception e) {
            throw new CustomInternalServerErrorException("");
        }
        return listaNoticias.toArray(NoticiaFotoDto[]::new);
    }

    public ApiKeyDTO getApiKeyStored(){
        return this.apiKeyRepository.findAll().get(0);
    }

    public NoticiaFotoDto[] getNoticiasWithPhoto(String textoBuscado) {
        System.out.println("buscando noticias relacionadas con: ");
        System.out.println(textoBuscado);
        String url = "https://www.abc.com.py/buscar/"+textoBuscado;
        ArrayList<NoticiaFotoDto> listaNoticias = new ArrayList<>();
        NoticiaFotoDto noticia = null;
        try (Playwright playwright = Playwright.create()) {
            final BrowserType chromium = playwright.chromium();
            final Browser browser = chromium.launch();
            Page page = browser.newPage();
            page.navigate(url);
            page.waitForLoadState(LoadState.NETWORKIDLE);
            final ElementHandle contentElement = page.querySelector("[class=article-list-wrapper]");
            //System.out.println(page.innerHTML("body"));
            Document docPrueba = null;
            if(contentElement==null) {
                listaNoticias.toArray(NoticiaFotoDto[]::new);
            }
            docPrueba = Jsoup.parse(contentElement.innerHTML());
            Elements articulos = docPrueba.select("div.item-article");
            String enlaceFoto="";
            String enlace="";
            String titulo="";
            String resumen="";
            String fecha="";
            String contenidoFoto="";
            String contentTypeFoto = "";
            for (Element articulo: articulos) {
                //obtener enlace de foto de noticia
                noticia = new NoticiaFotoDto();
                if(articulo.selectFirst("div.article-photo").selectFirst("img")!=null) {
                    enlaceFoto = articulo.selectFirst("div.article-photo").selectFirst("img").attr("src");
                    noticia.setEnlaceFoto(enlaceFoto);
                    contenidoFoto=NoticiaUtils.getBase64EncodedImage(enlaceFoto);
                    contentTypeFoto = NoticiaUtils.getImageContentType(enlaceFoto);
                    noticia.setContenidoFoto(contenidoFoto);
                    noticia.setContentTypeFoto(contentTypeFoto);
                }
                else {
                    System.out.println("no tiene atributo definido de img");
                }
                //obtener titulo noticia
                if(articulo.selectFirst("div.article-info").selectFirst("div.article-title")!=null) {
                    titulo = articulo.selectFirst("div.article-info").selectFirst("div.article-title").selectFirst("span").text();
                    noticia.setTitulo(titulo);
                }
                else {
                    System.out.println("no tiene definido titulo");
                }

                //obtener enlace noticia
                if(articulo.selectFirst("div.article-info").selectFirst("a")!=null) {
                    enlace = articulo.selectFirst("div.article-info").selectFirst("a").attr("href");
                    noticia.setEnlace(enlace);
                }
                else {
                    System.out.println("no tiene definido enlace");
                }

                //obtener texto de resumen de noticia
                if(articulo.selectFirst("div.article-info").selectFirst("div.article-intro")!=null) {
                    resumen = articulo.selectFirst("div.article-info").selectFirst("div.article-intro").selectFirst("p").text();
                    noticia.setResumen(resumen);
                }
                else {
                    System.out.println("no tiene definido resumen");
                }

                //obtener fecha de noticia
                if(articulo.selectFirst("div.article-info").selectFirst("div.article-time")!=null) {
                    fecha = articulo.selectFirst("div.article-info").selectFirst("div.article-time").selectFirst("span").text();
                    System.out.println(fecha);
                    noticia.setFecha(NoticiaUtils.getFechaIso(fecha));
                }else {
                    System.out.println("no tiene definida fecha.Estableciendo fecha default");

                }
                System.out.println(noticia.toString());
                listaNoticias.add(noticia);
            }

            browser.close();
        } catch (Exception e) {
            throw new CustomInternalServerErrorException("");
        }
        return listaNoticias.toArray(NoticiaFotoDto[]::new);
    }


}
