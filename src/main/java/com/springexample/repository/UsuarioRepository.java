package com.springexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springexample.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findById(int id);


	@Query(value = "select * from usuario where id = (select min(id) from usuario)", nativeQuery = true)
	public List<Usuario> buscarMenor();

	@Query(value = "select * from usuario where codigo = (select max(id) from usuario)", nativeQuery = true)
	public List<Usuario> buscarMaior();

	@Query(value = "select * from usuario", nativeQuery = true)
	public List<Usuario> buscarTodos();
	
	@Query(value = "select * from usuario where id = :id", nativeQuery = true)
	Usuario findOne(@Param("id") String searchTerm);
	
	
	
}
