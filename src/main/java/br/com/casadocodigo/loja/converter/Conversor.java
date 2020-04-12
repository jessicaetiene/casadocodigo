package br.com.casadocodigo.loja.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Conversor<E, T> {

    T converterParaDTO(E entidade);

    E converterParaEntidade(T dto);

    default List<T> converterParaDTO(List<E> listaEntidade){
        return listaEntidade.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    default List<E> converterParaEntidade(List<T> listaEntidade){
        return listaEntidade.stream().map(this::converterParaEntidade).collect(Collectors.toList());
    }

}
