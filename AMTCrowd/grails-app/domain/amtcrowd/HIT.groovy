package amtcrowd

class HIT {

	String batchID
	String hitID
	String hitTypeID
	Boolean batchCompleted
	String uniqueTokenID
	Date startTime
	
    static constraints = {
    }
	
	static belongsTo = [user:User]
	
}
