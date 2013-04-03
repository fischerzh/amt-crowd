import amtcrowd.Tasks;

class BootStrap {

    def init = { servletContext ->
		
		def tasklevel1 = Tasks.findById(1) ?: new Tasks(level: 1, factor: 1, assignment:'a,n,d,u,f', result: 'faun, fund, and, dan, dun, fad, fan, fun', description: 'Find at least 3 words with the given characters! The words must be found on dict.leo.org ').save(failOnError: true)
		def tasklevel12 = Tasks.findById(2) ?: new Tasks(level: 1, factor: 1, assignment:'d,c,u,q,r', result: 'faun, fund, and, dan, dun, fad, fan, fun', description: 'Find at least 3 words with the given characters! The words must be found on dict.leo.org ').save(failOnError: true)
		def tasklevel13 = Tasks.findById(3) ?: new Tasks(level: 1, factor: 1, assignment:'e,l,n,t,r', result: 'faun, fund, and, dan, dun, fad, fan, fun', description: 'Find at least 3 words with the given characters! The words must be found on dict.leo.org ').save(failOnError: true)
		def tasklevel14 = Tasks.findById(4) ?: new Tasks(level: 1, factor: 1, assignment:'o,s,u,n,m', result: 'faun, fund, and, dan, dun, fad, fan, fun', description: 'Find at least 3 words with the given characters! The words must be found on dict.leo.org ').save(failOnError: true)
		
		def tasklevel2 = Tasks.findById(5) ?: new Tasks(level: 2, factor: 1.5, assignment:'{{0,-1},{1,0}}.{{1,2},{3,4}}+{{2,-1},{-1,2}}', result: '{{-1,-5},{0,4}}', description: 'Find the solution to the given matrices calculation!').save(failOnError: true)
		def tasklevel3 = Tasks.findById(6) ?: new Tasks(level: 3, factor: 2, assignment:'Chose a firm is considering marketing a new product in Region 1 or Region 2. Region 1: 30% chance of making $4M profit, 70% of $2M loss. \n Region 2: 30% chance of making $3M profit, 70% chance of $1M loss.', 
						result: 'Region 2', description: 'In what region should the new product be marketed? The cost of marketing the product is $0.1M').save(failOnError: true)
		
		
		
    }
	
    def destroy = {
    }
}
