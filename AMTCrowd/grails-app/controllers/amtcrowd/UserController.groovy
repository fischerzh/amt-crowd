package amtcrowd

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create() {
        [userInstance: new User(params)]
    }

    def save() {
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def register()
	{
		println params
		def dateToday = new Date()
		def user
		def newUser = false

		println "Username: " +params.username
		if(params.username !=null)
		{
			user = User.findByUsername(params.username)
			if(!user)
			{
				user = new User(params)
				newUser = true
			}
		}
		else
		{
			flash.message = "Please enter your username!"
			render(view: "register", model: [userInstance: user])
			return
		}
		def taskAvailable = false
		
		if(!newUser)
		{
			Integer day = dateToday.date
			Integer lastDay = user.lastHitRegister.date
			println "Today: " + day
			println "Last AMT day: " + lastDay
			if (day > lastDay )
			{
				println "New Task available!"
				taskAvailable = true
				user.lastHitRegister = dateToday
			}
		}
		else
		{
			user.lastHitRegister = dateToday
		}
		
		def uuid = UUID.randomUUID().toString()
		
//		if (!user.save(flush: true))
		if(!taskAvailable && !newUser)
		{
//			flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
			flash.message = "You can only complete ONE Amazon Mechanical Turk Task per day! Please come back tomorrow!"
			render(view: "register", model: [userInstance: user])
			return
		}
		if(user.save(flush:true))
		{
			flash.message = "Please enter this Token to Amazon Mechanical Turk: " + uuid
			redirect(action: "showamt", id: user.id)
		}
		else
		{
			flash.message = "Username not found!"
			redirect(action: "showamt", id: user.id)
		}
		
//		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])

	}
	
	def showamt(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "showamt")
			return
		}

		[userInstance: userInstance]
	}
}
