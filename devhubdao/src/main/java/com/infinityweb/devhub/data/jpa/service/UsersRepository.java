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
package com.infinityweb.devhub.data.jpa.service;

import com.infinityweb.devhub.data.jpa.domain.Users;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author faulken
 */
public interface UsersRepository extends CrudRepository<Users, Integer> {

	
    @Override
    List<Users> findAll();

    
    @Override 
    Users findOne(Integer id);

}
