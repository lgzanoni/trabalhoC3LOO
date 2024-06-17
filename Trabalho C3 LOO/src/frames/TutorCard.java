/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class TutorCard extends JPanel {
    
    private JLabel lblNome;
    private JLabel lblMateria;
    private JButton btnAcao;

    public TutorCard(String nome, String materia, String acaoText) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        lblNome = new JLabel(nome);
        lblMateria = new JLabel(materia);

        btnAcao = new JButton(acaoText);
        // Adicione um ActionListener ao btnAcao se necessário

        JPanel topPanel = new JPanel(new GridLayout(0, 1));
        topPanel.add(lblNome);
        topPanel.add(lblMateria);

        add(topPanel, BorderLayout.CENTER);
        add(btnAcao, BorderLayout.SOUTH);
    }
    
}
