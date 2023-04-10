package com.example.cleverp.controladors;

/**
 *Exercici:
 *Descripció:
 * @author brian
 */
import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class errorController {

    @ExceptionHandler(value = { AccessDeniedException.class })
    public ModelAndView handleAccessDeniedError(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error403");
        modelAndView.addObject("code", "403");
        modelAndView.addObject("message", "Acceso denegado");
        return modelAndView;
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    public ModelAndView handleNotFoundError(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error404");
        modelAndView.addObject("code", "404");
        modelAndView.addObject("message", "Página no encontrada");
        return modelAndView;
    }
}