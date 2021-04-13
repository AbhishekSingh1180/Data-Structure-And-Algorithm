class StrangeEquality {
    StrangeEquality(int A)
    {
        int T = A;
        int MSB = (int)(Math.log(T)/Math.log(2));
        for(int i=0; i<=MSB; i++) T = T^(1<<i); //flipbit
        System.out.print(T^(1<<(MSB+1)));
    }
    public static void main(String[] args) {
        new StrangeEquality(5);
    }
}
