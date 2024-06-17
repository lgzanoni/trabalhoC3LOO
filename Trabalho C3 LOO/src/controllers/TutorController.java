/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import arquivos.Arquivos;
import arquivos.GravadorArquivos;
import arquivos.LeitorArquivoTutor;
import entities.Tutor;
import java.io.IOException;

/**
 *
 * @author Luis
 */
public class TutorController {
    
    private LeitorArquivoTutor leitor;

    public boolean registrar(Tutor u) {
        try {
            GravadorArquivos leitor = new GravadorArquivos(Arquivos.TUTORES);
            leitor.gravar(u.toString());
            leitor.fechar();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
