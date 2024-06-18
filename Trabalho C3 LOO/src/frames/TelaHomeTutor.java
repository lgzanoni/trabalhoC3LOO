package frames;

import arquivos.LeitorArquivoAluno;
import entities.Aluno;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Luis
 */
public class TelaHomeTutor extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private JPanel panelCards;
    private JScrollPane scrollPane;
    private JPanel sideMenuPanel;
    private LeitorArquivoAluno leitor;
    private boolean isMenuVisible = false;

    public TelaHomeTutor(MainFrame mainFrame) throws IOException {
        this.mainFrame = mainFrame;
        setSize(1080, 900);
        setLayout(new BorderLayout());
        setBackground(Styles.BACKGROUND_COLOR);

        // Painel Superior
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1080, 100));
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Styles.BACKGROUND_COLOR);
        topPanel.setBorder(BorderFactory.createLineBorder(Styles.PANEL_BORDER_COLOR));
        JLabel labelTitulo = new JLabel("ESTUDAAI", SwingConstants.CENTER);
        labelTitulo.setForeground(Styles.PANEL_BORDER_COLOR);
        labelTitulo.setSize(new Dimension(200, 100));
        labelTitulo.setFont(new Font("Calibri", Font.BOLD, 36));
        topPanel.add(labelTitulo, BorderLayout.CENTER);

        String basePath = new File(System.getProperty("user.dir")).getAbsolutePath();
        String iconPath = basePath + File.separator + "files" + File.separator + "icon.png";
        ImageIcon menuIcon = new ImageIcon(iconPath);
        System.out.println("Caminho do ícone do menu: " + iconPath);
        if (menuIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Erro ao carregar o ícone: " + iconPath);
        }
                // Redimensionar a imagem
        Image image = menuIcon.getImage(); // transforma o ícone em Image
        Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // escala a imagem
        menuIcon = new ImageIcon(newimg);  // transforma de volta para ImageIcon
        JLabel menuLabel = new JLabel(menuIcon);
        menuLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleMenu();
            }
        });
        topPanel.add(menuLabel, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);

        sideMenuPanel = new JPanel();
        sideMenuPanel.setLayout(new BorderLayout());
        sideMenuPanel.setPreferredSize(new Dimension(250, getHeight()));
        sideMenuPanel.setBackground(Styles.MENU_COLOR);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> mainFrame.showCard("Login"));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(Styles.MENU_COLOR);
        bottomPanel.add(btnSair);

        sideMenuPanel.add(bottomPanel, BorderLayout.SOUTH);
        sideMenuPanel.setVisible(false); // O menu começa oculto

        add(sideMenuPanel, BorderLayout.WEST);

        // Configuração dos cards
        panelCards = new JPanel();
        panelCards.setLayout(new BoxLayout(panelCards, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(panelCards,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        // Adicionando cards
        adicionarCards();
    }

    private void toggleMenu() {
        isMenuVisible = !isMenuVisible;
        sideMenuPanel.setVisible(isMenuVisible);
        revalidate();
        repaint();
    }

    private void adicionarCards() throws IOException {
        leitor = new LeitorArquivoAluno();
        for (Aluno a : leitor.ler()) {
            TutorCard card = new TutorCard("Aluno " + a.getNome(), "Quero ajuda na materia: " + a.getMateriaDesejada(), "Enviar mensagem para aluno!");
            JButton btnMessage = card.getBtnAcao();  // Supondo que TutorCard tem um método getButton()
            btnMessage.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MessageDialog dialog = new MessageDialog(JFrame.getFrames()[0]);  // Pega o frame principal
                    dialog.setVisible(true);
                }
            });
            panelCards.add(card);
            panelCards.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre cards
        }
        panelCards.revalidate();
        panelCards.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
