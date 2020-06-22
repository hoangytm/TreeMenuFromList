package com.javainuse.controllers;

import com.javainuse.TreeDoc.Execute;
import com.javainuse.TreeDoc.Node;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PhanHoang
 * 6/23/2020
 */
@RestController
@RequestMapping("/tree")
public class TreeController {
    @GetMapping
    public List<Node> getNode() {
        return Execute.main();
    }
}
