import amtcrowd.*;
import grails.plugins.springsecurity.*;

class BootStrap {

    def init = { servletContext ->
		
		def tasklevel1= Tasks.findById(1) ?: new Tasks(level: 1, factor: 1, assignment:'a,n,i,m,o', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel12= Tasks.findById(2) ?: new Tasks(level: 1, factor: 1, assignment:'a,b,o,n,f', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel13= Tasks.findById(3) ?: new Tasks(level: 1, factor: 1, assignment:'e,l,o,n,g', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel14= Tasks.findById(4) ?: new Tasks(level: 1, factor: 1, assignment:'d,u,e,n,k', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel15= Tasks.findById(5) ?: new Tasks(level: 1, factor: 1, assignment:'d,a,n,r,o', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel16= Tasks.findById(6) ?: new Tasks(level: 1, factor: 1, assignment:'a,b,a,s,e', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel17= Tasks.findById(7) ?: new Tasks(level: 1, factor: 1, assignment:'a,t,a,p,s', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel18= Tasks.findById(8) ?: new Tasks(level: 1, factor: 1, assignment:'r,e,b,a,k', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel19= Tasks.findById(9) ?: new Tasks(level: 1, factor: 1, assignment:'a,v,e,r,t', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel110= Tasks.findById(10) ?: new Tasks(level: 1, factor: 1, assignment:'b,a,l,m,y', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel111= Tasks.findById(11) ?: new Tasks(level: 1, factor: 1, assignment:'a,d,e,r,t', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel112= Tasks.findById(12) ?: new Tasks(level: 1, factor: 1, assignment:'l,i,n,s,a', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel113= Tasks.findById(13) ?: new Tasks(level: 1, factor: 1, assignment:'e,a,s,t,s', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel114= Tasks.findById(14) ?: new Tasks(level: 1, factor: 1, assignment:'m,u,r,s,o', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel115 = Tasks.findById(15) ?: new Tasks(level: 1, factor: 1, assignment:'a,n,d,u,f', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel116 = Tasks.findById(16) ?: new Tasks(level: 1, factor: 1, assignment:'d,c,u,q,r', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel117 = Tasks.findById(17) ?: new Tasks(level: 1, factor: 1, assignment:'e,l,n,t,r', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
		def tasklevel118 = Tasks.findById(18) ?: new Tasks(level: 1, factor: 1, assignment:'o,s,u,n,m', result: '', description: 'Find at least 3 words with the provided 5 letters. The words must be real english words and will be double checked with dict.leo.org! No double use of a letter is possible.').save(failOnError: true)
				
		
		def tasklevel2 = Tasks.findById(20) ?: new Tasks(level: 2, factor: 1, assignment:'Please enter your result in the following manner, beginning with your 5 letters, then providing 5 possible solutions to it: "k,w,a,l,e / walk, leak, weal, law, elk"', result: '', description: 'Please create a scrabble task. Define 5 letters, with which it is possible to find at least 5 words containing at least 3 of the defined letters. The words must be real english words and will be double checked with dict.leo.org!').save(failOnError: true)
		
		
//		def tasklevel2 = Tasks.findById(5) ?: new Tasks(level: 2, factor: 1.5, assignment:'{{0,-1},{1,0}}.{{1,2},{3,4}}+{{2,-1},{-1,2}}', result: '{{-1,-5},{0,4}}', description: 'Find the solution to the given matrices calculation!').save(failOnError: true)
//		def tasklevel3 = Tasks.findById(6) ?: new Tasks(level: 3, factor: 2, assignment:'Chose a firm is considering marketing a new product in Region 1 or Region 2. Region 1: 30% chance of making $4M profit, 70% of $2M loss. \n Region 2: 30% chance of making $3M profit, 70% chance of $1M loss.', 
//						result: 'Region 2', description: 'In what region should the new product be marketed? The cost of marketing the product is $0.1M').save(failOnError: true)
		
	}
	
    def destroy = {
    }
}
