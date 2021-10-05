package leetcode.editor.cn;

import java.util.Iterator;

//284、窥探迭代器
class PeekingIterators {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
    	private Iterator<Integer> iterator;
    	private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
			this.iterator = iterator;
			nextElement = iterator.next();
        }

		// Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
        	Integer next = nextElement;
        	if(iterator.hasNext()){
        		nextElement =  iterator.next();
			}else {
				nextElement =  null;
			}
        	return next;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}