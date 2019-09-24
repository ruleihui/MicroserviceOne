package com.xgl.Handler;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/*
 *RestErrorHandler
 *
 *@author 87990
 *@email
 *@date 2019/9/23
 */
@RestControllerAdvice(annotations = {RestController.class})
public class RestErrorHandler {
    private final MessageSource messageSource;

    public RestErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Map<String, Object> processValidationError(WebExchangeBindException ex, ServerWebExchange exchange) {
        Locale locale = exchange.getLocaleContext().getLocale();
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(locale, fieldErrors);
    }

    private Map<String, Object> processFieldErrors(Locale locale, List<FieldError> fieldErrors) {
        Map map = new HashMap();
        for (FieldError fieldError : fieldErrors) {
            String localizedErrorMessage = resolveLocalizedErrorMessage(locale, fieldError);
            map.put(fieldError.getField(), localizedErrorMessage);
        }
        return map;
    }

    private String resolveLocalizedErrorMessage(Locale locale, FieldError fieldError) {
        String localizedErrorMessage = messageSource.getMessage(fieldError, locale);
        return localizedErrorMessage;
    }
}
