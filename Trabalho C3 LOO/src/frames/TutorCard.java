/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
        setBackground(Styles.CARD_COLOR);
        setBorder(BorderFactory.createLineBorder(Styles.PANEL_BORDER_COLOR));

        lblNome = new JLabel(nome);
        lblNome.setForeground(Styles.PANEL_BORDER_COLOR);
        lblMateria = new JLabel(materia);
        lblMateria.setForeground(Styles.PANEL_BORDER_COLOR);

        btnAcao = new JButton(acaoText);
        // Adicione um ActionListener ao btnAcao se necessário

        JPanel topPanel = new JPanel(new GridLayout(0, 1));
        topPanel.setBackground(Styles.CARD_COLOR);
        topPanel.add(lblNome);
        topPanel.add(lblMateria);

        add(topPanel, BorderLayout.CENTER);
        add(btnAcao, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(300, 100)); // Defina um tamanho preferido adequado
        setMinimumSize(new Dimension(300, 100));
    }

    public JButton getBtnAcao() {
        return btnAcao;
    }

}
