package com.agora.retobackend.repository;

import com.agora.retobackend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRespository extends JpaRepository<Client,Integer> {
    public Client findClientByDni(int dni);
    public Client findClientByEmail(String email);
    @Query("SELECT COUNT(c) FROM Client c WHERE MONTH(c.dBirth) = :month")
    public Integer countClientsByDBirth_Month(@Param("month") Integer mes);

    @Query("SELECT COUNT(c) FROM Client c WHERE YEAR(c.dBirth) = :year")
    public Integer countClientsByDBirth_Year(@Param("year") Integer year);

    @Query("SELECT YEAR(c.dBirth) AS year, COUNT(c) AS count FROM Client c GROUP BY YEAR(c.dBirth) ORDER BY COUNT(c) DESC")
    List<Object[]> moreClientesByYear();

    @Query("SELECT MONTH(c.dBirth) AS month, COUNT(c) AS count FROM Client c GROUP BY MONTH(c.dBirth) ORDER BY COUNT(c) DESC")
    List<Object[]> moreClientesByMonth();

    @Query("SELECT YEAR(c.dBirth) AS year, COUNT(c) AS count FROM Client c GROUP BY YEAR(c.dBirth) ORDER BY COUNT(c) ASC")
    List<Object[]> lessClientesByYear();

    @Query("SELECT MONTH(c.dBirth) AS month, COUNT(c) AS count FROM Client c GROUP BY MONTH(c.dBirth) ORDER BY COUNT(c) ASC")
    List<Object[]> lessClientesByMonth();

    @Query("SELECT MONTH(c.dBirth) AS mes, COUNT(c) AS count FROM Client c GROUP BY MONTH(c.dBirth)")
    List<Object[]> birthrateByMonth();

}
