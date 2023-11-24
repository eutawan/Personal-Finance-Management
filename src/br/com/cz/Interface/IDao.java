package br.com.cz.Interface;
import java.util.List;
import java.util.UUID;

public interface IDao<T> {
    boolean adicionar(T objeto);
    boolean remover(T objeto);
    boolean atualizar(T objeto);
    T buscar(UUID idDoObjeto);
    List<T> listar();
}
