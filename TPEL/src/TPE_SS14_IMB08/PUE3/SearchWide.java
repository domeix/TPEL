package TPE_SS14_IMB08.PUE3;

public class SearchWide<T> implements SearchStrategy<T> {

    private NodeListImpl<T> path;
    
    public SearchWide(){
        this.path = new NodeListImpl<>();
    }

    @Override
    public NodeListImpl<T> search(T wert, Node<T> start) {
        path.clear();
        NodeListImpl<T> matches = new NodeListImpl<T>();
        
        NodeListImpl<T> queue = new NodeListImpl<T>();
        
        path.add(start);
        //Kinder an Queue haengen       
        queue.addAll(start.getChildren());

        if(start.getValue().equals(wert)) {
            matches.add(start);
        }
        
        while(!queue.isEmpty()){
            Node<T> tmp = queue.pop();
            if(!path.contains(tmp)) {
                path.add(tmp);
                queue.addAll(tmp.getChildren());
                if(tmp.getValue().equals(wert)) {
                    matches.add(tmp);
                }
            }
        }
        
        return matches;
        
        
    }

    @Override
    public NodeListImpl<T> getPath() {
        return this.path;
    }
    
    

}
