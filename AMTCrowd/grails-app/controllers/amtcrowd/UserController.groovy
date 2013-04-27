package amtcrowd

import java.util.Formatter.DateTime;

import org.springframework.dao.DataIntegrityViolationException

class UserController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST", register:["GET","POST"]]

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
		println "REQUEST: " +request.method
		switch (request.method) {
			case 'GET':
				println "GET"
				def userInstance = new User(params)

				[userInstance:userInstance]
				break
				
			case 'POST':
				println "POST"
				println params
				def dateToday = new Date()
				def newUser = false
				println "Username: " +params.username
		        def user = User.findByUsername(params.username)
				
				if(user)
				{
					println "params.password: " +params.password
					println "user.password: " +user.password
					if(user.password != params.password)
					{
						flash.message = "Please enter correct username and password!"
						render(view: "register", model: [userInstance: user])
						return
					}

				}
				else
				{
					println "User count: " + User.count()

					// New User to register!
					user = new User(params)
					user.lastHitRegister = dateToday
					user.level = 1
					newUser = true
				}
				
				def taskAvailable = false
				def uuid
//				Integer day = dateToday.date
//				isNewDay(user.lastHitRegister)
				
//				if (isNewDay(user.lastHitRegister))
//				{
//					println "New Task available!"
//					taskAvailable = true
//				}
//				else
//				{
//					user.lastHitRegister = dateToday
//					taskAvailable = false
//				}
				taskAvailable = true
				println "Hits completed: " + user.hitsCompleted
				if(user.hitsCompleted >= 30)
				{
					flash.message = "You have already solved 30 Tasks. Thank you very much for your contribution!"
					render(view: "register", model: [userInstance: user])
					return
				}
				
//				if(!taskAvailable && !newUser)
//				{
//					flash.message = "You can only complete ONE Amazon Mechanical Turk Task per day! Please come back tomorrow!"
//					render(view: "register", model: [userInstance: user])
//					return
//				}
				if(user.hasErrors()){
					user.errors.allErrors.each{println it}
				 }
				
				if(user.save(failOnError:true))
				{
					user.lastHitRegister = dateToday
//					def hit = new HIT(hitID:user.id)
//					uuid = UUID.randomUUID().toString()
//					hit.uniqueTokenGeneratedID = uuid
//					hit.startTime = dateToday
//					user.addToHits(hit) 
					user.save(flash:true)
//					flash.message = "Please enter this Token to Amazon Mechanical Turk: " + uuid
					redirect(action: "showamt", id: user.id)
				}
				else
				{
					flash.message = "Username not found!"
					render(view: "register", model: [userInstance: user])
					return
				}
				
		//		flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
				break
		}
	}
	
	def showamt(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
			redirect(action: "showamt")
			return
		}
//		def hitForUser = HIT.createCriteria().list{
//			
//		}
				
		String charset = (('A'..'Z')).join()
		String randomString = org.apache.commons.lang.RandomStringUtils.random(4, charset.toCharArray())
		
		def taskForUser = getTaskForUser(userInstance)
		println "TaskForUser: " + taskForUser
		
//		println "Hits for User: " + userInstance.hits.max{ it.id }
		def uniqueToken
		taskForUser.hits.each{ it->
			if(it.user == userInstance)
			{
				println "Hit for User: " + it
				uniqueToken = it
			}
		}
//		def uniqueToken = userInstance.hits.max{ it.id }

		println "uniqueToken: " + uniqueToken.uniqueTokenGeneratedID
		uniqueToken.save(flush:true)
		[userInstance: userInstance, uniqueToken: uniqueToken, taskForUser:taskForUser]
	}
	
	def getTaskForUser(user)
	{
		def randomTask
		println "UserLevel: " +user.level
//		def tasksList =	Tasks.createCriteria.list {
//			if(user.level) eq("level", user.level)
////			if(user) not{ 'in' ("users",it.users)}
//		}
		def results = Tasks.findAllByLevel(user.level)
		println "Tasks for Level " + user.level + results
		def filteredResults = []
		if(user.level == 1)
		{
			def userHitTasks = HIT.findAllByUser(user)
			if(userHitTasks)
			{
				println "user Hit Tasks: " +userHitTasks.task
				filteredResults = results - userHitTasks.task
			}
			else
			{
				filteredResults = results
			}
			int rand = new Random().nextInt(filteredResults.size())
			
			randomTask = filteredResults[rand]
			
			println "Random Task: " +randomTask
			
		}
		else
		{
			randomTask = Tasks.findByLevel(2)
		}
		
		def hit = new HIT()
		def uuid = UUID.randomUUID().toString()
		hit.uniqueTokenGeneratedID = uuid
		hit.startTime = new Date()
		hit.save(flush:true)
		
		user.addToHits(hit)
		if(user.hitsCompleted)
			user.hitsCompleted +=1
		else
			user.hitsCompleted = 1
		user.save(flush:true)
		println user
		randomTask.addToHits(hit)
		randomTask.save(flush:true)
		
		return randomTask
	}
	
	def isNewDay(date)
	{
		def dateToday = new Date()
		def dateTodayOfYear = dateToday.getAt(Calendar.DAY_OF_YEAR)
		def dateLastTaskOfYear = date.getAt(Calendar.DAY_OF_YEAR)
		println "dateLastTaskOfYear: " + dateLastTaskOfYear
		println "dateTodayOfYear: " + dateTodayOfYear
		
		return dateTodayOfYear > dateLastTaskOfYear
	}
}
