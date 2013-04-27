package amtcrowd

import org.springframework.dao.DataIntegrityViolationException

import com.sun.org.apache.xalan.internal.xsltc.compiler.CeilingCall;

class RankingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", rankinglist: ["GET","POST"]]

	def userRankingList = User.list(sort:"totalPoints", order: "desc")
	def totalUsers = userRankingList.size()
	def ranking
//	def top10 = Math.ceil(totalUsers*0.1)
//	def top50 = Math.ceil(totalUsers*0.5)	
	
    def index() {
        redirect(action: "list", params: params)
    }

	def calculateRanking(Ranking ranking) {
		def userList = User.findAll()	
		println "userList "  + userList
		println "Total Users" + totalUsers
		
		userList.collect() { 
			println it
			calculatePoints(it)
			calculateRankingLevel(it)
			calculateRankingPosition(it)
			ranking.addToUsers(it)
			ranking.save(flush:true)
		}

		println "Ranking After Calc" + ranking
	}
	
	def calculatePoints(User user) {
		def hitList = user.hits
		float totalPoints = 0;
		
		hitList.each() {hit -> 
			if(hit.points)
				totalPoints += hit.points
		}
		user.totalPoints = totalPoints
		println "TotalPoints for User '" +user.username + "': "+ user.totalPoints
		user.save(flush:true)
	}
	
	def calculateRankingLevel(User user) {
//		def userRanking = userRankingList.findIndexOf {
//			it == user
//		}
		if(user.totalPoints >= 5000 )//&& user.hitsCompleted > 5)
			user.level = 2
		else
			user.level = 1
		println "Userlevel " + user.username + " :" + user.level
		user.save(flush:true)

	}
	
	def calculateRankingPosition(User user)
	{
		def usersByRanking = User.findAll(sort:"totalPoints", order:"desc")
		println "users By Ranking: " + usersByRanking
		
	}
	
    def rankinglist() {
		ranking = Ranking.findByRankingName("AMTRanking")?:new Ranking(rankingName:"AMTRanking").save(flush:true)
		println ranking
		calculateRanking(ranking)
//		def userList = userRankingList;
		println ranking
		println ranking.users
		def rankingList = ranking.users.toList() //sort:"rankingPosition", order:"desc")
		println "rankingList: " +rankingList
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
