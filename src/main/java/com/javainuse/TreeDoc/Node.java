package com.javainuse.TreeDoc;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author PhanHoang
 * 6/22/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"lstDoc"})
public class Node {
    private int id;
    private String name;
    private List<Document> lstDoc;
    private List<Node> child;
}
