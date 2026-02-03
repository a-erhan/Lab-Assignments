public class LTMatrix extends Matrix{
    public LTMatrix(float[][] data) {
        super(data);
        boolean isValid = isValidLTM(data);
        if (!isValid) {
            System.out.println("Error: The input array does not represent a valid lower triangular matrix!");
            this.data = new float[0][0]; 
        }
    }    

    @Override
    public LTMatrix negate(){
        float[][] newData = new float[this.data.length][this.data[0].length];
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j <= i; j++){
                newData[i][j] = -data[i][j];
            }
        }
        return new LTMatrix(newData);
    }

    @Override
    public Matrix add(Algebraic other){
        if(!(other instanceof LTMatrix)){
            super.add(other);
        }
        LTMatrix otherMat = (LTMatrix)(other);
        if(this.data.length != otherMat.data.length){
            return null;
        }
        float[][] newData = new float[this.data.length][this.data[0].length];
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j <= i; j++){
                newData[i][j] = data[i][j] + otherMat.data[i][j];
            }
        }
        return new LTMatrix(newData);
    }

    @Override
    public Matrix subtract(Algebraic other){
        return this.add(other.negate());
    }

    @Override
    public Algebraic multiply(Algebraic other){
        if(other instanceof LTMatrix){
            Matrix othMatrix = (LTMatrix)(other);
            if(this.data[0].length != othMatrix.data.length){
                return null;
            }
            float[][] newData = new float[this.data.length][othMatrix.data[0].length];
            for(int i = 0; i < this.data.length; i++){
                for(int j = 0; j <= i; j++){
                    for(int k = j; k <= i; k++){
                        newData[i][j] += this.data[i][k] * othMatrix.data[k][j]; 
                    }
                }
            }
            return new LTMatrix(newData);
        }else if(other instanceof Matrix){
            Matrix othMatrix = (Matrix)(other);
            if(this.data[0].length != othMatrix.data.length){
                return null;
            }
            float[][] newData = new float[this.data.length][othMatrix.data[0].length];
            for(int i = 0; i < this.data.length; i++){
                for(int j = 0; j < othMatrix.data[0].length; j++){
                    for(int k = 0; k <= i; k++){
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

    @Override
    public Vector determinant(){
        if(!((this.data.length == 2 && this.data[0].length == 2) ||
      (this.data.length == 3 && this.data[0].length == 3))){
            return null;
        }
        if(this.data.length == 2){
            return new Vector(new float[]{this.data[0][0]*this.data[1][1]});
        }
        return new Vector(new float[]{this.data[0][0]*this.data[1][1]*this.data[2][2]});
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof LTMatrix)){
            return false;
        }
        LTMatrix otherMatrix = (LTMatrix)(other);
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data[0].length; j++) {
                if (Math.abs(data[i][j] - otherMatrix.data[i][j]) > 1E-6) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidLTM(float[][] data){
        if (data == null || data.length != data[0].length) {
            return false;
        }else{
            for (int i = 0; i < data.length; i++) {
                for (int j = i + 1; j < data[0].length; j++) {
                    if (data[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
