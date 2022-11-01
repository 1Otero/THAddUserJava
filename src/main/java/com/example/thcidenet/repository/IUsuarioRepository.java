package com.example.thcidenet.repository;

import com.example.thcidenet.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query(value = "SELECT COUNT(r.Id) FROM Registro r WHERE r.Correo_Electronico LIKE %?1% AND r.Id!=?2",nativeQuery = true)
    public int countCorreos(String correo,Long id);
}
