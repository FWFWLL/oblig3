class InvalidListIndex extends RuntimeException {
    InvalidListIndex(int index){
        super("Invalid index: " + index);
    }
}
