package com.javainuse.TreeDoc;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author PhanHoang
 * 6/22/2020
 */
public class Execute {
    public static List<Node> main() {
        List<Document> data = getListDoc();
        List<Node> lstInvetory = getInventory(data);
        for (Node inventoryNode : lstInvetory) {
            List<Document> lstShelfDoc = inventoryNode.getLstDoc();
            List<Node> lstShelf = getShelf(lstShelfDoc, inventoryNode.getId());
            for (Node shelfNode : lstShelf) {
                List<Node> lstBox = getBox(lstShelfDoc, inventoryNode.getId(), shelfNode.getId());
                shelfNode.setChild(lstBox);
            }
            inventoryNode.setChild(lstShelf);
        }
//        String json = new Gson().toJson(lstInvetory);
//        System.out.println(json);

        return lstInvetory;
    }

    // loc ra list kho
    public static List<Node> getInventory(List<Document> lstDada) {
        Map<Integer, List<Document>> mapInventory = lstDada.stream().filter(r -> r.getInvetoryId() != null).
                collect(Collectors.groupingBy(Document::getInvetoryId));
        List<Node> lstInventory = new ArrayList<>();
        if (!isNullOrEmptyMap(mapInventory)) {
            mapInventory.forEach((k, v) -> {
                Node node = new Node();
                node.setId(k);
                node.setName(v.get(0).getInvetoryId().toString());
                node.setLstDoc(v);
                lstInventory.add(node);
            });
        }
        return lstInventory;
    }

    // loc ra list gia
    public static List<Node> getShelf(List<Document> lst, Integer inventoryId) {
        List<Document> data = lst.stream().filter(r -> (r.getInvetoryId() == inventoryId) && (r.getShelfId() != null)).collect(Collectors.toList());
        List<Node> lstShelf = new ArrayList<>();
        Map<Integer, List<Document>> mapShelf = data.stream().
                collect(Collectors.groupingBy(Document::getShelfId));
        if (!isNullOrEmptyMap(mapShelf)) {
            mapShelf.forEach((k, v) -> {
                Node node = new Node();
                node.setId(k);
                node.setName(v.get(0).getShelfId().toString());
                node.setLstDoc(v);
                lstShelf.add(node);
            });
        }
        return lstShelf;
    }

    // loc ra list hop
    public static List<Node> getBox(List<Document> lst, Integer intentoryId, Integer shelfId) {
        Map<Integer, List<Document>> mapBox = lst.stream()
                .filter(r -> (r.getBoxId() != null) && ((r.getInvetoryId() == intentoryId) && (r.getShelfId() == shelfId))).
                        collect(Collectors.groupingBy(Document::getBoxId));
        List<Node> lstBox = new ArrayList<>();
        if (!isNullOrEmptyMap(mapBox)) {
            mapBox.forEach((k, v) -> {
                Node node = new Node();
                node.setId(k);
                node.setName(v.get(0).getShelfId().toString());
                node.setLstDoc(v);
                lstBox.add(node);
            });
        }
        return lstBox;
    }


    //    public static List<i> getInvetory(List<Document> lstDoc){
//        lstDoc.stream().
//    }
    public static boolean isNullOrEmpty(List lst) {
        if (lst == null || lst.size() == 0) return true;
        return false;
    }

    public static boolean isNullOrEmptyMap(Map map) {
        if (map == null || map.size() == 0) return true;
        return false;
    }


    public static List<Document> getListDoc() {
        Document doc1 = new Document(1, "sach", 1, 1, 1);
        Document doc2 = new Document(2, "vo", 1, 1, 2);
        Document doc3 = new Document(3, "vo1", 1, 2, 2);
        Document doc4 = new Document(4, "vo2", 2, 1, 2);
        Document doc5 = new Document(5, "vo3", 1, 1, 2);
        Document doc6 = new Document(6, "vo4", 2, 2, 2);
        List<Document> lst = new ArrayList<>();
        lst.add(doc1);
        lst.add(doc2);
        lst.add(doc3);
        lst.add(doc4);
        lst.add(doc5);
        lst.add(doc6);

        return lst;

    }
}
