package br.dev.ferreiras.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.ferreiras.Model.AlgaworksModel;
import br.dev.ferreiras.Repository.AlgaworksRepository;
import br.dev.ferreiras.Service.AlgaworksService;
import br.dev.ferreiras.ExceptionHandler.AlgaworksExceptionHandler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class AlgaworksController {
	
	protected AlgaworksController() {
	}
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@Autowired
	private AlgaworksRepository algaworksRepository;	
// Injecao via construtor
//	protected AlgaworksController(AlgaworksRepository algaworksRepository) {
//		super();
//		this.algaworksRepository = algaworksRepository;
//	}
	@Autowired
	private AlgaworksService algaworksService;

//	@GetMapping("/users")
	@GetMapping
	public List<AlgaworksModel> listar() {
		
		
//		String jpql = "Select * from AlgaworksModel";
//		TypedQuery<AlgaworksModel> query = entityManager.createQuery(jpql, AlgaworksModel.class);
//		
//		return query.getResultList();
		
//		return entityManager.createQuery("from AlgaworksModel", AlgaworksModel.class)
//				.getResultList();
//		
		
		return algaworksRepository.findAll();
//		return algaworksRepository.findByNomeContaining("Ricardo");
//		AlgaworksModel algaworksmodelOne = new AlgaworksModel();
//		algaworksmodelOne.setId(1L);
//		algaworksmodelOne.setNome("Ricardo Ferreira");
//		algaworksmodelOne.setEndereco("R Santo Agapito, 7");
//		algaworksmodelOne.setCpf("916.217.048-15");
//		algaworksmodelOne.setIdade(65);
//		algaworksmodelOne.setEmail("ricardo@ferreiras.dev.br");
//		
//		AlgaworksModel algaworksmodelTwo = new AlgaworksModel();
//		algaworksmodelTwo.setId(1L);
//		algaworksmodelTwo.setNome("Ricardo A F Silva");
//		algaworksmodelTwo.setEndereco("R Santo Agapito, 7");
//		algaworksmodelTwo.setCpf("916.217.048-15");
//		algaworksmodelTwo.setIdade(65);
//		algaworksmodelTwo.setEmail("rnhc1000@gmail.com");
//		return Arrays.asList(algaworksmodelOne, algaworksmodelTwo);
	
	}
	
//	@GetMapping("/users/{userId}")
	@GetMapping("/{userId}")
	public ResponseEntity<AlgaworksModel> buscar(@PathVariable Long userId) {
		
		Optional<AlgaworksModel> algaworksModel = algaworksRepository.findById(userId);
		
//		return algaworksModel.orElse(null);
		
		if (algaworksModel.isPresent() ) {
			
			return ResponseEntity.ok(algaworksModel.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AlgaworksModel adicionar(@Valid @RequestBody AlgaworksModel algaworksModel) {
		
		//return algaworksRepository.save(algaworksModel);
		return algaworksService.salvar(algaworksModel);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<AlgaworksModel> atualizar(@PathVariable Long userId, @Valid @RequestBody AlgaworksModel algaworksModel) {
		
		if (!algaworksRepository.existsById(userId)) {
			
			return ResponseEntity.notFound().build();
			
		}
		algaworksModel.setId(userId);
		//algaworksModel = algaworksRepository.save(algaworksModel);
		algaworksModel = algaworksService.salvar(algaworksModel);

		return ResponseEntity.ok(algaworksModel);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> remover(@PathVariable Long userId) {
		
		if (!algaworksRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		
		//algaworksRepository.deleteById(userId);
		algaworksService.excluir(userId);
		return ResponseEntity.noContent().build();
		
	}
}
