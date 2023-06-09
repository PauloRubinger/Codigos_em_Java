package avltree;

public class Node {
    
    private Jogador item;
    private Node left;
    private Node right;
    private int height;

    public Node() {
        item = new Jogador();
        height = 0;
        left = null;
        right = null;
    }

    public Node(Jogador newPlayer) {
        item = newPlayer;
        height = 0;
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

    public int getHeight() {
        return height;
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

    public void setHeight() {

        int leftHeight;
        int rightHeight;

        if (this.right == null) {
            rightHeight = -1;
        } else {
            rightHeight = this.right.getHeight();
        }

        if (this.left == null) {
            leftHeight = -1;
        } else {
            leftHeight = this.left.getHeight();
        }

        if (leftHeight > rightHeight) {
            this.height = leftHeight + 1;
        } else {
            this.height = rightHeight + 1;
        }
    }

    public int getBalanceFactor() {

        int leftHeight;
        int rightHeight;

        if (this.right == null) {
            rightHeight = -1;
        } else {
            rightHeight = this.right.getHeight();
        }

        if (this.left == null) {
            leftHeight = -1;
        } else {
            leftHeight = this.left.getHeight();
        }

        return (leftHeight - rightHeight);
    }
}
