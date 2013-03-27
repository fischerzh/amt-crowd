package amtcrowd

class HIT {

	String batchID
	String hitID
	String hitTypeID
	Boolean batchCompleted = false
	String uniqueTokenGeneratedID
	String uniqueTokenEnteredID
	Date startTime
	Date endTime
	
    static constraints = {
		batchID nullable:true
		hitID unique:true
		hitTypeID nullable:true
		batchCompleted nullable:true
		uniqueTokenGeneratedID nullable:true, unique:true
		uniqueTokenEnteredID nullable:true, unique:true
		startTime nullable:true
		endTime nullable:true
    }
	
	static belongsTo = [user:User]
	
}
