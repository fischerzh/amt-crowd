package amtcrowd

class Tasks {
	
	Integer level
	String assignment
	String result
	String description
	Float factor

    static constraints = {
		description nullable:true
		hits nullable:true
    }
	
	static hasMany = [hits:HIT]
	
}
