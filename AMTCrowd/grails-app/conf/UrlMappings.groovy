class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
			// apply constraints here
			}
		}
		
		"/"(view:"/index")
		"500"(view:'/error')
		
		"/user/register" {
			controller ="user"
			action = "register"
		}
		
		"/user/showamt/$id" {
			controller = "user"
			action = "showamt"
		}
		
		"/user/index" {
			controller ="user"
			action = "index"
		}
		
		
		"/ranking/rankinglist" {
			controller ="ranking"
			action = "rankinglist"
		}
				
	}
}
