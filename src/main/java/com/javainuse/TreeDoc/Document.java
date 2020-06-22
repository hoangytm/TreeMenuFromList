package com.javainuse.TreeDoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 6/22/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private Integer id;
    private String name;
    private Integer InvetoryId;
    private Integer shelfId;
    private Integer boxId;

}
