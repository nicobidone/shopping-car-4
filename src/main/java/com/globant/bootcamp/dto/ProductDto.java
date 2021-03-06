/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author nicob
 */
@Data
public class ProductDto implements Serializable {

    private Integer id;
    
    private Integer quantity;
    
    private String description;
    
    @JsonIgnore
    private List<CartContentDto> cartcontent;
    
    
}
