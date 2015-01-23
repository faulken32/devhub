/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.data.jpa.service;

import com.infinity.data.jpa.domain.Code;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author nicolas
 */
public interface CodeRepository extends CrudRepository<Code, Integer>{
    
      
      List<Code> findTop5ByOrderBySouscriptiondateDesc();
      
}
