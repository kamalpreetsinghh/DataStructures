package com.cleverdev;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        var newNode = new Node(value);

        if(root == null) {
            root = newNode;
            return;
        }

        var current = root;
        while(true) {
            if(value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;

        while(current != null) {
            if(value < current.value) {
                current = current.leftChild;
            } else if(value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if(node == null) return;

        traverseInOrder(node.leftChild);
        System.out.println(node.value);
        traverseInOrder(node.rightChild);
    }

    public void traversePreOrder() { traversePreOrder(root); }

    private void traversePreOrder(Node node) {
        if(node == null) return;

        System.out.println(node.value);
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    public void traversePostOrder() { traversePostOrder(root); }

    private void traversePostOrder(Node node) {
        if(node == null) return;

        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
        System.out.println(node.value);
    }

    public int heightOfTree() { return heightOfTree(root); }

    private int heightOfTree(Node node) {
        if(node == null) return -1;

        if(isLeaf(node)) return 0;

        return 1 + Math.max(heightOfTree(node.leftChild), heightOfTree(node.rightChild));
    }

    private boolean isLeaf(Node node) { return node.leftChild == null && node.rightChild == null; }

    public int min() { return min(root); }

    private int min(Node node) {        // O(n)
        if(node == null) throw new IllegalStateException();

        if(isLeaf(node)) return node.value;

        var left = min(node.leftChild);
        var right = min(node.rightChild);

        return Math.min(Math.min(left, right), node.value);
    }

    private int minBinaryTree(Node node) {      // O(log n)
        if(node == null) throw new IllegalStateException();

        var current = node;
        while(true) {
            if(current.leftChild == null) {
                return current.value;
            }

            current = current.leftChild;
        }
    }

    public boolean equals(Tree other) {
        if(other == null) return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null) return true;

        if(first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max) {
        if(node == null) return true;

        if(node.value < min && node.value > max) return false;

        return isBST(node.leftChild, min, node.value - 1)
                && isBST(node.rightChild, node.value + 1, max);
    }
}
