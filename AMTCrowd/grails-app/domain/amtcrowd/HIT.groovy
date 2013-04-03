package amtcrowd

import groovy.time.*

class HIT {

	String batchID
	String hitID
	String hitTypeID
	Boolean batchCompleted = false
	String uniqueTokenGeneratedID
	String uniqueTokenEnteredID
	Date startTime
	Date endTime
	Float overallPerformance
//	Date performanceTime = endTime-startTime
	Float performanceQuality
	Float points
	
	
    static constraints = {
		batchID nullable:true
		hitID nullable:true
		hitTypeID nullable:true
		batchCompleted nullable:true
		uniqueTokenGeneratedID nullable:true, unique:true
		uniqueTokenEnteredID nullable:true, unique:true
		startTime nullable:true
		endTime nullable:true
		overallPerformance nullable:true
//		performanceTime nullable:true
		performanceQuality nullable:true
		points nullable:true
    }
	
	static belongsTo = [user:User, task:Tasks]
	
}
