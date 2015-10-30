package com.controllers;

import com.models.Documento;
import com.models.DocumentoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alaor on 30/10/15.
 */
@RestController
public class DocumentoController {

    @Autowired
    private DocumentoDAO documentoDAO;

    @RequestMapping("/list")
    @ResponseBody
    public List<Documento> list(){
        return (List<Documento>) documentoDAO.findAll();
    }

    @RequestMapping("/create")
    @ResponseBody
    public void create(String titulo, String codigo, String texto) {

        Documento documento = new Documento(titulo, codigo, texto);

        try {

            documentoDAO.save(documento);

        }catch (Exception e) {

            System.out.println(e.getMessage());

        }

        System.out.println("Documento criado com sucesso.");
    }

    @RequestMapping("/update")
    @ResponseBody
    public void updateUser(long id, String titulo, String codigo, String texto) {

        try {
            Documento documento = documentoDAO.findOne(id);
            documento.setTitulo(titulo);
            documento.setCodigo(codigo);
            documento.setTexto(texto);
            documentoDAO.save(documento);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Documento alterado com sucesso.");

    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(long id) {
        try {
            Documento documento = new Documento(id);
            documentoDAO.delete(documento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Documento removido com sucesso.");
    }

}
