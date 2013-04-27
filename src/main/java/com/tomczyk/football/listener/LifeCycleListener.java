package com.tomczyk.football.listener;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifeCycleListener implements PhaseListener {

	private static final long serialVersionUID = 5121632372072934612L;
	
	static final Logger log = LoggerFactory.getLogger(LifeCycleListener.class);

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		
		if (log.isDebugEnabled()) {

			List<FacesMessage> messages = event.getFacesContext()
					.getMessageList();

			log.debug("START PHASE " + event.getPhaseId());

			for (FacesMessage fm : messages) {
				log.debug(fm.getDetail());
			}
		}

	}

	public void afterPhase(PhaseEvent event) {
		
		if (log.isDebugEnabled()) {
			
			log.debug("END PHASE " + event.getPhaseId());

			List<FacesMessage> messages = event.getFacesContext()
					.getMessageList();

			for (FacesMessage fm : messages) {
				log.debug(fm.getDetail());
			}
		}

	}

}