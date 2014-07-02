package com.classcoordinator.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class LoginForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private String keyword = null;
    private String searchArtist = null;
    // TODO: Add variable for searchArtist

    /**
     * Get keyword
     * @return String
     */
    public String getKeyword() {
	return keyword;
    }

    /**
     * Set keyword
     * @param <code>String</code>
     */
    public void setKeyword(String k) {
	this.keyword = k;
    }

	public String getSearchArtist() {
		return searchArtist;
	}

	public void setSearchArtist(String searchArtist) {
		this.searchArtist = searchArtist;
	}    

    public void reset(ActionMapping mapping, HttpServletRequest request) {


	keyword = null;
	searchArtist = null;

    }
    
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

    	if (keyword.length() == 0) {
    	    ActionMessage vulgar = new ActionMessage("error.loginForm.noText");
    	    errors.add("error.loginForm.noText",vulgar);
    	}
        
        return errors;

    }
    

    


}
