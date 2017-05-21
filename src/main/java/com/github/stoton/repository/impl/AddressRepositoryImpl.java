package com.github.stoton.repository.impl;

import com.github.stoton.domain.Address;
import com.github.stoton.repository.AddressRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressRepositoryImpl implements AddressRepository<Address> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Address> getAll() {
        return getSession().createCriteria(Address.class).list();
    }

    @Override
    public void save(Address object) {
        getSession().save(object);
    }

    @Override
    public void update(Address object) {
        getSession().update(object);
    }

    @Override
    public void delete(long id) {
        getSession().delete(id);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
