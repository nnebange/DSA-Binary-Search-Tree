package com.neba.bst;

import com.neba.bst.model.TreeEntity;
import com.neba.bst.service.BSTService;
import com.neba.bst.util.BSTNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BstApplicationTests {

    @Autowired
    private BSTService service;

    @Test
    void testBSTInsertion() {
        BSTNode result = service.getBalancedBST("5,3,7,2,4,6,8");
        assertNotNull(result);
    }

    @Test
    void testEmptyBST() {
        BSTNode result = service.getBalancedBST("");
        assertNull(result);  
    }

    @Test
    void testDatabaseSave() {
        service.getBalancedBST("1,2,3");
        List<TreeEntity> trees = service.getAllTrees();
        assertFalse(trees.isEmpty());
    }
}
