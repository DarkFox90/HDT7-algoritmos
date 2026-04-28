public class BinaryTree <E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(E data) {
        root = insertRecursive(root, data);
    }

    private Node<E> insertRecursive(Node<E> current, E data) {
        if (current == null) {
            return new Node<>(data);
        }

        int comparison = data.compareTo(current.getData());

        if (comparison < 0) {
            current.setLeft(insertRecursive(current.getLeft(), data));
        } else if (comparison > 0) {
            current.setRight(insertRecursive(current.getRight(), data));
        }
        return current;
    }

    public E search(E searchData) {
        Node<E> resultNode = searchRecursive(root, searchData);
        if (resultNode != null) {
            return resultNode.getData();
        }
        return null;
    }

    private Node<E> searchRecursive(Node<E> current, E searchData) {
        if (current == null) {
            return null;
        }

        int comparison = searchData.compareTo(current.getData());

        if (comparison == 0) {
            return current;
        }

        if (comparison < 0) {
            return searchRecursive(current.getLeft(), searchData);
        } else {
            return searchRecursive(current.getRight(), searchData);
        }
    }
}
