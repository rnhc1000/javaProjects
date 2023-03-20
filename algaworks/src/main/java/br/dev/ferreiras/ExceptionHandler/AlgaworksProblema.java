package br.dev.ferreiras.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class AlgaworksProblema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
//	public void setDataHora(LocalDateTime now) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void setStatus(int value) {
//		// TODO Auto-generated method stub
//		
//	}
	
	private List<Campo> campos;
	@Getter
	@Setter
	public static class Campo {
		
		protected Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
		private String nome;
		private String mensagem;
	}
	
}
