package com.neba.bst.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BSTNode {
    private int value;
    private BSTNode left;
    private BSTNode right;
}
