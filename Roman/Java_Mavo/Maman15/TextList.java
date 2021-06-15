/**
 * Maman15
 * Author: Roman Rapoport
 */
public class TextList {
    private WordNode _head;

    /**
     * Instantiates a new Text list object that represents a linked-list where each node represents a string:
     * default constructor
     */
    public TextList(){
        _head = new WordNode("");
    }

    /**
     * Instantiates a new Text list object that represents a linked-list where each node represents a string.
     * Time complexity is O(n(Log n)) - using merge sort to sort the text.
     * @param text the text.
     */
    public TextList (String text){
        if (text.length() == 0){
            _head = new WordNode(text);
        }
        else {
            split(text);
            _head = mergeSort(_head);
        }
    }

    private void split(String text){
        int i = 0;
        int j = 0;
        WordNode newWord;
        while (i < text.length()){
            if (text.charAt(i) == ' ' || i == text.length() - 1){
                if (text.substring(j, i+1).charAt(text.substring(j, i+1).length()-1) == ' '){
                    newWord = new WordNode(text.substring(j, i));
                }
                else{
                    newWord = new WordNode(text.substring(j, i+1));
                }
                if (j == 0){
                    _head = newWord;
                }
                else {
                    WordNode current = _head;
                    while (current.getNext() != null){
                        current = current.getNext();
                    }
                    current.setNext(newWord);
                }
                j = i+1;
            }
            i++;
        }
    }

    private WordNode mergeSort(WordNode node){
        if (node == null || node.getNext() == null){
            return node;
        }
        WordNode head2 = splitList(node);
        node = mergeSort(node);
        head2 = mergeSort(head2);
        return mergeSplitList(node, head2);
    }

    private WordNode mergeSplitList(WordNode head1, WordNode head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.getWord().compareTo(head2.getWord()) < 0){
            head1.setNext(mergeSplitList(head1.getNext(), head2));
            return head1;
        }
        else{
            head2.setNext(mergeSplitList(head1, head2.getNext()));
            return head2;
        }
    }

    private WordNode splitList(WordNode node){
        if (node == null || node.getNext() == null){
            return null;
        }
        WordNode list2 = node.getNext();
        node.setNext(list2.getNext());
        list2.setNext(splitList(list2.getNext()));
        return list2;
    }

    /**
     * Adds the word to the list and resorts the list lexicographically again.
     * Time complexity is O(n(Log n)) - using merge sort
     * @param word the string representing a word to be added to the list.
     */
    public void addToData(String word){
        if (!(word.equalsIgnoreCase(""))){
            if (_head.getWord().equalsIgnoreCase("")){
                split(word);
                _head = mergeSort(_head);
            }
            else {
                WordNode newWord = new WordNode(word, _head);
                _head = newWord;
                _head = mergeSort(_head);
            }
        }
    }

    /**
     * How many words.
     * Time complexity is O(n) - using 1 while loop.
     * @return amount of words.
     */
    public int howManyWords(){
        WordNode current = _head;
        int words;
        if (current.getWord().length() > 0){
            words = 1;
        }
        else {
            words = 0;
        }
        while(current.getNext() != null){
            words++;
            current = current.getNext();
        }
        return words;
    }

    /**
     * How many different words.
     * Time complexity is O(n) - using 1 while loop.
     * @return amount of different words
     */
    public int howManyDifferentWords(){
        WordNode current = _head;
        int counter = 1;
        if (_head.getNext() == null && !_head.getWord().equalsIgnoreCase("")){
            return 1;
        }
        else if (_head.getWord().equalsIgnoreCase("")) {
            return 0;
        }
        while(current.getNext() != null) {
            if (current.getWord().equals(current.getNext().getWord())) {
                current = current.getNext();
                continue;
            }
            counter++;
            if (current.getNext() == null) {
                break;
            } else {
                current = current.getNext();
            }
        }
        return counter;
    }

    /**
     * Most frequent word.
     * Time complexity is O(n) - using 1 while loop.
     * @return the most frequently recurring word.
     */
    public String mostFrequentWord() {
        if (_head.getNext() == null){
            return _head.getWord();
        }
        int frequentC1 = 1;
        int frequentC2 = 1;
        WordNode current = _head;
        String word = "";
        while (current.getNext() != null){
            if (current.getWord().equalsIgnoreCase(current.getNext().getWord())){
                frequentC1++;
            }
            else {
                if (frequentC2 < frequentC1) {
                    frequentC2 = frequentC1;
                    word = current.getWord();
                }
                frequentC1 = 1;
            }
            current = current.getNext();
        }
        if (frequentC1 > frequentC2){
            word = current.getWord();
        }
        return word.equalsIgnoreCase("") ? _head.getWord() : word;
    }

    /**
     * How many starting.
     * Time complexity is O(n) - using 1 while loop.
     * @param letter the char to check how many words start with it
     * @return amount of words starting with that char
     */
    public int howManyStarting(char letter){
        if (_head.getNext() == null){
            return charAtFirstIdx(_head) == letter ? 1 : 0;
        }
        WordNode current = _head;
        int startingCounter = 0;
        while (current.getNext() != null && charAtFirstIdx(current) <= letter){
            if (current.getWord().charAt(0) == letter){
                startingCounter++;
            }
            current = current.getNext();
        }
        if (charAtFirstIdx(current) == letter){
            startingCounter++;
        }
        return startingCounter;
    }

    private char charAtFirstIdx(WordNode node){
        return node.getWord().charAt(0);
    }

    private char mostFrequentStartingLetter(WordNode current, int counter1, int counter2, char frequentChar){
        if (current.getNext() != null) {
            if (charAtFirstIdx(current) == charAtFirstIdx(current.getNext())) {
                counter1++;
            } else {
                if (counter2 < counter1) {
                    counter2 = counter1;
                    frequentChar = charAtFirstIdx(current);
                }
                counter1 = 1;
            }
            return mostFrequentStartingLetter(current.getNext(), counter1, counter2, frequentChar);
        }
        if (counter1 > counter2){
            frequentChar = charAtFirstIdx(current);
        }
        return frequentChar;
    }

    /**
     * Most frequent starting letter.
     *
     * @return most frequent starting char.
     */
    public char mostFrequentStartingLetter (){
        if (_head.getNext() == null && !_head.getWord().equalsIgnoreCase("")){
            return charAtFirstIdx(_head);
        }
        else if (_head.getNext() == null &&  _head.getWord().equalsIgnoreCase("")){
            return ' ';
        }
        return mostFrequentStartingLetter(_head, 1, 1, ' ');
    }

    private String howToPrint(WordNode current, String text){
        if (current.getWord().charAt(current.getWord().length()-1) == ' '){
            text += current.getWord();
        }
        else {
            text += current.getWord() + " ";
        }
        return text;
    }

    public String toString(){
        WordNode current = _head;
        String text = "";
        int counter = 1;
        if (_head.getNext() == null && _head.getWord().equalsIgnoreCase("")){
            return "";
        }
        while(current.getNext() != null) {
            if (current.getWord().equals(current.getNext().getWord())) {
                current = current.getNext();
                counter++;
                continue;
            }
            text = howToPrint(current, text) + "\t" + counter + "\n";
            if (current.getNext() == null) {
                break;
            } else {
                current = current.getNext();
                counter = 1;
            }
        }
        if (counter > 1){
            text = howToPrint(current, text) + "\t" + counter + "\n";
        }
        else{
            text = howToPrint(current, text) + "\t" + 1 + "\n";
        }
        return text;
    }
}
