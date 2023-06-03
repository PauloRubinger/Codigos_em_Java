package bst;

public class Node {
    
    private Jogador item;
    private Node left;
    private Node right;

    public Node() {
        item = new Jogador();
        left = null;
        right = null;
    }

    public Node(Jogador newPlayer) {
        item = newPlayer;
        left = null;
        right = null;
    }

    public Jogador getitem() {
        return item;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setItem(Jogador item) {
        this.item = item;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
