hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
//        dataSource {
//            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
//        }
		dataSource {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dbCreate = "create-drop"
			url ="jdbc:mysql://46.163.77.113:3306/amtcrowd?useUnicode=yes&characterEncoding=UTF-8"
			dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			username = "amtcrowd"
			password = "crowdseminar2013"
			}
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dbCreate = "update"
			
//            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			url ="jdbc:mysql://127.0.0.1:3306/amtcrowd?useUnicode=yes&characterEncoding=UTF-8"
			dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			username = "amtcrowd"
			password = "crowdseminar2013"
						
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
