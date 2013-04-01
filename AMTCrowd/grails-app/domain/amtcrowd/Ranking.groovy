package amtcrowd

class Ranking {

	Integer level
	Integer position
	
    static constraints = {
		level nullable: true
		position nullable:true
    }
	
	static hasMany = [users:User]
}
