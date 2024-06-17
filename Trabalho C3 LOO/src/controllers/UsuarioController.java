/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import arquivos.LeitorArquivoUsuarios;
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
public abstract class UsuarioController {

    public boolean verificarLogin(String usuario, String senha) {
        try {
            File arquivo = new File("usuarios.txt");
            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()) {
                String[] dados = leitor.nextLine().split(",");
                if (dados[0].equals(usuario) && dados[1].equals(senha)) {
                    return true;
                }
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}