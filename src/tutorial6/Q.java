package tutorial6;

public class Q {
    /*
     * Q1
     * c. peek
     *
     * Q2
     * s2.push(s1.pop());  s1=[zero,one]  s2=[two]      s3=[]
     * s3.push(s1.pop());  s1=[zero]      s2=[two]      s3=[one]
     * s1.pop();           s1=[]          s2=[two]      s3=[one]
     * s1.push(s2.pop());  s1=[two]       s2=[]         s3=[one]
     * s2.push(s3.pop());  s1=[two]       s2=[one]      s3=[]
     * s2.push(s1.pop());  s1=[]          s2=[one,two]  s3=[]
     *
     * Q3
     * (a) 1-2-3
     * Yes.
     * Operations: push(1) -> pop() = 1 -> push(2) -> pop() = 2 -> push(3) -> pop() = 3
     *
     * (b) 2-3-1
     * Yes.
     * Operations: push(1) -> push(2) -> pop() = 2 -> push(3) -> pop() = 3 -> pop() = 1
     *
     * (c) 3-2-1
     * Yes.
     * Operations: push(1) -> push(2) -> push(3) -> pop() = 3 -> pop() = 2 -> pop() = 1
     *
     * (d) 1-3-2
     * Yes.
     * Operations: push(1) -> pop() = 1 -> push(2) -> push(3) -> pop() = 3 -> pop() = 2
     *
     * Q4
     * a) a b c * +
     * b) a b * c d / -
     * c) a b c * d + e / +
     *
     * Q5
     * a) ((a + b) * c)
     * b) (a * (b + c))
     *
     * Q6
     * D. all of the above
     */
}
