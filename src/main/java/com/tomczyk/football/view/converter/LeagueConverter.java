package com.tomczyk.football.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tomczyk.football.model.League;
import com.tomczyk.football.service.LeagueService;

@Named("leagueConverter")
public class LeagueConverter implements Converter {

	static final Logger log = LoggerFactory.getLogger(LeagueConverter.class);
	
	@Inject
	private LeagueService leagueService;
	
	public LeagueConverter() {
	}

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
				
		League league = null;
        try {
            league = leagueService.getLeague(Long.parseLong(value));
            
        }catch(Throwable ex) {
        
        	/*
        	 * TODO add resourcebundle like below, just make it working
        	 */
        	
        	//ResourceBundle bundle = ResourceBundle.getBundle("messages");
            //FacesMessage msg = new FacesMessage(bundle.getString("league_convertion_message"));
            //msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            //throw new ConverterException(msg);
        	log.error("ex: " + ex);
        }
        
        return league;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		String val = null;
        
		try {
            League league = (League) value;
            val = Long.toString(league.getId());
            
        }catch(Throwable ex) {
            
        	/*
        	 * TODO add resourcebundle like below, just make it working
        	 */
        	
        	//ResourceBundle bundle = ResourceBundle.getBundle("messages");
            //FacesMessage msg = new FacesMessage(bundle.getString("league_convertion_message"));
            //msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            //throw new ConverterException(msg);
        	log.error("ex: " + ex);
        }
		
        return val;
	}

}