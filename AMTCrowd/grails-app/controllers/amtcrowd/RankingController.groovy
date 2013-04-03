package amtcrowd

import org.springframework.dao.DataIntegrityViolationException

import com.sun.org.apache.xalan.internal.xsltc.compiler.CeilingCall;

class RankingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", rankinglist: ["GET","POST"]]

	def userRankingList = User.list(sort:"totalPoints", order: "desc")
	def totalUsers = userRankingList.size()
	def top10 = Math.ceil(totalUsers*0.1)
	def top50 = Math.ceil(totalUsers*0.5)	
	
    def index() {
        redirect(action: "list", params: params)
    }

	def calculateRanking(Ranking ranking) {
		def userList = User.getAll();		
		userList.each() {
			user -> calculateUserRanking(user)
		}
		println "userList "  + userList
		userList.each() {user ->
			def returnedUser = calculateRankingPosition(user) 
			println "Returned User"  + returnedUser
			ranking.addToUsers(returnedUser)
			ranking.save(flush:true)
		}
		println "Ranking After Calc" + ranking
	}
	
	def calculateUserRanking(User user) {
		def hitList = user.hits
		float totalPoints = 0;
		
		hitList.each() {hit -> 
			if(hit.points)
				totalPoints += hit.points
		}
		user.totalPoints = totalPoints
		println "TotalPoints: " + user.totalPoints
	}
	
	def calculateRankingPosition(User user) {
		println "Total Users" + totalUsers
		println "Top 10" + top10
		println "Top 50" + top50
		def userRanking = userRankingList.findIndexOf {
			it == user
		}
		println "User Ranking Position: " + userRanking+1
		user.rankingPosition = userRanking+1
		if(userRanking <= top10 && user.hitsCompleted > 5)
			user.level = 3
		if(userRanking > top10 && userRanking <= top50 && user.hitsCompleted > 2)
			user.level = 2
		else
			user.level = 1
		println "User " + user.username + " :" + user.level
		user.save(flush:true)
		return user
//		ranking.addToUsers(user)
//		ranking.save(flush:true)
	}
	
    def rankinglist() {
		def ranking = Ranking.findByRankingName("AMTRanking")?:new Ranking(rankingName:"AMTRanking").save(failOnError:true)
		println ranking
		calculateRanking(ranking)
//		def userList = userRankingList;
		println ranking
		println ranking.users
        [rankingInstanceList: ranking.users]
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [rankingInstanceList: Ranking.list(params), rankingInstanceTotal: Ranking.count()]
    }
    
    def create() {
        [rankingInstance: new Ranking(params)]
    }

    def save() {
        def rankingInstance = new Ranking(params)
        if (!rankingInstance.save(flush: true)) {
            render(view: "create", model: [rankingInstance: rankingInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ranking.label', default: 'Ranking'), rankingInstance.id])
        redirect(action: "show", id: rankingInstance.id)
    }

    def show(Long id) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        [rankingInstance: rankingInstance]
    }

    def edit(Long id) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        [rankingInstance: rankingInstance]
    }

    def update(Long id, Long version) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (rankingInstance.version > version) {
                rankingInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ranking.label', default: 'Ranking')] as Object[],
                          "Another user has updated this Ranking while you were editing")
                render(view: "edit", model: [rankingInstance: rankingInstance])
                return
            }
        }

        rankingInstance.properties = params

        if (!rankingInstance.save(flush: true)) {
            render(view: "edit", model: [rankingInstance: rankingInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ranking.label', default: 'Ranking'), rankingInstance.id])
        redirect(action: "show", id: rankingInstance.id)
    }

    def delete(Long id) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        try {
            rankingInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "show", id: id)
        }
    }
}
