package org.orcid.frontend.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Declan Newman (declan)
 *         Date: 18/10/2012
 */
@Controller
public class ErrorController extends BaseController {

    @ExceptionHandler(Exception.class)
    @RequestMapping(value = "/error")
    public ModelAndView error500Page(ModelAndView mav, Exception e) {
        mav.setViewName("error-500");
        mav.addObject("exception", e);
        return mav;
    }

    @RequestMapping(value = "/not-found")
    public ModelAndView error404Page(ModelAndView mav) {
        mav.setViewName("error-404");
        return mav;
    }

    @RequestMapping(value = "/oauth/error/redirect-uri-mismatch")
    public ModelAndView oauthErrorInvalidRedirectUri(ModelAndView mav, Exception e) {
        mav.setViewName("oauth-error");
        mav.addObject("error", getMessage("oauth.errors.redirect_mismatch_exception"));        
        return mav;
    }
    
    @RequestMapping(value = "/oauth/error")
    public ModelAndView oauthError(ModelAndView mav, Exception e) {
        mav.setViewName("oauth-error");
        mav.addObject("error", getMessage("oauth.errors.other"));        
        return mav;
    }
    
}
