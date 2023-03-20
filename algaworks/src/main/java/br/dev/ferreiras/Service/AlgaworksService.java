package br.dev.ferreiras.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.ferreiras.Model.AlgaworksModel;
import br.dev.ferreiras.Repository.AlgaworksRepository;
import br.dev.ferreiras.Exception.NegocioException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlgaworksService {
	
	private AlgaworksRepository algaworksRepository;
	
	@Transactional
	public AlgaworksModel salvar(AlgaworksModel algaworksModel) {
		
		
		boolean emailEmUso = algaworksRepository.findByEmail(algaworksModel.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(algaworksModel));
		
		if (emailEmUso) {
			
			throw new NegocioException("Já existe um cliente cadastrado com este email");
		}
		
		return algaworksRepository.save(algaworksModel);
		
	}
	
	@Transactional
	public void  excluir(Long userId) {
		
		algaworksRepository.deleteById(userId );
		
	}

}
