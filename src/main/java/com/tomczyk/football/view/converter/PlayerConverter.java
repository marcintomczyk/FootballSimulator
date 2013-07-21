package com.tomczyk.football.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.PlayerService;

@Named("playerConverter")
public class PlayerConverter implements Converter {

	static final Logger log = LoggerFactory.getLogger(PlayerConverter.class);
	
	@Inject
	private PlayerService playerService;
	
	public PlayerConverter() {
	}

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
				
		Player player = null;
        try {
            player = playerService.getPlayer(Long.parseLong(value));
            
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
        
        return player;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		String val = null;
        
		try {
            Player player = (Player) value;
            val = Long.toString(player.getId());
            
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