package edu.pucmm.practica11_Quiz3.repository;


import edu.pucmm.practica11_Quiz3.modelo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String>{

    Client findByIdentificationNumber(String identificationNumber);
}
