package com.prueba.apificacion.noticia;

import com.prueba.apificacion.db.ApiKeyDTO;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/consulta")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping(produces={MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_PLAIN_VALUE,
            MediaType.TEXT_HTML_VALUE}
    )
    public NoticiaFotoDto[] getNoticiasByTexto(@RequestParam("q") Optional<String> textoBuscadoParam,
                                           @RequestParam("f") Optional<String> cargarFotosParam,
                                           @RequestHeader Map<String, String> headers){
        //primeramente se verifica el api key
        Base64 base64 = new Base64();
        boolean accesoPermitido = false;
        if(headers.containsKey("authorization")){
            System.out.println("header de autorizacion");
            String auth = (String) headers.get("authorization");
            System.out.println(auth);
            //String decodedString = new String(base64.decode(auth.getBytes()));
            //obtener parte correspondiente a clave
            String apiKeyClient = auth.split(" ")[1];
            String decodedApiKeyClient = new String(base64.decode(apiKeyClient.getBytes()));
            System.out.println("decodedApiKeyClient="+decodedApiKeyClient);
            ApiKeyDTO apiKeyDTO = noticiaService.getApiKeyStored();
            accesoPermitido = NoticiaUtils.assertEquals(apiKeyDTO,decodedApiKeyClient);
            System.out.println("accesoPermitido?====>"+accesoPermitido);
            if (!accesoPermitido){
                throw new CustomForbiddenErrorException("");
            }
        }else {
            throw new CustomForbiddenErrorException("");
        }
        if (textoBuscadoParam.isPresent()){
            System.out.println("textoBuscado esta presente");
        }else{
            throw new InvalidQueryParametersException("","g268","Parámetros inválidos");
        }
        String textoBuscado = textoBuscadoParam.get();

        if(textoBuscado==null || textoBuscado.length()==0){
            throw new InvalidQueryParametersException("","g268","Parámetros inválidos");
        }
        System.out.println(textoBuscado);


        //obtener noticias
        NoticiaFotoDto[] arrayNoticiasRetornadas = null;
        if(cargarFotosParam.isPresent() && cargarFotosParam.get().equals("true")){
            arrayNoticiasRetornadas = noticiaService.getNoticiasWithPhoto(textoBuscado);
        }else {
            arrayNoticiasRetornadas = noticiaService.getNoticiasWithoutPhoto(textoBuscado);
        }
        if (arrayNoticiasRetornadas.length==0){
            throw new NotFoundException("","g267","No se encuentran noticias para el texto:{"+ textoBuscado+"}");
        }
        return arrayNoticiasRetornadas;
    }






    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = new NoticiaService();
    }

}
