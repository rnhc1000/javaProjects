package br.dev.ferreiras.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.dev.ferreiras.Exception.NegocioException;

@ControllerAdvice
public class AlgaworksExceptionHandler extends ResponseEntityExceptionHandler {
	
	// interface spring para manipulçao de mensagens
	// DI ou outra possibilidade seria declarar um construtor
	//	protected AlgaworksExceptionHandler(MessageSource messageSource) {
	//	super();
	//	this.messageSource = messageSource;
	//}
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
		List<AlgaworksProblema.Campo> campos = new ArrayList<>();
		
		for  (ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			String nome  = ((FieldError)error).getField();
			//String mensagem = error.getDefaultMessage();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			campos.add(new AlgaworksProblema.Campo(nome, mensagem));
		}
		
		AlgaworksProblema algaworksProblema = new AlgaworksProblema();
		algaworksProblema.setStatus(status.value());
		algaworksProblema.setDataHora(LocalDateTime.now());
		algaworksProblema.setTitulo("Um ou mais campos estão inválidos");
		algaworksProblema.setCampos(campos);
		
		
		return handleExceptionInternal(ex, algaworksProblema, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		AlgaworksProblema algaworksProblema = new AlgaworksProblema();
		algaworksProblema.setStatus(status.value());
		algaworksProblema.setDataHora(LocalDateTime.now());
		algaworksProblema.setTitulo(ex.getMessage());
		return handleExceptionInternal(ex, algaworksProblema, new HttpHeaders(), status, request);
		
		
	}
}
