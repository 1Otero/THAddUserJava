package com.example.thcidenet.repository;

import com.example.thcidenet.modelo.Registro;
import com.example.thcidenet.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegistroRepository extends JpaRepository<Registro,Long> {
    @Query(value = "SELECT * FROM Registro r WHERE r.Usuario_Id =?1",nativeQuery = true)
    public Registro findByIdUser(Long Id);
}
