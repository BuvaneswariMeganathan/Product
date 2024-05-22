package com.nielseniq.prodcut.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nielseniq.prodcut.dto.response.BaseResponse;
import com.nielseniq.prodcut.utils.InfoId;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ProductExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<String> errorList = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errorList.add(error.getDefaultMessage())
        );
        return BaseResponse.builder().infoId(InfoId.REQUEST_NOT_VALID).infoMsg(errorList.toString()).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
        return BaseResponse.builder().infoId(InfoId.REQUEST_NOT_VALID).infoMsg(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnexpectedTypeException.class)
    public BaseResponse handleUnexpectedType(UnexpectedTypeException ex) {
        return BaseResponse.builder().infoId(InfoId.REQUEST_NOT_VALID).infoMsg(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse handleHandlerMethodValidation(ConstraintViolationException ex) {
        return BaseResponse.builder().infoId(InfoId.REQUEST_NOT_VALID).infoMsg(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JsonProcessingException.class)
    public BaseResponse handleBusinessException(JsonProcessingException ex) {
        return BaseResponse.builder().infoId(InfoId.JSON_PARSE_ERROR).infoMsg(ex.getMessage()).build();
    }

}
