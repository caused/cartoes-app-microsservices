package br.com.mastertech.cartao.exception;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MastertechExceptionHandler extends ResponseEntityExceptionHandler{

	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		List<Error> erros = new ArrayList<Error>();
		
		erros.add(new Error("Requisição inválida"));
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> erros =  this.getErrorList(ex.getBindingResult());
		
		return handleExceptionInternal(ex,erros , headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ClienteNaoEncontradoException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(ClienteNaoEncontradoException ex, WebRequest request){
		
		List<Error> erros = new ArrayList<Error>();
		
		erros.add(new Error(ex.getMensagem()));
		
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({CartaoNaoExisteException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(CartaoNaoExisteException ex, WebRequest request){
		
		List<Error> erros = new ArrayList<Error>();
		
		erros.add(new Error(ex.getMensagem()));
		
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({CartaoExistenteException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(CartaoExistenteException ex, WebRequest request){
		
		List<Error> erros = new ArrayList<Error>();
		
		erros.add(new Error(ex.getMensagem()));
		
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({CartaoInativoException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(CartaoInativoException ex, WebRequest request){
		
		List<Error> erros = new ArrayList<Error>();
		
		erros.add(new Error(ex.getMensagem()));
		
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> getErrorList(BindingResult bindingResult){
		
		List<Error> erros = new ArrayList<Error>();
		for(FieldError field : bindingResult.getFieldErrors()){
			String mensagemUsuario = field.getDefaultMessage();
			
			erros.add(new Error(mensagemUsuario));
		}
		
		
		return erros;
	}
}
