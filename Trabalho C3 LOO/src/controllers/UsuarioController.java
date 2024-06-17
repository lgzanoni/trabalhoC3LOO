/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import arquivos.Arquivos;
import arquivos.GravadorArquivos;
import arquivos.LeitorArquivoUsuarios;
import entities.Aluno;
import entities.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class UsuarioController {

    private LeitorArquivoUsuarios leitor;

    public Usuario verificarLogin(String usuario, String senha) throws IOException {
        try {
            leitor = new LeitorArquivoUsuarios();
            Usuario uRetorno = null;
            for (Usuario u : leitor.ler()) {
                if (usuario.equals(u.getLogin())
                        && senha.equals(u.getSenha())) {
                    uRetorno = u;
                    break;
                }
            }
            leitor.fechar();
            return uRetorno;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registrar(Usuario u) {
        try {
            GravadorArquivos leitor = new GravadorArquivos(Arquivos.USUARIOS);
            leitor.gravar(u.toString());
            leitor.fechar();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
