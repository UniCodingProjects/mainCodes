/**
 * Maman15
 * Author: Roman Rapoport
 */
public class WordNode {
    private String _word;
    private WordNode _next;

    /**
     * Instantiates a new Word node object.
     *
     * @param word the string that will represent this word node object.
     */
    public WordNode(String word){
        _word = word;
        _next = null;
    }

    /**
     * Instantiates a new Word node object.
     *
     * @param word the string that represents the object
     * @param next the pointer to the next word node object.
     */
    public WordNode(String word, WordNode next){
        _word = word;
        _next = next;
    }

    /**
     * Get word.
     *
     * @return the string value of the stored word
     */
    public String getWord(){
        return _word;
    }

    /**
     * Set word.
     *
     * @param word the string value to set as the word var.
     */
    public void setWord(String word){
        _word = word;
    }

    /**
     * Get next word node object.
     *
     * @return the word node if exists, if not returns nyll.
     */
    public WordNode getNext(){
        return _next;
    }

    /**
     * Set next word node pointer.
     *
     * @param next the word node object to be the sequential ater this.
     */
    public void setNext(WordNode next){
        _next = next;
    }
}
