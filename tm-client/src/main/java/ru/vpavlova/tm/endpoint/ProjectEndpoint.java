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
 * 2021-05-28T21:10:56.178+03:00
 * Generated source version: 3.4.2
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.vpavlova.ru/", name = "ProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findProjectByIdRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findProjectByIdResponse")
    @RequestWrapper(localName = "findProjectById", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindProjectById")
    @ResponseWrapper(localName = "findProjectByIdResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project findProjectById(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/finishProjectByNameRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/finishProjectByNameResponse")
    @RequestWrapper(localName = "finishProjectByName", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FinishProjectByName")
    @ResponseWrapper(localName = "finishProjectByNameResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FinishProjectByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project finishProjectByName(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/updateProjectByIndexRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/updateProjectByIndexResponse")
    @RequestWrapper(localName = "updateProjectByIndex", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.UpdateProjectByIndex")
    @ResponseWrapper(localName = "updateProjectByIndexResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.UpdateProjectByIndexResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project updateProjectByIndex(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "index", targetNamespace = "")
        java.lang.Integer index,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "description", targetNamespace = "")
        java.lang.String description
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/updateProjectByIdRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/updateProjectByIdResponse")
    @RequestWrapper(localName = "updateProjectById", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.UpdateProjectById")
    @ResponseWrapper(localName = "updateProjectByIdResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.UpdateProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project updateProjectById(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "description", targetNamespace = "")
        java.lang.String description
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findProjectOneByNameRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findProjectOneByNameResponse")
    @RequestWrapper(localName = "findProjectOneByName", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindProjectOneByName")
    @ResponseWrapper(localName = "findProjectOneByNameResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindProjectOneByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project findProjectOneByName(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/removeProjectOneByNameRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/removeProjectOneByNameResponse")
    @RequestWrapper(localName = "removeProjectOneByName", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.RemoveProjectOneByName")
    @ResponseWrapper(localName = "removeProjectOneByNameResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.RemoveProjectOneByNameResponse")
    public void removeProjectOneByName(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/clearRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/clearResponse")
    @RequestWrapper(localName = "clear", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.Clear")
    @ResponseWrapper(localName = "clearResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ClearResponse")
    public void clear(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findProjectByIndexRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findProjectByIndexResponse")
    @RequestWrapper(localName = "findProjectByIndex", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindProjectByIndex")
    @ResponseWrapper(localName = "findProjectByIndexResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindProjectByIndexResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project findProjectByIndex(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "index", targetNamespace = "")
        java.lang.Integer index
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/startProjectByIndexRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/startProjectByIndexResponse")
    @RequestWrapper(localName = "startProjectByIndex", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.StartProjectByIndex")
    @ResponseWrapper(localName = "startProjectByIndexResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.StartProjectByIndexResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project startProjectByIndex(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "index", targetNamespace = "")
        java.lang.Integer index
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/changeProjectStatusByIndexRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/changeProjectStatusByIndexResponse")
    @RequestWrapper(localName = "changeProjectStatusByIndex", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ChangeProjectStatusByIndex")
    @ResponseWrapper(localName = "changeProjectStatusByIndexResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ChangeProjectStatusByIndexResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project changeProjectStatusByIndex(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "index", targetNamespace = "")
        java.lang.Integer index,
        @WebParam(name = "status", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Status status
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/removeProjectOneByIndexRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/removeProjectOneByIndexResponse")
    @RequestWrapper(localName = "removeProjectOneByIndex", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.RemoveProjectOneByIndex")
    @ResponseWrapper(localName = "removeProjectOneByIndexResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.RemoveProjectOneByIndexResponse")
    public void removeProjectOneByIndex(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "index", targetNamespace = "")
        java.lang.Integer index
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/startProjectByNameRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/startProjectByNameResponse")
    @RequestWrapper(localName = "startProjectByName", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.StartProjectByName")
    @ResponseWrapper(localName = "startProjectByNameResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.StartProjectByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project startProjectByName(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findAllProjectsRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/findAllProjectsResponse")
    @RequestWrapper(localName = "findAllProjects", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindAllProjects")
    @ResponseWrapper(localName = "findAllProjectsResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FindAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.vpavlova.tm.endpoint.Project> findAllProjects(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/addProjectRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/addProjectResponse")
    @RequestWrapper(localName = "addProject", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.AddProject")
    @ResponseWrapper(localName = "addProjectResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.AddProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project addProject(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "description", targetNamespace = "")
        java.lang.String description
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/changeProjectStatusByIdRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/changeProjectStatusByIdResponse")
    @RequestWrapper(localName = "changeProjectStatusById", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ChangeProjectStatusById")
    @ResponseWrapper(localName = "changeProjectStatusByIdResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ChangeProjectStatusByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project changeProjectStatusById(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "status", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Status status
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/startProjectByIdRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/startProjectByIdResponse")
    @RequestWrapper(localName = "startProjectById", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.StartProjectById")
    @ResponseWrapper(localName = "startProjectByIdResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.StartProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project startProjectById(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/removeProjectByIdRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/removeProjectByIdResponse")
    @RequestWrapper(localName = "removeProjectById", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.RemoveProjectById")
    @ResponseWrapper(localName = "removeProjectByIdResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.RemoveProjectByIdResponse")
    public void removeProjectById(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/changeProjectStatusByNameRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/changeProjectStatusByNameResponse")
    @RequestWrapper(localName = "changeProjectStatusByName", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ChangeProjectStatusByName")
    @ResponseWrapper(localName = "changeProjectStatusByNameResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.ChangeProjectStatusByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project changeProjectStatusByName(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "status", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Status status
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/finishProjectByIdRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/finishProjectByIdResponse")
    @RequestWrapper(localName = "finishProjectById", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FinishProjectById")
    @ResponseWrapper(localName = "finishProjectByIdResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FinishProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project finishProjectById(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/finishProjectByIndexRequest", output = "http://endpoint.tm.vpavlova.ru/ProjectEndpoint/finishProjectByIndexResponse")
    @RequestWrapper(localName = "finishProjectByIndex", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FinishProjectByIndex")
    @ResponseWrapper(localName = "finishProjectByIndexResponse", targetNamespace = "http://endpoint.tm.vpavlova.ru/", className = "ru.vpavlova.tm.endpoint.FinishProjectByIndexResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.vpavlova.tm.endpoint.Project finishProjectByIndex(

        @WebParam(name = "session", targetNamespace = "")
        ru.vpavlova.tm.endpoint.Session session,
        @WebParam(name = "index", targetNamespace = "")
        java.lang.Integer index
    );
}
