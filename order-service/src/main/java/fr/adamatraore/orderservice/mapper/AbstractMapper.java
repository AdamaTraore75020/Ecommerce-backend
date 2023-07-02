package fr.adamatraore.orderservice.mapper;

import java.util.List;

public interface AbstractMapper<T1, T2> {
    T2 mapFrom(T1 t1);
    T1 mapTo(T2 t2);
    List<T2> mapListFrom(List<T1> t1);
    List<T1> mapListTo(List<T2> t2);
}
