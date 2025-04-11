package com.neba.bst.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neba.bst.model.TreeEntity;
import com.neba.bst.repository.TreeRepository;
import com.neba.bst.util.BST;
import com.neba.bst.util.BSTNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BSTService {

    private final TreeRepository repository;

    public BSTNode getBalancedBST(String numbers) {
        BST bst = new BST();

        if (numbers != null && !numbers.trim().isEmpty()) {
            Arrays.stream(numbers.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .forEach(bst::insert);
        }

        List<Integer> sortedList = bst.inOrderTraversal(bst.getRoot());
        BSTNode balancedRoot = bst.buildBalancedTree(sortedList, 0, sortedList.size() - 1);

        repository.save(new TreeEntity(null, numbers, balancedRoot == null ? "{}" : toJson(balancedRoot)));

        return balancedRoot;
    }

    public String getBalancedBSTAsJson(String numbers) {
        BSTNode balancedRoot = getBalancedBST(numbers);

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(balancedRoot);
        } catch (Exception e) {
            return "{}";
        }
    }

    private String toJson(BSTNode root) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        } catch (Exception e) {
            return "{}";
        }
    }

    public List<TreeEntity> getAllTrees() {
        return repository.findAll();
    }
}
