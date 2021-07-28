class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
       while(sx<=tx && sy<=ty){
            if(tx>ty){
                if(ty > sy) tx -= ty;
                else return (tx-sx) % ty == 0;
            }
            else{
                if(tx > sx) ty -= tx;
                else return (ty-sy) % tx == 0;
            }
        }
        return sx == tx && sy == ty;
    }
    }