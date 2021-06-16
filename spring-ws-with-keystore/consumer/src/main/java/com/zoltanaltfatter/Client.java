package com.zoltanaltfatter;

import com.eufa.euro.GetTeamResponse;
import com.eufa.euro.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.WebServiceException;

/**
 * @author Zoltan Altfatter
 */
@SpringBootApplication
public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
    	LOGGER.info(">>>>>>>>>>>>>>> Start Client App : ");
        SpringApplication application = new SpringApplication(Client.class);
        //application.setAddCommandLineProperties(false);
        application.run(args);
    }

    @Bean
    CommandLineRunner lookup(TeamClient teamClient) {
        return args -> {
        	String countryCode = "FR";
        	if (args.length > 0 ) {
        		LOGGER.info("<<<<<<<<<<<<<<<<<< Use argument :  "+  args[0]);
        		countryCode =  args[0];
        	}
            
            try {
                GetTeamResponse response = teamClient.getTeamByCountryCode(countryCode);
                Team team = response.getTeam();
                if (team != null) {
                    LOGGER.info("countryCode: '{}', country: '{}', team nick name:'{}', coach:'{}'",
                            team.getCountryCode(), team.getCountry(), team.getNickName(), team.getCoach());
                }
            } catch (WebServiceException e) {
                LOGGER.error(e.getMessage());
            }
        };
    }


}
