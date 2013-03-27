package amtcrowd

class User {
	
	String username
	String mail
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
		mail nullable:true, unique:true
		hitsCompleted nullable:true
    }
	
	static hasMany = [hits:HIT]
		
}
