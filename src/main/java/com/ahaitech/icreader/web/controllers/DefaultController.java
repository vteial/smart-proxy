package com.ahaitech.icreader.web.controllers;

//import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class DefaultController extends AbstractController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String slash() {
        return index();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/index.html";
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, String> ping() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("ping", "Ping Pong!!!");

//        log.debug("Debug map : {}", map);
//        log.info("Info map : {}", map);

        return map;
    }

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public @ResponseBody
    String echo(HttpSession session, HttpServletRequest request) {
        int noOfChars = 80;
        char schar = '-';
        String s = "-";

        StringBuilder sb = new StringBuilder();

        sb.append("<html><head><title>Echo</title><head><body><pre>");
        sb.append("\n");
        //sb.append(Strings.padEnd(s, noOfChars, schar));
        try {
            sb.append("\n");
            sb.append("Request URI = ");
            sb.append(request.getRequestURI());
            sb.append("\n");
            sb.append("Request URL = ");
            sb.append(request.getRequestURL());
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                sb.append("\n");
                sb.append(headerName);
                sb.append(" = ");
                sb.append(request.getHeader(headerName));
            }
            sb.append("\n");
            Enumeration<String> attrNames = request.getSession().getAttributeNames();
            if (attrNames.hasMoreElements()) {
                //sb.append(Strings.padEnd(s, noOfChars, schar));
                while (attrNames.hasMoreElements()) {
                    String attrName = attrNames.nextElement();
                    sb.append("\n");
                    sb.append(attrName);
                    sb.append(" = ");
                    sb.append(session.getAttribute(attrName));
                }
            }
        } catch (Throwable t) {
            sb.append("\n");
            //sb.append(Helper.getStackTraceAsString(t));
        }
        sb.append("\n");
        //sb.append(Strings.padEnd(s, noOfChars, schar));
        sb.append("\n");
        sb.append("</pre></body></html>");

        return sb.toString();
    }

}
