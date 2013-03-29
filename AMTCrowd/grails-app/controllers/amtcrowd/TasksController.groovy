package amtcrowd

import org.springframework.dao.DataIntegrityViolationException

class TasksController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tasksInstanceList: Tasks.list(params), tasksInstanceTotal: Tasks.count()]
    }

    def create() {
        [tasksInstance: new Tasks(params)]
    }

    def save() {
        def tasksInstance = new Tasks(params)
        if (!tasksInstance.save(flush: true)) {
            render(view: "create", model: [tasksInstance: tasksInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tasks.label', default: 'Tasks'), tasksInstance.id])
        redirect(action: "show", id: tasksInstance.id)
    }

    def show(Long id) {
        def tasksInstance = Tasks.get(id)
        if (!tasksInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tasks.label', default: 'Tasks'), id])
            redirect(action: "list")
            return
        }

        [tasksInstance: tasksInstance]
    }

    def edit(Long id) {
        def tasksInstance = Tasks.get(id)
        if (!tasksInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tasks.label', default: 'Tasks'), id])
            redirect(action: "list")
            return
        }

        [tasksInstance: tasksInstance]
    }

    def update(Long id, Long version) {
        def tasksInstance = Tasks.get(id)
        if (!tasksInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tasks.label', default: 'Tasks'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tasksInstance.version > version) {
                tasksInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tasks.label', default: 'Tasks')] as Object[],
                          "Another user has updated this Tasks while you were editing")
                render(view: "edit", model: [tasksInstance: tasksInstance])
                return
            }
        }

        tasksInstance.properties = params

        if (!tasksInstance.save(flush: true)) {
            render(view: "edit", model: [tasksInstance: tasksInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tasks.label', default: 'Tasks'), tasksInstance.id])
        redirect(action: "show", id: tasksInstance.id)
    }

    def delete(Long id) {
        def tasksInstance = Tasks.get(id)
        if (!tasksInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tasks.label', default: 'Tasks'), id])
            redirect(action: "list")
            return
        }

        try {
            tasksInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tasks.label', default: 'Tasks'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tasks.label', default: 'Tasks'), id])
            redirect(action: "show", id: id)
        }
    }
}
