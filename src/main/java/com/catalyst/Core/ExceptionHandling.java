package com.catalyst.Core;

import java.io.IOException;
import com.catalyst.Config.Global;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.core.NestedRuntimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
    Exception Handling For All Controllers

    Specifying Which Exceptions To Override Below
*/
@ControllerAdvice
public class ExceptionHandling
{
    @ExceptionHandler(value = {IOException.class, RuntimeException.class, NestedRuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest argRequest, Exception argException) throws Exception
    {
        ModelAndView hModelView = new ModelAndView();
        hModelView.setViewName(Global.ErrorPage); // Error.jsp Is Template
        hModelView.addObject("exception", argException);
        hModelView.addObject("url", argRequest.getRequestURL());

        return(hModelView);
    }
}