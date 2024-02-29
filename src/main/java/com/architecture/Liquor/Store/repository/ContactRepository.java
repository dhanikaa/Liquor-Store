package com.architecture.Liquor.Store.repository;


import com.architecture.Liquor.Store.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
