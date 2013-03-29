import amtcrowd.Tasks;

class BootStrap {

    def init = { servletContext ->
		
		def tasklevel1 = Tasks.findById(1) ?: new Tasks(level: 1, assignment:'a,n,d,u,f', result: 'faun, fund, and, dan, dun, fad, fan, fun', description: 'Find at least 3 words with the given characters! The words must be found on dict.leo.org ').save(failOnError: true)
		def tasklevel2 = Tasks.findById(2) ?: new Tasks(level: 2, assignment:'{{0,-1},{1,0}}.{{1,2},{3,4}}+{{2,-1},{-1,2}}', result: '{{-1,-5},{0,4}}', description: 'Find the solution to the given matrices calculation!').save(failOnError: true)
		def tasklevel3 = Tasks.findById(3) ?: new Tasks(level: 3, assignment:'Chose a firm is considering marketing a new product in Region 1 or Region 2. Region 1: 30% chance of making $4M profit, 70% of $2M loss. \n Region 2: 30% chance of making $3M profit, 70% chance of $1M loss.', 
						result: 'Region 2', description: 'In what region should the new product be marketed? The cost of marketing the product is $0.1M').save(failOnError: true)
		
		
		
    }
	
    def destroy = {
    }
}
