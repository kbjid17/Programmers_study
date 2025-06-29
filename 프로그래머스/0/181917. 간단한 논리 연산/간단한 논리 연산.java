class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return comp2(comp1(x1,x2), comp1(x3,x4));
    }
    
    public boolean comp1(boolean n1, boolean n2) { // ∨
        if(!n1 && !n2) return false;
        else return true;
    }
    
    public boolean comp2(boolean n1, boolean n2) { // ∧
        if(n1 && n2) return true;
        else return false;
    }
    
}