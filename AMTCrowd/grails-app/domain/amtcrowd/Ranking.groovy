package amtcrowd

class Ranking {
	
	String rankingName
	
    static constraints = {
		users nullable:true
		rankingName nullable:true
    }
	
	static hasMany = [users:User]
}
