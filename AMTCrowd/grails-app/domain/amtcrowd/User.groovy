package amtcrowd

class User {
	
	String username
	String password
	String workerID
	Integer batchesCompleted 
	Date lastHitRegister
	Integer hitsCompleted
	Integer level = 1

    static constraints = {
		username unique:true
		workerID nullable:true
		batchesCompleted nullable:true
		lastHitRegister nullable:true
		hits nullable:true
		hitsCompleted nullable:true
		level nullable:true
		ranking nullable:true
    }
	
	static hasMany = [hits:HIT]
	
	static belongsTo = [ranking:Ranking]
		
}
