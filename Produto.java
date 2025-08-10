package atv01_jefte;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

public class Produto {
    private String codigo;
    private String descricao;
    private Double preco;
    private String imagem;
    Scanner scanner = new Scanner(System.in);

    public Produto(String codigo, String descricao, Double preco, String imagem){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    // getters
    public String getCodigo() {
        return codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }

    // setters

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void editarProduto(int opcao){
        switch (opcao){
            case 1:
                System.out.println("Digite o  novo código: ");
                setCodigo(scanner.nextLine());
                break;
            case 2:
                System.out.println("Digite a nova descrição: ");
                setDescricao(scanner.nextLine());
                break;
            case 3:
                System.out.println("Digite o novo preço: ");
                setPreco(scanner.nextDouble());
                scanner.nextLine();
                break;
            case 4:
                System.out.println("Atualize a nova imagem: ");
                setImagem(scanner.nextLine());
                break;
        }
        System.out.println("Produto atualizado!!\n");
    }

    public void mover(String caminhoOrigem) {
        try {
            Path origem = Paths.get(caminhoOrigem);
            Path nomeArquivo = origem.getFileName();
            Path pastaDestino = Paths.get("//Caminho de destino que deseja//");
            Path destino = pastaDestino.resolve(nomeArquivo);

            Files.move(origem, destino, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Imagem movida com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao mover a imagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Descrição: " + descricao + "\n" +
                "Preço: " + preco + "\n" +
                "Imagem: " + imagem;
    }
}

