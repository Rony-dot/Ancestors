package com.ancestors.exception;

import com.ancestors.exception.model.ErrorResponse;
import com.ancestors.exception.model.ItemValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    public static final String VALIDATION_ERROR = "validation_error";
//    /**
//     * Handle TypeMismatchException. Triggered when a 'required' request parameter is missing.
//     *
//     * @param ex      MethodArgumentNotValidException.class
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ErrorResponse object
//     */
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        ErrorResponse response = new ErrorResponse(VALIDATION_ERROR, "Request is not valid");
//        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
//        List<ItemValidationError> validationErrors = new LinkedList<>();
//        fieldErrors.forEach((v) -> {
//            validationErrors.add(new ItemValidationError(v.getObjectName(), v.getField(), v.getRejectedValue(), v.getDefaultMessage()));
//        });
//        response.setErrorItems(validationErrors);
//
//        return this.handleExceptionInternal(ex, response, headers, status, request);
//    }
//
//    /**
//     * Handle TypeMismatchException. Triggered when a 'required' request parameter is missing.
//     *
//     * @param ex      BindException.class
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ErrorResponse object
//     */
//    protected ResponseEntity<Object> handleBindException(
//            BindException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        ErrorResponse response = new ErrorResponse(VALIDATION_ERROR, "Request is not valid");
//        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
//        List<ItemValidationError> validationErrors = new LinkedList<> ();
//        fieldErrors.forEach((v) -> {
//            validationErrors.add(new ItemValidationError(v.getObjectName(), v.getField(), v.getRejectedValue(), v.getDefaultMessage()));
//        });
//        response.setErrorItems(validationErrors);
//
//        return this.handleExceptionInternal(ex, response, headers, status, request);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
//                                                             @Nullable Object body,
//                                                             HttpHeaders headers,
//                                                             HttpStatus status,
//                                                             WebRequest request) {
//        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//            request.setAttribute("javax.servlet.error.exception", ex, 0);
//        }
//        if (body == null) {
//            body = new ErrorResponse(ex.getClass().getName(), ex.getMessage());
//
//        }
//        StackTraceElement[] trace = ex.getStackTrace();
//        StringBuilder traceLines = new StringBuilder();
//        traceLines.append("Caused By: ").append(ex.fillInStackTrace()).append("\n");
//        Arrays.stream(trace).filter(f -> f.getClassName().contains("com.ancestors"))
//                .forEach(traceElement -> traceLines.append("\tat ").append(traceElement).append("\n"));
//        log.error("tracelines : {}",traceLines);
//        System.out.println(ex.getClass().getName());
//        System.out.println(ex.getMessage());
//        System.out.println(ex.getLocalizedMessage());
//        return new ResponseEntity(body, headers, status);
//    }


    @ExceptionHandler(ResourceDoesNotExistException.class)
    public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest webRequest){
        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(),
                webRequest.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionModel,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Object> handleAlreadyExistsException(Exception ex, WebRequest webRequest){
        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(),
                webRequest.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionModel,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel("provided input is not valid",
                ex.getBindingResult().toString(), LocalDateTime.now());
        return new ResponseEntity<Object>(exceptionModel, HttpStatus.BAD_REQUEST);
    }
}
