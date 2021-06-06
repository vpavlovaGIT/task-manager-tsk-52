package ru.vpavlova.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-06-06T13:25:13.213+03:00
 * Generated source version: 3.4.2
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.vpavlova.ru/", name = "SessionEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SessionEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/SessionEndpoint/closeSessionRequest", output = "http://endpoint.tm.vpavlova.ru/SessionEndpoint/closeSessionResponse")
    @RequestWrapper(localName = "closeSession", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.CloseSession")
    @ResponseWrapper(localName = "closeSessionResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.CloseSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Session closeSession(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/SessionEndpoint/openSessionRequest", output = "http://endpoint.tm.vpavlova.ru/SessionEndpoint/openSessionResponse")
    @RequestWrapper(localName = "openSession", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.OpenSession")
    @ResponseWrapper(localName = "openSessionResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.OpenSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Session openSession(

        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );
}
