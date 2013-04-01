package amtcrowd

import org.springframework.dao.DataIntegrityViolationException

class HITController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [HITInstanceList: HIT.list(params), HITInstanceTotal: HIT.count()]
    }

    def create() {
        [HITInstance: new HIT(params)]
    }

    def save() {
        def HITInstance = new HIT(params)		
		HITInstance.points = HITInstance.overallPerformance / HITInstance.performanceQuality * 1000
		
        if (!HITInstance.save(flush: true)) {
            render(view: "create", model: [HITInstance: HITInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'HIT.label', default: 'HIT'), HITInstance.id])
        redirect(action: "show", id: HITInstance.id)
    }

    def show(Long id) {
        def HITInstance = HIT.get(id)
        if (!HITInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'HIT.label', default: 'HIT'), id])
            redirect(action: "list")
            return
        }

        [HITInstance: HITInstance]
    }

    def edit(Long id) {
        def HITInstance = HIT.get(id)
        if (!HITInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'HIT.label', default: 'HIT'), id])
            redirect(action: "list")
            return
        }

        [HITInstance: HITInstance]
    }

    def update(Long id, Long version) {
        def HITInstance = HIT.get(id)
        if (!HITInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'HIT.label', default: 'HIT'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (HITInstance.version > version) {
                HITInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'HIT.label', default: 'HIT')] as Object[],
                          "Another user has updated this HIT while you were editing")
                render(view: "edit", model: [HITInstance: HITInstance])
                return
            }
        }

        HITInstance.properties = params

        if (!HITInstance.save(flush: true)) {
            render(view: "edit", model: [HITInstance: HITInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'HIT.label', default: 'HIT'), HITInstance.id])
        redirect(action: "show", id: HITInstance.id)
    }

    def delete(Long id) {
        def HITInstance = HIT.get(id)
        if (!HITInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'HIT.label', default: 'HIT'), id])
            redirect(action: "list")
            return
        }

        try {
            HITInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'HIT.label', default: 'HIT'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'HIT.label', default: 'HIT'), id])
            redirect(action: "show", id: id)
        }
    }
}
