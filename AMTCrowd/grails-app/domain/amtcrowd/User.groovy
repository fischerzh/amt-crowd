package amtcrowd

class User {
	
	String username
	String password
	String workerID
	Integer batchesCompleted 
	Date lastHitRegister
	Integer hitsCompleted

    static constraints = {
		workerID nullable:true
		batchesCompleted nullable:true
		lastHitRegister nullable:true
		hits nullable:true
		username unique:true
		hitsCompleted nullable:true
    }
	
	static hasMany = [hits:HIT]
		
}
