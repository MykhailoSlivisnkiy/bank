package com.bank.application.mapper;

public interface Mapper<E, D> {
    D convertToDto(E e);
    E convertToEntity(D d);
}
