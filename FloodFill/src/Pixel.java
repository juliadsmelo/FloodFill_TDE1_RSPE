/*
Essa classe é só para guardar as coordenadas (x, y) de cada
ponto da imagem/matriz
*/

public class Pixel {
    public int x;
    public int y;

    public Pixel(int x, int y){
        this.x = x;
        this.y = y;
    }
}

/*
Explicação:
x = linha da matriz
y = coluna da matriz
Ex.: Cria-se 'new Pixel(2,3)' para representar a posição '(2,3)'.
 */