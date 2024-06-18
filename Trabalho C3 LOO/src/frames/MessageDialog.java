/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frames;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luis
 */
public class MessageDialog extends JDialog {

    private JTextField txtSubject;
    private JTextArea txtMessage;
    private JButton btnSend, btnCancel, btnAttach;
    private JLabel lblAttachedFile;
    private File attachedFile;

    public MessageDialog(Frame owner) {
        super(owner, "Enviar Mensagem", true);
        setSize(400, 350);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        txtSubject = new JTextField();
        txtMessage = new JTextArea(5, 20);
        txtMessage.setWrapStyleWord(true);
        txtMessage.setLineWrap(true);

        panel.add(new JLabel("Assunto:"));
        panel.add(txtSubject);
        panel.add(new JLabel("Mensagem:"));
        panel.add(new JScrollPane(txtMessage));

        lblAttachedFile = new JLabel("Nenhum arquivo selecionado");
        btnAttach = new JButton("Anexar Arquivo");
        btnAttach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(MessageDialog.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    attachedFile = fileChooser.getSelectedFile();
                    lblAttachedFile.setText("Anexado: " + attachedFile.getName());
                }
            }
        });
        panel.add(btnAttach);
        panel.add(lblAttachedFile);

        add(panel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        btnSend = new JButton("Enviar");
        btnCancel = new JButton("Cancelar");
        buttonsPanel.add(btnSend);
        buttonsPanel.add(btnCancel);
        add(buttonsPanel, BorderLayout.SOUTH);

        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulação de envio de mensagem
                JOptionPane.showMessageDialog(MessageDialog.this,
                        "Mensagem enviada com sucesso!\nAnexo: " + (attachedFile != null ? attachedFile.getName() : "Nenhum"),
                        "Informação",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
