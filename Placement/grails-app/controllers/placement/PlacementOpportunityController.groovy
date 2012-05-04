package placement

import grails.converters.*
import org.springframework.dao.DataIntegrityViolationException

class PlacementOpportunityController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

def listOpenPlacements() {
  log.debug("listOpenPlacements() - ${params.format}");
    def placements = PlacementOpportunity.findAllByStatus('Open')
  log.debug("Located placements: ${placements}");
    
        withFormat{
            xml { render placements as XML  }
            json { render placements as JSON }
        }
}

def listApplicants() {
    def jobTitle = PlacementOpportunity.findByJobTitle('Network Administrator')
       def r = []
       jobTitle.applications.each { app ->
          log.debug("jobTitle...: ${app}");
          r.add([applicantid:app.student.id])
       }

        log.debug("returning ${r}");

        withFormat{
            xml { render r as XML  }
            json { render r as JSON }
        }
}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [placementOpportunityInstanceList: PlacementOpportunity.list(params), placementOpportunityInstanceTotal: PlacementOpportunity.count()]
    }

    def create() {
        [placementOpportunityInstance: new PlacementOpportunity(params)]
    }

    def save() {
        def placementOpportunityInstance = new PlacementOpportunity(params)
        if (!placementOpportunityInstance.save(flush: true)) {
            render(view: "create", model: [placementOpportunityInstance: placementOpportunityInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), placementOpportunityInstance.id])
        redirect(action: "show", id: placementOpportunityInstance.id)
    }

    def show() {
        def placementOpportunityInstance = PlacementOpportunity.get(params.id)
        if (!placementOpportunityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), params.id])
            redirect(action: "list")
            return
        }

        [placementOpportunityInstance: placementOpportunityInstance]
    }

    def edit() {
        def placementOpportunityInstance = PlacementOpportunity.get(params.id)
        if (!placementOpportunityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), params.id])
            redirect(action: "list")
            return
        }

        [placementOpportunityInstance: placementOpportunityInstance]
    }

    def update() {
        def placementOpportunityInstance = PlacementOpportunity.get(params.id)
        if (!placementOpportunityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (placementOpportunityInstance.version > version) {
                placementOpportunityInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity')] as Object[],
                          "Another user has updated this PlacementOpportunity while you were editing")
                render(view: "edit", model: [placementOpportunityInstance: placementOpportunityInstance])
                return
            }
        }

        placementOpportunityInstance.properties = params

        if (!placementOpportunityInstance.save(flush: true)) {
            render(view: "edit", model: [placementOpportunityInstance: placementOpportunityInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), placementOpportunityInstance.id])
        redirect(action: "show", id: placementOpportunityInstance.id)
    }

    def delete() {
        def placementOpportunityInstance = PlacementOpportunity.get(params.id)
        if (!placementOpportunityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), params.id])
            redirect(action: "list")
            return
        }

        try {
            placementOpportunityInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'placementOpportunity.label', default: 'PlacementOpportunity'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
