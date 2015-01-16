/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.infinityweb.devhub.data.jpa;

import com.infinityweb.devhub.data.jpa.domain.Country;
import com.infinityweb.devhub.data.jpa.domain.Users;
import com.infinityweb.devhub.data.jpa.service.UsersRepository;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan

public class SampleDataJpaApplication {

    public static void main(String[] args) throws Exception {

       // ConfigurableApplicationContext run = SpringApplication.run(SampleDataJpaApplication.class, args);
//
//        UsersRepository bean = run.getBean(UsersRepository.class);
//       // List<Users> findAll = bean.findAll();
////        for (Users findAll1 : findAll) {
////
////            System.out.println(findAll1.getName() + " : " + findAll1.getEmail());
////        }
//        
//        
//        Users users = new Users();
//        
//        users.setName("nicolas");
//        users.setAdress("8 rue de moulin");
//        users.setCity("Nice");
//        users.setEmail("toto");
//        Country country = new Country();
//        country.setIdcountry("fr");
//        
//        users.setCountryid(country);
//        
//        try {
//            
//          
//            
//            
//            Users save = bean.save(users);
//            System.out.println("SAVED");
//        } catch (Exception e) {
//            
//            System.err.println(e.getMessage());
//              
//        }
        
        
        //     Users findOne = bean.findOne(2);
//            Collection<Code> codeCollection = findOne.getCodeCollection();
//            for (Code c : codeCollection) {
//                
//                System.out.println(c.getContends());
//                System.out.println(c.getUserlikeCollection());
//            }
//            
//	}

    }
}
