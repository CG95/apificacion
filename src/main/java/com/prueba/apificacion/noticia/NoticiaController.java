package com.prueba.apificacion.noticia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/consulta")
public class NoticiaController {

    private NoticiaService noticiaService;

    @GetMapping
    public NoticiaDto[] getNoticiasByTexto(@RequestParam("q") Optional<String> textoBuscadoParam){
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
        NoticiaDto[] arrayNoticiasRetornadas = noticiaService.getNoticiasByText(textoBuscado);
        if (arrayNoticiasRetornadas.length==0){
            throw new NotFoundException("","g267","No se encuentran noticias para el texto:{"+ textoBuscado+"}");
        }
        return arrayNoticiasRetornadas;
    }

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = new NoticiaService();
    }

}
