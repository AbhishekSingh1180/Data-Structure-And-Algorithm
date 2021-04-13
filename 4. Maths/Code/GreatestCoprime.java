class GreatestCoprime {
        static int max(int A,int B) {return Math.max(A,B);}
        static int min(int A,int B) {return Math.min(A,B);}
        static int gcd(int A,int B)
        {
            if(B==0) return A;
            return gcd(B,A%B);
        }
        static int cpFact(int A, int B) {
            int X = max(A,B);
            int Y = min(A,B);
            while(gcd(max(X,Y),min(X,Y))!=1) X/=gcd(max(X,Y),min(X,Y));
            return X;
        }
        public static void main(String[] args) {
            System.out.print(cpFact(12,30));
        }
}
