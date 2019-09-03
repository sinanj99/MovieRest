/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.RenameMe;

/**
 *
 * @author sinanjasar
 */
public class DTO {
    private String dummyStr1;
    private String dummyStr2;

    public DTO(RenameMe r) {
        this.dummyStr1 = r.getDummyStr1();
        this.dummyStr2 = r.getDummyStr2();
    }
    
    
}
