package amtcrowd

class User {
	
	String username
	String password
	String workerID
	Integer batchesCompleted 
	Date lastHitRegister
	Integer hitsCompleted = 0
	Integer level = 1
	Integer rankingPosition
	Float totalPoints

    static constraints = {
		username blank:false, unique:true
		password blank: false
		workerID nullable:true
		batchesCompleted nullable:true
		lastHitRegister nullable:true
		hits nullable:true
		hitsCompleted nullable:true
		level nullable:true
		totalPoints nullable:true
		rankingPosition unique:true, nullable:true
		ranking nullable:true
    }
	
	static hasMany = [hits:HIT]
	
	static belongsTo = [ranking:Ranking]
			
	String toString()  {
		return username? username: ""
	}
	
	def afterUpdate()
	{
		hitsCompleted = hits!=null?hits.size():0
	}
	
	def beforeValidate()
	{
		hitsCompleted = hits!=null?hits.size():0
	}
		
	def onLoad()
	{
		hitsCompleted = hits!=null?hits.size():0
	}
}
