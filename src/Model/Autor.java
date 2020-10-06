 

package Model;

import java.util.ArrayList;
import java.util.List;

 
public class Autor {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List autor;
    private Livro livro;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    

    public Autor(int id, String nome, String endereco, String telefone, String email, List autor, Livro livro) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.autor = autor;
        this.livro = livro;
    }

    public Autor() {
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getAutor() {
        return autor;
    }

    public void setAutor(ArrayList autor) {
        this.autor = autor;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", autor=" + autor + '}';
    }

   
   
    
}
