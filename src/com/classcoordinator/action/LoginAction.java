package com.classcoordinator.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.classcoordinator.forms.LoginForm;



public class LoginAction extends Action {

    public ActionForward execute(
				 ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {

    	ActionForward forward = new ActionForward(); // return value


        DynaActionForm lform = (DynaActionForm)form;
  	  request.setAttribute("name",lform.get("name"));
  	  
  	  // We would do real logon checking here

  	  // Forward control to the appropriate 'success' URI (change name as desired)
        forward = mapping.findForward("success");

        return (forward);

    }
}
