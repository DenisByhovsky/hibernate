package com.byhovsky.hibernate.repository;

import java.util.List;

public interface DAOInterface<T> {
    /**
     * create
     *
     * @param t Entity
     */
    void create(T t);

    /**
     * delete
     *
     * @param id Entity id
     */
    void delete(long id);

    /**
     * read
     *
     * @return list.
     */
    List<T> read();

    /**
     * update
     *
     * @param id Entity id.
     */
    void update(long id);
}
