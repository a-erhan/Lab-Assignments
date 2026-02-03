public class Matrix implements Algebraic{
    protected float[][] data;
    public Matrix(float[][] mat){
        this.data = mat;
    }

    public int[] getDimensions(){
        return new int[]{data.length, data[0].length};
    }

    @Override
    public Matrix negate(){
        float[][] newData = new float[this.data.length][this.data[0].length];
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                newData[i][j] = -data[i][j];
            }
        }
        return new Matrix(newData);
    }

    @Override
    public Matrix add(Algebraic other){
        if(!(other instanceof Matrix)){
            return null;
        }
        Matrix othMatrix = (Matrix)(other);
        if(othMatrix.data.length != this.data.length || othMatrix.data[0].length != this.data[0].length){
            return null;
        }
        float[][] newData = new float[this.data.length][this.data[0].length];
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                newData[i][j] = data[i][j] + othMatrix.data[i][j];
            }
        }
        return new Matrix(newData);
    }

    @Override
    public Matrix subtract(Algebraic other){
        return this.add(other.negate());
    }

    @Override
    public Algebraic multiply(Algebraic other){
        if(other instanceof Matrix){
            Matrix othMatrix = (Matrix)(other);
            if(this.data[0].length != othMatrix.data.length){
                return null;
            }
            float[][] newData = new float[this.data.length][othMatrix.data[0].length];
            for(int i = 0; i < this.data.length; i++){
                for(int j = 0; j < othMatrix.data[0].length; j++){
                    for(int k = 0; k < this.data[0].length; k++){
                        newData[i][j] += this.data[i][k] * othMatrix.data[k][j]; 
                    }
                }
            }
            return new Matrix(newData);

        } else if(other instanceof Vector){
            Vector othVector = (Vector)(other);
            if(othVector.getData().length != this.data[0].length){
                return null;
            }else{
                float[] newData = new float[this.data.length];
                for(int i = 0; i < this.data.length; i++){
                    newData[i] = (new Vector(this.data[i])).multiply(othVector).getData()[0];
                }
                return new Vector(newData);
            }
            
        }
        return null;
    }

    public Vector determinant(){
        if(!((this.data.length == 2 && this.data[0].length == 2) ||
      (this.data.length == 3 && this.data[0].length == 3))){
            return null;
        }
        if(this.data.length == 2){
            return new Vector(new float[]{this.data[0][0]*this.data[1][1] - this.data[0][1]*this.data[1][0]});
        }
        return new Vector(new float[]{
            this.data[0][0]*(this.data[1][1]*this.data[2][2] - this.data[1][2]*this.data[2][1]) -
            this.data[0][1]*(this.data[1][0]*this.data[2][2] - this.data[1][2]*this.data[2][0]) +
            this.data[0][2]*(this.data[1][0]*this.data[2][1] - this.data[1][1]*this.data[2][0])
        });
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Matrix){
            Matrix othMatrix = (Matrix)(other);
            if(othMatrix.data.length != this.data.length){
                return false;
            }
            for(int i = 0; i < this.data.length; i++){
                for(int j = 0; j < this.data[0].length; j++)
                    if(Math.abs(this.data[i][j] - othMatrix.data[i][j]) > 1E-6){
                        return false;
                    }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String ans = " |";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                ans += String.format("%8.2f", data[i][j]);
            }
            ans += "| \n |";
        }
        return ans.substring(0,ans.length()-1);
    }

    public static void main(String[] args) {
        final Matrix m1 = new Matrix(new float[][]{{1, 3.2f, 0}, {0, 2, 1}, {0, 2.16f, 1}});  
        final Matrix m2 = new Matrix(new float[][]{{0, 1.f, 0}, {0, 1, 0}, {3.02f, 0, 1}}); 
        final Matrix m3 = new Matrix(new float[][]{{1.f, 3.f}, {1.f, 4.f}, {5.12f, 2.31f}}); 
        final Vector v = new Vector(new float[]{1, 2, 3}); 
        System.out.printf("m1 \n%s\n\n", m1);  
        System.out.printf("m2 \n%s\n\n", m2);  
        System.out.printf("m3 \n%s\n\n", m3);  
        System.out.printf("v \n%s\n\n", v);  
        
        // Arithmetic operations 
        System.out.println(); 
        System.out.printf("-m1\n%s\n\n", m1.negate()); 
        System.out.printf("m1 + m2 \n%s\n\n", m1.add(m2)); 
        System.out.printf("m2 + m3 %s\n\n", m2.add(m3)); 
        System.out.printf("m1 - m2 \n%s\n\n", m1.subtract(m2)); 
        System.out.printf("m1 * m2 \n%s\n\n", m1.multiply(m2)); 
        System.out.printf("m2 * m1 \n%s\n\n", m2.multiply(m1)); 
        System.out.printf("m1 * m3 \n%s\n\n", m1.multiply(m3)); 
        System.out.printf("m3 * m1 \n%s\n\n", m3.multiply(m1)); 
        
        // Matrix-Vector operations 
        System.out.println(); 
        System.out.printf("m1 + v \n%s\n\n", m1.add(v)); 
        System.out.printf("v * m1 \n%s\n\n", v.multiply(m1)); 
        System.out.printf("m3 * v \n%s\n\n", m3.multiply(v)); 
        System.out.printf("m1 * v \n%s\n\n", m1.multiply(v)); 
        
        // Determinant 
        System.out.println(); 
        System.out.printf("|m1| = %s\n", m1.determinant()); 
        System.out.printf("|m3| = %s\n", m3.determinant()); 
        
        // Equality 
        System.out.println(); 
        System.out.printf("m1 == null => %s\n", m1.equals(null)); 
        System.out.printf("m1 == m2 => %s\n", m1.equals(m2)); 
        System.out.printf("m1 == m3 => %s\n", m1.equals(m3)); 
        System.out.printf("m1 == -(-m1) => %s\n", m1.equals(m1.negate().negate())); 
        
        final Algebraic m13 = m1.multiply(m3); 
        final Algebraic m23 = m2.multiply(m3); 
        final Algebraic m123 = m1.add(m2).multiply(m3); 
        System.out.printf("(m1 + m2) * m3 == (m1 * m3) + (m2 * m3) => %s\n", m123.equals(m13.add(m23)));
    }
}
