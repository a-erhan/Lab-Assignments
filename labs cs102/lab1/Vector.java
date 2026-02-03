import java.util.Arrays;

public class Vector implements Algebraic{
    private float[] data; 

    public float[] getData(){
        return Arrays.copyOf(data, data.length);
    }
    public Vector(float[] data){
        //Make a shallow copy of given data
        this.data = Arrays.copyOf(data, data.length);
    } 
    @Override
    public Vector negate(){
        float[] newData = new float[data.length];
        for(int i = 0; i < this.data.length; i++){
            newData[i] = -this.data[i];
        }
        return new Vector(newData);
    }
    @Override
    public Vector add(Algebraic other){
        if(!(other instanceof Vector)){
            return null;
        }
        Vector othVector = (Vector)(other);
        if(othVector.data.length != this.data.length){
            return null;
        }
        float[] newData = new float[this.data.length];
        for(int i = 0; i < this.data.length; i++){
            newData[i] = this.data[i] + othVector.data[i];
        }
        return new Vector(newData);
    }
    @Override
    public Vector subtract(Algebraic other){
        return this.add(other.negate());
    }

    @Override
    public Vector multiply(Algebraic other){
        if(other instanceof Vector){
            Vector othVector = (Vector)(other);
            if(othVector.data.length != this.data.length){
                return null;
            }
            float[] newData = new float[1];
            for(int i = 0; i < this.data.length; i++){
                newData[0] += othVector.data[i] * this.data[i];
            }
            return new Vector(newData);
        }
        return null;
    }

    public Vector crossproduct(Vector other){
        if(this.data.length != 3 || other.data.length != 3){
            return null;
        }
        float[] a = this.data;
        float[] b = other.data;
        return new Vector(new float[]{
            a[1] * b[2] - a[2] * b[1],
            a[2] * b[0] - a[0] * b[2],
            a[0] * b[1] - a[1] * b[0]
        });
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Vector){
            Vector othVector = (Vector)(other);
            if(othVector.data.length != this.data.length){
                return false;
            }
            for(int i = 0; i < this.data.length; i++){
                if(Math.abs(this.data[i] - othVector.data[i]) > 1E-6){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String ans = "";
        for (float val : data){
            ans += String.format("|%8.2f |%n", val);
        }
        return ans;
    }
    
    public static void main(String[] args) {

        //This is like a test for this class
        final Vector v1 = new Vector(new float[]{3.f, 2.f, 5.f}); 
        final Vector v2 = new Vector(new float[]{1.32f, 3.15f, 1.5f}); 
        final Vector v3 = new Vector(new float[]{1.32f, 3.15f, 1.5f, 32.f}); 
        
        System.out.printf("v1 \n%s\n\n", v1); 
        System.out.printf("v2 \n%s\n\n", v2); 
                
        System.out.println(); 
        System.out.printf("-v1 \n%s\n\n", v1.negate()); 
        System.out.printf("v1 + v2 \n%s\n\n", v1.add(v2)); 
        System.out.printf("v2 + v1 \n%s\n\n", v2.add(v1)); 
        System.out.printf("v1 - v2 \n%s\n\n", v1.subtract(v2)); 
        System.out.printf("v2 - v1 \n%s\n\n", v2.subtract(v1)); 
        
        System.out.println(); 
        System.out.printf("v1 == null         => %s\n", v1.equals(null)); 
        System.out.printf("v1 == v3           => %s\n", v1.equals(v3)); 
        System.out.printf("v1 == -v1          => %s\n", v1.equals(v1.negate())); 
        System.out.printf("v1 == -(-v1)       => %s\n", 
        v1.equals(v1.negate().negate())); 
        System.out.printf("v1 + v2 == v2 + v1 => %s\n", 
        (v1.add(v2)).equals(v2.add(v1))); 
        
        System.out.println(); 
        System.out.printf("v1 * v2 = %s\n", v1.multiply(v2)); 
        System.out.printf("v1 * v3 = %s\n", v1.multiply(v3)); 
        System.out.printf("v1 x v3 = %s\n", v1.crossproduct(v3)); 
        System.out.printf("v1 x v2 \n%s\n", v1.crossproduct(v2));
    }

}
