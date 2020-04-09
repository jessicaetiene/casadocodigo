package br.com.casadocodigo.loja.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Conversor<E, T> {

    T converter(E entidade);

    default List<T> converterList(List<E> listaEntidade){
        return listaEntidade.stream().map(this::converter).collect(Collectors.toList());
    }

}
