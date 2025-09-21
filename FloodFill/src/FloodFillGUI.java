import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// Classe que cria a janela e exibe a imagem
public class FloodFillGUI extends JPanel {
    private BufferedImage imagem;

    public FloodFillGUI(BufferedImage img) {
        this.imagem = img;
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, null);
    }

    // Atualiza a imagem exibida
    public void atualizar(BufferedImage novaImagem) {
        this.imagem = novaImagem;
        repaint(); // força redesenho da janela
    }

    // Método estático que cria a janela principal
    public static JFrame criarJanela(FloodFillGUI painel) {
        JFrame frame = new JFrame("Flood Fill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(painel);
        frame.pack();
        frame.setLocationRelativeTo(null); // centraliza na tela
        frame.setVisible(true);
        return frame;
    }
}
