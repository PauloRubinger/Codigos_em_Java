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

    public void inOrderTreeWalk() {
        inOrderTreeWalk(this.root);
    }

    public void inOrderTreeWalk(Node subtreeRoot) {

        if (subtreeRoot != null) {
            inOrderTreeWalk(subtreeRoot.getLeft());
            System.out.print(subtreeRoot.getitem().getNome());
            inOrderTreeWalk(subtreeRoot.getRight());
        }
    }
}
