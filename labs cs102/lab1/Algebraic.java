public interface Algebraic{
    //Returns the negation (additive inverse) of this object. 
    Algebraic negate();
    //Returns the result of adding this object to other, or null if the 
    //operation is not defined or the objects are incompatible.
    Algebraic add(Algebraic other);
    //Returns the result of subtracting other from this object, 
    //or null if the operation is not defined or the objects are incompatible.
    Algebraic subtract(Algebraic other);
    //Returns the result of multiplying this object by the other 
    //object. Depending on the types, this represents either the dot product (for vectors) or matrix 
    //multiplication (for matrices). Returns null if the operation is undefined or if the object dimensions 
    //are incompatible.
    Algebraic multiply(Algebraic other);

}