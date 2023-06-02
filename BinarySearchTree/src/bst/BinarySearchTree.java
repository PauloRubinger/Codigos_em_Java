package bst;

public class BinarySearchTree {
    
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Jogador search(String key) {
        return search(this.root, key);
    }

    public Jogador search(Node subtreeRoot, String key) {
        
        if (subtreeRoot == null) {
            return null;
        } else if (subtreeRoot.getitem().getNome().equals(key)) {
            return subtreeRoot.getitem();
        } else if (subtreeRoot.getitem().getNome().compareTo(key) > 0) {
            return search(subtreeRoot.getLeft(), key);
        } else {
            return search(subtreeRoot.getRight(), key);
        }
    }
}
