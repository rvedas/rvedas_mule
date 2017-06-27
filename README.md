# rvedas_mule

orders_system_api <- read from file source, split by //order and write output to file

orders_callidus_process_api <- xml to json as is

orders_hybris_process_api <- xml to json with enrichment. Read distributor level from mysql database
          <- select level from distributor where id = '101'

orders_salesforce_process_api <- xml to json with enrichment. Invoke REST service 'distributor', pass distributor id and get the level from http response

distributor_api <- write RAML
        <- write implementation
        <- onboard api
        <- client id client secret
        <- service connects to same mysql database to pull distributor level
            <- select level from distributor where id = '101'
