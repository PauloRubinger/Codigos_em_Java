package avltree;

import java.util.ArrayList;
import java.io.*;

public class AVLTree {

    int comp = 0; // For the log file (it stores the number of comparisons of the search method)

    private Node root;

    public AVLTree() {
        root = null;
    }

    public Node search(String key) {

        ArrayList<Node> path = new ArrayList<>(); // List to store the search path
        Node result = search(this.root, key, path);

        for (Node node : path) {
            System.out.print(node.getitem().getNome() + " ");
        }

        if (result != null) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }

        return result;
    }

    public Node search(Node subtreeRoot, String key, ArrayList<Node> path) {

        if (subtreeRoot == null) {
            comp++;
            return null;
        } else if (subtreeRoot.getitem().getNome().equals(key)) {
            comp++;
            path.add(subtreeRoot); // Add the current node to the path
            return subtreeRoot;
        } else if (subtreeRoot.getitem().getNome().compareTo(key) > 0) {
            comp++;
            path.add(subtreeRoot); // Add the current node to the path
            return search(subtreeRoot.getLeft(), key, path);
        } else {
            comp++;
            path.add(subtreeRoot); // Add the current node to the path
            return search(subtreeRoot.getRight(), key, path);
        }
    }

    public void insert(Jogador playerId) throws Exception {
        this.root = insert(this.root, playerId);
    }

    public Node insert(Node subtreeRoot, Jogador newPlayer) throws Exception {

        if (subtreeRoot == null) {
            subtreeRoot = new Node(newPlayer);
        } else if (subtreeRoot.getitem() == newPlayer) {
            throw new Exception("Não foi possível inserir esse item na árvore: o item já foi inserido anteriormente");
        } else if (subtreeRoot.getitem().getNome().compareTo(newPlayer.getNome()) > 0) {
            subtreeRoot.setLeft(insert(subtreeRoot.getLeft(), newPlayer));
        } else {
            subtreeRoot.setRight(insert(subtreeRoot.getRight(), newPlayer));
        }

        return subtreeRoot;
    }

    public void remove(Jogador removed) throws Exception {
        this.root = remove(this.root, removed);
    }

    public Node remove(Node subtreeRoot, Jogador playerRemoved) throws Exception {

        if (subtreeRoot == null) {
            throw new Exception("Não foi possível remover o item: item não encontrado");
        } else if (subtreeRoot.getitem() == playerRemoved) {
            if (subtreeRoot.getLeft() == null) {
                subtreeRoot = subtreeRoot.getRight();
            } else if (subtreeRoot.getRight() == null) {
                subtreeRoot = subtreeRoot.getLeft();
            } else {
                subtreeRoot.setLeft(predecessor(subtreeRoot, subtreeRoot.getLeft()));
            }
        } else if (subtreeRoot.getitem().getNome().compareTo(playerRemoved.getNome()) > 0) {
            subtreeRoot.setLeft(remove(subtreeRoot.getLeft(), playerRemoved));
        } else {
            subtreeRoot.setRight(remove(subtreeRoot.getRight(), playerRemoved));
        }

        return subtreeRoot;
    }

    public Node predecessor(Node nodeRemove, Node subtreeRoot) {

        if (subtreeRoot.getRight() != null) {
            subtreeRoot.setRight(predecessor(nodeRemove, subtreeRoot.getRight()));
        } else {
            nodeRemove.setItem(subtreeRoot.getitem());
            subtreeRoot = subtreeRoot.getLeft();
        }

        return subtreeRoot;
    }

    public Node balance(Node subtreeRoot) {

        int balaceFactor;
        int childBalanceFactor;

        balaceFactor = subtreeRoot.getBalanceFactor();

        if (balaceFactor == 2) { // Unbalanced tree on the left

            childBalanceFactor = subtreeRoot.getLeft().getBalanceFactor();

            if (childBalanceFactor == -1) { // Unbalanced child on the right
                // Double rotation
                // Left child rotation 
                subtreeRoot.setLeft(rotateLeft(subtreeRoot.getLeft()));
            }
            // Right rotation
            subtreeRoot = rotateRight(subtreeRoot);
        } else if (balaceFactor == -2) { // Unbalanced tree on the right

            childBalanceFactor = subtreeRoot.getRight().getBalanceFactor();

            if (childBalanceFactor == 1) { // Unbalanced child on the left
                // Double rotation
                // Right child rotation
                subtreeRoot.setRight(rotateRight(subtreeRoot.getRight()));
            }
            // Left rotation
            subtreeRoot = rotateLeft(subtreeRoot);
        } else {
            subtreeRoot.setHeight();
        }

        return subtreeRoot;
    }

    public Node rotateRight(Node subtreeRoot) {

        Node leftChild = subtreeRoot.getLeft();
        Node rightChildOfLeftChild = leftChild.getRight();

        leftChild.setRight(subtreeRoot);
        subtreeRoot.setLeft(rightChildOfLeftChild);

        leftChild.setHeight();
        rightChildOfLeftChild.setHeight();

        return leftChild;
    }

    public Node rotateLeft(Node subtreeRoot) {

        Node rightChild = subtreeRoot.getRight();
        Node leftChildOfRightChild = rightChild.getLeft();

        rightChild.setLeft(subtreeRoot);
        subtreeRoot.setRight(leftChildOfRightChild);

        rightChild.getHeight();
        leftChildOfRightChild.setHeight();

        return rightChild;
    }

    public void inorderTreeWalk() {
        inorderTreeWalk(this.root);
    }

    public void inorderTreeWalk(Node subtreeRoot) {

        if (subtreeRoot != null) {
            inorderTreeWalk(subtreeRoot.getLeft());
            System.out.print(subtreeRoot.getitem().getNome() + " ");
            inorderTreeWalk(subtreeRoot.getRight());
        }
    }

    public void preorderTreeWalk() {
        preorderTreeWalk(this.root);
    }

    public void preorderTreeWalk(Node subtreeRoot) {

        if (subtreeRoot != null) {
            System.out.print(subtreeRoot.getitem().getNome() + " ");
            preorderTreeWalk(subtreeRoot.getLeft());
            preorderTreeWalk(subtreeRoot.getRight());
        }
    }

    public void postorderTreeWalk() {
        postorderTreeWalk(this.root);
    }

    public void postorderTreeWalk(Node subtreeRoot) {

        if (subtreeRoot != null) {
            postorderTreeWalk(subtreeRoot.getLeft());
            postorderTreeWalk(subtreeRoot.getRight());
            System.out.print(subtreeRoot.getitem().getNome() + " ");
        }
    }

    public void logFile(long startTime, long endTime) throws Exception{

        FileWriter file = new FileWriter("794310_arvoreBinaria.txt");
        PrintWriter log = new PrintWriter(file);
        long timeElapsed = endTime - startTime;
        
        log.printf("794310");
        log.printf("\tTempo de execução(ms):" + timeElapsed);
        log.printf("\tComparações feitas:" + comp);

        log.close();
        file.close();
    }
}
