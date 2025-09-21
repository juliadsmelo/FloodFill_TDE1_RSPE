import java.awt.image.BufferedImage;

// Implementação do Flood Fill usando Fila
public class FloodFillFila {
    private BufferedImage imagem;
    private int novaCor;
    private int corOriginal;
    private FloodFillGUI painel;

    public FloodFillFila(BufferedImage img, FloodFillGUI painel) {
        this.imagem = img;
        this.painel = painel;
    }

    public void preencher(int startX, int startY, int novaCor) throws InterruptedException {
        this.novaCor = novaCor;
        this.corOriginal = imagem.getRGB(startX, startY);

        Queue<Pixel> fila = new Queue<>(imagem.getWidth() * imagem.getHeight());
        fila.enqueue(new Pixel(startX, startY));

        while (!fila.isEmpty()) {
            Pixel p = fila.dequeue();

            if (valido(p.x, p.y)) {
                imagem.setRGB(p.x, p.y, novaCor);

                painel.atualizar(imagem); // atualiza GUI
                Thread.sleep(1); // pausa para animação visível

                fila.enqueue(new Pixel(p.x + 1, p.y));
                fila.enqueue(new Pixel(p.x - 1, p.y));
                fila.enqueue(new Pixel(p.x, p.y + 1));
                fila.enqueue(new Pixel(p.x, p.y - 1));
            }
        }
    }

    private boolean valido(int x, int y) {
        return x >= 0 && x < imagem.getWidth() &&
                y >= 0 && y < imagem.getHeight() &&
                imagem.getRGB(x, y) == corOriginal;
    }
}
