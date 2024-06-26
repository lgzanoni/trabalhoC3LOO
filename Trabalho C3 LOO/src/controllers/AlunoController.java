/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import arquivos.Arquivos;
import arquivos.GravadorArquivos;
import entities.Aluno;
import java.io.IOException;

/**
 *
 * @author Luis
 */
public class AlunoController {
    
    public boolean registrar(Aluno u)
    {
        try {
            GravadorArquivos leitor = new GravadorArquivos(Arquivos.ALUNOS);
            leitor.gravar(u.toString());
            leitor.fechar();
            return true;
        }
        catch(IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
