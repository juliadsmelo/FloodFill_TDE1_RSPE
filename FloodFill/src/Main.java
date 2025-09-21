import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Verifica se a pasta de saída existe; se não, cria
        File pastaSaida = new File("saida");
        if (!pastaSaida.exists()) {
            pastaSaida.mkdir();
            System.out.println("Pasta 'saida' criada.");
        }

        // 2. Carrega a imagem de entrada da pasta images
        BufferedImage entrada = ImageIO.read(new File("C:/Users/meloj/OneDrive/Área de Trabalho/TDE1_RSPE/FloodFill/images/entrada.png"));

        // 3. Cria painel e janela
        FloodFillGUI painel = new FloodFillGUI(entrada);
        FloodFillGUI.criarJanela(painel);

        // 4. Executa Flood Fill em uma nova thread (não trava a GUI)
        new Thread(() -> {
            try {
                // USANDO PILHA
                FloodFillPilha floodPilha = new FloodFillPilha(entrada, painel);
                floodPilha.preencher(0, 0, 0xFF0000); // vermelho


                // USANDO FILA (se quiser testar, comente a parte acima e descomente abaixo)
                /*
                FloodFillFila floodFila = new FloodFillFila(entrada, painel);
                floodFila.preencher(10, 10, 0x0000FF); // azul
                */

                // 5. Salva o resultado final na pasta saida
                ImageIO.write(entrada, "png", new File("saida/final.png"));
                System.out.println("Flood Fill concluído! Resultado salvo em 'saida/final.png'.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
