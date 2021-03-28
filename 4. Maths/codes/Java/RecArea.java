class RecArea
{
    int max(int A,int B) {return Math.max(A,B);}
    int min(int A,int B) {return Math.min(A,B);}
    RecArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int X = min(G,C) - max(E,A);
        int Y = min(H,D) - max(F,B);
        if(X<0 || Y<0) System.out.print(0);
        else System.out.print(X*Y);
    }
    public static void main(String[] args) {
        int A = 0, B = 0, C = 4, D = 4, E = 2, F = 2, G = 6, H = 6;
        new RecArea(A, B, C, D, E, F, G, H);
    }
}