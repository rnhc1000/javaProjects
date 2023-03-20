package br.dev.ferreiras.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.dev.ferreiras.Model.AlgaworksModel;

@Repository
public interface AlgaworksRepository extends JpaRepository<AlgaworksModel, Long>{

	List<AlgaworksModel> findAll();
	List<AlgaworksModel> findByNome(String nome);
	List<AlgaworksModel> findByNomeContaining(String nome);
	Optional<AlgaworksModel> findByEmail(String email);

	
}
