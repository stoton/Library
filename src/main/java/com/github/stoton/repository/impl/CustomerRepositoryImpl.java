package com.github.stoton.repository.impl;

import com.github.stoton.domain.Book;
import com.github.stoton.domain.Customer;
import com.github.stoton.repository.BookRepository;
import com.github.stoton.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository<Customer> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAll() {
        return getSession().createCriteria(Customer.class).list();
    }

    @Override
    public void save(Customer customer) {
        getSession().save(customer);
    }

    @Override
    public void update(Customer customer) {
        getSession().update(customer);
    }

    @Override
    public boolean isExist(Customer customer) {
        return getSession().createQuery(
                "from " + Customer.class.getName() +  " where pesel = :pesel")
                .setParameter("pesel", customer.getPesel())
                .uniqueResult() != null;
    }

    @Override
    public Customer find(long id) {
        Customer customer = (Customer) getSession().createQuery("from " + Customer.class.getName() + " where id = :id")
                .setParameter("id", id).uniqueResult();
        return customer;
    }

    @Override
    public void delete(long id) {
        getSession().delete(id);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
