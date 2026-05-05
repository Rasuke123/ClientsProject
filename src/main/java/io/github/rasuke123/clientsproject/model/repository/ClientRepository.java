package io.github.rasuke123.clientsproject.model.repository;

import io.github.rasuke123.clientsproject.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {



}
