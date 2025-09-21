import java.awt.image.BufferedImage;

// Implementação do Flood Fill usando Pilha
public class FloodFillPilha {
    private BufferedImage imagem;
    private int novaCor;
    private int corOriginal;
    private FloodFillGUI painel;

    public FloodFillPilha(BufferedImage img, FloodFillGUI painel) {
        this.imagem = img;
        this.painel = painel;
    }

    public void preencher(int startX, int startY, int novaCor) throws InterruptedException {
        this.novaCor = novaCor;
        this.corOriginal = imagem.getRGB(startX, startY);

        Stack<Pixel> pilha = new Stack<>(imagem.getWidth() * imagem.getHeight());
        pilha.push(new Pixel(startX, startY));

        while (!pilha.isEmpty()) {
            Pixel p = pilha.pop();

            if (valido(p.x, p.y)) {
                imagem.setRGB(p.x, p.y, novaCor);

                painel.atualizar(imagem); // atualiza GUI
                Thread.sleep(1); // pausa para animação visível

                pilha.push(new Pixel(p.x + 1, p.y));
                pilha.push(new Pixel(p.x - 1, p.y));
                pilha.push(new Pixel(p.x, p.y + 1));
                pilha.push(new Pixel(p.x, p.y - 1));
            }
        }
    }

    private boolean valido(int x, int y) {
        return x >= 0 && x < imagem.getWidth() &&
                y >= 0 && y < imagem.getHeight() &&
                imagem.getRGB(x, y) == corOriginal;
    }
}
