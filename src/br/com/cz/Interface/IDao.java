package br.com.cz.Interface;
import java.util.List;

public interface IDao<T> {
    boolean adicionar(T objeto);
    boolean remover(T objeto);
    boolean atualizar(String identificador, T objeto);
    T buscar(String identificador);
    List<T> listar();
}
