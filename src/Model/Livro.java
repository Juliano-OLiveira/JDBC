 
package Model;

import Model.Autor;
import java.util.ArrayList;

 
public class Livro {
    private String titulo;
    private String isbn;
    private Integer edicao;
    private Autor autor;
     ArrayList<Livro> listLivro;

    public Livro(String titulo, String isbn, Integer edicao, Autor autor, ArrayList<Livro> listLivro) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.autor = autor;
        this.listLivro = listLivro;
    }

    public Livro() {
      
    }

   
    public ArrayList<Livro> getListLivro() {
        return listLivro;
    }

    public void setListLivro(ArrayList<Livro> listLivro) {
        this.listLivro = listLivro;
    }
     
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", isbn=" + isbn + ", edicao=" + edicao + '}';
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
}
